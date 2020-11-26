package com.edival.conversorAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edival.conversorAPI.entity.Moeda;

public interface IMoedaRepository extends JpaRepository<Moeda, Long>{

	public Moeda findByCodigo(String codigo);
	
}
