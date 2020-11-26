package com.edival.conversorAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.edival.conversorAPI.client.CurrencyExchangeAPI;
import com.edival.conversorAPI.entity.Moeda;
import com.edival.conversorAPI.repository.IMoedaRepository;

@RestController
public class CurrencyController {

	@Autowired
	private IMoedaRepository repository;
	
	@Autowired
	private CurrencyExchangeAPI currencyExchangeAPI;
		
	@GetMapping("/currency")
	public List<Moeda> all() {
		return repository.findAll();
	}
	
	@GetMapping("/currency/findByCodigo/{codigo}")
	public Object findByCodigo(@PathVariable String codigo) {		
		return  currencyExchangeAPI.live(codigo);
	}
	
	@GetMapping("/currency/converter/{codigoDe}/{codigoPara}/{valor}")
	public Object findByCodigo(@PathVariable String codigoDe,@PathVariable String codigoPara,@PathVariable Double valor) {		
		return  currencyExchangeAPI.converter(codigoDe, codigoPara, valor);
	}
	
	
	
}
