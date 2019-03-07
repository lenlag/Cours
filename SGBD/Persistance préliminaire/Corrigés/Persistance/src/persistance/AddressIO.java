package persistance;

import java.util.ArrayList;
import java.util.List;

import filemanager.FileManager;
import objets.Address;

/**
 * IO class associated to Address class
 * 
 * @author 1802448
 *
 */
public class AddressIO implements IIO {
	private Address bean;
	
	public AddressIO(Address bean) {
		super();
		this.bean = bean;
	}

	@Override
	public List<String> toFile() {
		List<String> list = new ArrayList<>();
		list.add(bean.getAddress());
		list.add(bean.getZipCode());
		list.add(bean.getCity());
		
		return list;
	}

	@Override
	public void fromFile(List<String> list) {
		bean.setAddress(list.get(0));
		bean.setZipCode(list.get(1));
		bean.setCity(list.get(2));
	}

	@Override
	public IPersistance getBean() {
		return bean;
	}

	@Override
	public void save() throws Exception {
		FileManager.getInstance().save(this);
	}

	@Override
	public void load() throws Exception {
		FileManager.getInstance().load(this);
	}
	
	
}
