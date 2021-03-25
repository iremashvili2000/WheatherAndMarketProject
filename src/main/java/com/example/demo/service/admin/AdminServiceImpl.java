package com.example.demo.service.admin;

import com.example.demo.exception.BadDataException;
import com.example.demo.exception.DontFindException;
import com.example.demo.models.realmodel.Atributs;
import com.example.demo.models.realmodel.Order;
import com.example.demo.models.realmodel.Product;
import com.example.demo.models.requests.forAdmin.AddAtrubut;
import com.example.demo.models.requests.forAdmin.UpdateAtributs;
import com.example.demo.models.requests.forAdmin.UpdateProduct;
import com.example.demo.repository.AtributsRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductsRepository;
import com.example.demo.service.StorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    private final StorageService storageService;
    private final ProductsRepository productsRepository;
    private final OrderRepository orderRepository;
    private final AtributsRepository atributsRepository;



    public AdminServiceImpl(StorageService storageService, ProductsRepository productsRepository, OrderRepository orderRepository, AtributsRepository atributsRepository) {
        this.storageService = storageService;
        this.productsRepository = productsRepository;
        this.orderRepository = orderRepository;
        this.atributsRepository = atributsRepository;
    }


    @Override
    public Product pictureUpdate(Product product, MultipartFile file) {
        String path = storageService.store(file);
        product.setPicture(path);
        productsRepository.save(product);
        return product;
    }

    @Override
    public Product updateProduct(UpdateProduct updateProduct) {
        Product product=new Product();
        product.setCreated_at(new Date());
        product.setDescription(updateProduct.getDescription());
        product.setTitle(updateProduct.getTitle());
        product.setUnique_name(updateProduct.getUnique_name());
        productsRepository.save(product);
        return product;
    }

    @Override
    public List<Order> getOrderList() {
     return   orderRepository.findAll();
    }

    @Override
    public Atributs createAtribut(UpdateAtributs updateAtributs) {
        if (atributsRepository.findByName(updateAtributs.getName()) != null) {
            Atributs atributs=atributsRepository.findByName(updateAtributs.getName());
            atributs.setName(updateAtributs.getName());
            atributs.setType(updateAtributs.getType());
            atributs.setValue(updateAtributs.getValue());
            atributsRepository.save(atributs);

            return atributs;
        } else{
           Atributs atributs = new Atributs();
            atributs.setName(updateAtributs.getName());
            atributs.setType(updateAtributs.getType());
            atributs.setValue(updateAtributs.getValue());
            atributsRepository.save(atributs);
            return atributs;
        }


    }

    @Override
    public void deleteAtribut(String name) {
            atributsRepository.deleteByName(name);
    }

    @Override
    public Product addAtribut(AddAtrubut addAtrubut) {
      Product product = productsRepository.findByTitle(addAtrubut.getProductName());
      if(product==null){
          throw new DontFindException("product dont found");
      }
      Atributs atributs=atributsRepository.findByName(addAtrubut.getAtributName());
      if(atributs==null){
          throw new DontFindException("dont found this atribut");
      }
      List<Atributs> atributsList=product.getAtributs();
      atributsList.add(atributs);
      product.setAtributs(atributsList);
      List<Product>productList=atributs.getProduct();
      productList.add(product);
      productsRepository.save(product);
      atributsRepository.save(atributs);
      return product;
    }

    @Override
    public void deleteOrder(String email) {
        orderRepository.deleteByEmail(email);
    }

    @Override
    public void deleteProduct(String title) {
      Product product=  productsRepository.findByTitle(title);
      productsRepository.deleteById(product.getId());
      System.out.println("waishalaa");
    }


}
