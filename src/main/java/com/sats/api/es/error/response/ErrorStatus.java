package com.sats.api.es.error.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sats.api.es.model.Address;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ErrorStatus {
		
	private int rootCode;
	private String rootType;
	private List<ErrorDetails> errorList;	
}
