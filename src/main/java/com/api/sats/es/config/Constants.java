package com.api.sats.es.config;

public class Constants {

	public static final int SUCCESS_ROOT_CODE = 20000;
	public static final String SUCCESS_ROOT_TYPE = "success";
	public static final String INGEST_RESTAURANT_SUCCESS_MESSAGE = "Restaurant insert successfully";
	
	public static final int ELASTIC_SEARCH_EXCEPTION_ROOT_CODE = 50000;
	public static final String ELASTIC_SEARCH_EXCEPTION_ROOT_TYPE = "ServerException";
	
	public static final int ELASTIC_SEARCH_EXCEPTION_RESULT_CODE = 50001;
	public static final String ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE = "ElasticSearchException";
	public static final String ELASTIC_SEARCH_EXCEPTION_MESSAGE = "Elastic search exception occured during request, "
																	+ " please check your request or whether ES is up and running";
	
	public static final int HEADER_VALIDATION_EXCEPTION_ROOT_CODE = 40000;
	public static final String HEADER_VALIDATION_EXCEPTION_ROOT_TYPE = "ValidationException";
	
	public static final int HEADER_VALIDATION_EXCEPTION_RESULT_CODE = 40001;
	public static final String HEADER_VALIDATION_EXCEPTION_RESULT_TYPE = "HeaderValidationException";
	public static final String HEADER_VALIDATION_EXCEPTION_RESULT_MESSAGE = "Headers validation error occurs, please check your request";
}
