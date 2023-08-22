package com.techelevator.dao;

import com.techelevator.exception.DaoException;
import com.techelevator.model.Animals;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcAnimalsDao implements AnimalsDao{

    private final JdbcTemplate jdbcTemplate;

    public  JdbcAnimalsDao(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Animals> getAllAnimals() {
        List<Animals> animalsList = new ArrayList<>();
        String sql = "SELECT animal_id, animal_name, animal_type, gender, age, " +
                " description, breed, is_adoptable, photo " +
                " FROM animals;";
        try{
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            animalsList.add(mapRowToAnimals(results));
        }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return animalsList;
    }

    @Override
    public boolean createAnimal(String animalName, String animalType, String gender, int age, String description, String breed, boolean isAdoptable, String photo) {
        String sql = "INSERT INTO animals (animal_name, animal_type, gender, age, description," +
                " breed, is_adoptable, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        boolean status;
        try{
            status = jdbcTemplate.update(sql, animalName, animalType, gender, age, description, breed, isAdoptable, photo) == 1;
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
    public Animals getAnimalById(int animalId) {
        Animals animal = null;
        String sql = "SELECT animal_id, animal_name, animal_type, gender, age, " +
                " description, breed, is_adoptable, photo " +
                " FROM animals WHERE animal_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, animalId);
            if (results.next()) {
                animal= mapRowToAnimals(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        }
        return animal;
    }

    @Override
    public boolean updateAnimal(Animals animal) {
        String sql = "UPDATE animals SET animal_name = ?, animal_type = ?, gender = ?, age = ?, " +
                " description = ?, breed = ?, is_adoptable = ? WHERE animal_id = ?";
        boolean status;
        try{
        status= jdbcTemplate.update(sql, animal.getAnimalName(), animal.getAnimalType(), animal.getGender(),
                animal.getAge(), animal.getDescription(), animal.getBreed(), animal.isAdoptable(), animal.getAnimalId()) == 1;
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
    public boolean deleteAnimal(int animalId) {
        String sql = "DELETE FROM animals WHERE animal_id = ?";
        // TODO delete other table's dependencies
        boolean status;
        try {
            status = jdbcTemplate.update(sql, animalId) == 1;
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
    public boolean updatePetPhoto(Animals animal) {
        String sql = "UPDATE animals SET photo =? WHERE animal_id = ?";
        boolean status;
        try{
            status= jdbcTemplate.update(sql, animal.getPhoto(), animal.getAnimalId()) == 1;
        }  catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (BadSqlGrammarException e) {
            throw new DaoException("SQL syntax error", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return status;
    }

    private Animals mapRowToAnimals(SqlRowSet result){
        Animals animals = new Animals();
        animals.setAnimalId(result.getInt("animal_id"));
        animals.setAnimalName(result.getString("animal_name"));
        animals.setAnimalType(result.getString("animal_type"));
        animals.setGender(result.getString("gender"));
        animals.setAge(result.getInt("age"));
        animals.setDescription(result.getString("description"));
        animals.setBreed(result.getString("breed"));
        animals.setAdoptable(result.getBoolean("is_adoptable"));
        animals.setPhoto(result.getString("photo"));

        return animals;
    }
}
