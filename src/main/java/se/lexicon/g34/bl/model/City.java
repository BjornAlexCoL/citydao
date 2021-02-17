package se.lexicon.g34.bl.model;

import java.util.Objects;

public class City {
    private int id;
    private int name;
    private int countryCode;
    private int district;
    private int population;

    //Constructors
    public City() {
    }

    public City(int id, int name, int countryCode, int district, int population) {
        this.id = id;
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

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }

    public int getDistrict() {
        return district;
    }

    public void setDistrict(int district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    //Overrides
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city = (City) o;
        return getId() == city.getId() && getName() == city.getName() && getCountryCode() == city.getCountryCode() && getDistrict() == city.getDistrict() && getPopulation() == city.getPopulation();
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
