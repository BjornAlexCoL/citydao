package se.lexicon.g34.bl.model;

import java.util.Objects;

public class City {
    private int id;
    private String name;
    private String countryCode;
    private String district;
    private int population;

    //Constructors
    public City() {
    }

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    public City(String name, String countryCode, String district, int population) {
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }

    //Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId() == city.getId() && getPopulation() == city.getPopulation() && Objects.equals(getName(), city.getName()) && Objects.equals(getCountryCode(), city.getCountryCode()) && Objects.equals(getDistrict(), city.getDistrict());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getCountryCode(), getDistrict(), getPopulation());
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name=" + name +
                ", countryCode=" + countryCode +
                ", district=" + district +
                ", population=" + population +
                '}';
    }
}
