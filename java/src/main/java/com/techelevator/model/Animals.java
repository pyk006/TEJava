package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Animals {

    private int animalId;
    private String animalName;
    private String animalType;
    private String gender;
    private int age;
    private String description;
    private String breed;
    @JsonProperty("isAdoptable")
    private boolean isAdoptable;
    @JsonProperty("photo")
    private String photo;

    public Animals() {}

    public Animals(String animalName, String animalType, String gender, int age, String description, String breed, boolean isAdoptable, String photo) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.gender = gender;
        this.age = age;
        this.description = description;
        this.breed = breed;
        this.isAdoptable = isAdoptable;
        this.photo = photo;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isAdoptable() {
        return isAdoptable;
    }

    public void setAdoptable(boolean adoptable) {
        isAdoptable = adoptable;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Animals{" +
                "animalId=" + animalId +
                ", animalName='" + animalName + '\'' +
                ", animalType='" + animalType + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", description='" + description + '\'' +
                ", breed='" + breed + '\'' +
                ", isAdoptable=" + isAdoptable +
                ", photo=" + photo +
                '}';
    }
}
