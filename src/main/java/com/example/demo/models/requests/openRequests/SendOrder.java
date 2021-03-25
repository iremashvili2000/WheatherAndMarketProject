package com.example.demo.models.requests.openRequests;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class SendOrder {
    @NotNull
    private String fullName;
    @NotNull
    private String company;
    @NotNull
    @Email
    private String email;
    @NotNull
    private Long phone;

    public SendOrder(@NotNull String fullName, @NotNull String company, @NotNull String email, @NotNull Long phone) {
        this.fullName = fullName;
        this.company = company;
        this.email = email;
        this.phone = phone;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
