package main.xml;

import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler {
	private boolean bstaff = false;
	private boolean bfirst = false;
	private boolean blast = false;
	private boolean bnick = false;
	private boolean bsalary = false;
	private boolean bid = false;
	private SalaryMan sm = null;
	List<SalaryMan> sls = null;
	
	public  MyHandler(List<SalaryMan> sls) {
		this.sls = sls;
	}
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		if (length > 0) {
			String tmp = new String(ch,start,length);
			if (bfirst) {
				sm.setFirstName(tmp);
			} else if (blast) {
				sm.setLastName(tmp);
			} else if (bnick) {
				sm.setNickName(tmp);
			} else if (bsalary) {
				try {
					sm.setSalary(Integer.parseInt(tmp));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		super.endElement(uri, localName, qName);
		if (qName.equals(SaxEnum.staff.toString())) {
			sls.add(sm);
			sm = null;
			bstaff = false;
		} else if (qName.equals(SaxEnum.firstname.toString())) {
			bfirst = false;
		} else if (qName.equals(SaxEnum.lastname.toString())) {
			blast = false;
		} else if (qName.equals(SaxEnum.nickname.toString())) {
			bnick = false;
		} else if (qName.equals(SaxEnum.salary.toString())) {
			bsalary = false;
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if (qName.equals(SaxEnum.staff.toString())) {
			bstaff = true;
			sm = new SalaryMan();
			String tmp = attributes.getValue(SaxEnum.id.toString());
			try {
				sm.setId(Integer.parseInt(tmp));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} else if (qName.equals(SaxEnum.firstname.toString())) {
			bfirst = true;
		} else if (qName.equals(SaxEnum.lastname.toString())) {
			blast = true;
		} else if (qName.equals(SaxEnum.nickname.toString())) {
			bnick = true;
		} else if (qName.equals(SaxEnum.salary.toString())) {
			bsalary = true;
		}
	}

}
