package main.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class DomParser {

	public static void main(String[] args) throws Exception {
		List<SalaryMan> sls = new ArrayList<>();
		File fXmlFile = new File("files/test.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		NodeList nl = doc.getElementsByTagName("staff");
		if ((nl != null) && (nl.getLength() != 0)) {
			for (int i = 0 ; i < nl.getLength() ; i++) {
				Element e = (Element)nl.item(i);
				String tmp = e.getAttribute("id");
				int id = Integer.parseInt(tmp);
				String firstName =e.getElementsByTagName("firstname").item(0).getTextContent();
				String lastName =e.getElementsByTagName("lastname").item(0).getTextContent();
				String nickName =e.getElementsByTagName("nickname").item(0).getTextContent();
				tmp =e.getElementsByTagName("salary").item(0).getTextContent();
				int salary = Integer.parseInt(tmp);
				SalaryMan sm = new SalaryMan(firstName, lastName, nickName, id, salary);
				sls.add(sm);
			}
		}
		
		// Affichage
		
		for (SalaryMan sm:sls) {
			System.out.println(sm);
		}
	}

}
