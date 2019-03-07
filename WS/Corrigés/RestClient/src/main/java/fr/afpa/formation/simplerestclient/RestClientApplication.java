package fr.afpa.formation.simplerestclient;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import fr.afpa.formation.persistence.Specie;

public class RestClientApplication  {
	
	static final String BASE_URL = "http://localhost:8080/rest/species";
	
	private long current_id = 0L;
	
	public void listAsString() {
		RestTemplate rt = new RestTemplate();
		String result = rt.getForObject(BASE_URL, String.class);
		System.out.println("String = "+result);
		System.out.println();
	}
	public void list() {
		RestTemplate rt = new RestTemplate();
		Specie[] sps = rt.getForObject(BASE_URL, Specie[].class);
		for (Specie sp : sps) {
			System.out.println("Specie = "+sp.toString());
		}
		System.out.println();
	}
	public void listAsMap() {
		RestTemplate rt = new RestTemplate();
		Map<?, ?>[]maps  = rt.getForObject(BASE_URL, Map[].class);
		for (Map<?,?> map : maps) {
			for (Object key:map.keySet()) {
				System.out.print(key.toString()+" = "+map.get(key).toString()+", ");
			}
			System.out.println();
		}
		System.out.println();
	}
	public void post() {
		RestTemplate rt = new RestTemplate();
		Specie sp = new Specie();
		sp.setCommonName("COMMON");
		sp.setLatinName("LATIN");
		
		HttpHeaders head = new HttpHeaders();
		head.add("Accept", MediaType.APPLICATION_JSON_VALUE);
		head.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Specie> body = new HttpEntity<>(sp,head);
		long id = rt.postForObject(BASE_URL, body, Long.class);
		
		System.out.println("id = "+id);
		System.out.println();
		current_id = id;
	}
	public void delete() {
		RestTemplate rt = new RestTemplate();
		rt.delete(BASE_URL+"/"+current_id);
	}
	public static void main(String[] args) {
		RestClientApplication rca = new RestClientApplication();
		rca.listAsString();
		rca.list();
		rca.listAsMap();
		rca.post();
		rca.list();
		rca.delete();
		rca.list();
	}
}
