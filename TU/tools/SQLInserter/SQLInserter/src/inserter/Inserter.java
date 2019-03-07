package inserter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import exception.SqlInserterException;
import facade.ListFacade;

/**
 * Class to execute sql script in a file (typically create/drop or select) for Mysql
 * It works using mysql client exec to do the stuff on command line (with input, output and error streams redirected. See javadoc for Process)
 * 
 * @author 1802448
 *
 */
public class Inserter {
	private Properties cfg = null;
	public Inserter(Properties cfg) {
		this.cfg = cfg;
	}
	/**
	 * Execute sql script on the server
	 * 
	 * @param script file
	 * @return A ListFacade if any 
	 * @throws Exception
	 */
	public ListFacade insert(String file) throws SqlInserterException {
		return insert(file,true,false);
	}
	/**
	 * Execute sql script on the server
	 * 
	 * @param file script file
	 * @param relative true if file is in the project as a resource. false otherwise
	 * @param withDb true if the db name must be used on command line
	 * @return A ListFacade if any
	 * @throws Exception
	 */
	private ListFacade insert(String file,boolean relative,boolean withDb) throws SqlInserterException {
		List<String> retMysql = null;
		try {
			File path = null;
			if (relative) {
				path = new File(this.getClass().getClassLoader().getResource(file).toURI());
			} else {
				path = new File(file);
			}
			String exec = "\""+cfg.getProperty("mysql")+"\""+" -u "+cfg.getProperty("user")+" -p"+cfg.getProperty("password");
			if (withDb) {
				exec +=" "+cfg.getProperty("database");
			}
			//System.out.println(exec+" "+path);
			Process p = Runtime.getRuntime().exec(exec);
			writeOutputStream(p, path);
			int ret = p.waitFor();
			if (ret != 0) {
				String err = readErrorStream(p);
				throw new SqlInserterException ("Trouble launching mysql. ret code is "+ret+" err = "+err);
			}
			retMysql = readOutputStream(p);
		} catch (Exception e) {
			throw new SqlInserterException(e);
		}
		return new ListFacade(retMysql);
	}
	/**
	 * Execute a SELECT query (result without the header) 
	 * @see select(String query,boolean removeFirstLine)
	 * @param query query to execute
	 * @return a ListFacade as result of select
	 * @throws SqlInserterException
	 */
	public ListFacade select(String query) throws SqlInserterException {
		return select(query,true);
	}
	/**
	 * Execute a SQL select
	 * @param query query to execute
	 * @param removeFirstLine true if firstLine is removed (usually header)
	 * @return a ListFacade as result of select
	 * @throws SqlInserterException
	 */
	public ListFacade select(String query,boolean removeFirstLine) throws SqlInserterException {
		ListFacade lf =  null;
		File f = null;
		try {
			f = File.createTempFile("xx_","_zz");
			PrintWriter pw = null;
			try {
				pw = new PrintWriter(new FileWriter(f));
				pw.println(query);
			} finally {
				if (pw != null) {
					pw.close();
				}
			}
			lf =  insert(f.getPath(),false,true);
		} catch (Exception e) {
			throw new SqlInserterException(e);
		}
		f.delete();
		if (removeFirstLine) {
			lf.getData().remove(0);
		}
		return lf;
	}
	private void writeOutputStream(Process p,File f) throws SqlInserterException {
		try {
			OutputStream os = p.getOutputStream();
			os.write(("SOURCE "+f.getPath().replace('\\', '/')+";\r\n").getBytes());
			os.write("quit\r\n".getBytes());
			os.close();
		} catch (Exception e) {
			throw new SqlInserterException(e);
		}
	}
	private List<String> readInputStream(InputStream is) throws SqlInserterException {
		List<String> list = new ArrayList<String>();
		BufferedReader br = null; 
		try {
			br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while(true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				line = line.trim();
				list.add(line);
			}
		} catch (Exception e) {
			throw new SqlInserterException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception ex) {
					throw new SqlInserterException(ex);
				}
			}
		}
		return list;
	}
	private String readErrorStream(Process p) throws SqlInserterException {
		List<String> list = null;
		list = readInputStream(p.getErrorStream());
		return (list.size() > 0) ? list.get(0):"";
	}
	private List<String> readOutputStream(Process p) throws SqlInserterException {
		return readInputStream(p.getInputStream());
	}
	public static void main(String[] args) throws Exception {
		Properties cfg = new Properties();
		cfg.setProperty("user", "root");
		cfg.setProperty("password", "root");
		cfg.setProperty("database", "bestioles");
		cfg.setProperty("mysql", "C:/data/mysql-5.5.61-winx64/bin/mysql.exe");
		Inserter inserter = new Inserter(cfg);
		ListFacade lf = inserter.select("Select * from specie", false);
		List<Map<String,String>> list = lf.getDataAsMapList();
		for (Map<String, String> map : list) {
			for (String key:map.keySet()) {
				System.out.println(key +" = "+map.get(key));
			}
		}
	}
}
