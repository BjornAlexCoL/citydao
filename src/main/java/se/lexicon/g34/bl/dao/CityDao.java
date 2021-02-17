package se.lexicon.g34.bl.dao;

import se.lexicon.g34.bl.model.City;
import java.util.List;

public interface CityDao {
    City findById(int id);
    List<City> findByCode(String code);
    List<City> findByName(String name);
    List<City> findAll();
    City add(City city);
    City update(City city);
    int delete(City city);
}
