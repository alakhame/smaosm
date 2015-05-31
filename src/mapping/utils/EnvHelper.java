package mapping.utils;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import network.structure.Arc;
import network.structure.Coordonnees;
import network.structure.Place;
import network.structure.Reseau;

public class EnvHelper {

	
	static HashSet<Long> validWays = new HashSet<Long>();
	final double maxLong = 4.4001;
	final double minLong = 4.3782;
	final double maxLat = 45.444;
	final double minLat = 45.4325;
	final int FENX = 400;
	final int FENY = 300;
	Connection cnx = null;

	public EnvHelper() {
		try {
			Class.forName("org.postgresql.Driver");
			cnx = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test_osm1", "osm", "1234");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}

	}

	public static void main(String[] args) throws SQLException {
		EnvHelper e = new EnvHelper();
		e.genEnv();
		for (Arc a : Reseau.listeArc) {
			Long h = (long) a.getId();
			if (Reseau.arcLies.get(h).size()==1 ) {
				System.out.println(h + " ++ " + Reseau.arcLies.get(h));
			}
		}
		System.out.println("last node from way "+e.lastPointFromWay(-9356));
	}

	public HashSet<Long> waysToWorkWith() throws SQLException {
		HashSet<Long> ways = new HashSet<Long>();
		String req = "SELECT distinct(way_id) FROM way_tags WHERE k='highway' "
				+ "or  ( k='name' and (v like '%rue%' or v like '%Rue%' or v like '%venue%' or v like '%ouleva%') )";
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		while (rslt.next()) {
			if (isWithinLimits((rslt.getLong("way_id"))))
				ways.add(rslt.getLong("way_id"));
		}
		rslt.close();
		stmt.close();

		return ways;
	}

	public void genEnv() throws SQLException {

		System.out.println("Building the environment ...");
		EnvHelper.validWays = waysToWorkWith();

		Reseau.listeArc = new ArrayList<Arc>();
		Reseau.placeprisedebut = new ArrayList<Place>();
		Reseau.arcLies = new HashMap<Long, HashSet<Integer>>();
		for (Long w : EnvHelper.validWays) {
			Arc a = getArcFromWayId(w);
			if (a != null) {

				HashSet<Integer> listSuiv = new HashSet<Integer>();
				Reseau.listeArc.add(a);
				HashSet<Integer> foll = getFollowingWays(w);
				if (foll != null) {
					listSuiv.addAll(foll);
					for (Integer wy : foll) {
						if (getFollowingWays(wy.longValue()) != null)
							listSuiv.addAll(getFollowingWays(wy.longValue()));
					}
					Reseau.arcLies.put(w, listSuiv);
				} else {
					listSuiv.add(w.intValue());
					Reseau.arcLies.put(w, listSuiv);
				}
			}
		}
	}

	public boolean isWithinLimits(long wayId) throws SQLException {
		String req = "SELECT * FROM way_nodes WHERE way_id =" + wayId;
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		int n=0;
		while (rslt.next()) {
			if (getCoordFromId(rslt.getLong("node_id")) == null)
				return false;
			n++;
		}
		rslt.close();
		stmt.close();
		if(n<2) return false;
		return true;
	}

	
	private Arc getArcFromWayId(long id) throws SQLException {
		ArrayList<Coordonnees> coord = new ArrayList<Coordonnees>();
		String req = "SELECT * FROM way_nodes WHERE way_id =" + id;
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		int i = 0;
		while (rslt.next()) {
			Coordonnees c = getCoordFromId(rslt.getLong("node_id"));
			if (c == null)
				return null;
			coord.add(c);
			i++;
		}
		rslt.close();
		stmt.close();
		if (i < 2) {
			return null;
		}
		return getArcFromCoord(coord, (int) id);
	}

	private Arc getArcFromCoord(ArrayList<Coordonnees> coord, int wayId) {
		if (coord == null || coord.size() < 2) {
			return null;
		}
		Arc a = new Arc(coord, wayId);
		return a;
	}

	public Coordonnees getCoordFromId(long l) throws SQLException {
		Coordonnees c = null;
		String req = "SELECT * FROM nodes WHERE node_id =" + l;
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		if (rslt.next()) {
			double longi = rslt.getInt("longitude") / 10000000.0;
			double lat = rslt.getInt("latitude") / 10000000.0;
			if(longi<=maxLong && longi>=minLong && lat<=maxLat && lat>=minLat)
			c = latLongToXY(longi, lat);
		}
		rslt.close();
		stmt.close();
		return c;
	}

	Coordonnees latLongToXY(double longi, double lat) {
		double x = 0, y = 0;

		x = (longi - minLong) * (FENX / (maxLong - minLong));
		double mintmp = minLat * Math.PI / 180;
		double maxtmp = maxLat * Math.PI / 180;
		y = lat * Math.PI / 180;
		y = Math.log(Math.tan((Math.PI / 4.0) + 0.5 * y));
		mintmp = Math.log(Math.tan((Math.PI / 4.0) + 0.5 * mintmp));
		maxtmp = Math.log(Math.tan((Math.PI / 4.0) + 0.5 * maxtmp));
		y = (y - mintmp) * (FENY / (maxtmp - mintmp));
		Coordonnees c = new Coordonnees((int) Math.round(x),(int) Math.round(y));
		return c;
	}

	HashSet<Integer> getFollowingWays(long wayId) throws SQLException {
		long lastNode = lastPointFromWay(wayId);
		long firstNode = firstPointFromWay(wayId);
		HashSet<Integer> followings = new HashSet<Integer>();

		String req = "SELECT * FROM way_nodes WHERE way_id <>" + wayId
					+ " and (node_id=" + lastNode + " or node_id=" + firstNode
					+ ")";
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		while (rslt.next()) {
			if (EnvHelper.validWays.contains(rslt.getLong("way_id"))) {
				followings.add((int) rslt.getLong("way_id"));
			}
		}
		rslt.close();
		stmt.close();

		if (followings.size() > 0)
			return followings;
		return null;
	}

	long lastPointFromWay(long wayId) throws SQLException {

		long idNode = 0;
		String req = "SELECT * FROM way_nodes WHERE way_id =" + wayId;
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		while (rslt.next()) {
			idNode = rslt.getLong("node_id");
		}
		rslt.close();
		stmt.close();

		return idNode;
	}

	long firstPointFromWay(long wayId) throws SQLException {

		long idNode = 0;
		String req = "SELECT * FROM way_nodes WHERE way_id =" + wayId;
		Statement stmt = cnx.createStatement();
		ResultSet rslt = stmt.executeQuery(req);
		rslt.next();
		idNode = rslt.getLong("node_id");
		rslt.close();
		stmt.close();

		return idNode;
	}

}
