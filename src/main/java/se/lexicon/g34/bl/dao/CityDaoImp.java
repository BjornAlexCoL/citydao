package se.lexicon.g34.bl.dao;

import se.lexicon.g34.bl.dao.db.MySqlConnection;
import se.lexicon.g34.bl.model.City;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CityDaoImp implements CityDao {
    @Override
    public City findById(int id) {
        String query = "SELECT * from city where ID = ?;";
        City city = null;
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                city = new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public List<City> findByCode(String code) {
        String query = "SELECT * FROM city WHERE countryCode = ?;";
        List<City> cityList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cityList.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> findByName(String name) {
        String query = "SELECT * FROM city WHERE name = ?;";
        List<City> cityList = new ArrayList<>();
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                cityList.add(new City(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getInt(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public List<City> findAll() {
        String query = "Select * from city;";
        List<City> cityList = new ArrayList<>();
        try {
            Statement statement = MySqlConnection.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) cityList.add(new City(
                    resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getInt(5)));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cityList;
    }

    @Override
    public City add(City city) {
        String query = "INSERT INTO city VALUE (0,?,?,?,?);";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query, RETURN_GENERATED_KEYS)
        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.executeUpdate();
            ResultSet genKeys = preparedStatement.getGeneratedKeys();
            if (genKeys.next()) {
                city.setId(genKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }


    @Override
    public City update(City city) {
        String query = "UPDATE city SET name=?,CountryCode=?,District=?,Population=? WHERE ID=?;";
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setString(1, city.getName());
            preparedStatement.setString(2, city.getCountryCode());
            preparedStatement.setString(3, city.getDistrict());
            preparedStatement.setInt(4, city.getPopulation());
            preparedStatement.setInt(5, city.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    @Override
    public int delete(City city) {
        String query = "DELETE FROM city WHERE id=?";
        int result = 0;
        try (
                PreparedStatement preparedStatement = MySqlConnection.getConnection().prepareStatement(query)
        ) {
            preparedStatement.setInt(1, city.getId());
            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
