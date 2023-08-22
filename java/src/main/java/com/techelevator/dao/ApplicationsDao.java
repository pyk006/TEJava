package com.techelevator.dao;

import java.time.LocalDate;
import java.util.*;
import com.techelevator.model.Applications;

public interface ApplicationsDao {

     boolean approveApplication(int applicationId, String approval);

    List<Applications> getAllApplications();
    List<Applications> getAllApprovedApplications();
    boolean createApplication(String firstName, String lastName, String date, String homeAddress, String availability, String mascot, String email, String phoneNumber, boolean optInText, boolean experience, boolean transportation, String photo);
    Applications findById(int applicationId);
    List<Applications> findByFirstName(String firstName);
    List<Applications> findByLastName(String lastName);
    boolean updateApplication(Applications applications);
    boolean updateApplicationPhoto (Applications applications);
}
