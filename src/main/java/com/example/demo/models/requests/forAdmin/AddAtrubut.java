package com.example.demo.models.requests.forAdmin;

import javax.validation.constraints.NotNull;

public class AddAtrubut {
    @NotNull
    private String productName;
    @NotNull
    private String atributName;

    public AddAtrubut(@NotNull String productName, @NotNull String atributName) {
        this.productName = productName;
        this.atributName = atributName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getAtributName() {
        return atributName;
    }

    public void setAtributName(String atributName) {
        this.atributName = atributName;
    }
}
