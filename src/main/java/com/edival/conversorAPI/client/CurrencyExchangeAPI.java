package com.edival.conversorAPI.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.edival.conversorAPI.entity.Currency;

@Service
public class CurrencyExchangeAPI {

	@Value("${currencylayer.api.url}")
	private String apiUrl;
	
	@Value("${currencylayer.api.key}")
	private String apiKey;
	
	
	public Object live(String codigo) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("source", codigo);
		Currency response = getResponse("live", params, Currency.class);
		System.out.println(response);
		return response;
	}
	
	public Object converter(String codigoDe, String codigoPara, Double valor) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("from", codigoDe);
		params.put("to", codigoPara);
		params.put("amount", valor);
		Currency response = getResponse("convert", params, Currency.class);
		System.out.println(response);
		return response;
	}
	
	
	private <T> T getResponse(String resource, Map<String, Object> params, Class<T> t) {
		UriComponentsBuilder uri = UriComponentsBuilder.newInstance()
				.scheme("http")
				.host(apiUrl + resource)
				.queryParam("access_key", apiKey);
		
		params.forEach((k,v) -> uri.queryParam(k, v));
		
		return new RestTemplate().getForObject(uri.build().toUriString() , t);
	}


	
}
