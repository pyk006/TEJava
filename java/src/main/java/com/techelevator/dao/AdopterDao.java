package com.techelevator.dao;

import com.techelevator.model.Adopter;

import java.util.List;

public interface AdopterDao {

    boolean createAdopter(int animalId, String adopterFirstName, String adopterLastName, String email, String phoneNumber);

    List<Adopter> getAllAdopters();

    boolean updateAdopter(Adopter adopter);

    boolean deleteAdopter(int adopterId);

    Adopter getAdopterById(int adopterId);

}
