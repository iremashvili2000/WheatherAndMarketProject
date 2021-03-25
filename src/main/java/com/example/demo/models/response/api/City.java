package com.example.demo.models.response.api;

public class City {
    private long id;

    private String name;

    private Cord coord;
    private String country;
    private Long population;
    private Long timezone;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getTimezone() {
        return timezone;
    }

    public void setTimezone(Long timezone) {
        this.timezone = timezone;
    }

    public Cord getCoord() {
        return coord;
    }

    public void setCoord(Cord coord) {
        this.coord = coord;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
