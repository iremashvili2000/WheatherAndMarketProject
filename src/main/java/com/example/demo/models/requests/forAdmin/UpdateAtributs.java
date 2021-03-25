package com.example.demo.models.requests.forAdmin;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class UpdateAtributs {
    @NotNull
    private String name;
    @NotNull
    private String value;
    @NotNull
    private String type;

    public UpdateAtributs(@NotNull String name, @NotNull String value, @NotNull String type) {
        this.name = name;
        this.value = value;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
