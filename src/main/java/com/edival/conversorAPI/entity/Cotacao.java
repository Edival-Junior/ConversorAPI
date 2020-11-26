package com.edival.conversorAPI.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
public class Cotacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="moedaDe_id", referencedColumnName = "id")
	private Moeda moedaDe;
	
	@ManyToOne
	@JoinColumn(name="moedaPara_id", referencedColumnName = "id")
	private Moeda moedaPara;
	
	@Column
	private Double valorUnidade;
	
	@Column
	private Double valorTotal;
	
	@Column
	private int quantidade;
	
	@Column
	@UpdateTimestamp
	private LocalDateTime data;
}
