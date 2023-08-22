package com.techelevator.controller;

import com.techelevator.dao.ApplicationsDao;
import com.techelevator.model.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class ApplicationsController {
    @Autowired
    ApplicationsDao applicationsDao;

    @RequestMapping(path = "/applications", method = RequestMethod.GET)
    public List<Applications> listApplications () {
        return applicationsDao.getAllApplications();
    }

    @RequestMapping(path = "/directory", method = RequestMethod.GET)
    public List<Applications> listApprovedApplications () {
        return applicationsDao.getAllApprovedApplications();
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/volunteer/submit-form")
    public void createApplication(@RequestBody Applications applications) {
        applicationsDao.createApplication(applications.getFirstName(), applications.getLastName(), applications.getDateOfBirth(), applications.getHomeAddress(), applications.getAvailability(), applications.getSchoolMascot(), applications.getEmail(), applications.getPhoneNumber(), applications.isOptInText(), applications.isExperience(), applications.isTransportation(), applications.getPhoto());
    }

    @RequestMapping(path = "/applications", method = RequestMethod.PUT)
    public String approveApplication(@RequestBody Applications applications) {
        return applicationsDao.approveApplication(applications.getApplicationId(), applications.isAdminApproval()) ? "Successfully Approved Application!" : "That didn't work";
    }

    @RequestMapping(path = "/updateApps", method = RequestMethod.PUT)
    public String updateApplication(@RequestBody Applications applications) {
        return applicationsDao.updateApplication(applications) ? "Successfully Updated Application" : "Update failed";
    }

    @RequestMapping(path = "/updateApps/photo", method = RequestMethod.PUT)
    public String updateApplicationPhoto(@RequestBody Applications applications) {
        System.out.println(applications.toString());
        return applicationsDao.updateApplicationPhoto(applications) ? "Successfully Updated Application" : "Update failed";
    }
}

