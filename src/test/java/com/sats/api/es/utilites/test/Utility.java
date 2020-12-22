package com.sats.api.es.utilites.test;

import com.sats.api.es.error.response.ErrorDetails;
import com.sats.api.es.error.response.ErrorResponse;
import com.sats.api.es.error.response.ErrorStatus;
import com.sats.api.es.model.Address;
import com.sats.api.es.model.CurrentStatus;
import com.sats.api.es.model.GeneralStatus;
import com.sats.api.es.model.Location;
import com.sats.api.es.model.Restaurant;
import com.sats.api.es.model.StoreType;
import com.sats.api.es.response.FinalResponse;
import com.sats.api.es.response.Status;

import static com.sats.api.es.config.Constants.*;

import java.util.ArrayList;
import java.util.List;

public class Utility {

	public static Restaurant RestaruantIngestObject() {
		Restaurant restaurant = new Restaurant();
//		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
//		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
//		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}

	public static Restaurant RestaruantReturnObject() {
		Restaurant restaurant = new Restaurant();
		restaurant.setId("195500273006:en-US");
		restaurant.setNationalStoreNumber(1349);
		restaurant.setStoreIdentifierType("NATLSTRNUMBER");
		restaurant.setLocalization("en-US");
		restaurant.setGblNumber("195500273006");
		restaurant.setCountryCode("US");
		restaurant.setMarketCode("US");
		restaurant.setAddress(new Address("USA", "MO", 64119, "Claycomo", "290 E 69 Hwy", "DENVER FIELD OFFICE"));
		restaurant.setGeneralStatus(new GeneralStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setCurrentStatus(new CurrentStatus("OPEN", "26-02-2019", "15-02-2025"));
		restaurant.setLocation(new Location(39.200516, -94.499097));
		restaurant.setStoreType(new StoreType("FREESTANDING", "partyHere"));

		return restaurant;
	}
	
	public static ErrorDetails ErrorDetailsElasticExceptionReturnObject() {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setResultCode(ELASTIC_SEARCH_EXCEPTION_RESULT_CODE);
		errorDetails.setResultType(ELASTIC_SEARCH_EXCEPTION_RESULT_TYPE);
		errorDetails.setResultMessage(ELASTIC_SEARCH_INGEST_EXCEPTION_MESSAGE); 
		return errorDetails;
	}
	
	public static ErrorStatus ErrorStatusServerExceptionReturnObject() {
		ErrorStatus errorStatus = new ErrorStatus();
		List<ErrorDetails> errorList = new ArrayList<>();
		errorList.add(ErrorDetailsElasticExceptionReturnObject());
		errorStatus.setRootCode(SERVER_EXCEPTION_ROOT_CODE);
		errorStatus.setRootType(SERVER_EXCEPTION_ROOT_TYPE);
		errorStatus.setErrorList(errorList);
		return errorStatus;
	}
	
	public static ErrorDetails ErrorDetailsValidationExceptionReturnObject() {
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setResultCode(REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_CODE);
		errorDetails.setResultType(REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE);
		errorDetails.setResultMessage(REQUEST_BODY_VALIDATION_EXCEPTION_RESULT_MESSAGE);
		errorDetails.setHttpMethod(null);
		errorDetails.setHttpRequestURI(null);
		return errorDetails;
	}
	
	public static ErrorStatus ErrorStatusVALIDATIONExceptionReturnObject() {
		ErrorStatus errorStatus = new ErrorStatus();
		List<ErrorDetails> errorList = new ArrayList<>();
		errorList.add(ErrorDetailsValidationExceptionReturnObject());
		errorStatus.setRootCode(VALIDATION_EXCEPTION_ROOT_CODE);
		errorStatus.setRootType(VALIDATION_EXCEPTION_ROOT_TYPE);
		errorStatus.setErrorList(errorList);
		return errorStatus;
	}
	 
	public static ErrorResponse ErrorResponseReturnObject(ErrorStatus status) {
		ErrorResponse errorResponse = new ErrorResponse(status);
		return errorResponse;
	} 
	
	public static Status SuccessStatusObject() {
		Status status = new Status(SUCCESS_ROOT_CODE, SUCCESS_ROOT_TYPE, INGEST_RESTAURANT_SUCCESS_MESSAGE);
		return status;
	}
	
	public static FinalResponse FinalResponseObject(ArrayList<Restaurant> restaurants) {
		FinalResponse finalResponse = new FinalResponse(SuccessStatusObject(), restaurants);
		return finalResponse;
	} 
}
