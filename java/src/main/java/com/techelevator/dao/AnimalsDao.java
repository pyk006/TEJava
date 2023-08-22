package com.techelevator.dao;

import com.techelevator.model.Animals;

import java.util.List;

public interface AnimalsDao {

    List<Animals> getAllAnimals();

    boolean createAnimal(String animalName, String animalType, String gender, int age, String description, String breed, boolean isAdoptable, String photo);

    Animals getAnimalById(int animalId);

    boolean updateAnimal(Animals animal);

    boolean deleteAnimal(int animalId);

    boolean updatePetPhoto(Animals animal);

}
