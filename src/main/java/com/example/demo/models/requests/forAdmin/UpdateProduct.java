package com.example.demo.models.requests.forAdmin;

import org.springframework.web.multipart.MultipartFile;

public class UpdateProduct {
    private String title;
    private String description;

    private MultipartFile multiPartFile;
    private String unique_name;


    public UpdateProduct(String title, String description, MultipartFile multiPartFile) {
        this.title = title;
        this.description = description;
        this.multiPartFile = multiPartFile;
    }

    public String getUnique_name() {
        return unique_name;
    }

    public void setUnique_name(String unique_name) {
        this.unique_name = unique_name;
    }

    public MultipartFile getMultiPartFile() {
        return multiPartFile;
    }

    public void setMultiPartFile(MultipartFile multiPartFile) {
        this.multiPartFile = multiPartFile;
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

}
