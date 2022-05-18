package com.codegym.testmd4c12.model;

import javax.persistence.*;

@Entity
@Table(name = "Cities")
public class City{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private  String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    private Double area;
    private Long population;
    private Double gdp;
    private String description;

    public City() {
    }

    public City(String name, Country country, Double area, Long population, Double gdp, String description) {
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public City(Long id) {
        this.id = id;
    }

    public City(Long id, String name, Country country, Double area, Long population, Double gdp, String description) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.area = area;
        this.population = population;
        this.gdp = gdp;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
