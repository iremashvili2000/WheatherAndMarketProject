package com.example.demo.models.response.api;

import java.util.List;

public class Amindi {
    private City city;
    private String cod;
    private Double message;
    private long cnt;
    private List<Info> list;




    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Double getMessage() {
        return message;
    }

    public void setMessage(Double message) {
        this.message = message;
    }

    public long getCnt() {
        return cnt;
    }

    public void setCnt(long cnt) {
        this.cnt = cnt;
    }

    public List<Info> getList() {
        return list;
    }

    public void setList(List<Info> list) {
        this.list = list;
    }
}
