package meta;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import persistence.manager.JDBCManager;

public class MetaInspector {
	public static final int CATALOG_NAME=1;
	public static final int TABLE_NAME=3;
	public static final int COL_NAME=4;
	public static final int COL_TYPE=6;
	public static final int COL_LEN=7;
	public static final String SUB_SEP=".";
	public static final int SUB_MAX_SEP=2;
	
	private Map<String,Map<String,List<ColumnInfo>>> metaMap;
	
	private List<ColumnInfo> cloneList(List<ColumnInfo> list) throws Exception {
		List<ColumnInfo> ret = new ArrayList<>();
		for (ColumnInfo o:list) {
			ret.add(o.clone());
		}
		return ret;
	}
	private Map<String,?> cloneMap(Map<String,?> map) throws Exception {
		Map<String,Object> ret = new HashMap<>();
		for (String key:map.keySet()) {
			Object o = map.get(key);
			if (o instanceof Map<?, ?>) {
				//log("instance map");
				@SuppressWarnings("unchecked")
				Map<String,?> sub = cloneMap((Map<String,?>)o);
				ret.put(key, sub);
			} else if (o instanceof List<?> ) {
				//log("instance list");
				@SuppressWarnings("unchecked")
				List<ColumnInfo> l = cloneList((List<ColumnInfo>)o);
				ret.put(key, l);
			} else {
				throw new Exception("Object to clone different of map or List");
			}
		}
		return ret;
	}
	public Map<String,Map<String,List<ColumnInfo>>> getSubTable(String sub) throws Exception {
		// because . is a reserved char in regex
		String[] a = sub.split("\\"+SUB_SEP);
		if (a.length > SUB_MAX_SEP) {
			throw new Exception("Too many separators");
		}
		if (a.length == 0) {
			a = new String[1];
			a[0] = sub;
		}
		Map<String,Map<String,List<ColumnInfo>>> map = new HashMap<>();
		@SuppressWarnings("unchecked")
		Map<String,List<ColumnInfo>> subMap = (Map<String,List<ColumnInfo>>)cloneMap(metaMap.get(a[0]));
		map.put(a[0],subMap);
		if (a.length == 2) {
			Map<String,List<ColumnInfo>> subMap2 = new HashMap<>();
			List<ColumnInfo> l = cloneList(subMap.get(a[1]));
			subMap2.put(a[1],l);
			map.put(a[0], subMap2);
		}
		
		return map;
	}
	public static void display(Map<String,Map<String,List<ColumnInfo>>> map) {
		for (String db:map.keySet()) {
			log(db);
			Map<String,List<ColumnInfo>> sub = map.get(db);
			for (String table:sub.keySet()) {
				log("----"+table);
				List<ColumnInfo> list = sub.get(table);
				for (ColumnInfo ci:list) {
					log("--------"+ci.getName()+" "+ci.getType()+"("+ci.getLength()+")");
				}
			}
		}
	}
	public void parse() throws Exception {
		Connection cnx = null;
		try {
			cnx = JDBCManager.getInstance().getConnection();
			Map<String,Map<String,List<ColumnInfo>>> map = new HashMap<>();

			DatabaseMetaData dmd = cnx.getMetaData();
			ResultSet rs = dmd.getCatalogs();
			while(rs.next()) {
				String dbName = rs.getString(CATALOG_NAME);
				Map<String,List<ColumnInfo>> subMap = new HashMap<>();
				map.put(dbName, subMap);
				ResultSet rs2 = dmd.getTables(dbName, null, null, null);
				while(rs2.next()) {
					String tableName = rs2.getString(TABLE_NAME);
					List<ColumnInfo> colList = new ArrayList<>(); 
					subMap.put(tableName, colList);
					ResultSet rs3 = dmd.getColumns(dbName, null, tableName, null);
					while(rs3.next()) {
						colList.add(new ColumnInfo(rs3.getString(COL_NAME),rs3.getString(COL_TYPE),rs3.getString(COL_LEN)));
					}
				}
			}
			metaMap = map;
		} finally {
			JDBCManager.getInstance().close();
		}
	}
	
	public Map<String, Map<String, List<ColumnInfo>>> getMetaMap() {
		return metaMap;
	}

	public static void log(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) throws Exception {
		MetaInspector mi = new MetaInspector();
		mi.parse();
		Map<String,Map<String,List<ColumnInfo>>> map = mi.getMetaMap();
		MetaInspector.display(map);
		log("------ pour la db bestioles ");
		MetaInspector.display(mi.getSubTable("bestioles"));
		log("------ pour la table bestioles.specie ");
		MetaInspector.display(mi.getSubTable("bestioles.specie"));
	}
}
