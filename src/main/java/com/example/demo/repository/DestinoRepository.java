package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entidades.Destino;

@Repository
public interface DestinoRepository extends JpaRepository<Destino,Long> {

	
	
}
