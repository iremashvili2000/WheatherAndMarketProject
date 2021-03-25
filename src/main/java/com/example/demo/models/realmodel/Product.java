package com.example.demo.models.realmodel;

import com.example.demo.models.realmodel.Atributs;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="product")
public class Product {
    @Column(name = "title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="picture")
    private String picture;
    @Column(name="created_at")
    private Date created_at;
    @Column(name = "unique_name",unique = true)
    private String unique_name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Atributs> atributs;

    public List<Atributs> getAtributs() {
        return atributs;
    }

    public void setAtributs(List<Atributs> atributs) {
        this.atributs = atributs;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getUnique_name() {
        return unique_name;
    }

    public void setUnique_name(String unique_name) {
        this.unique_name = unique_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
