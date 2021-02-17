package se.lexicon.g34.bl;

import se.lexicon.g34.bl.dao.CityDao;
import se.lexicon.g34.bl.dao.CityDaoImp;
import se.lexicon.g34.bl.model.City;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        CityDao dao = new CityDaoImp();
        City city =dao.findById(11);
        System.out.println( "Hello World!" );
    }
}
