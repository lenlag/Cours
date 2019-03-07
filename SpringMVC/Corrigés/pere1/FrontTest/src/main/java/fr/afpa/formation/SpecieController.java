/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package fr.afpa.formation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import fr.afpa.formation.business.ServiceSpecie;
import fr.afpa.formation.persistence.Specie;

@Controller
class SpecieController {
	
    @Autowired
    private ServiceSpecie service;

    @InitBinder("specie")
    public void initSpecieBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new SpecieValidator());
    }
    
    @GetMapping("/")
    public String initCreationForm(Model model) {
    	List<Specie> list = service.list();
        model.addAttribute("species", list);
        return "debut";
    }
    @GetMapping("/specie")
    public String debut(Model model) {
    	return initCreationForm(model);
    }
    @GetMapping("/specie/{id}/delete")
    public String delete(@PathVariable("id") long id) {
    	service.deleteById(id);
        return "redirect:/specie";
    }
    @GetMapping("/specie/create")
    public String initCreate(Model model) {
    	Specie sp = new Specie();
    	sp.setCommonName("");
    	sp.setLatinName("");
    	sp.setId(0L);
    	return fillCreateOrUpdate(model, sp);
    }
    @GetMapping("/specie/{id}/update")
    public String initUpdate(@PathVariable("id") long id,Model model) {
    	Specie sp = service.findById(id);
    	return fillCreateOrUpdate(model, sp);
    }
    private String fillCreateOrUpdate(Model model,Specie sp) {
    	model.addAttribute("specie", sp);
    	return "create";
    }
    @PostMapping("/specie/create")
    public String doCreate(@Valid Specie sp, BindingResult result,Model model) {
    	if (result.hasErrors()) {
        	model.addAttribute("specie", sp);
    		return "create";
    	}
    	service.save(sp);
        return "redirect:/specie";
    }
    @GetMapping("/oups")
    public void doError() throws Exception {
    	throw new Exception("Exception pour tester");
    }
}
