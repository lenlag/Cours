package fr.afpa.formation.business;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afpa.formation.persistence.Specie;
import fr.afpa.formation.persistence.SpecieRepository;

@Service
@Transactional
public class ServiceSpecie {

	@Autowired
	SpecieRepository srepo;
	
	public List<Specie> list() {
		Iterable<Specie> it = srepo.findAll();
		return (List<Specie>)it;
	}
	public List<Specie> listBeginName(String name) {
		return srepo.findByBeginName(name);
	}
	public void deleteById(long id) {
		srepo.deleteById(id);
	}
	public void save(Specie sp) {
		srepo.save(sp);
	}
	public Specie findById(long id) {
		return srepo.findById(id).get();
	}
}
