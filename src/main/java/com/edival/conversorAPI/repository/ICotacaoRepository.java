package com.edival.conversorAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edival.conversorAPI.entity.Cotacao;

public interface ICotacaoRepository extends JpaRepository<Cotacao, Long>{
}
