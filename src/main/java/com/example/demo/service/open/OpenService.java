package com.example.demo.service.open;

import com.example.demo.models.requests.openRequests.SendOrder;

public interface OpenService {
    String registration(SendOrder sendOrder);
}
