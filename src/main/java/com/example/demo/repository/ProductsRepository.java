package com.example.demo.repository;

import com.example.demo.models.realmodel.Product;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductsRepository extends JpaRepository<Product,Long> {


  //  PageRequest.of(0,20)
  //  Page<Product> findAllByTitleLike(String title, Pageable pageable)

    Page<Product> findAllByTitleLike(String title, Pageable pageable);
    Product findByTitle(String title);



}
