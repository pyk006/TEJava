package com.techelevator.dao;
import com.techelevator.Application;
import com.techelevator.exception.DaoException;
import com.techelevator.model.Applications;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class JdbcApplicationsDao implements ApplicationsDao {
    private final JdbcTemplate jdbcTemplate;

    public  JdbcApplicationsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override

    public boolean approveApplication(int applicationId, String approval) {
        int rowsChanged = 0;
        String sql = "UPDATE applications SET admin_approval = ? WHERE application_id = ?; ";
        try {
            rowsChanged = jdbcTemplate.update(sql, approval, applicationId);
            if (rowsChanged == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return rowsChanged == 1;
    }
    @Override
    public List<Applications> getAllApplications() {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, " +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo FROM applications;";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                applicationsList.add(mapRowToApplications(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return applicationsList;
    }
    @Override
    public List<Applications> getAllApprovedApplications() {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, " +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo FROM applications WHERE admin_approval = 'Approved'";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                applicationsList.add(mapRowToApplications(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return applicationsList;
    }

    public boolean createApplication(String firstName, String lastName, String date, String homeAddress, String availability, String mascot, String email, String phoneNumber, boolean optInText, boolean experience, boolean transportation, String photo) {
        String sql = "INSERT INTO applications (first_name, last_name, date_of_birth, home_address, availability, school_mascot, email, " +
            "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'Pending', 'Pending', ?);";
        boolean isSuccessful = false;
        try {
            isSuccessful = jdbcTemplate.update(sql, firstName, lastName, date, homeAddress, availability, mascot, email, phoneNumber, optInText, experience, transportation, photo) == 1;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return isSuccessful;
    }

    public Applications findById(int applicationId) {
        Applications application = null;
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, availability, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo FROM applications WHERE application_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, applicationId);
            if (results.next()) {
                application = mapRowToApplications(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return application;
    }
    public List<Applications> findByFirstName(String firstName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, availability, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo FROM applications WHERE first_name = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstName);
            while (results.next()) {
                applicationsList.add(mapRowToApplications(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return applicationsList;
    }
    public List<Applications> findByLastName(String lastName) {
        List<Applications> applicationsList = new ArrayList<>();
        String sql = "SELECT application_id, first_name, last_name, date_of_birth, home_address, availability, school_mascot, email," +
                "phone_number, opt_in_text, experience, transportation, bkgrnd_check_approved, admin_approval, photo FROM applications WHERE last_name = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, lastName);
            while (results.next()) {
                applicationsList.add(mapRowToApplications(results));
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return applicationsList;
    }

    @Override
    public boolean updateApplication(Applications applications) {
        String sql = "UPDATE applications SET first_name = ?, last_name = ?, date_of_birth = ?, home_address = ?, " +
                " availability = ?, school_mascot = ?, email = ?, phone_number = ?, opt_in_text = ?, experience = ?," +
                " transportation = ?, bkgrnd_check_approved = ?, photo = ? WHERE application_id = ?;";
        boolean status;
        try{
            status= jdbcTemplate.update(sql, applications.getFirstName(), applications.getLastName(), applications.getDateOfBirth(), applications.getHomeAddress(),
                    applications.getAvailability(), applications.getSchoolMascot(), applications.getEmail(), applications.getPhoneNumber(),
                    applications.isOptInText(), applications.isExperience(), applications.isTransportation(), applications.getBkgrndCheckApproved(),
                    applications.getPhoto(), applications.getApplicationId()) == 1;
        }   catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return status;
    }

    @Override
    public boolean updateApplicationPhoto(Applications applications) {
        String sql = "UPDATE applications SET photo =? WHERE application_id = ?";
        boolean status;
        try{
            status= jdbcTemplate.update(sql, applications.getPhoto(), applications.getApplicationId()) == 1;
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        System.out.println(status);
        return status;
    }

    private Applications mapRowToApplications(SqlRowSet sql) {
        Applications application = new Applications();
        application.setApplicationId(sql.getInt("application_id"));
        application.setFirstName(sql.getString("first_name"));
        application.setLastName(sql.getString("last_name"));
        application.setDateOfBirth((sql.getString("date_of_birth")));
        application.setHomeAddress(sql.getString("home_address"));
        application.setAvailability(sql.getString("availability"));
        application.setSchoolMascot(sql.getString("school_mascot"));
        application.setEmail(sql.getString("email"));
        application.setPhoneNumber(sql.getString("phone_number"));
        application.setOptInText(sql.getBoolean("opt_in_text"));
        application.setExperience(sql.getBoolean("experience"));
        application.setTransportation(sql.getBoolean("transportation"));
        application.setBkgrndCheckApproved(sql.getString("bkgrnd_check_approved"));
        application.setAdminApproval(sql.getString("admin_approval"));
        application.setPhoto(sql.getString("photo"));
        return application;

    }
}
