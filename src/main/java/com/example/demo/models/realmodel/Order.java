package com.example.demo.models.realmodel;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Entity
@Table(name="orders")
public class Order {
    @Column(name="order_name")
    @NotNull
    private String name;
    @Column(name="company")
    private String company;
    @Column(name="phone")
    @NotNull
    private Long phone;
    @Email
    @Column(name="email",unique = true)
    @NotNull
    private String email;
    @Column(name="created_at")
    private Date created_at;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
