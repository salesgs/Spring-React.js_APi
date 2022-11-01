package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entidades.Destino;
import com.example.demo.repository.DestinoRepository;


@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class DestinoController { 
	
	@Autowired
	private DestinoRepository destinoRepository;

	//READ or GET all
    @GetMapping("/destinos")
    public List<Destino>getAllDestinos(){
    
    	return destinoRepository.findAll();
    }
    
    // READ OR GET by ID
    @GetMapping("/destinos/{id}")
    public ResponseEntity<Destino>getDestinoById(@PathVariable Long id){
    	Destino destino = destinoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Destino inválido"));
    	return ResponseEntity.ok(destino);
    }
    
    
    //POST or CREATE
    @PutMapping("/destinos")
    public Destino createDestino(@RequestBody Destino destino) {
    	return destinoRepository.save(destino);
    }
    
    
    //PUT or UPDATE
    @PutMapping("destinos/{id}")
    public ResponseEntity<Destino>putDestino(@PathVariable Long id,@RequestBody Destino destinoDetails ){
    
    	Destino destino = destinoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Destino inválido"));
    	destino.setNomedesitno(destino.getNomedesitno());
    	
    	Destino newDestino = destinoRepository.save(destino);
    	return ResponseEntity.ok(newDestino);
    }
    
    //DELETE
    public ResponseEntity<Map<String,Boolean>>deletarDestino(@PathVariable Long id){
    	Destino destino = destinoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Destino inválido"));
    	
    	destinoRepository.save(destino);
    	Map<String,Boolean> response = new HashMap<>();
    	response.put("deleted",Boolean.TRUE);
    	return ResponseEntity.ok(response);
    }
    
	
}
