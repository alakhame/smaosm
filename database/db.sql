PGDMP     %                    s        	   test_osm1    9.4.1    9.4.1 Æ   
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            
           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            
           1262    42052 	   test_osm1    DATABASE        CREATE DATABASE test_osm1 WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'French_France.1252' LC_CTYPE = 'French_France.1252';
    DROP DATABASE test_osm1;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            
           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    5            
           0    0    public    ACL     ¢   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    5            æ            3079    11855    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            
           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    230            À           0    0    gbtreekey16 
   SHELL TYPE        CREATE TYPE gbtreekey16;
            public       postgres    false            ç            1255    42054    gbtreekey16_in(cstring)    FUNCTION        CREATE FUNCTION gbtreekey16_in(cstring) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_in';
 .   DROP FUNCTION public.gbtreekey16_in(cstring);
       public       postgres    false    5    704            ô            1255    42055    gbtreekey16_out(gbtreekey16)    FUNCTION        CREATE FUNCTION gbtreekey16_out(gbtreekey16) RETURNS cstring
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_out';
 3   DROP FUNCTION public.gbtreekey16_out(gbtreekey16);
       public       postgres    false    5    704            ¿           1247    42053    gbtreekey16    TYPE        CREATE TYPE gbtreekey16 (
    INTERNALLENGTH = 16,
    INPUT = gbtreekey16_in,
    OUTPUT = gbtreekey16_out,
    ALIGNMENT = int4,
    STORAGE = plain
);
 &   DROP TYPE public.gbtreekey16 CASCADE;
       public       postgres    false    244    5    231            Ä           0    0    gbtreekey32 
   SHELL TYPE        CREATE TYPE gbtreekey32;
            public       postgres    false            õ            1255    42058    gbtreekey32_in(cstring)    FUNCTION        CREATE FUNCTION gbtreekey32_in(cstring) RETURNS gbtreekey32
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_in';
 .   DROP FUNCTION public.gbtreekey32_in(cstring);
       public       postgres    false    5    708            ö            1255    42059    gbtreekey32_out(gbtreekey32)    FUNCTION        CREATE FUNCTION gbtreekey32_out(gbtreekey32) RETURNS cstring
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_out';
 3   DROP FUNCTION public.gbtreekey32_out(gbtreekey32);
       public       postgres    false    5    708            Ã           1247    42057    gbtreekey32    TYPE        CREATE TYPE gbtreekey32 (
    INTERNALLENGTH = 32,
    INPUT = gbtreekey32_in,
    OUTPUT = gbtreekey32_out,
    ALIGNMENT = int4,
    STORAGE = plain
);
 &   DROP TYPE public.gbtreekey32 CASCADE;
       public       postgres    false    5    245    246            È           0    0 
   gbtreekey4 
   SHELL TYPE        CREATE TYPE gbtreekey4;
            public       postgres    false            ÷            1255    42062    gbtreekey4_in(cstring)    FUNCTION        CREATE FUNCTION gbtreekey4_in(cstring) RETURNS gbtreekey4
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_in';
 -   DROP FUNCTION public.gbtreekey4_in(cstring);
       public       postgres    false    5    712            ø            1255    42063    gbtreekey4_out(gbtreekey4)    FUNCTION        CREATE FUNCTION gbtreekey4_out(gbtreekey4) RETURNS cstring
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_out';
 1   DROP FUNCTION public.gbtreekey4_out(gbtreekey4);
       public       postgres    false    5    712            Ç           1247    42061 
   gbtreekey4    TYPE        CREATE TYPE gbtreekey4 (
    INTERNALLENGTH = 4,
    INPUT = gbtreekey4_in,
    OUTPUT = gbtreekey4_out,
    ALIGNMENT = int4,
    STORAGE = plain
);
 %   DROP TYPE public.gbtreekey4 CASCADE;
       public       postgres    false    248    5    247            Ì           0    0 
   gbtreekey8 
   SHELL TYPE        CREATE TYPE gbtreekey8;
            public       postgres    false            ù            1255    42066    gbtreekey8_in(cstring)    FUNCTION        CREATE FUNCTION gbtreekey8_in(cstring) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_in';
 -   DROP FUNCTION public.gbtreekey8_in(cstring);
       public       postgres    false    5    716            ú            1255    42067    gbtreekey8_out(gbtreekey8)    FUNCTION        CREATE FUNCTION gbtreekey8_out(gbtreekey8) RETURNS cstring
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_out';
 1   DROP FUNCTION public.gbtreekey8_out(gbtreekey8);
       public       postgres    false    5    716            Ë           1247    42065 
   gbtreekey8    TYPE        CREATE TYPE gbtreekey8 (
    INTERNALLENGTH = 8,
    INPUT = gbtreekey8_in,
    OUTPUT = gbtreekey8_out,
    ALIGNMENT = int4,
    STORAGE = plain
);
 %   DROP TYPE public.gbtreekey8 CASCADE;
       public       postgres    false    250    5    249            Ð           0    0    gbtreekey_var 
   SHELL TYPE        CREATE TYPE gbtreekey_var;
            public       postgres    false            û            1255    42070    gbtreekey_var_in(cstring)    FUNCTION        CREATE FUNCTION gbtreekey_var_in(cstring) RETURNS gbtreekey_var
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_in';
 0   DROP FUNCTION public.gbtreekey_var_in(cstring);
       public       postgres    false    5    720            ü            1255    42071     gbtreekey_var_out(gbtreekey_var)    FUNCTION        CREATE FUNCTION gbtreekey_var_out(gbtreekey_var) RETURNS cstring
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbtreekey_out';
 7   DROP FUNCTION public.gbtreekey_var_out(gbtreekey_var);
       public       postgres    false    5    720            Ï           1247    42069    gbtreekey_var    TYPE     ©   CREATE TYPE gbtreekey_var (
    INTERNALLENGTH = variable,
    INPUT = gbtreekey_var_in,
    OUTPUT = gbtreekey_var_out,
    ALIGNMENT = int4,
    STORAGE = extended
);
 (   DROP TYPE public.gbtreekey_var CASCADE;
       public       postgres    false    252    5    251            Ó           1247    42074    gpx_visibility_enum    TYPE     n   CREATE TYPE gpx_visibility_enum AS ENUM (
    'private',
    'public',
    'trackable',
    'identifiable'
);
 &   DROP TYPE public.gpx_visibility_enum;
       public       postgres    false    5            Ö           1247    42084    nwr_enum    TYPE     H   CREATE TYPE nwr_enum AS ENUM (
    'Node',
    'Way',
    'Relation'
);
    DROP TYPE public.nwr_enum;
       public       postgres    false    5            Ù           1247    42092    user_role_enum    TYPE     M   CREATE TYPE user_role_enum AS ENUM (
    'administrator',
    'moderator'
);
 !   DROP TYPE public.user_role_enum;
       public       postgres    false    5            Ü           1247    42098    user_status_enum    TYPE     w   CREATE TYPE user_status_enum AS ENUM (
    'pending',
    'active',
    'confirmed',
    'suspended',
    'deleted'
);
 #   DROP TYPE public.user_status_enum;
       public       postgres    false    5            ý            1255    42109    gbt_bit_compress(internal)    FUNCTION        CREATE FUNCTION gbt_bit_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_compress';
 1   DROP FUNCTION public.gbt_bit_compress(internal);
       public       postgres    false    5            þ            1255    42110 :   gbt_bit_consistent(internal, bit, smallint, oid, internal)    FUNCTION     ®   CREATE FUNCTION gbt_bit_consistent(internal, bit, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_consistent';
 Q   DROP FUNCTION public.gbt_bit_consistent(internal, bit, smallint, oid, internal);
       public       postgres    false    5            ÿ            1255    42111 -   gbt_bit_penalty(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_bit_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_penalty';
 D   DROP FUNCTION public.gbt_bit_penalty(internal, internal, internal);
       public       postgres    false    5                        1255    42112 %   gbt_bit_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_bit_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_picksplit';
 <   DROP FUNCTION public.gbt_bit_picksplit(internal, internal);
       public       postgres    false    5                       1255    42113 *   gbt_bit_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_bit_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_same';
 A   DROP FUNCTION public.gbt_bit_same(internal, internal, internal);
       public       postgres    false    5                       1255    42114    gbt_bit_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_bit_union(bytea, internal) RETURNS gbtreekey_var
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bit_union';
 5   DROP FUNCTION public.gbt_bit_union(bytea, internal);
       public       postgres    false    719    5                       1255    42115    gbt_bpchar_compress(internal)    FUNCTION        CREATE FUNCTION gbt_bpchar_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bpchar_compress';
 4   DROP FUNCTION public.gbt_bpchar_compress(internal);
       public       postgres    false    5                       1255    42116 C   gbt_bpchar_consistent(internal, character, smallint, oid, internal)    FUNCTION     º   CREATE FUNCTION gbt_bpchar_consistent(internal, character, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bpchar_consistent';
 Z   DROP FUNCTION public.gbt_bpchar_consistent(internal, character, smallint, oid, internal);
       public       postgres    false    5                       1255    42117    gbt_bytea_compress(internal)    FUNCTION        CREATE FUNCTION gbt_bytea_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_compress';
 3   DROP FUNCTION public.gbt_bytea_compress(internal);
       public       postgres    false    5                       1255    42118 >   gbt_bytea_consistent(internal, bytea, smallint, oid, internal)    FUNCTION     ´   CREATE FUNCTION gbt_bytea_consistent(internal, bytea, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_consistent';
 U   DROP FUNCTION public.gbt_bytea_consistent(internal, bytea, smallint, oid, internal);
       public       postgres    false    5                       1255    42119 /   gbt_bytea_penalty(internal, internal, internal)    FUNCTION     £   CREATE FUNCTION gbt_bytea_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_penalty';
 F   DROP FUNCTION public.gbt_bytea_penalty(internal, internal, internal);
       public       postgres    false    5                       1255    42120 '   gbt_bytea_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_bytea_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_picksplit';
 >   DROP FUNCTION public.gbt_bytea_picksplit(internal, internal);
       public       postgres    false    5            	           1255    42121 ,   gbt_bytea_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_bytea_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_same';
 C   DROP FUNCTION public.gbt_bytea_same(internal, internal, internal);
       public       postgres    false    5            
           1255    42122     gbt_bytea_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_bytea_union(bytea, internal) RETURNS gbtreekey_var
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_bytea_union';
 7   DROP FUNCTION public.gbt_bytea_union(bytea, internal);
       public       postgres    false    719    5                       1255    42123    gbt_cash_compress(internal)    FUNCTION        CREATE FUNCTION gbt_cash_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_compress';
 2   DROP FUNCTION public.gbt_cash_compress(internal);
       public       postgres    false    5                       1255    42124 =   gbt_cash_consistent(internal, money, smallint, oid, internal)    FUNCTION     ²   CREATE FUNCTION gbt_cash_consistent(internal, money, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_consistent';
 T   DROP FUNCTION public.gbt_cash_consistent(internal, money, smallint, oid, internal);
       public       postgres    false    5                       1255    42125 .   gbt_cash_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_cash_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_penalty';
 E   DROP FUNCTION public.gbt_cash_penalty(internal, internal, internal);
       public       postgres    false    5                       1255    42126 &   gbt_cash_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_cash_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_picksplit';
 =   DROP FUNCTION public.gbt_cash_picksplit(internal, internal);
       public       postgres    false    5                       1255    42127 +   gbt_cash_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_cash_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_same';
 B   DROP FUNCTION public.gbt_cash_same(internal, internal, internal);
       public       postgres    false    5                       1255    42128    gbt_cash_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_cash_union(bytea, internal) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_cash_union';
 6   DROP FUNCTION public.gbt_cash_union(bytea, internal);
       public       postgres    false    715    5                       1255    42129    gbt_date_compress(internal)    FUNCTION        CREATE FUNCTION gbt_date_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_compress';
 2   DROP FUNCTION public.gbt_date_compress(internal);
       public       postgres    false    5                       1255    42130 <   gbt_date_consistent(internal, date, smallint, oid, internal)    FUNCTION     ±   CREATE FUNCTION gbt_date_consistent(internal, date, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_consistent';
 S   DROP FUNCTION public.gbt_date_consistent(internal, date, smallint, oid, internal);
       public       postgres    false    5                       1255    42131 .   gbt_date_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_date_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_penalty';
 E   DROP FUNCTION public.gbt_date_penalty(internal, internal, internal);
       public       postgres    false    5                       1255    42132 &   gbt_date_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_date_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_picksplit';
 =   DROP FUNCTION public.gbt_date_picksplit(internal, internal);
       public       postgres    false    5                       1255    42133 +   gbt_date_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_date_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_same';
 B   DROP FUNCTION public.gbt_date_same(internal, internal, internal);
       public       postgres    false    5                       1255    42134    gbt_date_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_date_union(bytea, internal) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_date_union';
 6   DROP FUNCTION public.gbt_date_union(bytea, internal);
       public       postgres    false    5    715                       1255    42135    gbt_decompress(internal)    FUNCTION        CREATE FUNCTION gbt_decompress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_decompress';
 /   DROP FUNCTION public.gbt_decompress(internal);
       public       postgres    false    5                       1255    42136    gbt_float4_compress(internal)    FUNCTION        CREATE FUNCTION gbt_float4_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_compress';
 4   DROP FUNCTION public.gbt_float4_compress(internal);
       public       postgres    false    5                       1255    42137 >   gbt_float4_consistent(internal, real, smallint, oid, internal)    FUNCTION     µ   CREATE FUNCTION gbt_float4_consistent(internal, real, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_consistent';
 U   DROP FUNCTION public.gbt_float4_consistent(internal, real, smallint, oid, internal);
       public       postgres    false    5                       1255    42138 0   gbt_float4_penalty(internal, internal, internal)    FUNCTION     ¥   CREATE FUNCTION gbt_float4_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_penalty';
 G   DROP FUNCTION public.gbt_float4_penalty(internal, internal, internal);
       public       postgres    false    5                       1255    42139 (   gbt_float4_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_float4_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_picksplit';
 ?   DROP FUNCTION public.gbt_float4_picksplit(internal, internal);
       public       postgres    false    5                       1255    42140 -   gbt_float4_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_float4_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_same';
 D   DROP FUNCTION public.gbt_float4_same(internal, internal, internal);
       public       postgres    false    5                       1255    42141 !   gbt_float4_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_float4_union(bytea, internal) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float4_union';
 8   DROP FUNCTION public.gbt_float4_union(bytea, internal);
       public       postgres    false    5    715                       1255    42142    gbt_float8_compress(internal)    FUNCTION        CREATE FUNCTION gbt_float8_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_compress';
 4   DROP FUNCTION public.gbt_float8_compress(internal);
       public       postgres    false    5                       1255    42143 J   gbt_float8_consistent(internal, double precision, smallint, oid, internal)    FUNCTION     Á   CREATE FUNCTION gbt_float8_consistent(internal, double precision, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_consistent';
 a   DROP FUNCTION public.gbt_float8_consistent(internal, double precision, smallint, oid, internal);
       public       postgres    false    5                        1255    42144 0   gbt_float8_penalty(internal, internal, internal)    FUNCTION     ¥   CREATE FUNCTION gbt_float8_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_penalty';
 G   DROP FUNCTION public.gbt_float8_penalty(internal, internal, internal);
       public       postgres    false    5            !           1255    42145 (   gbt_float8_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_float8_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_picksplit';
 ?   DROP FUNCTION public.gbt_float8_picksplit(internal, internal);
       public       postgres    false    5            "           1255    42146 -   gbt_float8_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_float8_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_same';
 D   DROP FUNCTION public.gbt_float8_same(internal, internal, internal);
       public       postgres    false    5            #           1255    42147 !   gbt_float8_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_float8_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_float8_union';
 8   DROP FUNCTION public.gbt_float8_union(bytea, internal);
       public       postgres    false    5    703            $           1255    42148    gbt_inet_compress(internal)    FUNCTION        CREATE FUNCTION gbt_inet_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_compress';
 2   DROP FUNCTION public.gbt_inet_compress(internal);
       public       postgres    false    5            %           1255    42149 <   gbt_inet_consistent(internal, inet, smallint, oid, internal)    FUNCTION     ±   CREATE FUNCTION gbt_inet_consistent(internal, inet, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_consistent';
 S   DROP FUNCTION public.gbt_inet_consistent(internal, inet, smallint, oid, internal);
       public       postgres    false    5            &           1255    42150 .   gbt_inet_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_inet_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_penalty';
 E   DROP FUNCTION public.gbt_inet_penalty(internal, internal, internal);
       public       postgres    false    5            '           1255    42151 &   gbt_inet_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_inet_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_picksplit';
 =   DROP FUNCTION public.gbt_inet_picksplit(internal, internal);
       public       postgres    false    5            (           1255    42152 +   gbt_inet_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_inet_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_same';
 B   DROP FUNCTION public.gbt_inet_same(internal, internal, internal);
       public       postgres    false    5            )           1255    42153    gbt_inet_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_inet_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_inet_union';
 6   DROP FUNCTION public.gbt_inet_union(bytea, internal);
       public       postgres    false    703    5            *           1255    42154    gbt_int2_compress(internal)    FUNCTION        CREATE FUNCTION gbt_int2_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_compress';
 2   DROP FUNCTION public.gbt_int2_compress(internal);
       public       postgres    false    5            +           1255    42155 @   gbt_int2_consistent(internal, smallint, smallint, oid, internal)    FUNCTION     µ   CREATE FUNCTION gbt_int2_consistent(internal, smallint, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_consistent';
 W   DROP FUNCTION public.gbt_int2_consistent(internal, smallint, smallint, oid, internal);
       public       postgres    false    5            ,           1255    42156 .   gbt_int2_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_int2_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_penalty';
 E   DROP FUNCTION public.gbt_int2_penalty(internal, internal, internal);
       public       postgres    false    5            -           1255    42157 &   gbt_int2_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_int2_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_picksplit';
 =   DROP FUNCTION public.gbt_int2_picksplit(internal, internal);
       public       postgres    false    5            .           1255    42158 +   gbt_int2_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_int2_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_same';
 B   DROP FUNCTION public.gbt_int2_same(internal, internal, internal);
       public       postgres    false    5            /           1255    42159    gbt_int2_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_int2_union(bytea, internal) RETURNS gbtreekey4
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int2_union';
 6   DROP FUNCTION public.gbt_int2_union(bytea, internal);
       public       postgres    false    5    711            0           1255    42160    gbt_int4_compress(internal)    FUNCTION        CREATE FUNCTION gbt_int4_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_compress';
 2   DROP FUNCTION public.gbt_int4_compress(internal);
       public       postgres    false    5            1           1255    42161 ?   gbt_int4_consistent(internal, integer, smallint, oid, internal)    FUNCTION     ´   CREATE FUNCTION gbt_int4_consistent(internal, integer, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_consistent';
 V   DROP FUNCTION public.gbt_int4_consistent(internal, integer, smallint, oid, internal);
       public       postgres    false    5            2           1255    42162 .   gbt_int4_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_int4_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_penalty';
 E   DROP FUNCTION public.gbt_int4_penalty(internal, internal, internal);
       public       postgres    false    5            3           1255    42163 &   gbt_int4_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_int4_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_picksplit';
 =   DROP FUNCTION public.gbt_int4_picksplit(internal, internal);
       public       postgres    false    5            4           1255    42164 +   gbt_int4_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_int4_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_same';
 B   DROP FUNCTION public.gbt_int4_same(internal, internal, internal);
       public       postgres    false    5            5           1255    42165    gbt_int4_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_int4_union(bytea, internal) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int4_union';
 6   DROP FUNCTION public.gbt_int4_union(bytea, internal);
       public       postgres    false    5    715            6           1255    42166    gbt_int8_compress(internal)    FUNCTION        CREATE FUNCTION gbt_int8_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_compress';
 2   DROP FUNCTION public.gbt_int8_compress(internal);
       public       postgres    false    5            7           1255    42167 >   gbt_int8_consistent(internal, bigint, smallint, oid, internal)    FUNCTION     ³   CREATE FUNCTION gbt_int8_consistent(internal, bigint, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_consistent';
 U   DROP FUNCTION public.gbt_int8_consistent(internal, bigint, smallint, oid, internal);
       public       postgres    false    5            8           1255    42168 .   gbt_int8_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_int8_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_penalty';
 E   DROP FUNCTION public.gbt_int8_penalty(internal, internal, internal);
       public       postgres    false    5            9           1255    42169 &   gbt_int8_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_int8_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_picksplit';
 =   DROP FUNCTION public.gbt_int8_picksplit(internal, internal);
       public       postgres    false    5            :           1255    42170 +   gbt_int8_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_int8_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_same';
 B   DROP FUNCTION public.gbt_int8_same(internal, internal, internal);
       public       postgres    false    5            ;           1255    42171    gbt_int8_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_int8_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_int8_union';
 6   DROP FUNCTION public.gbt_int8_union(bytea, internal);
       public       postgres    false    703    5            <           1255    42172    gbt_intv_compress(internal)    FUNCTION        CREATE FUNCTION gbt_intv_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_compress';
 2   DROP FUNCTION public.gbt_intv_compress(internal);
       public       postgres    false    5            =           1255    42173 @   gbt_intv_consistent(internal, interval, smallint, oid, internal)    FUNCTION     µ   CREATE FUNCTION gbt_intv_consistent(internal, interval, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_consistent';
 W   DROP FUNCTION public.gbt_intv_consistent(internal, interval, smallint, oid, internal);
       public       postgres    false    5            >           1255    42174    gbt_intv_decompress(internal)    FUNCTION        CREATE FUNCTION gbt_intv_decompress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_decompress';
 4   DROP FUNCTION public.gbt_intv_decompress(internal);
       public       postgres    false    5            ?           1255    42175 .   gbt_intv_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_intv_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_penalty';
 E   DROP FUNCTION public.gbt_intv_penalty(internal, internal, internal);
       public       postgres    false    5            @           1255    42176 &   gbt_intv_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_intv_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_picksplit';
 =   DROP FUNCTION public.gbt_intv_picksplit(internal, internal);
       public       postgres    false    5            A           1255    42177 +   gbt_intv_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_intv_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_same';
 B   DROP FUNCTION public.gbt_intv_same(internal, internal, internal);
       public       postgres    false    5            B           1255    42178    gbt_intv_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_intv_union(bytea, internal) RETURNS gbtreekey32
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_intv_union';
 6   DROP FUNCTION public.gbt_intv_union(bytea, internal);
       public       postgres    false    707    5            C           1255    42179    gbt_macad_compress(internal)    FUNCTION        CREATE FUNCTION gbt_macad_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_compress';
 3   DROP FUNCTION public.gbt_macad_compress(internal);
       public       postgres    false    5            D           1255    42180 @   gbt_macad_consistent(internal, macaddr, smallint, oid, internal)    FUNCTION     ¶   CREATE FUNCTION gbt_macad_consistent(internal, macaddr, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_consistent';
 W   DROP FUNCTION public.gbt_macad_consistent(internal, macaddr, smallint, oid, internal);
       public       postgres    false    5            E           1255    42181 /   gbt_macad_penalty(internal, internal, internal)    FUNCTION     £   CREATE FUNCTION gbt_macad_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_penalty';
 F   DROP FUNCTION public.gbt_macad_penalty(internal, internal, internal);
       public       postgres    false    5            F           1255    42182 '   gbt_macad_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_macad_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_picksplit';
 >   DROP FUNCTION public.gbt_macad_picksplit(internal, internal);
       public       postgres    false    5            G           1255    42183 ,   gbt_macad_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_macad_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_same';
 C   DROP FUNCTION public.gbt_macad_same(internal, internal, internal);
       public       postgres    false    5            H           1255    42184     gbt_macad_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_macad_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_macad_union';
 7   DROP FUNCTION public.gbt_macad_union(bytea, internal);
       public       postgres    false    5    703            I           1255    42185    gbt_numeric_compress(internal)    FUNCTION        CREATE FUNCTION gbt_numeric_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_compress';
 5   DROP FUNCTION public.gbt_numeric_compress(internal);
       public       postgres    false    5            J           1255    42186 B   gbt_numeric_consistent(internal, numeric, smallint, oid, internal)    FUNCTION     º   CREATE FUNCTION gbt_numeric_consistent(internal, numeric, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_consistent';
 Y   DROP FUNCTION public.gbt_numeric_consistent(internal, numeric, smallint, oid, internal);
       public       postgres    false    5            K           1255    42187 1   gbt_numeric_penalty(internal, internal, internal)    FUNCTION     §   CREATE FUNCTION gbt_numeric_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_penalty';
 H   DROP FUNCTION public.gbt_numeric_penalty(internal, internal, internal);
       public       postgres    false    5            L           1255    42188 )   gbt_numeric_picksplit(internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_numeric_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_picksplit';
 @   DROP FUNCTION public.gbt_numeric_picksplit(internal, internal);
       public       postgres    false    5            M           1255    42189 .   gbt_numeric_same(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_numeric_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_same';
 E   DROP FUNCTION public.gbt_numeric_same(internal, internal, internal);
       public       postgres    false    5            N           1255    42190 "   gbt_numeric_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_numeric_union(bytea, internal) RETURNS gbtreekey_var
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_numeric_union';
 9   DROP FUNCTION public.gbt_numeric_union(bytea, internal);
       public       postgres    false    719    5            O           1255    42191    gbt_oid_compress(internal)    FUNCTION        CREATE FUNCTION gbt_oid_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_compress';
 1   DROP FUNCTION public.gbt_oid_compress(internal);
       public       postgres    false    5            P           1255    42192 :   gbt_oid_consistent(internal, oid, smallint, oid, internal)    FUNCTION     ®   CREATE FUNCTION gbt_oid_consistent(internal, oid, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_consistent';
 Q   DROP FUNCTION public.gbt_oid_consistent(internal, oid, smallint, oid, internal);
       public       postgres    false    5            Q           1255    42193 -   gbt_oid_penalty(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_oid_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_penalty';
 D   DROP FUNCTION public.gbt_oid_penalty(internal, internal, internal);
       public       postgres    false    5            R           1255    42194 %   gbt_oid_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_oid_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_picksplit';
 <   DROP FUNCTION public.gbt_oid_picksplit(internal, internal);
       public       postgres    false    5            S           1255    42195 *   gbt_oid_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_oid_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_same';
 A   DROP FUNCTION public.gbt_oid_same(internal, internal, internal);
       public       postgres    false    5            T           1255    42196    gbt_oid_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_oid_union(bytea, internal) RETURNS gbtreekey8
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_oid_union';
 5   DROP FUNCTION public.gbt_oid_union(bytea, internal);
       public       postgres    false    715    5            U           1255    42197    gbt_text_compress(internal)    FUNCTION        CREATE FUNCTION gbt_text_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_compress';
 2   DROP FUNCTION public.gbt_text_compress(internal);
       public       postgres    false    5            V           1255    42198 <   gbt_text_consistent(internal, text, smallint, oid, internal)    FUNCTION     ±   CREATE FUNCTION gbt_text_consistent(internal, text, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_consistent';
 S   DROP FUNCTION public.gbt_text_consistent(internal, text, smallint, oid, internal);
       public       postgres    false    5            W           1255    42199 .   gbt_text_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_text_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_penalty';
 E   DROP FUNCTION public.gbt_text_penalty(internal, internal, internal);
       public       postgres    false    5            X           1255    42200 &   gbt_text_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_text_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_picksplit';
 =   DROP FUNCTION public.gbt_text_picksplit(internal, internal);
       public       postgres    false    5            Y           1255    42201 +   gbt_text_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_text_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_same';
 B   DROP FUNCTION public.gbt_text_same(internal, internal, internal);
       public       postgres    false    5            Z           1255    42202    gbt_text_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_text_union(bytea, internal) RETURNS gbtreekey_var
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_text_union';
 6   DROP FUNCTION public.gbt_text_union(bytea, internal);
       public       postgres    false    719    5            [           1255    42203    gbt_time_compress(internal)    FUNCTION        CREATE FUNCTION gbt_time_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_compress';
 2   DROP FUNCTION public.gbt_time_compress(internal);
       public       postgres    false    5            \           1255    42204 N   gbt_time_consistent(internal, time without time zone, smallint, oid, internal)    FUNCTION     Ã   CREATE FUNCTION gbt_time_consistent(internal, time without time zone, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_consistent';
 e   DROP FUNCTION public.gbt_time_consistent(internal, time without time zone, smallint, oid, internal);
       public       postgres    false    5            ]           1255    42205 .   gbt_time_penalty(internal, internal, internal)    FUNCTION     ¡   CREATE FUNCTION gbt_time_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_penalty';
 E   DROP FUNCTION public.gbt_time_penalty(internal, internal, internal);
       public       postgres    false    5            ^           1255    42206 &   gbt_time_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_time_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_picksplit';
 =   DROP FUNCTION public.gbt_time_picksplit(internal, internal);
       public       postgres    false    5            _           1255    42207 +   gbt_time_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_time_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_same';
 B   DROP FUNCTION public.gbt_time_same(internal, internal, internal);
       public       postgres    false    5            `           1255    42208    gbt_time_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_time_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_time_union';
 6   DROP FUNCTION public.gbt_time_union(bytea, internal);
       public       postgres    false    703    5            a           1255    42209    gbt_timetz_compress(internal)    FUNCTION        CREATE FUNCTION gbt_timetz_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_timetz_compress';
 4   DROP FUNCTION public.gbt_timetz_compress(internal);
       public       postgres    false    5            b           1255    42210 M   gbt_timetz_consistent(internal, time with time zone, smallint, oid, internal)    FUNCTION     Ä   CREATE FUNCTION gbt_timetz_consistent(internal, time with time zone, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_timetz_consistent';
 d   DROP FUNCTION public.gbt_timetz_consistent(internal, time with time zone, smallint, oid, internal);
       public       postgres    false    5            c           1255    42211    gbt_ts_compress(internal)    FUNCTION        CREATE FUNCTION gbt_ts_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_compress';
 0   DROP FUNCTION public.gbt_ts_compress(internal);
       public       postgres    false    5            d           1255    42212 Q   gbt_ts_consistent(internal, timestamp without time zone, smallint, oid, internal)    FUNCTION     Ä   CREATE FUNCTION gbt_ts_consistent(internal, timestamp without time zone, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_consistent';
 h   DROP FUNCTION public.gbt_ts_consistent(internal, timestamp without time zone, smallint, oid, internal);
       public       postgres    false    5            e           1255    42213 ,   gbt_ts_penalty(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_ts_penalty(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_penalty';
 C   DROP FUNCTION public.gbt_ts_penalty(internal, internal, internal);
       public       postgres    false    5            f           1255    42214 $   gbt_ts_picksplit(internal, internal)    FUNCTION        CREATE FUNCTION gbt_ts_picksplit(internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_picksplit';
 ;   DROP FUNCTION public.gbt_ts_picksplit(internal, internal);
       public       postgres    false    5            g           1255    42215 )   gbt_ts_same(internal, internal, internal)    FUNCTION        CREATE FUNCTION gbt_ts_same(internal, internal, internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_same';
 @   DROP FUNCTION public.gbt_ts_same(internal, internal, internal);
       public       postgres    false    5            h           1255    42216    gbt_ts_union(bytea, internal)    FUNCTION        CREATE FUNCTION gbt_ts_union(bytea, internal) RETURNS gbtreekey16
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_ts_union';
 4   DROP FUNCTION public.gbt_ts_union(bytea, internal);
       public       postgres    false    5    703            i           1255    42217    gbt_tstz_compress(internal)    FUNCTION        CREATE FUNCTION gbt_tstz_compress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_tstz_compress';
 2   DROP FUNCTION public.gbt_tstz_compress(internal);
       public       postgres    false    5            j           1255    42218 P   gbt_tstz_consistent(internal, timestamp with time zone, smallint, oid, internal)    FUNCTION     Å   CREATE FUNCTION gbt_tstz_consistent(internal, timestamp with time zone, smallint, oid, internal) RETURNS boolean
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_tstz_consistent';
 g   DROP FUNCTION public.gbt_tstz_consistent(internal, timestamp with time zone, smallint, oid, internal);
       public       postgres    false    5            k           1255    42219    gbt_var_decompress(internal)    FUNCTION        CREATE FUNCTION gbt_var_decompress(internal) RETURNS internal
    LANGUAGE c IMMUTABLE STRICT
    AS '$libdir/btree_gist', 'gbt_var_decompress';
 3   DROP FUNCTION public.gbt_var_decompress(internal);
       public       postgres    false    5            ö           2616    42221    gist_bit_ops    OPERATOR CLASS     ¾  CREATE OPERATOR CLASS gist_bit_ops
    DEFAULT FOR TYPE bit USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(bit,bit) ,
    OPERATOR 2 <=(bit,bit) ,
    OPERATOR 3 =(bit,bit) ,
    OPERATOR 4 >=(bit,bit) ,
    OPERATOR 5 >(bit,bit) ,
    FUNCTION 1 (bit, bit) gbt_bit_consistent(internal,bit,smallint,oid,internal) ,
    FUNCTION 2 (bit, bit) gbt_bit_union(bytea,internal) ,
    FUNCTION 3 (bit, bit) gbt_bit_compress(internal) ,
    FUNCTION 4 (bit, bit) gbt_var_decompress(internal) ,
    FUNCTION 5 (bit, bit) gbt_bit_penalty(internal,internal,internal) ,
    FUNCTION 6 (bit, bit) gbt_bit_picksplit(internal,internal) ,
    FUNCTION 7 (bit, bit) gbt_bit_same(internal,internal,internal);
 4   DROP OPERATOR CLASS public.gist_bit_ops USING gist;
       public       postgres    false    5    5    719            ÷           2616    42235    gist_bpchar_ops    OPERATOR CLASS     g  CREATE OPERATOR CLASS gist_bpchar_ops
    DEFAULT FOR TYPE character USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(character,character) ,
    OPERATOR 2 <=(character,character) ,
    OPERATOR 3 =(character,character) ,
    OPERATOR 4 >=(character,character) ,
    OPERATOR 5 >(character,character) ,
    FUNCTION 1 (character, character) gbt_bpchar_consistent(internal,character,smallint,oid,internal) ,
    FUNCTION 2 (character, character) gbt_text_union(bytea,internal) ,
    FUNCTION 3 (character, character) gbt_bpchar_compress(internal) ,
    FUNCTION 4 (character, character) gbt_var_decompress(internal) ,
    FUNCTION 5 (character, character) gbt_text_penalty(internal,internal,internal) ,
    FUNCTION 6 (character, character) gbt_text_picksplit(internal,internal) ,
    FUNCTION 7 (character, character) gbt_text_same(internal,internal,internal);
 7   DROP OPERATOR CLASS public.gist_bpchar_ops USING gist;
       public       postgres    false    719    5    5            ø           2616    42249    gist_bytea_ops    OPERATOR CLASS        CREATE OPERATOR CLASS gist_bytea_ops
    DEFAULT FOR TYPE bytea USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(bytea,bytea) ,
    OPERATOR 2 <=(bytea,bytea) ,
    OPERATOR 3 =(bytea,bytea) ,
    OPERATOR 4 >=(bytea,bytea) ,
    OPERATOR 5 >(bytea,bytea) ,
    FUNCTION 1 (bytea, bytea) gbt_bytea_consistent(internal,bytea,smallint,oid,internal) ,
    FUNCTION 2 (bytea, bytea) gbt_bytea_union(bytea,internal) ,
    FUNCTION 3 (bytea, bytea) gbt_bytea_compress(internal) ,
    FUNCTION 4 (bytea, bytea) gbt_var_decompress(internal) ,
    FUNCTION 5 (bytea, bytea) gbt_bytea_penalty(internal,internal,internal) ,
    FUNCTION 6 (bytea, bytea) gbt_bytea_picksplit(internal,internal) ,
    FUNCTION 7 (bytea, bytea) gbt_bytea_same(internal,internal,internal);
 6   DROP OPERATOR CLASS public.gist_bytea_ops USING gist;
       public       postgres    false    719    5    5            ù           2616    42263    gist_cash_ops    OPERATOR CLASS     ó  CREATE OPERATOR CLASS gist_cash_ops
    DEFAULT FOR TYPE money USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(money,money) ,
    OPERATOR 2 <=(money,money) ,
    OPERATOR 3 =(money,money) ,
    OPERATOR 4 >=(money,money) ,
    OPERATOR 5 >(money,money) ,
    FUNCTION 1 (money, money) gbt_cash_consistent(internal,money,smallint,oid,internal) ,
    FUNCTION 2 (money, money) gbt_cash_union(bytea,internal) ,
    FUNCTION 3 (money, money) gbt_cash_compress(internal) ,
    FUNCTION 4 (money, money) gbt_decompress(internal) ,
    FUNCTION 5 (money, money) gbt_cash_penalty(internal,internal,internal) ,
    FUNCTION 6 (money, money) gbt_cash_picksplit(internal,internal) ,
    FUNCTION 7 (money, money) gbt_cash_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_cash_ops USING gist;
       public       postgres    false    5    703    5            ú           2616    42277    gist_cidr_ops    OPERATOR CLASS     Ù  CREATE OPERATOR CLASS gist_cidr_ops
    DEFAULT FOR TYPE cidr USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(inet,inet) ,
    OPERATOR 2 <=(inet,inet) ,
    OPERATOR 3 =(inet,inet) ,
    OPERATOR 4 >=(inet,inet) ,
    OPERATOR 5 >(inet,inet) ,
    FUNCTION 1 (cidr, cidr) gbt_inet_consistent(internal,inet,smallint,oid,internal) ,
    FUNCTION 2 (cidr, cidr) gbt_inet_union(bytea,internal) ,
    FUNCTION 3 (cidr, cidr) gbt_inet_compress(internal) ,
    FUNCTION 4 (cidr, cidr) gbt_decompress(internal) ,
    FUNCTION 5 (cidr, cidr) gbt_inet_penalty(internal,internal,internal) ,
    FUNCTION 6 (cidr, cidr) gbt_inet_picksplit(internal,internal) ,
    FUNCTION 7 (cidr, cidr) gbt_inet_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_cidr_ops USING gist;
       public       postgres    false    5    703    5            û           2616    42291    gist_date_ops    OPERATOR CLASS     Ø  CREATE OPERATOR CLASS gist_date_ops
    DEFAULT FOR TYPE date USING gist AS
    STORAGE gbtreekey8 ,
    OPERATOR 1 <(date,date) ,
    OPERATOR 2 <=(date,date) ,
    OPERATOR 3 =(date,date) ,
    OPERATOR 4 >=(date,date) ,
    OPERATOR 5 >(date,date) ,
    FUNCTION 1 (date, date) gbt_date_consistent(internal,date,smallint,oid,internal) ,
    FUNCTION 2 (date, date) gbt_date_union(bytea,internal) ,
    FUNCTION 3 (date, date) gbt_date_compress(internal) ,
    FUNCTION 4 (date, date) gbt_decompress(internal) ,
    FUNCTION 5 (date, date) gbt_date_penalty(internal,internal,internal) ,
    FUNCTION 6 (date, date) gbt_date_picksplit(internal,internal) ,
    FUNCTION 7 (date, date) gbt_date_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_date_ops USING gist;
       public       postgres    false    5    715    5            ü           2616    42305    gist_float4_ops    OPERATOR CLASS     æ  CREATE OPERATOR CLASS gist_float4_ops
    DEFAULT FOR TYPE real USING gist AS
    STORAGE gbtreekey8 ,
    OPERATOR 1 <(real,real) ,
    OPERATOR 2 <=(real,real) ,
    OPERATOR 3 =(real,real) ,
    OPERATOR 4 >=(real,real) ,
    OPERATOR 5 >(real,real) ,
    FUNCTION 1 (real, real) gbt_float4_consistent(internal,real,smallint,oid,internal) ,
    FUNCTION 2 (real, real) gbt_float4_union(bytea,internal) ,
    FUNCTION 3 (real, real) gbt_float4_compress(internal) ,
    FUNCTION 4 (real, real) gbt_decompress(internal) ,
    FUNCTION 5 (real, real) gbt_float4_penalty(internal,internal,internal) ,
    FUNCTION 6 (real, real) gbt_float4_picksplit(internal,internal) ,
    FUNCTION 7 (real, real) gbt_float4_same(internal,internal,internal);
 7   DROP OPERATOR CLASS public.gist_float4_ops USING gist;
       public       postgres    false    715    5    5            ý           2616    42319    gist_float8_ops    OPERATOR CLASS       CREATE OPERATOR CLASS gist_float8_ops
    DEFAULT FOR TYPE double precision USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(double precision,double precision) ,
    OPERATOR 2 <=(double precision,double precision) ,
    OPERATOR 3 =(double precision,double precision) ,
    OPERATOR 4 >=(double precision,double precision) ,
    OPERATOR 5 >(double precision,double precision) ,
    FUNCTION 1 (double precision, double precision) gbt_float8_consistent(internal,double precision,smallint,oid,internal) ,
    FUNCTION 2 (double precision, double precision) gbt_float8_union(bytea,internal) ,
    FUNCTION 3 (double precision, double precision) gbt_float8_compress(internal) ,
    FUNCTION 4 (double precision, double precision) gbt_decompress(internal) ,
    FUNCTION 5 (double precision, double precision) gbt_float8_penalty(internal,internal,internal) ,
    FUNCTION 6 (double precision, double precision) gbt_float8_picksplit(internal,internal) ,
    FUNCTION 7 (double precision, double precision) gbt_float8_same(internal,internal,internal);
 7   DROP OPERATOR CLASS public.gist_float8_ops USING gist;
       public       postgres    false    5    703    5            þ           2616    42333    gist_inet_ops    OPERATOR CLASS     Ù  CREATE OPERATOR CLASS gist_inet_ops
    DEFAULT FOR TYPE inet USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(inet,inet) ,
    OPERATOR 2 <=(inet,inet) ,
    OPERATOR 3 =(inet,inet) ,
    OPERATOR 4 >=(inet,inet) ,
    OPERATOR 5 >(inet,inet) ,
    FUNCTION 1 (inet, inet) gbt_inet_consistent(internal,inet,smallint,oid,internal) ,
    FUNCTION 2 (inet, inet) gbt_inet_union(bytea,internal) ,
    FUNCTION 3 (inet, inet) gbt_inet_compress(internal) ,
    FUNCTION 4 (inet, inet) gbt_decompress(internal) ,
    FUNCTION 5 (inet, inet) gbt_inet_penalty(internal,internal,internal) ,
    FUNCTION 6 (inet, inet) gbt_inet_picksplit(internal,internal) ,
    FUNCTION 7 (inet, inet) gbt_inet_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_inet_ops USING gist;
       public       postgres    false    703    5    5            ÿ           2616    42347    gist_int2_ops    OPERATOR CLASS     @  CREATE OPERATOR CLASS gist_int2_ops
    DEFAULT FOR TYPE smallint USING gist AS
    STORAGE gbtreekey4 ,
    OPERATOR 1 <(smallint,smallint) ,
    OPERATOR 2 <=(smallint,smallint) ,
    OPERATOR 3 =(smallint,smallint) ,
    OPERATOR 4 >=(smallint,smallint) ,
    OPERATOR 5 >(smallint,smallint) ,
    FUNCTION 1 (smallint, smallint) gbt_int2_consistent(internal,smallint,smallint,oid,internal) ,
    FUNCTION 2 (smallint, smallint) gbt_int2_union(bytea,internal) ,
    FUNCTION 3 (smallint, smallint) gbt_int2_compress(internal) ,
    FUNCTION 4 (smallint, smallint) gbt_decompress(internal) ,
    FUNCTION 5 (smallint, smallint) gbt_int2_penalty(internal,internal,internal) ,
    FUNCTION 6 (smallint, smallint) gbt_int2_picksplit(internal,internal) ,
    FUNCTION 7 (smallint, smallint) gbt_int2_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_int2_ops USING gist;
       public       postgres    false    5    5    711                        2616    42361    gist_int4_ops    OPERATOR CLASS     &  CREATE OPERATOR CLASS gist_int4_ops
    DEFAULT FOR TYPE integer USING gist AS
    STORAGE gbtreekey8 ,
    OPERATOR 1 <(integer,integer) ,
    OPERATOR 2 <=(integer,integer) ,
    OPERATOR 3 =(integer,integer) ,
    OPERATOR 4 >=(integer,integer) ,
    OPERATOR 5 >(integer,integer) ,
    FUNCTION 1 (integer, integer) gbt_int4_consistent(internal,integer,smallint,oid,internal) ,
    FUNCTION 2 (integer, integer) gbt_int4_union(bytea,internal) ,
    FUNCTION 3 (integer, integer) gbt_int4_compress(internal) ,
    FUNCTION 4 (integer, integer) gbt_decompress(internal) ,
    FUNCTION 5 (integer, integer) gbt_int4_penalty(internal,internal,internal) ,
    FUNCTION 6 (integer, integer) gbt_int4_picksplit(internal,internal) ,
    FUNCTION 7 (integer, integer) gbt_int4_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_int4_ops USING gist;
       public       postgres    false    5    5    715                       2616    42375    gist_int8_ops    OPERATOR CLASS       CREATE OPERATOR CLASS gist_int8_ops
    DEFAULT FOR TYPE bigint USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(bigint,bigint) ,
    OPERATOR 2 <=(bigint,bigint) ,
    OPERATOR 3 =(bigint,bigint) ,
    OPERATOR 4 >=(bigint,bigint) ,
    OPERATOR 5 >(bigint,bigint) ,
    FUNCTION 1 (bigint, bigint) gbt_int8_consistent(internal,bigint,smallint,oid,internal) ,
    FUNCTION 2 (bigint, bigint) gbt_int8_union(bytea,internal) ,
    FUNCTION 3 (bigint, bigint) gbt_int8_compress(internal) ,
    FUNCTION 4 (bigint, bigint) gbt_decompress(internal) ,
    FUNCTION 5 (bigint, bigint) gbt_int8_penalty(internal,internal,internal) ,
    FUNCTION 6 (bigint, bigint) gbt_int8_picksplit(internal,internal) ,
    FUNCTION 7 (bigint, bigint) gbt_int8_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_int8_ops USING gist;
       public       postgres    false    5    5    703                       2616    42389    gist_interval_ops    OPERATOR CLASS     J  CREATE OPERATOR CLASS gist_interval_ops
    DEFAULT FOR TYPE interval USING gist AS
    STORAGE gbtreekey32 ,
    OPERATOR 1 <(interval,interval) ,
    OPERATOR 2 <=(interval,interval) ,
    OPERATOR 3 =(interval,interval) ,
    OPERATOR 4 >=(interval,interval) ,
    OPERATOR 5 >(interval,interval) ,
    FUNCTION 1 (interval, interval) gbt_intv_consistent(internal,interval,smallint,oid,internal) ,
    FUNCTION 2 (interval, interval) gbt_intv_union(bytea,internal) ,
    FUNCTION 3 (interval, interval) gbt_intv_compress(internal) ,
    FUNCTION 4 (interval, interval) gbt_intv_decompress(internal) ,
    FUNCTION 5 (interval, interval) gbt_intv_penalty(internal,internal,internal) ,
    FUNCTION 6 (interval, interval) gbt_intv_picksplit(internal,internal) ,
    FUNCTION 7 (interval, interval) gbt_intv_same(internal,internal,internal);
 9   DROP OPERATOR CLASS public.gist_interval_ops USING gist;
       public       postgres    false    5    707    5                       2616    42403    gist_macaddr_ops    OPERATOR CLASS     0  CREATE OPERATOR CLASS gist_macaddr_ops
    DEFAULT FOR TYPE macaddr USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(macaddr,macaddr) ,
    OPERATOR 2 <=(macaddr,macaddr) ,
    OPERATOR 3 =(macaddr,macaddr) ,
    OPERATOR 4 >=(macaddr,macaddr) ,
    OPERATOR 5 >(macaddr,macaddr) ,
    FUNCTION 1 (macaddr, macaddr) gbt_macad_consistent(internal,macaddr,smallint,oid,internal) ,
    FUNCTION 2 (macaddr, macaddr) gbt_macad_union(bytea,internal) ,
    FUNCTION 3 (macaddr, macaddr) gbt_macad_compress(internal) ,
    FUNCTION 4 (macaddr, macaddr) gbt_decompress(internal) ,
    FUNCTION 5 (macaddr, macaddr) gbt_macad_penalty(internal,internal,internal) ,
    FUNCTION 6 (macaddr, macaddr) gbt_macad_picksplit(internal,internal) ,
    FUNCTION 7 (macaddr, macaddr) gbt_macad_same(internal,internal,internal);
 8   DROP OPERATOR CLASS public.gist_macaddr_ops USING gist;
       public       postgres    false    703    5    5                       2616    42417    gist_numeric_ops    OPERATOR CLASS     B  CREATE OPERATOR CLASS gist_numeric_ops
    DEFAULT FOR TYPE numeric USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(numeric,numeric) ,
    OPERATOR 2 <=(numeric,numeric) ,
    OPERATOR 3 =(numeric,numeric) ,
    OPERATOR 4 >=(numeric,numeric) ,
    OPERATOR 5 >(numeric,numeric) ,
    FUNCTION 1 (numeric, numeric) gbt_numeric_consistent(internal,numeric,smallint,oid,internal) ,
    FUNCTION 2 (numeric, numeric) gbt_numeric_union(bytea,internal) ,
    FUNCTION 3 (numeric, numeric) gbt_numeric_compress(internal) ,
    FUNCTION 4 (numeric, numeric) gbt_var_decompress(internal) ,
    FUNCTION 5 (numeric, numeric) gbt_numeric_penalty(internal,internal,internal) ,
    FUNCTION 6 (numeric, numeric) gbt_numeric_picksplit(internal,internal) ,
    FUNCTION 7 (numeric, numeric) gbt_numeric_same(internal,internal,internal);
 8   DROP OPERATOR CLASS public.gist_numeric_ops USING gist;
       public       postgres    false    5    5    719                       2616    42431    gist_oid_ops    OPERATOR CLASS     ·  CREATE OPERATOR CLASS gist_oid_ops
    DEFAULT FOR TYPE oid USING gist AS
    STORAGE gbtreekey8 ,
    OPERATOR 1 <(oid,oid) ,
    OPERATOR 2 <=(oid,oid) ,
    OPERATOR 3 =(oid,oid) ,
    OPERATOR 4 >=(oid,oid) ,
    OPERATOR 5 >(oid,oid) ,
    FUNCTION 1 (oid, oid) gbt_oid_consistent(internal,oid,smallint,oid,internal) ,
    FUNCTION 2 (oid, oid) gbt_oid_union(bytea,internal) ,
    FUNCTION 3 (oid, oid) gbt_oid_compress(internal) ,
    FUNCTION 4 (oid, oid) gbt_decompress(internal) ,
    FUNCTION 5 (oid, oid) gbt_oid_penalty(internal,internal,internal) ,
    FUNCTION 6 (oid, oid) gbt_oid_picksplit(internal,internal) ,
    FUNCTION 7 (oid, oid) gbt_oid_same(internal,internal,internal);
 4   DROP OPERATOR CLASS public.gist_oid_ops USING gist;
       public       postgres    false    5    715    5                       2616    42445    gist_text_ops    OPERATOR CLASS     ß  CREATE OPERATOR CLASS gist_text_ops
    DEFAULT FOR TYPE text USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(text,text) ,
    OPERATOR 2 <=(text,text) ,
    OPERATOR 3 =(text,text) ,
    OPERATOR 4 >=(text,text) ,
    OPERATOR 5 >(text,text) ,
    FUNCTION 1 (text, text) gbt_text_consistent(internal,text,smallint,oid,internal) ,
    FUNCTION 2 (text, text) gbt_text_union(bytea,internal) ,
    FUNCTION 3 (text, text) gbt_text_compress(internal) ,
    FUNCTION 4 (text, text) gbt_var_decompress(internal) ,
    FUNCTION 5 (text, text) gbt_text_penalty(internal,internal,internal) ,
    FUNCTION 6 (text, text) gbt_text_picksplit(internal,internal) ,
    FUNCTION 7 (text, text) gbt_text_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_text_ops USING gist;
       public       postgres    false    719    5    5                       2616    42459    gist_time_ops    OPERATOR CLASS     ­  CREATE OPERATOR CLASS gist_time_ops
    DEFAULT FOR TYPE time without time zone USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(time without time zone,time without time zone) ,
    OPERATOR 2 <=(time without time zone,time without time zone) ,
    OPERATOR 3 =(time without time zone,time without time zone) ,
    OPERATOR 4 >=(time without time zone,time without time zone) ,
    OPERATOR 5 >(time without time zone,time without time zone) ,
    FUNCTION 1 (time without time zone, time without time zone) gbt_time_consistent(internal,time without time zone,smallint,oid,internal) ,
    FUNCTION 2 (time without time zone, time without time zone) gbt_time_union(bytea,internal) ,
    FUNCTION 3 (time without time zone, time without time zone) gbt_time_compress(internal) ,
    FUNCTION 4 (time without time zone, time without time zone) gbt_decompress(internal) ,
    FUNCTION 5 (time without time zone, time without time zone) gbt_time_penalty(internal,internal,internal) ,
    FUNCTION 6 (time without time zone, time without time zone) gbt_time_picksplit(internal,internal) ,
    FUNCTION 7 (time without time zone, time without time zone) gbt_time_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_time_ops USING gist;
       public       postgres    false    5    5    703                       2616    42473    gist_timestamp_ops    OPERATOR CLASS     (  CREATE OPERATOR CLASS gist_timestamp_ops
    DEFAULT FOR TYPE timestamp without time zone USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(timestamp without time zone,timestamp without time zone) ,
    OPERATOR 2 <=(timestamp without time zone,timestamp without time zone) ,
    OPERATOR 3 =(timestamp without time zone,timestamp without time zone) ,
    OPERATOR 4 >=(timestamp without time zone,timestamp without time zone) ,
    OPERATOR 5 >(timestamp without time zone,timestamp without time zone) ,
    FUNCTION 1 (timestamp without time zone, timestamp without time zone) gbt_ts_consistent(internal,timestamp without time zone,smallint,oid,internal) ,
    FUNCTION 2 (timestamp without time zone, timestamp without time zone) gbt_ts_union(bytea,internal) ,
    FUNCTION 3 (timestamp without time zone, timestamp without time zone) gbt_ts_compress(internal) ,
    FUNCTION 4 (timestamp without time zone, timestamp without time zone) gbt_decompress(internal) ,
    FUNCTION 5 (timestamp without time zone, timestamp without time zone) gbt_ts_penalty(internal,internal,internal) ,
    FUNCTION 6 (timestamp without time zone, timestamp without time zone) gbt_ts_picksplit(internal,internal) ,
    FUNCTION 7 (timestamp without time zone, timestamp without time zone) gbt_ts_same(internal,internal,internal);
 :   DROP OPERATOR CLASS public.gist_timestamp_ops USING gist;
       public       postgres    false    5    5    703            	           2616    42487    gist_timestamptz_ops    OPERATOR CLASS     à  CREATE OPERATOR CLASS gist_timestamptz_ops
    DEFAULT FOR TYPE timestamp with time zone USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(timestamp with time zone,timestamp with time zone) ,
    OPERATOR 2 <=(timestamp with time zone,timestamp with time zone) ,
    OPERATOR 3 =(timestamp with time zone,timestamp with time zone) ,
    OPERATOR 4 >=(timestamp with time zone,timestamp with time zone) ,
    OPERATOR 5 >(timestamp with time zone,timestamp with time zone) ,
    FUNCTION 1 (timestamp with time zone, timestamp with time zone) gbt_tstz_consistent(internal,timestamp with time zone,smallint,oid,internal) ,
    FUNCTION 2 (timestamp with time zone, timestamp with time zone) gbt_ts_union(bytea,internal) ,
    FUNCTION 3 (timestamp with time zone, timestamp with time zone) gbt_tstz_compress(internal) ,
    FUNCTION 4 (timestamp with time zone, timestamp with time zone) gbt_decompress(internal) ,
    FUNCTION 5 (timestamp with time zone, timestamp with time zone) gbt_ts_penalty(internal,internal,internal) ,
    FUNCTION 6 (timestamp with time zone, timestamp with time zone) gbt_ts_picksplit(internal,internal) ,
    FUNCTION 7 (timestamp with time zone, timestamp with time zone) gbt_ts_same(internal,internal,internal);
 <   DROP OPERATOR CLASS public.gist_timestamptz_ops USING gist;
       public       postgres    false    703    5    5            
           2616    42501    gist_timetz_ops    OPERATOR CLASS     e  CREATE OPERATOR CLASS gist_timetz_ops
    DEFAULT FOR TYPE time with time zone USING gist AS
    STORAGE gbtreekey16 ,
    OPERATOR 1 <(time with time zone,time with time zone) ,
    OPERATOR 2 <=(time with time zone,time with time zone) ,
    OPERATOR 3 =(time with time zone,time with time zone) ,
    OPERATOR 4 >=(time with time zone,time with time zone) ,
    OPERATOR 5 >(time with time zone,time with time zone) ,
    FUNCTION 1 (time with time zone, time with time zone) gbt_timetz_consistent(internal,time with time zone,smallint,oid,internal) ,
    FUNCTION 2 (time with time zone, time with time zone) gbt_time_union(bytea,internal) ,
    FUNCTION 3 (time with time zone, time with time zone) gbt_timetz_compress(internal) ,
    FUNCTION 4 (time with time zone, time with time zone) gbt_decompress(internal) ,
    FUNCTION 5 (time with time zone, time with time zone) gbt_time_penalty(internal,internal,internal) ,
    FUNCTION 6 (time with time zone, time with time zone) gbt_time_picksplit(internal,internal) ,
    FUNCTION 7 (time with time zone, time with time zone) gbt_time_same(internal,internal,internal);
 7   DROP OPERATOR CLASS public.gist_timetz_ops USING gist;
       public       postgres    false    703    5    5                       2616    42515    gist_vbit_ops    OPERATOR CLASS       CREATE OPERATOR CLASS gist_vbit_ops
    DEFAULT FOR TYPE bit varying USING gist AS
    STORAGE gbtreekey_var ,
    OPERATOR 1 <(bit varying,bit varying) ,
    OPERATOR 2 <=(bit varying,bit varying) ,
    OPERATOR 3 =(bit varying,bit varying) ,
    OPERATOR 4 >=(bit varying,bit varying) ,
    OPERATOR 5 >(bit varying,bit varying) ,
    FUNCTION 1 (bit varying, bit varying) gbt_bit_consistent(internal,bit,smallint,oid,internal) ,
    FUNCTION 2 (bit varying, bit varying) gbt_bit_union(bytea,internal) ,
    FUNCTION 3 (bit varying, bit varying) gbt_bit_compress(internal) ,
    FUNCTION 4 (bit varying, bit varying) gbt_var_decompress(internal) ,
    FUNCTION 5 (bit varying, bit varying) gbt_bit_penalty(internal,internal,internal) ,
    FUNCTION 6 (bit varying, bit varying) gbt_bit_picksplit(internal,internal) ,
    FUNCTION 7 (bit varying, bit varying) gbt_bit_same(internal,internal,internal);
 5   DROP OPERATOR CLASS public.gist_vbit_ops USING gist;
       public       postgres    false    719    5    5            ¬            1259    42528    acls    TABLE     ª   CREATE TABLE acls (
    id integer NOT NULL,
    address inet NOT NULL,
    netmask inet NOT NULL,
    k character varying(255) NOT NULL,
    v character varying(255)
);
    DROP TABLE public.acls;
       public         postgres    false    5            ­            1259    42534    acls_id_seq    SEQUENCE     m   CREATE SEQUENCE acls_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.acls_id_seq;
       public       postgres    false    172    5            
           0    0    acls_id_seq    SEQUENCE OWNED BY     -   ALTER SEQUENCE acls_id_seq OWNED BY acls.id;
            public       postgres    false    173            ®            1259    42536    changeset_tags    TABLE     Ì   CREATE TABLE changeset_tags (
    changeset_id bigint NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL
);
 "   DROP TABLE public.changeset_tags;
       public         postgres    false    5            ¯            1259    42544 
   changesets    TABLE     :  CREATE TABLE changesets (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    min_lat integer,
    max_lat integer,
    min_lon integer,
    max_lon integer,
    closed_at timestamp without time zone NOT NULL,
    num_changes integer DEFAULT 0 NOT NULL
);
    DROP TABLE public.changesets;
       public         postgres    false    5            °            1259    42548    changesets_id_seq    SEQUENCE     s   CREATE SEQUENCE changesets_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.changesets_id_seq;
       public       postgres    false    175    5            
           0    0    changesets_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE changesets_id_seq OWNED BY changesets.id;
            public       postgres    false    176            ±            1259    42550    client_applications    TABLE     º  CREATE TABLE client_applications (
    id integer NOT NULL,
    name character varying(255),
    url character varying(255),
    support_url character varying(255),
    callback_url character varying(255),
    key character varying(50),
    secret character varying(50),
    user_id integer,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    allow_read_prefs boolean DEFAULT false NOT NULL,
    allow_write_prefs boolean DEFAULT false NOT NULL,
    allow_write_diary boolean DEFAULT false NOT NULL,
    allow_write_api boolean DEFAULT false NOT NULL,
    allow_read_gpx boolean DEFAULT false NOT NULL,
    allow_write_gpx boolean DEFAULT false NOT NULL
);
 '   DROP TABLE public.client_applications;
       public         postgres    false    5            ²            1259    42562    client_applications_id_seq    SEQUENCE     |   CREATE SEQUENCE client_applications_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.client_applications_id_seq;
       public       postgres    false    5    177            
           0    0    client_applications_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE client_applications_id_seq OWNED BY client_applications.id;
            public       postgres    false    178            ³            1259    42564 	   countries    TABLE     ø   CREATE TABLE countries (
    id integer NOT NULL,
    code character varying(2) NOT NULL,
    min_lat double precision NOT NULL,
    max_lat double precision NOT NULL,
    min_lon double precision NOT NULL,
    max_lon double precision NOT NULL
);
    DROP TABLE public.countries;
       public         postgres    false    5            ´            1259    42567    countries_id_seq    SEQUENCE     r   CREATE SEQUENCE countries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.countries_id_seq;
       public       postgres    false    5    179            
           0    0    countries_id_seq    SEQUENCE OWNED BY     7   ALTER SEQUENCE countries_id_seq OWNED BY countries.id;
            public       postgres    false    180            µ            1259    42569    current_node_tags    TABLE     Ê   CREATE TABLE current_node_tags (
    node_id bigint NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL
);
 %   DROP TABLE public.current_node_tags;
       public         postgres    false    5            ¶            1259    42577    current_nodes    TABLE     #  CREATE TABLE current_nodes (
    id bigint NOT NULL,
    latitude integer NOT NULL,
    longitude integer NOT NULL,
    changeset_id bigint NOT NULL,
    visible boolean NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    tile bigint NOT NULL,
    version bigint NOT NULL
);
 !   DROP TABLE public.current_nodes;
       public         postgres    false    5            ·            1259    42580    current_nodes_id_seq    SEQUENCE     v   CREATE SEQUENCE current_nodes_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.current_nodes_id_seq;
       public       postgres    false    182    5            
           0    0    current_nodes_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE current_nodes_id_seq OWNED BY current_nodes.id;
            public       postgres    false    183            ¸            1259    42582    current_relation_members    TABLE     ê   CREATE TABLE current_relation_members (
    relation_id bigint NOT NULL,
    member_type nwr_enum NOT NULL,
    member_id bigint NOT NULL,
    member_role character varying(255) NOT NULL,
    sequence_id integer DEFAULT 0 NOT NULL
);
 ,   DROP TABLE public.current_relation_members;
       public         postgres    false    726    5            ¹            1259    42586    current_relation_tags    TABLE     Ò   CREATE TABLE current_relation_tags (
    relation_id bigint NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL
);
 )   DROP TABLE public.current_relation_tags;
       public         postgres    false    5            º            1259    42594    current_relations    TABLE     Î   CREATE TABLE current_relations (
    id bigint NOT NULL,
    changeset_id bigint NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    visible boolean NOT NULL,
    version bigint NOT NULL
);
 %   DROP TABLE public.current_relations;
       public         postgres    false    5            »            1259    42597    current_relations_id_seq    SEQUENCE     z   CREATE SEQUENCE current_relations_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.current_relations_id_seq;
       public       postgres    false    186    5            
           0    0    current_relations_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE current_relations_id_seq OWNED BY current_relations.id;
            public       postgres    false    187            ¼            1259    42599    current_way_nodes    TABLE     }   CREATE TABLE current_way_nodes (
    way_id bigint NOT NULL,
    node_id bigint NOT NULL,
    sequence_id bigint NOT NULL
);
 %   DROP TABLE public.current_way_nodes;
       public         postgres    false    5            ½            1259    42602    current_way_tags    TABLE     È   CREATE TABLE current_way_tags (
    way_id bigint NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL
);
 $   DROP TABLE public.current_way_tags;
       public         postgres    false    5            ¾            1259    42610    current_ways    TABLE     É   CREATE TABLE current_ways (
    id bigint NOT NULL,
    changeset_id bigint NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    visible boolean NOT NULL,
    version bigint NOT NULL
);
     DROP TABLE public.current_ways;
       public         postgres    false    5            ¿            1259    42613    current_ways_id_seq    SEQUENCE     u   CREATE SEQUENCE current_ways_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.current_ways_id_seq;
       public       postgres    false    5    190            
           0    0    current_ways_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE current_ways_id_seq OWNED BY current_ways.id;
            public       postgres    false    191            À            1259    42615    diary_comments    TABLE     &  CREATE TABLE diary_comments (
    id bigint NOT NULL,
    diary_entry_id bigint NOT NULL,
    user_id bigint NOT NULL,
    body text NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    visible boolean DEFAULT true NOT NULL
);
 "   DROP TABLE public.diary_comments;
       public         postgres    false    5            Á            1259    42622    diary_comments_id_seq    SEQUENCE     w   CREATE SEQUENCE diary_comments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.diary_comments_id_seq;
       public       postgres    false    5    192            
           0    0    diary_comments_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE diary_comments_id_seq OWNED BY diary_comments.id;
            public       postgres    false    193            Â            1259    42624    diary_entries    TABLE     ¾  CREATE TABLE diary_entries (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    title character varying(255) NOT NULL,
    body text NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    latitude double precision,
    longitude double precision,
    language_code character varying(255) DEFAULT 'en'::character varying NOT NULL,
    visible boolean DEFAULT true NOT NULL
);
 !   DROP TABLE public.diary_entries;
       public         postgres    false    5            Ã            1259    42632    diary_entries_id_seq    SEQUENCE     v   CREATE SEQUENCE diary_entries_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.diary_entries_id_seq;
       public       postgres    false    5    194            
           0    0    diary_entries_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE diary_entries_id_seq OWNED BY diary_entries.id;
            public       postgres    false    195            Ä            1259    42634    friends    TABLE     r   CREATE TABLE friends (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    friend_user_id bigint NOT NULL
);
    DROP TABLE public.friends;
       public         postgres    false    5            Å            1259    42637    friends_id_seq    SEQUENCE     p   CREATE SEQUENCE friends_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.friends_id_seq;
       public       postgres    false    196    5            
           0    0    friends_id_seq    SEQUENCE OWNED BY     3   ALTER SEQUENCE friends_id_seq OWNED BY friends.id;
            public       postgres    false    197            Æ            1259    42639 
   gps_points    TABLE     ò   CREATE TABLE gps_points (
    altitude double precision,
    trackid integer NOT NULL,
    latitude integer NOT NULL,
    longitude integer NOT NULL,
    gpx_id bigint NOT NULL,
    "timestamp" timestamp without time zone,
    tile bigint
);
    DROP TABLE public.gps_points;
       public         postgres    false    5            Ç            1259    42642    gpx_file_tags    TABLE        CREATE TABLE gpx_file_tags (
    gpx_id bigint DEFAULT 0 NOT NULL,
    tag character varying(255) NOT NULL,
    id bigint NOT NULL
);
 !   DROP TABLE public.gpx_file_tags;
       public         postgres    false    5            È            1259    42646    gpx_file_tags_id_seq    SEQUENCE     v   CREATE SEQUENCE gpx_file_tags_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.gpx_file_tags_id_seq;
       public       postgres    false    5    199            
           0    0    gpx_file_tags_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE gpx_file_tags_id_seq OWNED BY gpx_file_tags.id;
            public       postgres    false    200            É            1259    42648 	   gpx_files    TABLE     
  CREATE TABLE gpx_files (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    visible boolean DEFAULT true NOT NULL,
    name character varying(255) DEFAULT ''::character varying NOT NULL,
    size bigint,
    latitude double precision,
    longitude double precision,
    "timestamp" timestamp without time zone NOT NULL,
    description character varying(255) DEFAULT ''::character varying NOT NULL,
    inserted boolean NOT NULL,
    visibility gpx_visibility_enum DEFAULT 'public'::gpx_visibility_enum NOT NULL
);
    DROP TABLE public.gpx_files;
       public         postgres    false    723    723    5            Ê            1259    42658    gpx_files_id_seq    SEQUENCE     r   CREATE SEQUENCE gpx_files_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.gpx_files_id_seq;
       public       postgres    false    5    201            
           0    0    gpx_files_id_seq    SEQUENCE OWNED BY     7   ALTER SEQUENCE gpx_files_id_seq OWNED BY gpx_files.id;
            public       postgres    false    202            Ë            1259    42660 	   languages    TABLE        CREATE TABLE languages (
    code character varying(255) NOT NULL,
    english_name character varying(255) NOT NULL,
    native_name character varying(255)
);
    DROP TABLE public.languages;
       public         postgres    false    5            Ì            1259    42666    messages    TABLE       CREATE TABLE messages (
    id bigint NOT NULL,
    from_user_id bigint NOT NULL,
    title character varying(255) NOT NULL,
    body text NOT NULL,
    sent_on timestamp without time zone NOT NULL,
    message_read boolean DEFAULT false NOT NULL,
    to_user_id bigint NOT NULL,
    to_user_visible boolean DEFAULT true NOT NULL,
    from_user_visible boolean DEFAULT true NOT NULL
);
    DROP TABLE public.messages;
       public         postgres    false    5            Í            1259    42675    messages_id_seq    SEQUENCE     q   CREATE SEQUENCE messages_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.messages_id_seq;
       public       postgres    false    5    204            
           0    0    messages_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE messages_id_seq OWNED BY messages.id;
            public       postgres    false    205            Î            1259    42677 	   node_tags    TABLE     ß   CREATE TABLE node_tags (
    node_id bigint NOT NULL,
    version bigint NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL
);
    DROP TABLE public.node_tags;
       public         postgres    false    5            Ï            1259    42685    nodes    TABLE     :  CREATE TABLE nodes (
    node_id bigint NOT NULL,
    latitude integer NOT NULL,
    longitude integer NOT NULL,
    changeset_id bigint NOT NULL,
    visible boolean NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    tile bigint NOT NULL,
    version bigint NOT NULL,
    redaction_id integer
);
    DROP TABLE public.nodes;
       public         postgres    false    5            Ð            1259    42688    oauth_nonces    TABLE     Ê   CREATE TABLE oauth_nonces (
    id integer NOT NULL,
    nonce character varying(255),
    "timestamp" integer,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);
     DROP TABLE public.oauth_nonces;
       public         postgres    false    5            Ñ            1259    42691    oauth_nonces_id_seq    SEQUENCE     u   CREATE SEQUENCE oauth_nonces_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.oauth_nonces_id_seq;
       public       postgres    false    208    5            
           0    0    oauth_nonces_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE oauth_nonces_id_seq OWNED BY oauth_nonces.id;
            public       postgres    false    209            Ò            1259    42693    oauth_tokens    TABLE       CREATE TABLE oauth_tokens (
    id integer NOT NULL,
    user_id integer,
    type character varying(20),
    client_application_id integer,
    token character varying(50),
    secret character varying(50),
    authorized_at timestamp without time zone,
    invalidated_at timestamp without time zone,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    allow_read_prefs boolean DEFAULT false NOT NULL,
    allow_write_prefs boolean DEFAULT false NOT NULL,
    allow_write_diary boolean DEFAULT false NOT NULL,
    allow_write_api boolean DEFAULT false NOT NULL,
    allow_read_gpx boolean DEFAULT false NOT NULL,
    allow_write_gpx boolean DEFAULT false NOT NULL,
    callback_url character varying(255),
    verifier character varying(20)
);
     DROP TABLE public.oauth_tokens;
       public         postgres    false    5            Ó            1259    42702    oauth_tokens_id_seq    SEQUENCE     u   CREATE SEQUENCE oauth_tokens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.oauth_tokens_id_seq;
       public       postgres    false    210    5            
           0    0    oauth_tokens_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE oauth_tokens_id_seq OWNED BY oauth_tokens.id;
            public       postgres    false    211            Ô            1259    42704    relation_members    TABLE       CREATE TABLE relation_members (
    relation_id bigint DEFAULT 0 NOT NULL,
    member_type nwr_enum NOT NULL,
    member_id bigint NOT NULL,
    member_role character varying(255) NOT NULL,
    version bigint DEFAULT 0 NOT NULL,
    sequence_id integer DEFAULT 0 NOT NULL
);
 $   DROP TABLE public.relation_members;
       public         postgres    false    5    726            Õ            1259    42710    relation_tags    TABLE     ñ   CREATE TABLE relation_tags (
    relation_id bigint DEFAULT 0 NOT NULL,
    k character varying(255) DEFAULT ''::character varying NOT NULL,
    v character varying(255) DEFAULT ''::character varying NOT NULL,
    version bigint NOT NULL
);
 !   DROP TABLE public.relation_tags;
       public         postgres    false    5            Ö            1259    42719 	   relations    TABLE        CREATE TABLE relations (
    relation_id bigint DEFAULT 0 NOT NULL,
    changeset_id bigint NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    version bigint NOT NULL,
    visible boolean DEFAULT true NOT NULL,
    redaction_id integer
);
    DROP TABLE public.relations;
       public         postgres    false    5            ×            1259    42724    schema_migrations    TABLE     P   CREATE TABLE schema_migrations (
    version character varying(255) NOT NULL
);
 %   DROP TABLE public.schema_migrations;
       public         postgres    false    5            Ø            1259    42727    sessions    TABLE     Á   CREATE TABLE sessions (
    id integer NOT NULL,
    session_id character varying(255),
    data text,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);
    DROP TABLE public.sessions;
       public         postgres    false    5            Ù            1259    42733    sessions_id_seq    SEQUENCE     q   CREATE SEQUENCE sessions_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.sessions_id_seq;
       public       postgres    false    5    216            
           0    0    sessions_id_seq    SEQUENCE OWNED BY     5   ALTER SEQUENCE sessions_id_seq OWNED BY sessions.id;
            public       postgres    false    217            Ú            1259    42735    user_blocks    TABLE     ]  CREATE TABLE user_blocks (
    id integer NOT NULL,
    user_id bigint NOT NULL,
    creator_id bigint NOT NULL,
    reason text NOT NULL,
    ends_at timestamp without time zone NOT NULL,
    needs_view boolean DEFAULT false NOT NULL,
    revoker_id bigint,
    created_at timestamp without time zone,
    updated_at timestamp without time zone
);
    DROP TABLE public.user_blocks;
       public         postgres    false    5            Û            1259    42742    user_blocks_id_seq    SEQUENCE     t   CREATE SEQUENCE user_blocks_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.user_blocks_id_seq;
       public       postgres    false    218    5            
           0    0    user_blocks_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE user_blocks_id_seq OWNED BY user_blocks.id;
            public       postgres    false    219            Ü            1259    42744    user_preferences    TABLE        CREATE TABLE user_preferences (
    user_id bigint NOT NULL,
    k character varying(255) NOT NULL,
    v character varying(255) NOT NULL
);
 $   DROP TABLE public.user_preferences;
       public         postgres    false    5            Ý            1259    42750 
   user_roles    TABLE     ì   CREATE TABLE user_roles (
    id integer NOT NULL,
    user_id bigint NOT NULL,
    created_at timestamp without time zone,
    updated_at timestamp without time zone,
    role user_role_enum NOT NULL,
    granter_id bigint NOT NULL
);
    DROP TABLE public.user_roles;
       public         postgres    false    729    5            Þ            1259    42753    user_roles_id_seq    SEQUENCE     s   CREATE SEQUENCE user_roles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.user_roles_id_seq;
       public       postgres    false    5    221            
           0    0    user_roles_id_seq    SEQUENCE OWNED BY     9   ALTER SEQUENCE user_roles_id_seq OWNED BY user_roles.id;
            public       postgres    false    222            ß            1259    42755    user_tokens    TABLE     À   CREATE TABLE user_tokens (
    id bigint NOT NULL,
    user_id bigint NOT NULL,
    token character varying(255) NOT NULL,
    expiry timestamp without time zone NOT NULL,
    referer text
);
    DROP TABLE public.user_tokens;
       public         postgres    false    5            à            1259    42761    user_tokens_id_seq    SEQUENCE     t   CREATE SEQUENCE user_tokens_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.user_tokens_id_seq;
       public       postgres    false    5    223             
           0    0    user_tokens_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE user_tokens_id_seq OWNED BY user_tokens.id;
            public       postgres    false    224            á            1259    42763    users    TABLE     ö  CREATE TABLE users (
    email character varying(255) NOT NULL,
    id bigint NOT NULL,
    pass_crypt character varying(255) NOT NULL,
    creation_time timestamp without time zone NOT NULL,
    display_name character varying(255) DEFAULT ''::character varying NOT NULL,
    data_public boolean DEFAULT false NOT NULL,
    description text DEFAULT ''::text NOT NULL,
    home_lat double precision,
    home_lon double precision,
    home_zoom smallint DEFAULT 3,
    nearby integer DEFAULT 50,
    pass_salt character varying(255),
    image text,
    email_valid boolean DEFAULT false NOT NULL,
    new_email character varying(255),
    creation_ip character varying(255),
    languages character varying(255),
    status user_status_enum DEFAULT 'pending'::user_status_enum NOT NULL,
    terms_agreed timestamp without time zone,
    consider_pd boolean DEFAULT false NOT NULL,
    preferred_editor character varying(255),
    terms_seen boolean DEFAULT false NOT NULL,
    openid_url character varying(255)
);
    DROP TABLE public.users;
       public         postgres    false    732    5    732            â            1259    42778    users_id_seq    SEQUENCE     n   CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE public.users_id_seq;
       public       postgres    false    5    225            ¡
           0    0    users_id_seq    SEQUENCE OWNED BY     /   ALTER SEQUENCE users_id_seq OWNED BY users.id;
            public       postgres    false    226            ã            1259    42780 	   way_nodes    TABLE        CREATE TABLE way_nodes (
    way_id bigint NOT NULL,
    node_id bigint NOT NULL,
    version bigint NOT NULL,
    sequence_id bigint NOT NULL
);
    DROP TABLE public.way_nodes;
       public         postgres    false    5            ä            1259    42783    way_tags    TABLE     «   CREATE TABLE way_tags (
    way_id bigint DEFAULT 0 NOT NULL,
    k character varying(255) NOT NULL,
    v character varying(255) NOT NULL,
    version bigint NOT NULL
);
    DROP TABLE public.way_tags;
       public         postgres    false    5            å            1259    42790    ways    TABLE     ö   CREATE TABLE ways (
    way_id bigint DEFAULT 0 NOT NULL,
    changeset_id bigint NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    version bigint NOT NULL,
    visible boolean DEFAULT true NOT NULL,
    redaction_id integer
);
    DROP TABLE public.ways;
       public         postgres    false    5            ë           2604    42795    id    DEFAULT     T   ALTER TABLE ONLY acls ALTER COLUMN id SET DEFAULT nextval('acls_id_seq'::regclass);
 6   ALTER TABLE public.acls ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    173    172            ï           2604    42796    id    DEFAULT     `   ALTER TABLE ONLY changesets ALTER COLUMN id SET DEFAULT nextval('changesets_id_seq'::regclass);
 <   ALTER TABLE public.changesets ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    176    175            ö           2604    42797    id    DEFAULT     r   ALTER TABLE ONLY client_applications ALTER COLUMN id SET DEFAULT nextval('client_applications_id_seq'::regclass);
 E   ALTER TABLE public.client_applications ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    178    177            ÷           2604    42798    id    DEFAULT     ^   ALTER TABLE ONLY countries ALTER COLUMN id SET DEFAULT nextval('countries_id_seq'::regclass);
 ;   ALTER TABLE public.countries ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    180    179            ú           2604    42799    id    DEFAULT     f   ALTER TABLE ONLY current_nodes ALTER COLUMN id SET DEFAULT nextval('current_nodes_id_seq'::regclass);
 ?   ALTER TABLE public.current_nodes ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    183    182            þ           2604    42800    id    DEFAULT     n   ALTER TABLE ONLY current_relations ALTER COLUMN id SET DEFAULT nextval('current_relations_id_seq'::regclass);
 C   ALTER TABLE public.current_relations ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    187    186            	           2604    42801    id    DEFAULT     d   ALTER TABLE ONLY current_ways ALTER COLUMN id SET DEFAULT nextval('current_ways_id_seq'::regclass);
 >   ALTER TABLE public.current_ways ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    191    190            	           2604    42802    id    DEFAULT     h   ALTER TABLE ONLY diary_comments ALTER COLUMN id SET DEFAULT nextval('diary_comments_id_seq'::regclass);
 @   ALTER TABLE public.diary_comments ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    193    192            	           2604    42803    id    DEFAULT     f   ALTER TABLE ONLY diary_entries ALTER COLUMN id SET DEFAULT nextval('diary_entries_id_seq'::regclass);
 ?   ALTER TABLE public.diary_entries ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    195    194            	           2604    42804    id    DEFAULT     Z   ALTER TABLE ONLY friends ALTER COLUMN id SET DEFAULT nextval('friends_id_seq'::regclass);
 9   ALTER TABLE public.friends ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    197    196            		           2604    42805    id    DEFAULT     f   ALTER TABLE ONLY gpx_file_tags ALTER COLUMN id SET DEFAULT nextval('gpx_file_tags_id_seq'::regclass);
 ?   ALTER TABLE public.gpx_file_tags ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    200    199            	           2604    42806    id    DEFAULT     ^   ALTER TABLE ONLY gpx_files ALTER COLUMN id SET DEFAULT nextval('gpx_files_id_seq'::regclass);
 ;   ALTER TABLE public.gpx_files ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    202    201            	           2604    42807    id    DEFAULT     \   ALTER TABLE ONLY messages ALTER COLUMN id SET DEFAULT nextval('messages_id_seq'::regclass);
 :   ALTER TABLE public.messages ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    205    204            	           2604    42808    id    DEFAULT     d   ALTER TABLE ONLY oauth_nonces ALTER COLUMN id SET DEFAULT nextval('oauth_nonces_id_seq'::regclass);
 >   ALTER TABLE public.oauth_nonces ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    209    208            	           2604    42809    id    DEFAULT     d   ALTER TABLE ONLY oauth_tokens ALTER COLUMN id SET DEFAULT nextval('oauth_tokens_id_seq'::regclass);
 >   ALTER TABLE public.oauth_tokens ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    211    210            %	           2604    42810    id    DEFAULT     \   ALTER TABLE ONLY sessions ALTER COLUMN id SET DEFAULT nextval('sessions_id_seq'::regclass);
 :   ALTER TABLE public.sessions ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    217    216            '	           2604    42811    id    DEFAULT     b   ALTER TABLE ONLY user_blocks ALTER COLUMN id SET DEFAULT nextval('user_blocks_id_seq'::regclass);
 =   ALTER TABLE public.user_blocks ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    219    218            (	           2604    42812    id    DEFAULT     `   ALTER TABLE ONLY user_roles ALTER COLUMN id SET DEFAULT nextval('user_roles_id_seq'::regclass);
 <   ALTER TABLE public.user_roles ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    222    221            )	           2604    42813    id    DEFAULT     b   ALTER TABLE ONLY user_tokens ALTER COLUMN id SET DEFAULT nextval('user_tokens_id_seq'::regclass);
 =   ALTER TABLE public.user_tokens ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    224    223            3	           2604    42814    id    DEFAULT     V   ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);
 7   ALTER TABLE public.users ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    226    225            L
          0    42528    acls 
   TABLE DATA               3   COPY acls (id, address, netmask, k, v) FROM stdin;
    public       postgres    false    172   a      ¢
           0    0    acls_id_seq    SEQUENCE SET     3   SELECT pg_catalog.setval('acls_id_seq', 1, false);
            public       postgres    false    173            N
          0    42536    changeset_tags 
   TABLE DATA               5   COPY changeset_tags (changeset_id, k, v) FROM stdin;
    public       postgres    false    174   ~      O
          0    42544 
   changesets 
   TABLE DATA               r   COPY changesets (id, user_id, created_at, min_lat, max_lat, min_lon, max_lon, closed_at, num_changes) FROM stdin;
    public       postgres    false    175   Ê      £
           0    0    changesets_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('changesets_id_seq', 1, false);
            public       postgres    false    176            Q
          0    42550    client_applications 
   TABLE DATA               è   COPY client_applications (id, name, url, support_url, callback_url, key, secret, user_id, created_at, updated_at, allow_read_prefs, allow_write_prefs, allow_write_diary, allow_write_api, allow_read_gpx, allow_write_gpx) FROM stdin;
    public       postgres    false    177         ¤
           0    0    client_applications_id_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('client_applications_id_seq', 1, false);
            public       postgres    false    178            S
          0    42564 	   countries 
   TABLE DATA               J   COPY countries (id, code, min_lat, max_lat, min_lon, max_lon) FROM stdin;
    public       postgres    false    179   5      ¥
           0    0    countries_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('countries_id_seq', 1, false);
            public       postgres    false    180            U
          0    42569    current_node_tags 
   TABLE DATA               3   COPY current_node_tags (node_id, k, v) FROM stdin;
    public       postgres    false    181   R      V
          0    42577    current_nodes 
   TABLE DATA               l   COPY current_nodes (id, latitude, longitude, changeset_id, visible, "timestamp", tile, version) FROM stdin;
    public       postgres    false    182   o      ¦
           0    0    current_nodes_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('current_nodes_id_seq', 1, false);
            public       postgres    false    183            X
          0    42582    current_relation_members 
   TABLE DATA               j   COPY current_relation_members (relation_id, member_type, member_id, member_role, sequence_id) FROM stdin;
    public       postgres    false    184         Y
          0    42586    current_relation_tags 
   TABLE DATA               ;   COPY current_relation_tags (relation_id, k, v) FROM stdin;
    public       postgres    false    185   ©      Z
          0    42594    current_relations 
   TABLE DATA               U   COPY current_relations (id, changeset_id, "timestamp", visible, version) FROM stdin;
    public       postgres    false    186   Æ      §
           0    0    current_relations_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('current_relations_id_seq', 1, false);
            public       postgres    false    187            \
          0    42599    current_way_nodes 
   TABLE DATA               B   COPY current_way_nodes (way_id, node_id, sequence_id) FROM stdin;
    public       postgres    false    188   ã      ]
          0    42602    current_way_tags 
   TABLE DATA               1   COPY current_way_tags (way_id, k, v) FROM stdin;
    public       postgres    false    189          ^
          0    42610    current_ways 
   TABLE DATA               P   COPY current_ways (id, changeset_id, "timestamp", visible, version) FROM stdin;
    public       postgres    false    190         ¨
           0    0    current_ways_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('current_ways_id_seq', 1, false);
            public       postgres    false    191            `
          0    42615    diary_comments 
   TABLE DATA               e   COPY diary_comments (id, diary_entry_id, user_id, body, created_at, updated_at, visible) FROM stdin;
    public       postgres    false    192   :      ©
           0    0    diary_comments_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('diary_comments_id_seq', 1, false);
            public       postgres    false    193            b
          0    42624    diary_entries 
   TABLE DATA                  COPY diary_entries (id, user_id, title, body, created_at, updated_at, latitude, longitude, language_code, visible) FROM stdin;
    public       postgres    false    194   W      ª
           0    0    diary_entries_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('diary_entries_id_seq', 1, false);
            public       postgres    false    195            d
          0    42634    friends 
   TABLE DATA               7   COPY friends (id, user_id, friend_user_id) FROM stdin;
    public       postgres    false    196   t      «
           0    0    friends_id_seq    SEQUENCE SET     6   SELECT pg_catalog.setval('friends_id_seq', 1, false);
            public       postgres    false    197            f
          0    42639 
   gps_points 
   TABLE DATA               `   COPY gps_points (altitude, trackid, latitude, longitude, gpx_id, "timestamp", tile) FROM stdin;
    public       postgres    false    198         g
          0    42642    gpx_file_tags 
   TABLE DATA               1   COPY gpx_file_tags (gpx_id, tag, id) FROM stdin;
    public       postgres    false    199   ®      ¬
           0    0    gpx_file_tags_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('gpx_file_tags_id_seq', 1, false);
            public       postgres    false    200            i
          0    42648 	   gpx_files 
   TABLE DATA                  COPY gpx_files (id, user_id, visible, name, size, latitude, longitude, "timestamp", description, inserted, visibility) FROM stdin;
    public       postgres    false    201   Ë      ­
           0    0    gpx_files_id_seq    SEQUENCE SET     8   SELECT pg_catalog.setval('gpx_files_id_seq', 1, false);
            public       postgres    false    202            k
          0    42660 	   languages 
   TABLE DATA               =   COPY languages (code, english_name, native_name) FROM stdin;
    public       postgres    false    203   è      l
          0    42666    messages 
   TABLE DATA                  COPY messages (id, from_user_id, title, body, sent_on, message_read, to_user_id, to_user_visible, from_user_visible) FROM stdin;
    public       postgres    false    204         ®
           0    0    messages_id_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('messages_id_seq', 1, false);
            public       postgres    false    205            n
          0    42677 	   node_tags 
   TABLE DATA               4   COPY node_tags (node_id, version, k, v) FROM stdin;
    public       postgres    false    206   "      o
          0    42685    nodes 
   TABLE DATA               w   COPY nodes (node_id, latitude, longitude, changeset_id, visible, "timestamp", tile, version, redaction_id) FROM stdin;
    public       postgres    false    207         p
          0    42688    oauth_nonces 
   TABLE DATA               O   COPY oauth_nonces (id, nonce, "timestamp", created_at, updated_at) FROM stdin;
    public       postgres    false    208   _£      ¯
           0    0    oauth_nonces_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('oauth_nonces_id_seq', 1, false);
            public       postgres    false    209            r
          0    42693    oauth_tokens 
   TABLE DATA                 COPY oauth_tokens (id, user_id, type, client_application_id, token, secret, authorized_at, invalidated_at, created_at, updated_at, allow_read_prefs, allow_write_prefs, allow_write_diary, allow_write_api, allow_read_gpx, allow_write_gpx, callback_url, verifier) FROM stdin;
    public       postgres    false    210   |£      °
           0    0    oauth_tokens_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('oauth_tokens_id_seq', 1, false);
            public       postgres    false    211            t
          0    42704    relation_members 
   TABLE DATA               k   COPY relation_members (relation_id, member_type, member_id, member_role, version, sequence_id) FROM stdin;
    public       postgres    false    212   £      u
          0    42710    relation_tags 
   TABLE DATA               <   COPY relation_tags (relation_id, k, v, version) FROM stdin;
    public       postgres    false    213   ¶£      v
          0    42719 	   relations 
   TABLE DATA               d   COPY relations (relation_id, changeset_id, "timestamp", version, visible, redaction_id) FROM stdin;
    public       postgres    false    214   Ó£      w
          0    42724    schema_migrations 
   TABLE DATA               -   COPY schema_migrations (version) FROM stdin;
    public       postgres    false    215   ð£      x
          0    42727    sessions 
   TABLE DATA               I   COPY sessions (id, session_id, data, created_at, updated_at) FROM stdin;
    public       postgres    false    216   ¤      ±
           0    0    sessions_id_seq    SEQUENCE SET     7   SELECT pg_catalog.setval('sessions_id_seq', 1, false);
            public       postgres    false    217            z
          0    42735    user_blocks 
   TABLE DATA               x   COPY user_blocks (id, user_id, creator_id, reason, ends_at, needs_view, revoker_id, created_at, updated_at) FROM stdin;
    public       postgres    false    218   ¢¤      ²
           0    0    user_blocks_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('user_blocks_id_seq', 1, false);
            public       postgres    false    219            |
          0    42744    user_preferences 
   TABLE DATA               2   COPY user_preferences (user_id, k, v) FROM stdin;
    public       postgres    false    220   ¿¤      }
          0    42750 
   user_roles 
   TABLE DATA               T   COPY user_roles (id, user_id, created_at, updated_at, role, granter_id) FROM stdin;
    public       postgres    false    221   Ü¤      ³
           0    0    user_roles_id_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('user_roles_id_seq', 1, false);
            public       postgres    false    222            
          0    42755    user_tokens 
   TABLE DATA               C   COPY user_tokens (id, user_id, token, expiry, referer) FROM stdin;
    public       postgres    false    223   ù¤      ´
           0    0    user_tokens_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('user_tokens_id_seq', 1, false);
            public       postgres    false    224            
          0    42763    users 
   TABLE DATA                 COPY users (email, id, pass_crypt, creation_time, display_name, data_public, description, home_lat, home_lon, home_zoom, nearby, pass_salt, image, email_valid, new_email, creation_ip, languages, status, terms_agreed, consider_pd, preferred_editor, terms_seen, openid_url) FROM stdin;
    public       postgres    false    225   ¥      µ
           0    0    users_id_seq    SEQUENCE SET     4   SELECT pg_catalog.setval('users_id_seq', 1, false);
            public       postgres    false    226            
          0    42780 	   way_nodes 
   TABLE DATA               C   COPY way_nodes (way_id, node_id, version, sequence_id) FROM stdin;
    public       postgres    false    227   ­¥      
          0    42783    way_tags 
   TABLE DATA               2   COPY way_tags (way_id, k, v, version) FROM stdin;
    public       postgres    false    228   &³      
          0    42790    ways 
   TABLE DATA               Z   COPY ways (way_id, changeset_id, "timestamp", version, visible, redaction_id) FROM stdin;
    public       postgres    false    229   ½      9	           2606    42816 	   acls_pkey 
   CONSTRAINT     E   ALTER TABLE ONLY acls
    ADD CONSTRAINT acls_pkey PRIMARY KEY (id);
 8   ALTER TABLE ONLY public.acls DROP CONSTRAINT acls_pkey;
       public         postgres    false    172    172            ?	           2606    42818    changesets_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY changesets
    ADD CONSTRAINT changesets_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.changesets DROP CONSTRAINT changesets_pkey;
       public         postgres    false    175    175            C	           2606    42820    client_applications_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY client_applications
    ADD CONSTRAINT client_applications_pkey PRIMARY KEY (id);
 V   ALTER TABLE ONLY public.client_applications DROP CONSTRAINT client_applications_pkey;
       public         postgres    false    177    177            G	           2606    42822    countries_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY countries
    ADD CONSTRAINT countries_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.countries DROP CONSTRAINT countries_pkey;
       public         postgres    false    179    179            I	           2606    42824    current_node_tags_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY current_node_tags
    ADD CONSTRAINT current_node_tags_pkey PRIMARY KEY (node_id, k);
 R   ALTER TABLE ONLY public.current_node_tags DROP CONSTRAINT current_node_tags_pkey;
       public         postgres    false    181    181    181            K	           2606    42826    current_nodes_pkey1 
   CONSTRAINT     X   ALTER TABLE ONLY current_nodes
    ADD CONSTRAINT current_nodes_pkey1 PRIMARY KEY (id);
 K   ALTER TABLE ONLY public.current_nodes DROP CONSTRAINT current_nodes_pkey1;
       public         postgres    false    182    182            P	           2606    42828    current_relation_members_pkey 
   CONSTRAINT     ¨   ALTER TABLE ONLY current_relation_members
    ADD CONSTRAINT current_relation_members_pkey PRIMARY KEY (relation_id, member_type, member_id, member_role, sequence_id);
 `   ALTER TABLE ONLY public.current_relation_members DROP CONSTRAINT current_relation_members_pkey;
       public         postgres    false    184    184    184    184    184    184            S	           2606    42830    current_relation_tags_pkey 
   CONSTRAINT     s   ALTER TABLE ONLY current_relation_tags
    ADD CONSTRAINT current_relation_tags_pkey PRIMARY KEY (relation_id, k);
 Z   ALTER TABLE ONLY public.current_relation_tags DROP CONSTRAINT current_relation_tags_pkey;
       public         postgres    false    185    185    185            V	           2606    42832    current_relations_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY current_relations
    ADD CONSTRAINT current_relations_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.current_relations DROP CONSTRAINT current_relations_pkey;
       public         postgres    false    186    186            Z	           2606    42834    current_way_nodes_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY current_way_nodes
    ADD CONSTRAINT current_way_nodes_pkey PRIMARY KEY (way_id, sequence_id);
 R   ALTER TABLE ONLY public.current_way_nodes DROP CONSTRAINT current_way_nodes_pkey;
       public         postgres    false    188    188    188            ]	           2606    42836    current_way_tags_pkey 
   CONSTRAINT     d   ALTER TABLE ONLY current_way_tags
    ADD CONSTRAINT current_way_tags_pkey PRIMARY KEY (way_id, k);
 P   ALTER TABLE ONLY public.current_way_tags DROP CONSTRAINT current_way_tags_pkey;
       public         postgres    false    189    189    189            `	           2606    42838    current_ways_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY current_ways
    ADD CONSTRAINT current_ways_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.current_ways DROP CONSTRAINT current_ways_pkey;
       public         postgres    false    190    190            e	           2606    42840    diary_comments_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY diary_comments
    ADD CONSTRAINT diary_comments_pkey PRIMARY KEY (id);
 L   ALTER TABLE ONLY public.diary_comments DROP CONSTRAINT diary_comments_pkey;
       public         postgres    false    192    192            g	           2606    42842    diary_entries_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY diary_entries
    ADD CONSTRAINT diary_entries_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.diary_entries DROP CONSTRAINT diary_entries_pkey;
       public         postgres    false    194    194            l	           2606    42844    friends_pkey 
   CONSTRAINT     K   ALTER TABLE ONLY friends
    ADD CONSTRAINT friends_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.friends DROP CONSTRAINT friends_pkey;
       public         postgres    false    196    196            s	           2606    42846    gpx_file_tags_pkey 
   CONSTRAINT     W   ALTER TABLE ONLY gpx_file_tags
    ADD CONSTRAINT gpx_file_tags_pkey PRIMARY KEY (id);
 J   ALTER TABLE ONLY public.gpx_file_tags DROP CONSTRAINT gpx_file_tags_pkey;
       public         postgres    false    199    199            v	           2606    42848    gpx_files_pkey 
   CONSTRAINT     O   ALTER TABLE ONLY gpx_files
    ADD CONSTRAINT gpx_files_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.gpx_files DROP CONSTRAINT gpx_files_pkey;
       public         postgres    false    201    201            {	           2606    42850    languages_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY languages
    ADD CONSTRAINT languages_pkey PRIMARY KEY (code);
 B   ALTER TABLE ONLY public.languages DROP CONSTRAINT languages_pkey;
       public         postgres    false    203    203            ~	           2606    42852    messages_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY messages
    ADD CONSTRAINT messages_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.messages DROP CONSTRAINT messages_pkey;
       public         postgres    false    204    204            	           2606    42854    node_tags_pkey 
   CONSTRAINT     `   ALTER TABLE ONLY node_tags
    ADD CONSTRAINT node_tags_pkey PRIMARY KEY (node_id, version, k);
 B   ALTER TABLE ONLY public.node_tags DROP CONSTRAINT node_tags_pkey;
       public         postgres    false    206    206    206    206            	           2606    42856 
   nodes_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY nodes
    ADD CONSTRAINT nodes_pkey PRIMARY KEY (node_id, version);
 :   ALTER TABLE ONLY public.nodes DROP CONSTRAINT nodes_pkey;
       public         postgres    false    207    207    207            	           2606    42858    oauth_nonces_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY oauth_nonces
    ADD CONSTRAINT oauth_nonces_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.oauth_nonces DROP CONSTRAINT oauth_nonces_pkey;
       public         postgres    false    208    208            	           2606    42860    oauth_tokens_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY oauth_tokens
    ADD CONSTRAINT oauth_tokens_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.oauth_tokens DROP CONSTRAINT oauth_tokens_pkey;
       public         postgres    false    210    210            	           2606    42862    relation_members_pkey 
   CONSTRAINT     ¡   ALTER TABLE ONLY relation_members
    ADD CONSTRAINT relation_members_pkey PRIMARY KEY (relation_id, version, member_type, member_id, member_role, sequence_id);
 P   ALTER TABLE ONLY public.relation_members DROP CONSTRAINT relation_members_pkey;
       public         postgres    false    212    212    212    212    212    212    212            	           2606    42864    relation_tags_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY relation_tags
    ADD CONSTRAINT relation_tags_pkey PRIMARY KEY (relation_id, version, k);
 J   ALTER TABLE ONLY public.relation_tags DROP CONSTRAINT relation_tags_pkey;
       public         postgres    false    213    213    213    213            	           2606    42866    relations_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_pkey PRIMARY KEY (relation_id, version);
 B   ALTER TABLE ONLY public.relations DROP CONSTRAINT relations_pkey;
       public         postgres    false    214    214    214            	           2606    42868    sessions_pkey 
   CONSTRAINT     M   ALTER TABLE ONLY sessions
    ADD CONSTRAINT sessions_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.sessions DROP CONSTRAINT sessions_pkey;
       public         postgres    false    216    216            	           2606    42870    user_blocks_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY user_blocks
    ADD CONSTRAINT user_blocks_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_blocks DROP CONSTRAINT user_blocks_pkey;
       public         postgres    false    218    218             	           2606    42872    user_preferences_pkey 
   CONSTRAINT     e   ALTER TABLE ONLY user_preferences
    ADD CONSTRAINT user_preferences_pkey PRIMARY KEY (user_id, k);
 P   ALTER TABLE ONLY public.user_preferences DROP CONSTRAINT user_preferences_pkey;
       public         postgres    false    220    220    220            £	           2606    42874    user_roles_pkey 
   CONSTRAINT     Q   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT user_roles_pkey;
       public         postgres    false    221    221            ¥	           2606    42876    user_tokens_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY user_tokens
    ADD CONSTRAINT user_tokens_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.user_tokens DROP CONSTRAINT user_tokens_pkey;
       public         postgres    false    223    223            ¬	           2606    42878 
   users_pkey 
   CONSTRAINT     G   ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.users DROP CONSTRAINT users_pkey;
       public         postgres    false    225    225            ¯	           2606    42880    way_nodes_pkey 
   CONSTRAINT     i   ALTER TABLE ONLY way_nodes
    ADD CONSTRAINT way_nodes_pkey PRIMARY KEY (way_id, version, sequence_id);
 B   ALTER TABLE ONLY public.way_nodes DROP CONSTRAINT way_nodes_pkey;
       public         postgres    false    227    227    227    227            ²	           2606    42882    way_tags_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY way_tags
    ADD CONSTRAINT way_tags_pkey PRIMARY KEY (way_id, version, k);
 @   ALTER TABLE ONLY public.way_tags DROP CONSTRAINT way_tags_pkey;
       public         postgres    false    228    228    228    228            µ	           2606    42884 	   ways_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY ways
    ADD CONSTRAINT ways_pkey PRIMARY KEY (way_id, version);
 8   ALTER TABLE ONLY public.ways DROP CONSTRAINT ways_pkey;
       public         postgres    false    229    229    229            7	           1259    42885 
   acls_k_idx    INDEX     1   CREATE INDEX acls_k_idx ON acls USING btree (k);
    DROP INDEX public.acls_k_idx;
       public         postgres    false    172            :	           1259    42886    changeset_tags_id_idx    INDEX     Q   CREATE INDEX changeset_tags_id_idx ON changeset_tags USING btree (changeset_id);
 )   DROP INDEX public.changeset_tags_id_idx;
       public         postgres    false    174            ;	           1259    42887    changesets_bbox_idx    INDEX     `   CREATE INDEX changesets_bbox_idx ON changesets USING gist (min_lat, max_lat, min_lon, max_lon);
 '   DROP INDEX public.changesets_bbox_idx;
       public         postgres    false    175    1792    1792    1792    1792    175    175    175            <	           1259    42888    changesets_closed_at_idx    INDEX     M   CREATE INDEX changesets_closed_at_idx ON changesets USING btree (closed_at);
 ,   DROP INDEX public.changesets_closed_at_idx;
       public         postgres    false    175            =	           1259    42889    changesets_created_at_idx    INDEX     O   CREATE INDEX changesets_created_at_idx ON changesets USING btree (created_at);
 -   DROP INDEX public.changesets_created_at_idx;
       public         postgres    false    175            @	           1259    42890 !   changesets_user_id_created_at_idx    INDEX     `   CREATE INDEX changesets_user_id_created_at_idx ON changesets USING btree (user_id, created_at);
 5   DROP INDEX public.changesets_user_id_created_at_idx;
       public         postgres    false    175    175            A	           1259    42891    changesets_user_id_id_idx    INDEX     P   CREATE INDEX changesets_user_id_id_idx ON changesets USING btree (user_id, id);
 -   DROP INDEX public.changesets_user_id_id_idx;
       public         postgres    false    175    175            E	           1259    42892    countries_code_idx    INDEX     H   CREATE UNIQUE INDEX countries_code_idx ON countries USING btree (code);
 &   DROP INDEX public.countries_code_idx;
       public         postgres    false    179            L	           1259    42893    current_nodes_tile_idx    INDEX     I   CREATE INDEX current_nodes_tile_idx ON current_nodes USING btree (tile);
 *   DROP INDEX public.current_nodes_tile_idx;
       public         postgres    false    182            M	           1259    42894    current_nodes_timestamp_idx    INDEX     U   CREATE INDEX current_nodes_timestamp_idx ON current_nodes USING btree ("timestamp");
 /   DROP INDEX public.current_nodes_timestamp_idx;
       public         postgres    false    182            N	           1259    42895 #   current_relation_members_member_idx    INDEX     s   CREATE INDEX current_relation_members_member_idx ON current_relation_members USING btree (member_type, member_id);
 7   DROP INDEX public.current_relation_members_member_idx;
       public         postgres    false    184    184            Q	           1259    42896    current_relation_tags_id_idx    INDEX     ^   CREATE INDEX current_relation_tags_id_idx ON current_relation_tags USING btree (relation_id);
 0   DROP INDEX public.current_relation_tags_id_idx;
       public         postgres    false    185            T	           1259    42897    current_relation_tags_v_idx    INDEX     S   CREATE INDEX current_relation_tags_v_idx ON current_relation_tags USING btree (v);
 /   DROP INDEX public.current_relation_tags_v_idx;
       public         postgres    false    185            W	           1259    42898    current_relations_timestamp_idx    INDEX     ]   CREATE INDEX current_relations_timestamp_idx ON current_relations USING btree ("timestamp");
 3   DROP INDEX public.current_relations_timestamp_idx;
       public         postgres    false    186            X	           1259    42899    current_way_nodes_node_idx    INDEX     T   CREATE INDEX current_way_nodes_node_idx ON current_way_nodes USING btree (node_id);
 .   DROP INDEX public.current_way_nodes_node_idx;
       public         postgres    false    188            [	           1259    42900    current_way_tags_id_idx    INDEX     O   CREATE INDEX current_way_tags_id_idx ON current_way_tags USING btree (way_id);
 +   DROP INDEX public.current_way_tags_id_idx;
       public         postgres    false    189            ^	           1259    42901    current_way_tags_v_idx    INDEX     I   CREATE INDEX current_way_tags_v_idx ON current_way_tags USING btree (v);
 *   DROP INDEX public.current_way_tags_v_idx;
       public         postgres    false    189            a	           1259    42902    current_ways_timestamp_idx    INDEX     S   CREATE INDEX current_ways_timestamp_idx ON current_ways USING btree ("timestamp");
 .   DROP INDEX public.current_ways_timestamp_idx;
       public         postgres    false    190            b	           1259    42903 &   diary_comment_user_id_created_at_index    INDEX     i   CREATE INDEX diary_comment_user_id_created_at_index ON diary_comments USING btree (user_id, created_at);
 :   DROP INDEX public.diary_comment_user_id_created_at_index;
       public         postgres    false    192    192            c	           1259    42904    diary_comments_entry_id_idx    INDEX     d   CREATE UNIQUE INDEX diary_comments_entry_id_idx ON diary_comments USING btree (diary_entry_id, id);
 /   DROP INDEX public.diary_comments_entry_id_idx;
       public         postgres    false    192    192            h	           1259    42905    diary_entry_created_at_index    INDEX     U   CREATE INDEX diary_entry_created_at_index ON diary_entries USING btree (created_at);
 0   DROP INDEX public.diary_entry_created_at_index;
       public         postgres    false    194            i	           1259    42906 *   diary_entry_language_code_created_at_index    INDEX     r   CREATE INDEX diary_entry_language_code_created_at_index ON diary_entries USING btree (language_code, created_at);
 >   DROP INDEX public.diary_entry_language_code_created_at_index;
       public         postgres    false    194    194            j	           1259    42907 $   diary_entry_user_id_created_at_index    INDEX     f   CREATE INDEX diary_entry_user_id_created_at_index ON diary_entries USING btree (user_id, created_at);
 8   DROP INDEX public.diary_entry_user_id_created_at_index;
       public         postgres    false    194    194            m	           1259    42908    friends_user_id_idx    INDEX     C   CREATE INDEX friends_user_id_idx ON friends USING btree (user_id);
 '   DROP INDEX public.friends_user_id_idx;
       public         postgres    false    196            q	           1259    42909    gpx_file_tags_gpxid_idx    INDEX     L   CREATE INDEX gpx_file_tags_gpxid_idx ON gpx_file_tags USING btree (gpx_id);
 +   DROP INDEX public.gpx_file_tags_gpxid_idx;
       public         postgres    false    199            t	           1259    42910    gpx_file_tags_tag_idx    INDEX     G   CREATE INDEX gpx_file_tags_tag_idx ON gpx_file_tags USING btree (tag);
 )   DROP INDEX public.gpx_file_tags_tag_idx;
       public         postgres    false    199            w	           1259    42911    gpx_files_timestamp_idx    INDEX     M   CREATE INDEX gpx_files_timestamp_idx ON gpx_files USING btree ("timestamp");
 +   DROP INDEX public.gpx_files_timestamp_idx;
       public         postgres    false    201            x	           1259    42912    gpx_files_user_id_idx    INDEX     G   CREATE INDEX gpx_files_user_id_idx ON gpx_files USING btree (user_id);
 )   DROP INDEX public.gpx_files_user_id_idx;
       public         postgres    false    201            y	           1259    42913     gpx_files_visible_visibility_idx    INDEX     ^   CREATE INDEX gpx_files_visible_visibility_idx ON gpx_files USING btree (visible, visibility);
 4   DROP INDEX public.gpx_files_visible_visibility_idx;
       public         postgres    false    201    201            D	           1259    42914     index_client_applications_on_key    INDEX     _   CREATE UNIQUE INDEX index_client_applications_on_key ON client_applications USING btree (key);
 4   DROP INDEX public.index_client_applications_on_key;
       public         postgres    false    177            	           1259    42915 )   index_oauth_nonces_on_nonce_and_timestamp    INDEX     p   CREATE UNIQUE INDEX index_oauth_nonces_on_nonce_and_timestamp ON oauth_nonces USING btree (nonce, "timestamp");
 =   DROP INDEX public.index_oauth_nonces_on_nonce_and_timestamp;
       public         postgres    false    208    208            	           1259    42916    index_oauth_tokens_on_token    INDEX     U   CREATE UNIQUE INDEX index_oauth_tokens_on_token ON oauth_tokens USING btree (token);
 /   DROP INDEX public.index_oauth_tokens_on_token;
       public         postgres    false    210            	           1259    42917    index_user_blocks_on_user_id    INDEX     P   CREATE INDEX index_user_blocks_on_user_id ON user_blocks USING btree (user_id);
 0   DROP INDEX public.index_user_blocks_on_user_id;
       public         postgres    false    218            |	           1259    42918    messages_from_user_id_idx    INDEX     O   CREATE INDEX messages_from_user_id_idx ON messages USING btree (from_user_id);
 -   DROP INDEX public.messages_from_user_id_idx;
       public         postgres    false    204            	           1259    42919    messages_to_user_id_idx    INDEX     K   CREATE INDEX messages_to_user_id_idx ON messages USING btree (to_user_id);
 +   DROP INDEX public.messages_to_user_id_idx;
       public         postgres    false    204            	           1259    42920    nodes_changeset_id_idx    INDEX     I   CREATE INDEX nodes_changeset_id_idx ON nodes USING btree (changeset_id);
 *   DROP INDEX public.nodes_changeset_id_idx;
       public         postgres    false    207            	           1259    42921    nodes_tile_idx    INDEX     9   CREATE INDEX nodes_tile_idx ON nodes USING btree (tile);
 "   DROP INDEX public.nodes_tile_idx;
       public         postgres    false    207            	           1259    42922    nodes_timestamp_idx    INDEX     E   CREATE INDEX nodes_timestamp_idx ON nodes USING btree ("timestamp");
 '   DROP INDEX public.nodes_timestamp_idx;
       public         postgres    false    207            	           1259    42923    nodes_uid_idx    INDEX     ;   CREATE INDEX nodes_uid_idx ON nodes USING btree (node_id);
 !   DROP INDEX public.nodes_uid_idx;
       public         postgres    false    207            o	           1259    42924    points_gpxid_idx    INDEX     B   CREATE INDEX points_gpxid_idx ON gps_points USING btree (gpx_id);
 $   DROP INDEX public.points_gpxid_idx;
       public         postgres    false    198            p	           1259    42925    points_tile_idx    INDEX     ?   CREATE INDEX points_tile_idx ON gps_points USING btree (tile);
 #   DROP INDEX public.points_tile_idx;
       public         postgres    false    198            	           1259    42926    relation_members_member_idx    INDEX     c   CREATE INDEX relation_members_member_idx ON relation_members USING btree (member_type, member_id);
 /   DROP INDEX public.relation_members_member_idx;
       public         postgres    false    212    212            	           1259    42927    relation_tags_id_version_idx    INDEX     _   CREATE INDEX relation_tags_id_version_idx ON relation_tags USING btree (relation_id, version);
 0   DROP INDEX public.relation_tags_id_version_idx;
       public         postgres    false    213    213            	           1259    42928    relations_changeset_id_idx    INDEX     Q   CREATE INDEX relations_changeset_id_idx ON relations USING btree (changeset_id);
 .   DROP INDEX public.relations_changeset_id_idx;
       public         postgres    false    214            	           1259    42929    relations_timestamp_idx    INDEX     M   CREATE INDEX relations_timestamp_idx ON relations USING btree ("timestamp");
 +   DROP INDEX public.relations_timestamp_idx;
       public         postgres    false    214            	           1259    42930    sessions_session_id_idx    INDEX     R   CREATE UNIQUE INDEX sessions_session_id_idx ON sessions USING btree (session_id);
 +   DROP INDEX public.sessions_session_id_idx;
       public         postgres    false    216            	           1259    42931    unique_schema_migrations    INDEX     Y   CREATE UNIQUE INDEX unique_schema_migrations ON schema_migrations USING btree (version);
 ,   DROP INDEX public.unique_schema_migrations;
       public         postgres    false    215            n	           1259    42932    user_id_idx    INDEX     B   CREATE INDEX user_id_idx ON friends USING btree (friend_user_id);
    DROP INDEX public.user_id_idx;
       public         postgres    false    196            ¨	           1259    42933    user_openid_url_idx    INDEX     K   CREATE UNIQUE INDEX user_openid_url_idx ON users USING btree (openid_url);
 '   DROP INDEX public.user_openid_url_idx;
       public         postgres    false    225            ¡	           1259    42934    user_roles_id_role_unique    INDEX     Y   CREATE UNIQUE INDEX user_roles_id_role_unique ON user_roles USING btree (user_id, role);
 -   DROP INDEX public.user_roles_id_role_unique;
       public         postgres    false    221    221            ¦	           1259    42935    user_tokens_token_idx    INDEX     N   CREATE UNIQUE INDEX user_tokens_token_idx ON user_tokens USING btree (token);
 )   DROP INDEX public.user_tokens_token_idx;
       public         postgres    false    223            §	           1259    42936    user_tokens_user_id_idx    INDEX     K   CREATE INDEX user_tokens_user_id_idx ON user_tokens USING btree (user_id);
 +   DROP INDEX public.user_tokens_user_id_idx;
       public         postgres    false    223            ©	           1259    42937    users_display_name_idx    INDEX     P   CREATE UNIQUE INDEX users_display_name_idx ON users USING btree (display_name);
 *   DROP INDEX public.users_display_name_idx;
       public         postgres    false    225            ª	           1259    42938    users_email_idx    INDEX     B   CREATE UNIQUE INDEX users_email_idx ON users USING btree (email);
 #   DROP INDEX public.users_email_idx;
       public         postgres    false    225            ­	           1259    42939    way_nodes_node_idx    INDEX     D   CREATE INDEX way_nodes_node_idx ON way_nodes USING btree (node_id);
 &   DROP INDEX public.way_nodes_node_idx;
       public         postgres    false    227            °	           1259    42940    way_tags_id_version_idx    INDEX     P   CREATE INDEX way_tags_id_version_idx ON way_tags USING btree (way_id, version);
 +   DROP INDEX public.way_tags_id_version_idx;
       public         postgres    false    228    228            ³	           1259    42941    ways_changeset_id_idx    INDEX     G   CREATE INDEX ways_changeset_id_idx ON ways USING btree (changeset_id);
 )   DROP INDEX public.ways_changeset_id_idx;
       public         postgres    false    229            ¶	           1259    42942    ways_timestamp_idx    INDEX     C   CREATE INDEX ways_timestamp_idx ON ways USING btree ("timestamp");
 &   DROP INDEX public.ways_timestamp_idx;
       public         postgres    false    229            ·	           2606    42943    changeset_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY changeset_tags
    ADD CONSTRAINT changeset_tags_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 O   ALTER TABLE ONLY public.changeset_tags DROP CONSTRAINT changeset_tags_id_fkey;
       public       postgres    false    174    175    2367            ¸	           2606    42948    changesets_user_id_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY changesets
    ADD CONSTRAINT changesets_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 L   ALTER TABLE ONLY public.changesets DROP CONSTRAINT changesets_user_id_fkey;
       public       postgres    false    175    225    2476            ¹	           2606    42953     client_applications_user_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY client_applications
    ADD CONSTRAINT client_applications_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 ^   ALTER TABLE ONLY public.client_applications DROP CONSTRAINT client_applications_user_id_fkey;
       public       postgres    false    177    225    2476            º	           2606    42958    current_node_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_node_tags
    ADD CONSTRAINT current_node_tags_id_fkey FOREIGN KEY (node_id) REFERENCES current_nodes(id);
 U   ALTER TABLE ONLY public.current_node_tags DROP CONSTRAINT current_node_tags_id_fkey;
       public       postgres    false    181    182    2379            »	           2606    42963    current_nodes_changeset_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_nodes
    ADD CONSTRAINT current_nodes_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 W   ALTER TABLE ONLY public.current_nodes DROP CONSTRAINT current_nodes_changeset_id_fkey;
       public       postgres    false    182    175    2367            ¼	           2606    42968     current_relation_members_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_relation_members
    ADD CONSTRAINT current_relation_members_id_fkey FOREIGN KEY (relation_id) REFERENCES current_relations(id);
 c   ALTER TABLE ONLY public.current_relation_members DROP CONSTRAINT current_relation_members_id_fkey;
       public       postgres    false    184    186    2390            ½	           2606    42973    current_relation_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_relation_tags
    ADD CONSTRAINT current_relation_tags_id_fkey FOREIGN KEY (relation_id) REFERENCES current_relations(id);
 ]   ALTER TABLE ONLY public.current_relation_tags DROP CONSTRAINT current_relation_tags_id_fkey;
       public       postgres    false    185    186    2390            ¾	           2606    42978 #   current_relations_changeset_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_relations
    ADD CONSTRAINT current_relations_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 _   ALTER TABLE ONLY public.current_relations DROP CONSTRAINT current_relations_changeset_id_fkey;
       public       postgres    false    186    175    2367            ¿	           2606    42983    current_way_nodes_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_way_nodes
    ADD CONSTRAINT current_way_nodes_id_fkey FOREIGN KEY (way_id) REFERENCES current_ways(id);
 U   ALTER TABLE ONLY public.current_way_nodes DROP CONSTRAINT current_way_nodes_id_fkey;
       public       postgres    false    188    190    2400            À	           2606    42988    current_way_nodes_node_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_way_nodes
    ADD CONSTRAINT current_way_nodes_node_id_fkey FOREIGN KEY (node_id) REFERENCES current_nodes(id);
 Z   ALTER TABLE ONLY public.current_way_nodes DROP CONSTRAINT current_way_nodes_node_id_fkey;
       public       postgres    false    188    182    2379            Á	           2606    42993    current_way_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_way_tags
    ADD CONSTRAINT current_way_tags_id_fkey FOREIGN KEY (way_id) REFERENCES current_ways(id);
 S   ALTER TABLE ONLY public.current_way_tags DROP CONSTRAINT current_way_tags_id_fkey;
       public       postgres    false    189    190    2400            Â	           2606    42998    current_ways_changeset_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY current_ways
    ADD CONSTRAINT current_ways_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 U   ALTER TABLE ONLY public.current_ways DROP CONSTRAINT current_ways_changeset_id_fkey;
       public       postgres    false    190    175    2367            Ã	           2606    43003 "   diary_comments_diary_entry_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY diary_comments
    ADD CONSTRAINT diary_comments_diary_entry_id_fkey FOREIGN KEY (diary_entry_id) REFERENCES diary_entries(id);
 [   ALTER TABLE ONLY public.diary_comments DROP CONSTRAINT diary_comments_diary_entry_id_fkey;
       public       postgres    false    192    194    2407            Ä	           2606    43008    diary_comments_user_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY diary_comments
    ADD CONSTRAINT diary_comments_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 T   ALTER TABLE ONLY public.diary_comments DROP CONSTRAINT diary_comments_user_id_fkey;
       public       postgres    false    192    225    2476            Å	           2606    43013     diary_entries_language_code_fkey    FK CONSTRAINT        ALTER TABLE ONLY diary_entries
    ADD CONSTRAINT diary_entries_language_code_fkey FOREIGN KEY (language_code) REFERENCES languages(code);
 X   ALTER TABLE ONLY public.diary_entries DROP CONSTRAINT diary_entries_language_code_fkey;
       public       postgres    false    194    203    2427            Æ	           2606    43018    diary_entries_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY diary_entries
    ADD CONSTRAINT diary_entries_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 R   ALTER TABLE ONLY public.diary_entries DROP CONSTRAINT diary_entries_user_id_fkey;
       public       postgres    false    194    225    2476            Ç	           2606    43023    friends_friend_user_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY friends
    ADD CONSTRAINT friends_friend_user_id_fkey FOREIGN KEY (friend_user_id) REFERENCES users(id);
 M   ALTER TABLE ONLY public.friends DROP CONSTRAINT friends_friend_user_id_fkey;
       public       postgres    false    196    225    2476            È	           2606    43028    friends_user_id_fkey    FK CONSTRAINT     m   ALTER TABLE ONLY friends
    ADD CONSTRAINT friends_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 F   ALTER TABLE ONLY public.friends DROP CONSTRAINT friends_user_id_fkey;
       public       postgres    false    196    225    2476            É	           2606    43033    gps_points_gpx_id_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY gps_points
    ADD CONSTRAINT gps_points_gpx_id_fkey FOREIGN KEY (gpx_id) REFERENCES gpx_files(id);
 K   ALTER TABLE ONLY public.gps_points DROP CONSTRAINT gps_points_gpx_id_fkey;
       public       postgres    false    198    201    2422            Ê	           2606    43038    gpx_file_tags_gpx_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY gpx_file_tags
    ADD CONSTRAINT gpx_file_tags_gpx_id_fkey FOREIGN KEY (gpx_id) REFERENCES gpx_files(id);
 Q   ALTER TABLE ONLY public.gpx_file_tags DROP CONSTRAINT gpx_file_tags_gpx_id_fkey;
       public       postgres    false    201    2422    199            Ë	           2606    43043    gpx_files_user_id_fkey    FK CONSTRAINT     q   ALTER TABLE ONLY gpx_files
    ADD CONSTRAINT gpx_files_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 J   ALTER TABLE ONLY public.gpx_files DROP CONSTRAINT gpx_files_user_id_fkey;
       public       postgres    false    225    2476    201            Ì	           2606    43048    messages_from_user_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY messages
    ADD CONSTRAINT messages_from_user_id_fkey FOREIGN KEY (from_user_id) REFERENCES users(id);
 M   ALTER TABLE ONLY public.messages DROP CONSTRAINT messages_from_user_id_fkey;
       public       postgres    false    225    2476    204            Í	           2606    43053    messages_to_user_id_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY messages
    ADD CONSTRAINT messages_to_user_id_fkey FOREIGN KEY (to_user_id) REFERENCES users(id);
 K   ALTER TABLE ONLY public.messages DROP CONSTRAINT messages_to_user_id_fkey;
       public       postgres    false    225    204    2476            Î	           2606    43058    node_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY node_tags
    ADD CONSTRAINT node_tags_id_fkey FOREIGN KEY (node_id, version) REFERENCES nodes(node_id, version);
 E   ALTER TABLE ONLY public.node_tags DROP CONSTRAINT node_tags_id_fkey;
       public       postgres    false    206    206    2436    207    207            Ï	           2606    43063    nodes_changeset_id_fkey    FK CONSTRAINT     x   ALTER TABLE ONLY nodes
    ADD CONSTRAINT nodes_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 G   ALTER TABLE ONLY public.nodes DROP CONSTRAINT nodes_changeset_id_fkey;
       public       postgres    false    2367    175    207            Ð	           2606    43068 '   oauth_tokens_client_application_id_fkey    FK CONSTRAINT     ¡   ALTER TABLE ONLY oauth_tokens
    ADD CONSTRAINT oauth_tokens_client_application_id_fkey FOREIGN KEY (client_application_id) REFERENCES client_applications(id);
 ^   ALTER TABLE ONLY public.oauth_tokens DROP CONSTRAINT oauth_tokens_client_application_id_fkey;
       public       postgres    false    2371    210    177            Ñ	           2606    43073    oauth_tokens_user_id_fkey    FK CONSTRAINT     w   ALTER TABLE ONLY oauth_tokens
    ADD CONSTRAINT oauth_tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 P   ALTER TABLE ONLY public.oauth_tokens DROP CONSTRAINT oauth_tokens_user_id_fkey;
       public       postgres    false    225    2476    210            Ò	           2606    43078    relation_members_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY relation_members
    ADD CONSTRAINT relation_members_id_fkey FOREIGN KEY (relation_id, version) REFERENCES relations(relation_id, version);
 S   ALTER TABLE ONLY public.relation_members DROP CONSTRAINT relation_members_id_fkey;
       public       postgres    false    2454    212    212    214    214            Ó	           2606    43083    relation_tags_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY relation_tags
    ADD CONSTRAINT relation_tags_id_fkey FOREIGN KEY (relation_id, version) REFERENCES relations(relation_id, version);
 M   ALTER TABLE ONLY public.relation_tags DROP CONSTRAINT relation_tags_id_fkey;
       public       postgres    false    2454    213    213    214    214            Ô	           2606    43088    relations_changeset_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY relations
    ADD CONSTRAINT relations_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 O   ALTER TABLE ONLY public.relations DROP CONSTRAINT relations_changeset_id_fkey;
       public       postgres    false    214    175    2367            Õ	           2606    43093    user_blocks_moderator_id_fkey    FK CONSTRAINT     }   ALTER TABLE ONLY user_blocks
    ADD CONSTRAINT user_blocks_moderator_id_fkey FOREIGN KEY (creator_id) REFERENCES users(id);
 S   ALTER TABLE ONLY public.user_blocks DROP CONSTRAINT user_blocks_moderator_id_fkey;
       public       postgres    false    218    2476    225            Ö	           2606    43098    user_blocks_revoker_id_fkey    FK CONSTRAINT     {   ALTER TABLE ONLY user_blocks
    ADD CONSTRAINT user_blocks_revoker_id_fkey FOREIGN KEY (revoker_id) REFERENCES users(id);
 Q   ALTER TABLE ONLY public.user_blocks DROP CONSTRAINT user_blocks_revoker_id_fkey;
       public       postgres    false    225    218    2476            ×	           2606    43103    user_blocks_user_id_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY user_blocks
    ADD CONSTRAINT user_blocks_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 N   ALTER TABLE ONLY public.user_blocks DROP CONSTRAINT user_blocks_user_id_fkey;
       public       postgres    false    2476    218    225            Ø	           2606    43108    user_preferences_user_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY user_preferences
    ADD CONSTRAINT user_preferences_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 X   ALTER TABLE ONLY public.user_preferences DROP CONSTRAINT user_preferences_user_id_fkey;
       public       postgres    false    2476    220    225            Ù	           2606    43113    user_roles_granter_id_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_granter_id_fkey FOREIGN KEY (granter_id) REFERENCES users(id);
 O   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT user_roles_granter_id_fkey;
       public       postgres    false    225    221    2476            Ú	           2606    43118    user_roles_user_id_fkey    FK CONSTRAINT     s   ALTER TABLE ONLY user_roles
    ADD CONSTRAINT user_roles_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 L   ALTER TABLE ONLY public.user_roles DROP CONSTRAINT user_roles_user_id_fkey;
       public       postgres    false    2476    221    225            Û	           2606    43123    user_tokens_user_id_fkey    FK CONSTRAINT     u   ALTER TABLE ONLY user_tokens
    ADD CONSTRAINT user_tokens_user_id_fkey FOREIGN KEY (user_id) REFERENCES users(id);
 N   ALTER TABLE ONLY public.user_tokens DROP CONSTRAINT user_tokens_user_id_fkey;
       public       postgres    false    225    223    2476            Ü	           2606    43128    way_nodes_id_fkey    FK CONSTRAINT        ALTER TABLE ONLY way_nodes
    ADD CONSTRAINT way_nodes_id_fkey FOREIGN KEY (way_id, version) REFERENCES ways(way_id, version);
 E   ALTER TABLE ONLY public.way_nodes DROP CONSTRAINT way_nodes_id_fkey;
       public       postgres    false    227    229    2485    229    227            Ý	           2606    43133    way_tags_id_fkey    FK CONSTRAINT     ~   ALTER TABLE ONLY way_tags
    ADD CONSTRAINT way_tags_id_fkey FOREIGN KEY (way_id, version) REFERENCES ways(way_id, version);
 C   ALTER TABLE ONLY public.way_tags DROP CONSTRAINT way_tags_id_fkey;
       public       postgres    false    229    228    228    2485    229            Þ	           2606    43138    ways_changeset_id_fkey    FK CONSTRAINT     v   ALTER TABLE ONLY ways
    ADD CONSTRAINT ways_changeset_id_fkey FOREIGN KEY (changeset_id) REFERENCES changesets(id);
 E   ALTER TABLE ONLY public.ways DROP CONSTRAINT ways_changeset_id_fkey;
       public       postgres    false    2367    229    175            L
      xÑãââ Å ©      N
   <   x3àL.JM,IMOªäô/ÎÍ/Î,V0Ð31Ö3ä2à,J-ÈÉLN,ÉÌÏã,)*MåÑãââ ºÞ      O
   >   x3à443·41å4204Õ50Ñ50S04µ"#s=SsN]K(àD°t-àl$&.3¸bô¸¸¸ *þ7      Q
      xÑãââ Å ©      S
      xÑãââ Å ©      U
      xÑãââ Å ©      V
      xÑãââ Å ©      X
      xÑãââ Å ©      Y
      xÑãââ Å ©      Z
      xÑãââ Å ©      \
      xÑãââ Å ©      ]
      xÑãââ Å ©      ^
      xÑãââ Å ©      `
      xÑãââ Å ©      b
      xÑãââ Å ©      d
      xÑãââ Å ©      f
      xÑãââ Å ©      g
      xÑãââ Å ©      i
      xÑãââ Å ©      k
      xÑãââ Å ©      l
      xÑãââ Å ©      n
   Ó  x½YÍÚ0>§È°rÛÚSÕVU=mÕS% °nÙ9A+Þ¦×½÷x±&6dÁ;!>lç±oìï)Ìf,J¢Å¾E=Ë¢yªÌïèþûûÞXí
7~ÕVçñwõ®2M¿c·_lõrÞ¢º©vó]UëFWe· CËÑÕvÕÝ=GF×ºÜX³ºvÎ>ûÎYãMçì çD»­®öfYDË|×)¦«®MìÌñ»ø6Å²{#þr|.Ï&ßñª¨ã¯»ãß¦§ñÇÓ»ñûøQ×E|üÿj_o_æEâÞ¹8v.æ5¸R^i×Ðöù]7ùñæÚãÎeÂÐF	ÌÂÌ&04qv|îàú »c |ôHaìf^xfXxfaÁ§<ê ßRaÄ*«ÎÙõò°Ü=BhÍëªjú}ñ7³H|À{xÏqï¹ïý@:»÷M<6­ùò²#Ãía´=sTÛÃÜèÍC3oö¦ì÷4]q¹Ñ.P$q:¤<9<2,x$§J±Ò­k2,´PK(2$Oc7(Â!¼´*°(Âfê%º«q)H9Ë©WÚR¬´¥j$¬¢¥ag¿N*Îö*®­ù2©¤1hÓlÊ¨¸Ç8ÇçCó0ÆùeBÝäMa3ÔÔîNvkwk	Ö$axá`ávzIX\$Ø­'AQV½É^îéLû	ÌcaÚgCÚgaô2^ÑËFéeaô2²N5$BRûÓªiKÿþÜ³ªqT]m%ó½ð)}(BØÅmk×Ïw|Ï,Òu @² Îc làqç0ÖºhÜCCPg¼Ô¢0ùyâãßÊð¡ÚÉî7möÆiü.þëÒÉ@q7:°x3È°(ÏÆ~ZBØÔ¼©(¤¼;ãM´°¹(2q¼õ´gPêÓý0§éBêBéBzº.ä¨.d.ìÐhiªºË"]õY¯Ûj½)ó­CB:r ÷Ø»Tí6zlÔêd½`V±E+ÅÕ|q>¯t+ên%%c0%c0¥úÅ$ã#w&²æd4§PC"S§RDìvrôæá)? ëÊv¤Ãë©MO7 Ü±üßf#á-KGÎw¶R{ÈÒ['øy7LþÁ?      o
      x]Ûm·	ý¾®"8Hèá"RAÊHÿ$àHûKðÇöÅ[ÁZ¼ÎßcNøS¹Vle´?µôY°?ðç`þô7ÍüCãJPükðÿü÷?ý=æ[ ô]^&Á[@;~ÁXÖÛäºK ÖÑjê¤G(Ì¼TÙR_°XüÚGh\^_ ÿ6ýô­ÄRyöýTÞF9
è\¶å8oç}+Q>]8Å êx­Dù{Ès	àBãeÜ Uâ¬Û¤ÄFm>¿àè ©'uZ4Ôú2$G*Qî¿îk½Î·ï/PKlÔ·0ðÆ@v"V¿ åUe¾ÀØæÜ¯q¢>ØÈË¾¨¹/`Uâcm%ò¬íe_j{ßH"·P }ÎXÚö£GÊñlJ7¸,qK«¯/øR5(v¿ÆÚC_p^c5K¡Û±ÈûÈ¼ÆªJìâÔ¥µÇ#UµÄhßÂÿù2ìäR:¿êçê 6ýéP¾T,gØ©ó3£bqäþ÷- À\:0C¸h#dq¡WU"Mxt@Ô©R_&X¨ZdmR!ñª)dGXG_¸À·@`·[TG¸ö¡µ}+Ê¦BªUu(³¾àVY½oX B9:@{i×!A2åÐ,QbÛ~Î}6|éà# Aù%  Æe`qAàúD(xÇÀ+¡~Aop®,.`m"HõÄ0KbÛ·wu#I|yZâWbeÜq[¢|L&°iqÞØ6d<G _>U ´ >À@VéUù?cãmC	üw(ÂZ¦<¦f%°÷)#ÇÊbh
@È}ýøÂþ*¸9`Êçpôsr_>£D#pÛáT¿Ì»!U¹PqÏ	K4Â!Ìel;V^>·ÐÝ'ÊÜ· áq>·`£Î¹ÑúrhýmÊ'2öó¸u@XJ¼8kÃ¶³8Å¸F:L,ì[c#å^£Ak$0ôÔ-ál§ìÛÛ'~´oáÀ .mC%áëS%J`+ y	°üjtFASfòÐ¦iÊ½¼tð±Dv³	 hu¾ná# :õeõÊ¢ÄÒÁpÐ×X[DÀ±j·GZ¸=Õ¢3Õ9ÔÇó>±±Z&õ1Í\"jÃv\X)z=¦Ïóe¥Vx_*J	p;' «Õ_Å©/>&ZéµÌ%¼ïÐÖGy;Õ^Od"Sb¨¼tâ'Ðü0%R×èÜÛî©í%ÆÑK_¦D±Åí¨qæÁ`>q?èg qùD´ç\w
yQ?Àæ¥ìÇTc½´$Dõ­Á('2cÒ3E¸óñHÆX)Ràg6ï&ÃKï\Qé??Ýúç±0X*L%§ðØ¾9·4~Ò¾8ciEÃ{?ãÂmÊÎXj/U0Ç=RWÆ":;¸Î"Ì%GªGe÷ëtuªü8ß/0K¯©q\§ßB7Æ²sY
²Ä)½Ì#Àó¬ SK<Ô±éÚþ`ðÊÃ$S·	#èú©Üz?'¶fù g2îv(ÝJ$ØÛ°ÈÜïÃ¢³ü±íÖÅ'L`éÆXä¿¯v Ä3By­D2%¢í#|®sF8î"@îÈlçÜpU_Ò@ÅD¤á`­8É-Édáx;° g`ù<g#òqûD ÝáhË´Ú×#äû:Å¤·Àq¡á é@ÈxÎG^áBÛ%SK^á P%
@yb¤pÈ¨êõÆû,.k¥Ëë5Þ§;áª0P J`ôj¥-7°í 9ÕC©®Ä^Õ¹d¢s7¾ ¨ô³¶RíV X^qÇF0û¦}×s¶E©5yf/ÚíkH JÀOh³E?¯n½Õg.ícV IÅïJ×çäiÖ5
@É`åîõ99m-ä?0´Îu¨W	ïÇ­×Ö¦.~ö|hhÅoCù7oá`$¯/ öPOÞø@^sÝeÊk×KÞ¹n§:ä¥<±òÇ¡LiÛÁzOöyÖôi
¤ÑÔÏ-8Z4£Ù:g*ß¼¤ë5Jd{º´ï,´æT'íJkÖgÑà*l<õÛ4|0
l¤*õti·SmÓ,Q¸ÖÚ>ç­æh}.X yågæ{YMY J$2%VoIä9Õ&Ä¡ÔgæöÍÐz]Ðf;¡ ©k´ú¯Ø¶K»%¬ÖptÐGK$_0SáhÖÛNìJW	tD]Gèêæ"N ¯/LíY9L}¡yCSrÊótª÷7JR;¨# qæ`YÝ¢ô_¢t8.­ÜGf@F .èÜy>qçå)Í)6¯/TÁ6Û­/À9Á}®Ó*")eÊ÷«¤} h) ãùdÍh
sÌÄfMDU3Y$9Ó£ÙØ!U"äHW3¸¿x¿v2?³û7ÈjV_à¦qaa¤¡<Íê°I¶SíüÎC²ú´ª=pR©ýø¯çlQÂö´Þ¸²@Ò¢ecÓd²8ÍÇbíË¢ÅÇÊ)Äx&¢¾_`X¬ÅÆÛ©~×jSÒEÉç­¾(°(¸ëY¼¿_£3Õg¼ëÎü¦<c¿«Uy×ðÊG -Ö-Ø¸ÆóÑãõ¡_P8ÃÚ­é[B
¡ ½Fñ ±ñÉúÜ:rÿu¥Ü:x¥ÈKL#ÂÝÉÈÂq®Ñú@ÅH«µ-cÊðC(¨|¡FèÿuF8ÅkZzÊn%²74	odÍ­÷§C¹³8<	I­|*×¨%®ý8k Cò¼Þ£YÁ½rªÿ/%+R×È©ÆÆ¸ìlÊ8=ÒØFG@u£5æ(Üì5Ðàº k¦ÎÄÝ7V:>¦ÛÙø|¹~
]È<g¶~$y
uÇlÏv¢%z?×ÍÚVB!Ò	sìÀøÓPÊSVãzêA[®ÇNg®ÑøBÇÝÞµ4v	0%¢ÕÄ-DÊGíu­úÏí?ä|A÷p%Û¥±ñF.ÔØ Æ´YÃ¤ÉøBY]Û©ÖL­< P[+]ò¬"ùëÞrÝ§ÊËLùÜñÝCß©GÐúP=-<5Çy#{y@þ§¦ÌÉ[ðòÀdmpTRM®Ò|f Òu]cµDTÁÝ¸úNéÛl|[ÑÇ#=çÆÄ¹îÄé¼"SñQM@ FZï%_r¾(á%Ðrë@ËBÈUë5Òðü£¾l^6àÛ`;Ù'(ÈüA¿ïçÖDâ5%:êÓ?>Ñú`wRí® éO<ÁÕû°)cÁ6#ôÿ|÷#MÖ¤¬Øá³?ñóp.)Úzk»,ÑGÅ¦	I*-Ò){^£÷#é¤£`fiÖÆè¥[
D"K ÖvàòuLµ¯µ c®Ë;×gåûó¼Â»õywG*ç9{f4w×u&:áh´Þ8atp¾ á Yíùtiw\¨N8ªñ¡ÿùÆëÜ'új;_¼hZc!QC¦±­cirÊä5d`^õ
²âÄïi¢Û«3^t²®À»Ú÷à(ÅÊò"vpéÀ*¥[C·	¸4<lEvwHu×î´n©êÞÁ¦9Òr]  Ð¾´)Z|¶ß.­zCSw¯L¨µÝGðYnãÊH·pèM»Ð¹t¸>:hÞ-\µÁQPb¤/m¿	
2 ¹÷ëéM×­Á3ò¹æ}ë:¦:Eâ¡Üø Zc$óHÎtJ5ÆÒÎ×	FFq®/°ªïj¾7ôÛ¯üc,[Wé½\lãNÓEVJîWohêE;ãÖgæç±Þ÷!Ü5zcåR5	SÞ¹õ ÷`¬Ömec¨ ¬UÊN6ïj ²EHW*´ý Ô'
},I8ìknÝ<R XwáÇHoAÞb¤ÅòÜù°ð@k/,Ïe"_¾Î¤h
¶IOuëð¹¾àû>,LEK÷Ï[@o±Ü35½§zu+úa_À«e14«ñKJ}Ûó1}Bói²uítIéÀG4[³éÐ<G /î±á"ÏÈòë¢ï)·ZcQÁQh=­F¦HÎ5ZB¬¹ës^í}©#xr6ñyIûe:JÓNY!ßôì?ø
p¾@E;ãÄ¿fSñEaw.5ÔRU ßÄ±ÿj1×ú8ß#XáºÛËóÙrc¤b|aÕÊ¬Î4#ýÊç¼#jÙxç©Ï¼ÂsVK§êÅç(ÀàÑA;ÌvHöÙz*R~+ú°þÄÀÊ':_¨¶%¶Àþ|aèB¡°OÞø`Ï¹÷ã	u?·àEu%²dêøÒÜmz iÕ²É:¢Z1;èÃ@×¼#­PEËã/p4ê[Ã@·ân#¿
´_|ÅÓKÛÏ95ó]| 5°bÈ`åbºzl5:ÏÈº³ëÑÓ°ç¯Ñ+¥è l/¹R½`9¬õ^bÊª78²ö¡à|O©
:HðÜÀð¹Fã],#µ¶ë|D³Õ¢íK¼âU8V¿±NÚ2G(çì15´	éï/CòQ0´¾ ^6TU8¬úi±¼¿ÀÁyÆ{¶ïcÊäýÊl#?·|®Ñ E  @°rW± öN¯ê?¦ÖÞá¦Ñ@ å²ß%LG×Õw+ÍÍ·TMPFyf®Ñ°&eÅ³Eë#xØ+]ºtðá ].$¨=ÕÌSÐ³yDÑ#Ñ,>q½÷*mïÌ9S
mê¢ùNLÉËÚ¨ÑYÞefî½cYKÍ'R	l+»\·T­ëû£r©=Yä¬Êû"Ï	S&c,CÀ²	qÍmúU8t¢à\H·@ÆX!isß*ÛeùÄõþsÛ_#ùÄ5£¶ÖÑO¼ñÏ©Fótkc¥¾+¡p(Ç`@ÜemrÌiÈ¦WÂ¾FyÈD^ C×5ì?¸tÐ½CK$sèe 9á(êTWæÙJ#¦Gol«:=PùÍÚnÚG¿O{KÐªµÍH3ÏÑAó¢-LÎP×øýBx7VDê<¼} ÉòÊí½÷v(í·öÎ: jO-!/PÔ¢#â#}(ç-°)±íõs+2ÑÓ­ß)QâÌ³±´Ï5²­ëúÃYézLF8j^ýlµ½áhU)ÏHOòOÓ6<¯ZK&FF8xtµDÊÏDÔG¾â	®xZEÌU_¬Ãº[xÁ®L½p¬¼­ÆÔ9á¢©à»/ísÅKeXÈÉ<&#ke.hî%5 IF8*[78ÓQ"9õÝ%«åÖ!2Uvtð[JK6´`VÆ¥ÙFkS¯QxcdßúõÞÈ¢ó³Óû?>Ñ	G·æÿÙø]õ½8á åZi%zK|ÖÞ¸¦
z¯.éé>Û?G0K¦K¦ Ä¹%â°%%´óè ¼õÕJdæ|xÃ³)±wN5<&¸_UâR:0ÂÑÖ2ÈhkÄéMß¨ÏÖî¶D`Aãs¢åÝÂ·ODû8.¡
ld9:@Ù.`cëÖ3ci8<£©;¦'Õ÷~åî£Ã}ùsÚ1-÷éE_	«Éõ#o¾ðQ¢óÑ¥µÕñ`Mßô-O5ÕØ>¡VWX¤õþ2$ãCSÔ«ÖÏªÏº7yZ_Z-i8v`|a¹êÇzÚÍæÔ+C}g4o^_h¬·s¦Ñà¾â.õÙ(àÒNtÆßEæÖßçvëèýH]é Aiç>AÁ]ÓÂ3°sþóükê"[BïJ×G½FÛ!*hvã~K¢m$£¾èpØ%¡uh?!e7_[§w¯îMyð·`©Ø¤íäç[ø
ðO:Rà½­ì{ßBÖnÜ".%Zoz M	ðóìáýýC7_Àâ5ÔñÄUªÈ#¡e0DNdÅÓ1e/®¾q2¥2¤ÓØV´Ê3£û×¼¡©6E(YRUH¾æJàiBh_Úý>g+ agg:À_N­ÞØ";$?@ÿ-©3ýg`ú¦au¦)Ï:Ó§øÃú2¼7j$nÁç¦îÍ[ë"«Â Û{òb§G*¿ì>êåÜ[à: ÿªk0«ðÌÏh ïSå¦«}¸¼¯ñXàW¬Óµ¸12÷s(`Ù}Òú²ê3){{eðì~! Q6ðÇÁ³û«ßX+]ï_K»L_9l¦B Pu}!Õõ÷Õ¥ÕÈZÜóþsµi°ç!íSÕ¹í`ôgõÿ¶¾yví¦wbúöà¿ ÑûÐÙ¾Ù· ¸VÒµ2ÏÎ¸!Ü_-	sÌÄðk(:IÓ14t®±ûr¡ª©q,ÀrR÷ß"AíÅU¶KÁãt4oµ¥²y%z?R¯Zk(ÿdï÷
Hh>,\ífh¦Äi»*½»Æ?É²ÎáÕÿ÷v¢Û­ÿäy7ÐJ%høBVüë"¹õë-ü~rNw¬_7Ô|!kI@;ðò (F#p¤íü:=gT¨+ÊìOòqiþs­ÛRõãD)qJ±	K÷sïG*Å¶TÎLXó¨:ûÏ5ÒNt}°Ál%Ðu]£ñµ0K  ¦v@/XÒ³XEÛò,Þ¿ÀV}Ù¯hö5ØñÿÉ¹>uX'§~³ü'çtÝÔîJMPÀ¯¨ê²1ÞùáéJºÖþÃÔì5.#V;Àø­EõÏÉº ²¶YÛÚ
mø[:§½û+·¾¡©Y©líË°w@g®öû½E^×ø#å·KûÁ	ê@üJ¢ä¿ÿþë¯¿þ-³pð      p
      xÑãââ Å ©      r
      xÑãââ Å ©      t
      xÑãââ Å ©      u
      xÑãââ Å ©      v
      xÑãââ Å ©      w
      x5Ëm@ïSLd0ÞO/é¿l^-!0MÃEZh£..,lÜ8xðÂ|é¢E¿Ê¦C½èMú""&2dM¹L1b^s©jÔÚòÜ?yßäõ¤¤¼\UÛU/pÿ³KÎ~Ü{=÷Ûüýü 6Ã&      x
      xÑãââ Å ©      z
      xÑãââ Å ©      |
      xÑãââ Å ©      }
      xÑãââ Å ©      
      xÑãââ Å ©      
      xË/ÎÍ/Î,/-N-743·41uH­HÌ-ÈIÕKÎÏåq F¦º&ºf
¦V@dd®gj`ÎËYc ¡1§©ÜDÎ?Î4A©y)yépQÁìHs#GBÈw¤7ÌÞ82F N6QY      
   i  x][[$+
üîÞKÏ|ïeö¿IhDZJ*"/«þ¹Qþü>ûöÇÿþ;ÑæC$X{GF$a³ÚC( Ä+Ã?S"G¦¼eÒûz½Ö3fÂòyO©)£~dwJáÝËL.B*¡þ¢~Fx.ýgD_Uu
Ågq/Á(#	Ød<þ÷ÌÐæP~GÔ>½à+>ò ¦d¼¢Ú#B
¡Ô[Ö
j#R(Â
B/ýÁ:µÞ½*\]2B!£½Á¥P§uôÔeujÄ«Ó¡/ÁÜ~F
áTami0S2ð(e$¡5îvê´1JCÿÈû2>#R§3	5×Úm>w®ÖAPVZ¡Ý#"·½y_uÚgJÆ÷'WE°Iªå½Qý³Ò"BË÷Âæ=btj½¬È¥wMy	µ¦bJÍÍ5-µhJúú¯TÒè¤ êª#,$#	}JF%ÁEXó³X²v[¡÷ÏK}6gåµ wú 0#<¯.ísP^óä$#	£Ï{d`é+ý,=	^>Sòääµc¦U8Á+tÒ.
ÂGÑ2¾Èàöay³C#^ÂÇ¡u-Ì-½¶Ñ4ÅR¨î-ñ;¢Oú Ê }xÏ;'ÓaÁ{ýádýOÞùùJ:i¯ÉHÂ^ë-ÃséÔÇú5~BÛä¡ÊÆ@(Mmá1M©TÐ$¸å;AËî)_åÝ/
|P´d¸Ð¤ /ê"XhI¨rîiëaòìóÙ$Ä´{JÓg3ÿÈ«s±õ³$¢ÃN+»x0Êpªb6#öÒ×³Em<ÏÜ¸Ø¼ÆûYöÆ6öª<òNKÞ |Èké&ÄOÜââc>¾ºÿÈ+ãvãýNò¡¡®mÏç>Éç	Ðë9±Ìæá'®üp«GÞ(ékO<?ãß8Øí8K;çµùc[ëá£`ÏhØgºÃ¡ïåeÕ<øÙpóíè×{ÙÞp[ÉO÷zÜÚêf×úëßê±¶*±ó{m±Ù¯62Ì´s>^e|ãrÂôáLp5èãDq~ïøë«Çml|èãäWÚ'ð(çü6¿muægìiÄ>vÚ¹qOýOySò××açè¸ ±Þìô:âg¶Ð~ø'{pîúvçþ×¸Ç·àþ0ÿD_)àÆÊ¥S^îWúÅêõüÓwÚ°÷sjfKýÚcÍÔ¨I_ûàùfMó³ ^vñq?|LÚ'p	ÏÔþØWçzQÅÑ§ÍoäÙ¸Ó_Wúï=¾ÿÍ.yuÑþ,ÓËÅõ&®öØG¥|$ÎÔ¯I¯Ú§ì)1JYÈË<³i©ï©ï£á@ý"uëùáäyÂ_Ñ?ï¢÷¸òüNû95ïÆóäã«À?dcxâð7ßÖ@òrýÎïÍ+5Û¸~ñíôp6n§8zp¿üp£}¿©Ô{¿ùý²çæ·"ù¹ÿñÉ4?¨?Ì7ú['^õæ¯Iý'î%
ñ8ßÛéþ)ìû;ÓÆñ¸ÒyãÆùqë?q¡ÿ)Ù4a¼ñbü8Xò÷/åga¸ó¾ W§~5¯ù>N|FW§'î?ò{®ûO\¤¿,I°>'./À+ú5>Ö~åzR^ÑzÀï-veãèÆz	©V%fJÚzÚBÐä±tÙK*BÈÕÀßãÝi¢ÛçP¡jËyÅOcic¸Ü2ª/ àVibm2¤ç÷[^é¡ñ8Rî/±õy/t	ã´[WÉ)tER6ÉK/`ÃáÉ:
õ×®>âÚýºìÝáiâc½âç~ú¼øE.³¢Èï%®Cã3i<¯ïÄ]úEgÍk<Bxî]OâÕihéMO¦Ø)5ðË¶{|7~¯t¦ NÜCó¡î/qíqÍ/²Ç,IV¼Ô\pÉF÷%q0(HA¥¿ýÛÅ7¦Ü¯õH?¹À~y~BèÆ<¤¸
	Hi[Õ|Ø+×(ìâI~âÆõn<¹^è¯û8â¤ì%¸É¾wÃúu¤X7?ö ,ý%v­)¬ðÈ£?í;ýK¦´µSßè.ïNy~»}H-Ý+4­ßþ\)Dâ%ÔxHae_HA]üÜOãyJÊGÊèâÃk¾RHbmÌûâõó´qaìô§À)V¬zùàÕ4ªs~î§é{éòn~k¼÷£¼Ê±Ï-Ï}~âÍÆ¹¾%yH-	y¡v)9æ`N<iÐÓap£AïñÌY9+sàÙõý¼PÝ(¿S¡o¾9_ìSóy #²ó jìã OVÌñ'{^Ï"z0NìZÿ@Í8¯ñÊÙqìywægcé­i§|äFùÈ!Û	ïÔ?rÐy
ðª§'<êÉÑ¶<Ô i@E7¸ñÆ),q5`¦txvâñQÀõJ@L £ßTäß/<e ÈqESÄta6ð!ÜÆÍw6ñJûÍ©ÈáÑ£h=À<Ð¦¢1çW çW=ÌqÓ|d`AÈ«K_ÈÈè¡£âEûCÆÕn~ÄSä£	)ýí×HÚ2&6E¢¨(qâ©óM¼XLûÁøBYî ¸1cÌ £hý(Zæ-/í³k¼&ìæãQ©É
¬¦f ÃaÈpdO_.H2f8À&ý ©7io»É,ù ë+ó!Û5öúp\?~&Á
*ð9ù=dDr ÈxëÝ¿&Óaeòýìëwýè ò2£g¸ËÁã	QöØêÍ·IûÀx6A7îÒÞôéPÑÌý¤} #>íMºÎ jpè´G4Ñ1wÝ'Óã­/6+$¼v)yxáù$v\¼NÞ74áüÜ7_wÓ
¸Ò¾Àvè/e°ö¾æ÷Ô×æ³I²ùEëSÓÿ=ß	É9àÂ
Ö'2Ô ?ãã°±ÜyßÿxàûÊx|¾ëex1#lòîùôOç³?Ø+ågÂ£¸³Éæûg>Ôbg<wüúÈ¨$<¿³ilóØ3pí\ÿPëGB¤õ£éöù>*Tê?±±É¶ùç¦DàÂxàhñþ ×B}!?aE±q¡}w4%?èßÁ7¯×Q/þ¢?vVÀ¡û~;þ¸·S O6Ù|wpxÞèøhûíøýPÏÏ~_
c^ã»ÓþÁ×zñK §}6u\xð|ñ«BûA>ÄØËxò_¬8+:¯òN\u>ÙRÇxê|7æ¯À=^þ¦þØoÅyh=ÔwEÂýíï×Î§èðû¯F{Aþ#YT±b<òWÉËógÇÍñHÉx<¤ýèHý~IùÈW´ß@¾Ïý")Ô/:*þÝq+.þ\ÔW ÁûGEVÈÀx´I{Ë|B?* VÇÁÑÑývÄßoðH·>ðè'{Â/øÈîèxÈßàQ­ØÅwvÝ~â©ÄõeXÇÏºäÝ?°ó=úóæ;Hñ[? ÖDl!¾_yàË_:qÿáO>Jì`÷ó³²;*6çu^¶Ñ¸4 hÀö¬§ÿÜ`è¿%½å!~LÊKÌóÝØ&åágØç·4?x0ß.û°ý¨F}L/õ1ôèíÄªoñþxÐ~Íf½m]¿
vâÖìâ>r}õ¿ã­ä¡Ñø¸â5ðý"þøy«]|ÕûÖ&ý¯ãÝÆl ÊóÇüuòàz~k¼¬Ý?Ò Vü1ÄgÙ3âó¬¿ê¾a<ýÏøÎï§?b½dû7r7®üÑU=zûóûµÒ?øÏ¯óD<ä#ÿÁÜoÕ£·ý½Øíý­/$|ô·ý£,~ñMöüóâl²Çý#ÍOû©óâw6ð,ãâ°úUª_¸2ÞZÜ/ZÀj¸ÚþQ×ðvñù¯:æi>iNì¬mÿ­ûÁdd»çz\ùðÍwþhÃûçx`ÖÈò_¾äUúÿJ<þüròËÍ§þ6ÄCÓ÷îõÏøtêçy°^@øøÃÿÿïïß¿ÿÅhC4      
   [
  x½\Írã8>»Â=¦ þ³Çª©9ìlUÚQí¸mä¤7o³×¹ïô-IË,/«r1>JAÄG@y`*dóÚ¾¼þ¬?6§æ©éÏ][6ÙÖßº]³ÙÕOµ§öá¹Û^ÄÛÇíom×ìÎíñ°ýý×__uõ¾ÙÚ×lÿøqúõ¿s¿}Øþcxöëömßlýwûoû´}ÖUCOZtMß>5s[ï'ðxhöÑôWAà8íß·?Ä`ÊKWy^éºåyÁuÎtíK5¸Äàrs.Ðx +90ôÀÊ1×©FÕ(j0³ª¥E®?éf÷±Û»G;Ûê¼9wõîÏ	}>Ï«eûr¨ÏÍÓ\ßÙ7»ãá©î>&¨o^ºæÅ7©aå¶óõþÏÍ÷ãùug`¹:P'­Ô-Óa¶ßÕ[÷\Û¾Nõûh´ Úñ´+ÂÚ·v 4v,·N°Ý8ðGýþÔØ$4	¾	ØßxK"ÞT¥:,büÞ|\Å<b¤ 4ÜKGÒÍ÷Ö¯åÙHÒ> FÎéÁ¢Wñ4ºsÓYv"_BjkébIRi­¹úÎµÖ­Sµu`ðÎ#S#ÛË·j8P<¡î3igÕì@ñ £8ü@PÄn]ºj½sÄ8p9('WsfÔ?çc÷í½ymÝªuË³µ¬ívj82½8Ú ÎÝq¿o>¾ý´oÎÝ¶¶ÃMC#mhò6ÞmZVÆíIZ+¼;´`çÅªCCk-»¿Ö²ðZË¢­µL]k)rÈtm·ºnÑÌà@sà=Û&!s¬k×ba»ÅÂksôQiüÈB5úTULÔRµO%@ªjUUcJÜjeEÖv9+Ê´¶ËK2+J´¶ËØ¯ª
MBê [ÝcæQH§5A8ì÷ÀB«Ò¨{ÇÍD=·<wßBl<igt¶ª0êå±;£2ë"2*>®ª\'ò[Lm¨¤ÇÍuà±}ýÑttü½òÑxé(«t÷tØ\)÷;Rº¥v«T,KêAë±Ålgz¼ê±esëõn×ôýæÔtvêÛ÷fDÂ÷ o.±-Þ9vØ²9pëTºujôEã°íH½(öØâîÌËÄ8ÌêoÔÉNcm©óÏåtç¾oÏv-^nÚn¡Ëuü¼s·83".Á¼(ÊNÚÉR *#SË¥F`©8R¶%`[¶¥Õm;,L==ë1¡)Ûf:;m+ÉBËmÓÉïv×åÃ»½}ïà²úû²#úv|~~¢üÈþ-¦ÌKõL¨§Ï®ÃOö3þI'à¬IäY¬R\- ûÃ^´XâýkÝ5ß¾¿õ®ÙµþÆ7ÅIGUI©oI	|¦G¢EYõI	¼¦^SÉ,åd`¦J9SE¾ÌFyúBÎD.ê"bÎ³æ,Â)2¶÷^P%z:ÄcËÞr`ö\=O§ûr&zªÅc³s{xùÖñ¥ÀÙri =»P%úõ¼Ç¯ÊrµÀÁú/ZÕ± ãI&+Æ 'Ô&Ô&Ñs}[6×¯=&I¥¤Ó¸f#JÜ¤ö·=_oô+Ò@Gq{
üS¤¸«yÛFgïæ<¢ËÀ¥ÃÚÃnßZ;rù·Q&^æ(s®Ì&$«]³`¥84i¯´§À(.ÛDW8L,µRvheÁÅ9¦ê æU2l'*ï0¡p V·SÖêS<)ÜæéÚ¨kßíìâIëî½ÝMòaðW÷°k'ûf<Å9ÖÊ88!ÝoiõÛ¦tèø=I¿'õR'wÂI~îµ0p,Sé»¾©´R.E×ÑùíphöïoíþÉc§ºïëfÀÇPðj<'ZîN¶Ü1 °¹ù¶j&;¾N}ª®³RR¶¨ÃÞâD¼¥"ÕÍñt:öí°À8dfuÆ9\rAF²BS ÛÒöE¤o¸\Ïèë434@$&×l\ùa¤Ðò;+B:JY½ ìêYø¢ÒÌèfÀÇ³»wSí®ÒµXÞUÉ>ð ÑÀ%äfõr­q`ÖÊ¬Þ¹%¯¬xõ¢(Á²Qk¹=é q=-þ­T÷4Ö¶ï) ðÛXÔß jn$7IÃ áfõ
q`&rd´lÕH¶j 4D@"Í¿îújc[{5â+éXR¡F¦BAõÉµüh±«)S6	R.ÖÍ,m9£íàK-#!ênÖ/¢±#DÂ¸BË&WZèÆ1 Eü¹H·[æ2Lé0?¨Ãæ×Ê,©ú÷ßQ.µËp4ü%?â"ü1D[}'áõ¿«¥©£a×ýéµÞ^Ãæµj¼þ¶CG1±dLÒl,Ólà³¥J~µTÍ?%Zø T»Y!`}ò7ÁcáÂNÁÇ'[*ÈKòÀ°dà
æ@w·âõ×aBAÞeÞS
$î8ÕîÊrã?)w,ó]jA5 ePíDqBá;Ë,ªOUNi ¤g©âõKN2Ú	KâÀë×!åºu¨Ð9Î·Â¢0 (,)
¯_1:1 >,ó_LÛÉÄÉYf²Ì8Ù2âd>{<o¤j+ë3B/ÅRzÍ&ËdInAU¤@a¦Ã^ºÏ¬¤Y:éí°Û[ºÕ>·á$YÉH Ld"Å*S$@ÚHæ²¨µPÕ8P©ÑIj¡¼XÔBQ©fúI'(N¤RWHf¨k7¿mËrW${H&{'É¬$kp¢8! ~â°8XAº÷Ï|×EúW	¾£àçpèI:F³tÓÂ¹em#e`J3¹I:VººÝ?îl[Ë©o0õU©hÎ7m£ø¾#q!H¡hyÕ$«)iÆ-oÄ ß#É÷HÿOÎEsÑçr.0ér¤\r«p ï#Éû°1l@ÎdÎÖ¯L´Èô/ðhõ/ð®GÍ,;t»¬Äÿ.´"`aÉ0Ynò!4}B6d¼ès¿ u(
	RVzüí±aXúrÍ[ÿëë/_þàjD      
   Æ  xØÙÝ0CÑï7Q8qu7©'Gà0þªP¸èäwÆóO|*r~GgüÊø©ý3÷g}þ}þþù:ÏX¢fï¾ÐØÏÞiMMkò½Ð<Ô¬Çc_OX³ü­ùìÇ>×bÎÍçé±ÏáµÃ{c´ß3Úë5æÅ{¦×bL¯Å7~<cx½F^xÎÏiÏõú?­ÿ½ÖÅ·ç§òBÖäöÞÈí9Ìíqå¾ð³.ü¬?óÿE¦×4Ó{#Ãûù$4Ý¯^s$oQÆÝýøCÑËÍÞoÑË3´%ú)íÞ÷Ðîæo×«iwµßòhßõâ¯ÒËó2mwz^fqvgèGb/#*Ûe£:Ûeþíö=ÃvÃvÃvÙvÝmv7¦ÒØîk»¯í¾¶ûÚîk»lÖGb/<½°aí²í²ô`9Û5wÏÅ½ÝÛÛµ½ÝÚÛ¥½ãsÛua»Î£á<Î£á<Î#eÚ'öAæH</Ná$á(ÇD9&Ê1QrLc¢eÀ×ãðeÀ_|ðeÀé]¦wÞezûß>ÆwðeÀ_FsÍe4Ñ\æn»eî¹[.ùe4Ñ\F³¯tºær/£ÙWGFsÍi4§¡jº{§¹ænº{§¹æ®¯îÄ^Ì]ßíµ¯öÚ·víK»#ñÕ41Ó8]ÓÜMs7ÍÝtßMs7ÍÝ4wÓ+i¨¦¡jªé2jªi¨¡jªá¾î»a4ÑFsøZ$Lïp%£9ÌÝ0wÃÜs7ÌÝp%Wâ0½Ãô£9ÜwÃôÓ;Lï0ÃhWâ0½ÃôÓ;Lïpk·æ0àÃô£9æ ß&1oùûûëëë?{Us     
