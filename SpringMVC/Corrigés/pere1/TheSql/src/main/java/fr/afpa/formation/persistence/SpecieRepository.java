package fr.afpa.formation.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


public interface SpecieRepository extends CrudRepository<Specie, Long> {
	@Query("SELECT s FROM Specie s WHERE s.latinName LIKE :name% OR s.commonName LIKE :name%")
	List<Specie> findByBeginName (@Param("name") String name); 
}
