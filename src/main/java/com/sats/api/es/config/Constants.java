package com.sats.api.es.config;

public class Constants { 
	
	public static final String BASE_API_PATH = "/api/restaurants";
	public static final String RESTAURANT_INGEST_PATH = "/ingest";

	public static final int SUCCESS_ROOT_CODE = 20000;
	public static final String SUCCESS_ROOT_TYPE = "success";
	public static final String INGEST_RESTAURANT_SUCCESS_MESSAGE = "Restaurant insert successfully";
	
	public static final int SERVER_EXCEPTION_ROOT_CODE = 50000;
	public static final String SERVER_EXCEPTION_ROOT_TYPE = "ServerException";
	
	public static final int ELASTIC_SEARCH_EXCEPTION_RESULT_CODE = 50001;
	public static final String ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE = "ElasticSearchException";
	public static final String ELASTIC_SEARCH_INGEST_EXCEPTION_MESSAGE = "Exception occured during inserting record in ElasticSearch, "
			+ "please check your ElasticSearch Cluster is up and running";
	
	public static final int VALIDATION_EXCEPTION_ROOT_CODE = 40000;
	public static final String VALIDATION_EXCEPTION_ROOT_TYPE = "ValidationException";
	
	public static final int HEADER_VALIDATION_EXCEPTION_RESULT_CODE = 40001;
	public static final String HEADER_VALIDATION_EXCEPTION_RESULT_TYPE = "HeaderValidationException";
	public static final String MARKET_CODE_EXCEPTION_RESULT_MESSAGE = "Headers validation error occurs, please check your market "
			+ "code is correct or not";
	public static final String LOCALE_EXCEPTION_RESULT_MESSAGE = "Headers validation error occurs, please check your locale "
			+ "is correct or not";
	public static final String UUID_EXCEPTION_RESULT_MESSAGE = "Headers validation error occurs, please check your uuid "
			+ "is correct or not";

	public static final int REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE = 40002;
	public static final String REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_TYPE = "RequestBodyValidationException";
	public static final String REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE = "Please check given request "
			+ "body, it's format is incorrect";

	public static final int METHOD_NOT_VALID_EXCEPTION_RESULT_CODE = 40003;
	public static final String METHOD_NOT_VALID_EXCEPTION_RESULT_TYPE = "HttpRequestMethodNotSupportedException";
	public static final String METHOD_NOT_VALID_EXCEPTION_RESULT_MESSAGE = "Given HTTP method does not support by requested url";
	
}
