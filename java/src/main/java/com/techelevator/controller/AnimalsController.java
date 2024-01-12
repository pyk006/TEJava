package com.techelevator.controller;

import com.techelevator.dao.AnimalsDao;
import com.techelevator.model.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class AnimalsController {

    @Autowired
    AnimalsDao animalsDao;

    @GetMapping(path = "/availablePets")
    public List<Animals> listAnimals() { return animalsDao.getAllAnimals(); }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/availablePets/addPets")
    public void createAnimal(@RequestBody Animals animals){
        System.out.println(animals.toString());
        animalsDao.createAnimal(animals.getAnimalName(), animals.getAnimalType(), animals.getGender(),
                animals.getAge(), animals.getDescription(), animals.getBreed(), animals.isAdoptable(), animals.getPhoto());
    }

    @RequestMapping(path = "/animals", method = RequestMethod.PUT)
    public void updateAnimal(@RequestBody Animals animals){
        System.out.println(animals.toString());
        animalsDao.updateAnimal(animals);
    }

    @RequestMapping(path = "/animals/updatePhoto", method = RequestMethod.PUT)
    public void updatePetPhoto(@RequestBody Animals animals){
        System.out.println(animals.toString());
        animalsDao.updatePetPhoto(animals);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path = "/animals/{id}", method = RequestMethod.DELETE)
    public void deleteAnimal(@PathVariable int id){
        animalsDao.deleteAnimal(id);
    }
}
