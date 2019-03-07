package persistance;

import java.util.ArrayList;
import java.util.List;

import filemanager.FileManager;
import objets.Person;

/**
 * IO class associated to a class Person
 * @author 1802448
 *
 */
public class PersonIO implements IIO {
	private Person bean;
	
	@Override
	public List<String> toFile() {
		List<String> list = new ArrayList<>();
		list.add(bean.getPrenom());
		list.add(bean.getNom());
		list.add(""+bean.getAge());
		
		return list;
	}

	@Override
	public void fromFile(List<String> list) {
		bean.setNom(list.get(1));
		bean.setPrenom(list.get(0));
		String s_age = list.get(2);
		int age = 0;
		try {
			age = Integer.parseInt(s_age);
		} catch (Exception ex) {
			//nada
		}
		bean.setAge(age);
	}

	@Override
	public IPersistance getBean() {
		// TODO Auto-generated method stub
		return bean;
	}
	
	public void save() throws Exception {
		FileManager.getInstance().save(this);
	}

	public void load() throws Exception {
		FileManager.getInstance().load(this);
	}

	public PersonIO(Person bean) {
		super();
		this.bean = bean;
	}
}
