package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Adopter;
import com.techelevator.model.Animals;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcAdopterDao implements AdopterDao{

    private final JdbcTemplate jdbcTemplate;

    public  JdbcAdopterDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public boolean createAdopter(int animalId, String adopterFirstName, String adopterLastName, String email, String phoneNumber) {
        String sql = "INSERT INTO adopter (animal_id, adopter_first_name, adopter_last_name, email, phone_number)" +
                " VALUES (?, ?, ?, ?, ?);";
        boolean isSuccessful;

        try{
            isSuccessful = jdbcTemplate.update(sql, animalId, adopterFirstName, adopterLastName, email, phoneNumber) == 1;
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return isSuccessful;
    }

    @Override
    public List<Adopter> getAllAdopters() {
        List<Adopter> allAdopters = new ArrayList<>();
        String sql = "SELECT adopter_id, animal_id, adopter_first_name, adopter_last_name, email, phone_number " +
                " FROM adopter;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            allAdopters.add(mapRowToAdopter(results));
        }
        return allAdopters;
    }

    @Override
    public boolean updateAdopter(Adopter adopter) {
        String sql = "UPDATE adopter SET animal_id=?, adopter_first_name=?, adopter_last_name=?, email=?, phone_number=?" +
                " WHERE adopter_id = ?;";
        boolean status;
        try{
            status = jdbcTemplate.update(sql, adopter.getAnimalId(), adopter.getAdopterFirstName(), adopter.getAdopterLastName(),
                    adopter.getEmail(), adopter.getPhoneNumber(), adopter.getAdopterId()) == 1;
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return status;
    }

    @Override
    public boolean deleteAdopter(int adopterId) {
        String sql = "DELETE FROM adopter WHERE adopter_id = ?;";
        boolean status;
        try{
            status = jdbcTemplate.update(sql, adopterId) == 1;
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return status;
    }

    @Override
    public Adopter getAdopterById(int adopterId) {
        Adopter adopter = null;
        String sql = "SELECT adopter_id, animal_id, adopter_first_name, adopter_last_name, email, phone_number " +
                "FROM adopter WHERE adopter_id = ?;";
        try{
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, adopterId);
            if(results.next()){
                adopter = mapRowToAdopter(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return adopter;
    }

    private Adopter mapRowToAdopter(SqlRowSet result){
        Adopter adopter = new Adopter();
        adopter.setAdopterId(result.getInt("adopter_id"));
        adopter.setAnimalId(result.getInt("animal_id"));
        adopter.setAdopterFirstName(result.getString("adopter_first_name"));
        adopter.setAdopterLastName(result.getString("adopter_last_name"));
        adopter.setEmail(result.getString("email"));
        adopter.setPhoneNumber(result.getString("phone_number"));
        return adopter;
    }
}
