package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import com.example.demo.entidades.Promocao;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao,Long> {

}
