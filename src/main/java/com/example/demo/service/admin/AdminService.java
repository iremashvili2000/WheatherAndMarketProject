package com.example.demo.service.admin;

import com.example.demo.models.realmodel.Atributs;
import com.example.demo.models.realmodel.Order;
import com.example.demo.models.realmodel.Product;
import com.example.demo.models.requests.forAdmin.AddAtrubut;
import com.example.demo.models.requests.forAdmin.UpdateAtributs;
import com.example.demo.models.requests.forAdmin.UpdateProduct;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
     Product pictureUpdate(Product product, MultipartFile file);

     Product updateProduct(UpdateProduct updateProduct);

    List<Order> getOrderList();

    Atributs createAtribut(UpdateAtributs updateAtributs);

    void deleteAtribut(String name);

    Product addAtribut(AddAtrubut addAtrubut);

    void deleteOrder(String email);

    void deleteProduct(String title);
}
