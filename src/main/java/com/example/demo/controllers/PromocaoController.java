package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ResourceNotFoundException;
import com.example.demo.entidades.Promocao;
import com.example.demo.repository.PromocaoRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class PromocaoController {

	@Autowired
	private PromocaoRepository promocaoRepository;
	
	
	//READ or GET all
	@GetMapping("/promocao")
	public List<Promocao>getAll(){
	return promocaoRepository.findAll()	;
	}
	
	//READ or GET by ID
	@GetMapping("/promocao/{id}")
	public ResponseEntity<Promocao>getById(@PathVariable Long id){
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Promocao Inexistente"));
		return ResponseEntity.ok(promocao);
	}

	//POST or CREATE
	@PostMapping("/promocao")
	public Promocao createPromocao(@RequestBody Promocao promocao) {
	 return  promocaoRepository.save(promocao);
	}
	
    //PUT or UPDATE
	@PutMapping("promocao/{id}")
	public ResponseEntity<Promocao>putPromocao(@PathVariable Long id,@RequestBody Promocao promocaoDetails){
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Promocao Inexistente"));
		
		promocao.setNomedesitno(promocaoDetails.getNomedesitno());
		Promocao newPromocao = promocaoRepository.save(promocao);
		return ResponseEntity.ok(newPromocao);
	}
	
	
	//DELETE
	public ResponseEntity<Map<String,Boolean>>deletarPromocao(@PathVariable Long id){
		Promocao promocao = promocaoRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Promocao Inexistente"));
		
		promocaoRepository.save(promocao);
		Map<String,Boolean>response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}

