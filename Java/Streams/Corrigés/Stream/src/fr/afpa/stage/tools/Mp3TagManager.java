package fr.afpa.stage.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
/**
 * 
 * @author 1802448
 *
 * Allow to manage mp3 file tags
 * See mp3 specifications at : http://mpgedit.org/mpgedit/mpeg_format/mpeghdr.htm
 */
public class Mp3TagManager {
	private static final String TAG_VALUE="TAG";
	
	/**
	 * File to mp3 file
	 */
	private File file;
	/**
	 * Title tag
	 */
	private String title;
	/**
	 * Author tag
	 */
	private String author;
	/**
	 * Album tag
	 */
	private String album;
	/**
	 * Year tag
	 */
	private String year;
	/**
	 * Comment tag
	 */
	private String comment;
	/**
	 * Style tag
	 */
	private int style;
	/**
	 * Private buffer used to manage tag zone
	 */
	private byte[] bs = new byte[Mp3Lengths.TAG_ZONE_SIZE.getValue()];
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getStyle() {
		return style;
	}
	public void setStyle(int style) {
		this.style = style;
	}
	
	/**
	 * Constructor with File to mp3 file
	 * 
	 * @param file : path to the mp3 file
	 * @loadOnstart: read mp3 file in constructor if true
	 * @throws IOException
	 * @throws Mp3TagException
	 */
	public Mp3TagManager(File file,boolean loadOnStart) throws IOException,Mp3TagException {
		this.file = file;
		if (loadOnStart) {
			readTags();
		}
	}

	/**
	 * Constructor with File to mp3 file. Automatically load the file in constructor
	 * 
	 * @param file : path to the mp3 file
	 * @throws IOException
	 * @throws Mp3TagException
	 */
	public Mp3TagManager(File file) throws IOException,Mp3TagException {
		this(file,true);
	}
	
	/**
	 * Constructor with String to the mp3 file
	 *  
	 * @param file : path to the mp3 file
	 * @loadOnstart: read mp3 file in constructor if true
	 * @throws IOException
	 * @throws Mp3TagException
	 */
	public Mp3TagManager(String file,boolean loadOnStart) throws IOException,Mp3TagException { 
		this(new File(file),loadOnStart);
	}
	
	/**
	 * Constructor with String to the mp3 file. Automatically load the file in constructor
	 * @param file : path to the mp3 file
	 * @throws IOException
	 * @throws Mp3TagException
	 */
	public Mp3TagManager(String file) throws IOException,Mp3TagException { 
		this(file,true);
	}
	
	@Override
	public String toString() {
		return "Mp3TagManager [title=" + title + ", author=" + author + ", album=" + album + ", year=" + year
				+ ", comment=" + comment + ", style=" + style + "]";
	}
	
	/**
	 * Read tags from mp3 file
	 * 
	 * @throws IOException
	 * @throws Mp3TagException
	 */
	public void readTags() throws IOException,Mp3TagException {
		FileInputStream fis = null;
		long size = file.length();
		try {
			fis = new FileInputStream(file);
			fis.skip(size-Mp3Lengths.TAG_ZONE_SIZE.getValue());
			fis.read(bs);
			if (!new String(bs,0,Mp3Lengths.TAG_LEN.getValue()).equals(TAG_VALUE)) {
				throw new Mp3TagException("No Tag zone found");
			}
			int offset = Mp3Lengths.TAG_LEN.getValue();
			title = new String(bs,offset,Mp3Lengths.TITLE_LEN.getValue()).trim();
			offset += Mp3Lengths.TITLE_LEN.getValue();
			author = new String(bs,offset,Mp3Lengths.AUTHOR_LEN.getValue()).trim();
			offset += Mp3Lengths.AUTHOR_LEN.getValue();
			album = new String(bs,offset,Mp3Lengths.ALBUM_LEN.getValue()).trim();
			offset += Mp3Lengths.ALBUM_LEN.getValue();
			year = new String(bs,offset,Mp3Lengths.YEAR_LEN.getValue()).trim();
			offset += Mp3Lengths.YEAR_LEN.getValue();
			comment = new String(bs,offset,Mp3Lengths.COMMENT_LEN.getValue()).trim();
			offset += Mp3Lengths.COMMENT_LEN.getValue();
			style = (int)bs[offset];
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (fis != null) {
				fis.close();
			}
		}
	}
	
	/**
	 * Limit the tag to its max len and pad (if needed) with whitespaces
	 * 
	 * @param tag : the tag itself
	 * @param len : max len of the tag
	 * @return padded (and limited) tag
	 */
	private String padAndLimit(String tag,int len) {
		if (tag.length() > len) {
			tag = tag.substring(0, len-1);
		}
		for (int i = tag.length() ; i < len ; i++) {
			tag += " ";
		}
		
		return tag;
	}
	
	/**
	 * Write tags into the mp3 file
	 * 
	 * @throws IOException
	 */
	public void writeTags() throws IOException {
		RandomAccessFile fos = null;
		long size = file.length();
		try {
			fos = new RandomAccessFile(file,"rw");
			fos.seek(size-Mp3Lengths.TAG_ZONE_SIZE.getValue());
			// rewrite or write if not exists
			fos.write(TAG_VALUE.getBytes(),0,Mp3Lengths.TAG_LEN.getValue());
			// get padded tags
			String _title = padAndLimit(title,Mp3Lengths.TITLE_LEN.getValue());
			String _author = padAndLimit(author, Mp3Lengths.AUTHOR_LEN.getValue());
			String _album = padAndLimit(album,Mp3Lengths.ALBUM_LEN.getValue());
			String _comment = padAndLimit(comment,Mp3Lengths.COMMENT_LEN.getValue());
			fos.write(_title.getBytes());
			fos.write(_author.getBytes());
			fos.write(_album.getBytes());
			fos.write(year.getBytes());
			fos.write(_comment.getBytes());
			fos.write(style);
		} catch (IOException ex) {
			throw ex;
		} finally {
			if (fos != null) {
				fos.close();
			}
		}
	}
}
