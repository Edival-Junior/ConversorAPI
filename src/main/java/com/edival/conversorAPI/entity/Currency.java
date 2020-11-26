package com.edival.conversorAPI.entity;

import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;

@Data
public class Currency {

	private Boolean success;
	
	private String terms;
	
	private String privacy;

	private Boolean timeFrame;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private String source;
	
	private Map<String, Object> quotes;
	
	private Double result;
	
	
}
