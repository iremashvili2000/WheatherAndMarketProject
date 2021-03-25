package com.example.demo.service;

import com.example.demo.models.response.api.Amindi;

import java.io.IOException;

public interface AmindService {
    String getUrl(String url);
    Amindi getUrlObject(String link) throws IOException;
    String GetRequests(String city)throws IOException;
}
