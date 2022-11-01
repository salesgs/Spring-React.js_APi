package com.example.demo.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="promocao")
public class Promocao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome_Destino")
	private String nomedesitno;

	@ManyToOne
	@JoinColumn(name="cliente_fk")
	private Cliente clientes;
	
	
	
	
	public Promocao() {
		super();
	
	}

	public Promocao(Long id, String nomedesitno) {
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