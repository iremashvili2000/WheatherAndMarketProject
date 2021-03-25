package com.example.demo.repository;

import com.example.demo.models.realmodel.Atributs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtributsRepository extends JpaRepository<Atributs,Long> {
        Atributs findByName(String name);
        void deleteByName(String name);
}
