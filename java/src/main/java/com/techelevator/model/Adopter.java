package com.techelevator.model;

public class Adopter {
    private int adopterId;
    private int animalId;
    private String adopterFirstName;
    private String adopterLastName;
    private String email;
    private String phoneNumber;

    public Adopter(){}

    public Adopter(int adopterId, int animalId, String adopterFirstName, String adopterLastName, String email, String phoneNumber) {
        this.adopterId = adopterId;
        this.animalId = animalId;
        this.adopterFirstName = adopterFirstName;
        this.adopterLastName = adopterLastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getAdopterId() {
        return adopterId;
    }

    public void setAdopterId(int adopterId) {
        this.adopterId = adopterId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getAdopterFirstName() {
        return adopterFirstName;
    }

    public void setAdopterFirstName(String adopterFirstName) {
        this.adopterFirstName = adopterFirstName;
    }

    public String getAdopterLastName() {
        return adopterLastName;
    }

    public void setAdopterLastName(String adopterLastName) {
        this.adopterLastName = adopterLastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Adopter{" +
                "adopterId=" + adopterId +
                ", animalId=" + animalId +
                ", adopterFirstName='" + adopterFirstName + '\'' +
                ", adopterLastName='" + adopterLastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
