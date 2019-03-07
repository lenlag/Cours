package facade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class to facade the result of an inserter method (a list generally)
 * 
 * @author 1802448
 *
 */
public class ListFacade {
	/**
	 * The list as the result of a Inserter method
	 */
	private List<String> retMysql;

	/**
	 * Constructor
	 * 
	 * @param retMysql the list to create the ListFacade with
	 */
	public ListFacade(List<String> retMysql) {
		super();
		this.retMysql = retMysql;
	}
	/**
	 * 
	 * @return the list embedded
	 */
	public List<String> getData() {
		return retMysql;
	}
	/**
	 * 
	 * @return the first line of the list as String
	 */
	public String getDataAsString() {
		return (retMysql.size() > 0) ? retMysql.get(0):"";
	}
	/**
	 * 
	 * @return the first line of the list as int (usually as result of a count)
	 */
	public int getDataAsInt() {
		String s = getDataAsString();
		if ((s == null) || (s.length() == 0)) {
			return 0;
		}
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return 0;
		}
	}
	/**
	 * 
	 * @return the result of a select as a map
	 */
	public List<Map<String,String>> getDataAsMapList() {
		if ((retMysql == null) || retMysql.isEmpty()) {
			return null;
		}
		List<String> titres = Arrays.asList(retMysql.get(0).split("\t"));
		List<Map<String,String>> ret = new ArrayList<>();
		for (int i = 1 ; i < retMysql.size(); i++) {
			Map<String,String> map = new HashMap<>();
			List<String> vals = Arrays.asList(retMysql.get(i).split("\t"));
			for (int j = 0 ; j < titres.size() ; j++) {
				map.put(titres.get(j),vals.get(j));
			}
			ret.add(map);
		}
		
		return ret;
	}
}
