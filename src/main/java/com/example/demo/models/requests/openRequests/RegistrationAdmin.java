package com.example.demo.models.requests.openRequests;

import javax.validation.constraints.NotNull;

public class RegistrationAdmin {
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @NotNull
    private String repassword;

    private boolean privatePolice;

    public RegistrationAdmin(@NotNull String username, @NotNull String email, @NotNull String password, @NotNull String repassword, boolean privatePolice) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.repassword = repassword;
        this.privatePolice = privatePolice;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public boolean isPrivatePolice() {
        return privatePolice;
    }

    public void setPrivatePolice(boolean privatePolice) {
        this.privatePolice = privatePolice;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
