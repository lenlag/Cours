package fr.afpa.formation;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import fr.afpa.formation.persistence.Specie;

public class SpecieValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
        return Specie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Specie sp = (Specie)target;
		if (sp.getLatinName() == null || sp.getLatinName().isEmpty()) {
			errors.rejectValue("latinName", "required","required");
		}
		if (sp.getCommonName() == null || sp.getCommonName().isEmpty()) {
			errors.rejectValue("commonName", "required","required");
		}
	}

}
