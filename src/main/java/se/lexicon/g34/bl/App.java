package se.lexicon.g34.bl;

import se.lexicon.g34.bl.dao.CityDao;
import se.lexicon.g34.bl.dao.CityDaoImp;
import se.lexicon.g34.bl.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        CityDao dao = new CityDaoImp();
       // dao.add(new City("Karlskrona", "SWE", "Blekinge", 66655));
        List<City> cityList = dao.findByName("Karlskrona");
        cityList.forEach(System.out::println);

       // dao.add(new City("Ronneby", "SWE", "Blekinge", 0));
        cityList = dao.findByName("Ronneby");
        cityList.forEach(System.out::println);
        cityList = dao.findByCode("swe");
        cityList.forEach(System.out::println);
        //dao.delete(dao.findById(4086));
        cityList = dao.findByName("Ronneby");
        cityList.forEach(System.out::println);
        City toUpdate=dao.findById(4082);
        toUpdate.setPopulation(29695);
        dao.update(toUpdate);
        cityList = dao.findByName("Ronneby");
        cityList.forEach(System.out::println);
        //toUpdate=dao.add(new City("Karlshamn", "SWE", "Blekinge", 32442));
        //System.out.println(toUpdate);
        cityList = dao.findByName("Karlshamn");
        cityList.forEach(System.out::println);
        //dao.delete(dao.findById(4088));
        //dao.delete(dao.findById(4089));
        //dao.delete(dao.findById(4090));
        //dao.delete(dao.findById(4091));
        cityList = dao.findByName("Karlshamn");
        cityList.forEach(System.out::println);

    }
}
