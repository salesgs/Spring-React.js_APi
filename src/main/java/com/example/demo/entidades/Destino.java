package com.example.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="destino")
public class Destino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_Destino")
	private String nomedesitno;

	public Destino() {
		super();

	}

	@ManyToOne
	@JoinColumn(name="cliente_fk")
	private Cliente clientes;
	

	public Destino(Long id, String nomedesitno) {
		super();
		this.id = id;
		this.nomedesitno = nomedesitno;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomedesitno() {
		return nomedesitno;
	}


	public void setNomedesitno(String nomedesitno) {
		this.nomedesitno = nomedesitno;
	}
	
	
}