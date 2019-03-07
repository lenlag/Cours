package main.xml;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.helpers.DefaultHandler;

public class SaxParser {

	public static void main(String[] args) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		
		List<SalaryMan> sls = new ArrayList<>();
		DefaultHandler handler = new MyHandler(sls);
		saxParser.parse("files/test.xml", handler);
		
		// Affichage
		
		for (SalaryMan sm:sls) {
			System.out.println(sm);
		}
	}

}
