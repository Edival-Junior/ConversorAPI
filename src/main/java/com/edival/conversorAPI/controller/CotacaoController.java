package com.edival.conversorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edival.conversorAPI.entity.Cotacao;
import com.edival.conversorAPI.repository.ICotacaoRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CotacaoController {

	@Autowired
	private ICotacaoRepository repository;
	
	@GetMapping("/cotacao")
	public List<Cotacao> all() {
		return repository.findAll();
	}
	
	@PostMapping("/cotacao")
	public void save(@RequestBody Cotacao cotacao) {
		repository.save(cotacao);
	}
	
	@PutMapping("/cotacao/{id}")
	public void update(@PathVariable Long id, @RequestBody Cotacao cotacao) {
		cotacao.setId(id);
		repository.save(cotacao);
	}
	
	@DeleteMapping("/cotacao/{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
			
}
