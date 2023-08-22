package com.techelevator.controller;

import com.techelevator.dao.AdopterDao;
import com.techelevator.model.Adopter;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AdopterController {

    @Autowired
    AdopterDao adopterDao;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/adopter/submit-form")
    public void createAdopter(@RequestBody Adopter adopter) {
        adopterDao.createAdopter(adopter.getAnimalId(), adopter.getAdopterFirstName(), adopter.getAdopterLastName(), adopter.getEmail(), adopter.getPhoneNumber());
    }

    @GetMapping("/adopters")
    public List<Adopter> listAdopters() {
        return adopterDao.getAllAdopters();
    }

    @RequestMapping(path = "/update-adopter", method = RequestMethod.PUT)
    public String updateAdopter(@RequestBody Adopter adopter) {
        return adopterDao.updateAdopter(adopter) ? "Successfully updated adopter" : "Update failed";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/adopter", method = RequestMethod.DELETE)
    public void deleteAdopter(@PathVariable int id) {
        adopterDao.deleteAdopter(id);
    }

    @GetMapping("/adopter/{id}")
    public Adopter getAdopterById(@PathVariable int id) {
        return adopterDao.getAdopterById(id);
    }
}
