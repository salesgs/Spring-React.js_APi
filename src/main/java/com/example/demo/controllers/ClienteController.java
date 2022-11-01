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
import com.example.demo.entidades.Cliente;
import com.example.demo.repository.ClienteRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	//RETURN LIST
	@GetMapping("/clientes")
	public List<Cliente>getAllClientes(){
		return clienteRepository.findAll();
	 }
	
	//GET or by ID
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente>getClienteById(@PathVariable Long id){
		Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cliente indefinido (:"));
		return ResponseEntity.ok(cliente);
	}
	
	
	//POST or  CREATE
	@PostMapping("/clientes")
	public Cliente createCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	//PUT OR UPDATE
	@PutMapping("clientes/{id}")
	public ResponseEntity<Cliente>putCliente(@PathVariable Long id,@RequestBody Cliente clienteDetails){
		Cliente cliente = clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cliente indefinido (:"));
		
		cliente.setCpf(clienteDetails.getCpf());
		cliente.setEmail(clienteDetails.getEmail());
		cliente.setNome(clienteDetails.getNome());
		
		Cliente newCliente = clienteRepository.save(cliente);
		return ResponseEntity.ok(newCliente);
	}
	
	//DELETE
	public ResponseEntity<Map<String,Boolean>>deletarCliente(@PathVariable Long id){
		Cliente cliente= clienteRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Cliente indefinido (:"));
		
		clienteRepository.save(cliente);
		Map<String,Boolean>response = new HashMap<>();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
	} 
	
}
