package main.cfg;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestCfg {
	private final static String FILE_PATH="files/cfg.ini";
	// in fact we have to use the same file, but for pedagogic purpose, we use different ones
	private final static String FILE_PATH_OUT="files/cfg.ini.save";
	
	private String charset;
	private String windowColor;
	private String defaultFontName;
	private int timer;
	
	public void loadCfg () throws IOException,MyException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(FILE_PATH);
			Properties p = new Properties();
			p.load(fis);
			charset = p.getProperty("charset");
			windowColor = p.getProperty("windowColor");
			defaultFontName = p.getProperty("defaultFontName");
			timer = Integer.parseInt(p.getProperty("timer"));
		} catch (IOException e) {
			throw e;
		} catch (Exception ex) {
			throw new MyException("Pb d'entier");
		} finally {
			if (fis != null ) {
				fis.close();
			}
		}
	}
	public void saveCfg () throws IOException {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(FILE_PATH_OUT);
			Properties p = new Properties();
			p.setProperty("charset", charset);
			p.setProperty("windowColor", windowColor);
			p.setProperty("defaultFontName", defaultFontName);
			p.setProperty("timer", ""+timer);
			p.store(fos, "This is a comment");
			
		} catch (IOException e) {
			throw e;
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
	public TestCfg() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCharset() {
		return charset;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public String getWindowColor() {
		return windowColor;
	}

	public void setWindowColor(String windowColor) {
		this.windowColor = windowColor;
	}

	public String getDefaultFontName() {
		return defaultFontName;
	}

	public void setDefaultFontName(String defaultFontName) {
		this.defaultFontName = defaultFontName;
	}

	public int getTimer() {
		return timer;
	}

	public void setTimer(int timer) {
		this.timer = timer;
	}

	@Override
	public String toString() {
		return "TestCfg [charset=" + charset + ", windowColor=" + windowColor + ", defaultFontName=" + defaultFontName
				+ ", timer=" + timer + "]";
	}

	public static void main(String[] args) throws IOException,MyException {
		TestCfg tc = new TestCfg();
		tc.loadCfg();
		System.out.println(tc.toString());
		tc.setWindowColor("yellow");
		tc.saveCfg();
	}


}
