package persistance;

import java.util.List;

/**
 * Interface for IObjects
 * @author 1802448
 *
 */
public interface IIO {
	/**
	 * Transform the fields of the associated class into a List to be saved in a file
	 *  
	 * @return List of values of fields
	 */
	public List<String> toFile();
	/**
	 * Get a list of values from file to be set to fields of the associated class
	 * 
	 * @param list List of values
	 */
	public void fromFile(List<String> list);
	/**
	 * Return the associated class
	 * 
	 * @return The associated class
	 */
	public IPersistance getBean();
	/**
	 * Save the associated class using the FileManager
	 * 
	 * @throws Exception
	 */
	public void save() throws Exception;
	/**
	 * Load the associated class using the FileManager
	 * 
	 * @throws Exception
	 */
	public void load() throws Exception;
}
