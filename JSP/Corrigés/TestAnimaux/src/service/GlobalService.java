package service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import business.entity.Animal;
import business.entity.Person;
import business.entity.User;
import persistence.dao.PersonDAO;
import persistence.dao.PwdChecker;
import persistence.exception.DaoException;
import pwd.Encoder;

public class GlobalService {
	private static final String USER_KEY = "__USER";
	
	private PersonDAO personDao = new PersonDAO();
	private PwdChecker pw = new PwdChecker();
	
	public List<Person> listPersons() throws DaoException {
		return personDao.findList();
	}
	public List<Animal> listAnimauxByPersonId(long id) throws Exception {
		Person p = personDao.findById(id);
		if (p == null) {
			return new ArrayList<>();
		}
		return p.getList();
	}
	public Person getPersonById(long id) throws Exception {
		return personDao.findById(id);
	}
	public Person create(Person p) throws Exception {
		return personDao.create(p);
	}
	public Person update(Person p) throws Exception {
		return personDao.updateById(p);
	}
	public void delete(long id) throws Exception {
		personDao.deleteById(id);
	}
	public boolean checkPwd(HttpSession session,String login, String pwd) throws Exception {
		User user = pw.checkPwd(login, Encoder.getInstance().sha256Encoder(pwd));
		if (user == null) {
			return false;
		}
		session.setAttribute(USER_KEY, user);
		return true;
	}
	public User getUser(HttpSession session) {
		return (User)session.getAttribute(USER_KEY);
	}
	public boolean isAdmin(HttpSession session) {
		User user = getUser(session);
		if (user == null) {
			return false;
		}
		return user.isAdmin();
	}
	public void clearUser(HttpSession session) {
		session.removeAttribute(USER_KEY);
	}
}
