package persistance;

/**
 * Interface for the object used in this test programm
 * 
 * It means that objets must have an id
 * 
 * @author 1802448
 *
 */
public interface IPersistance {
	/**
	 * Return the id of the class
	 * 
	 * @return the id
	 */
	public String getId();
	/**
	 * Set the id of the class
	 * 
	 * @param id id to be set
	 */
	public void setId(String id);
}
