package graphics;

public class ReseauParam {
	
	String name;
	String desc;
	int height;
	int width;
	
	
	
	public ReseauParam(String name, String desc, int width, int height) {
		super();
		this.name = name;
		this.desc = desc;
		this.height = height;
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	

}
