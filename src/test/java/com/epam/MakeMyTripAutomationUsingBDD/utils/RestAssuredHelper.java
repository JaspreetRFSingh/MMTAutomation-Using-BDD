package com.epam.MakeMyTripAutomationUsingBDD.utils;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredHelper {

	public RequestSpecification sendRequest(String url) {
		RestAssured.baseURI =  url;
		return RestAssured.given();
	}
	
	public int getStatusCode(String url) {
		RequestSpecification httpRequest = sendRequest(url);
		Response response = httpRequest.request(Method.GET);
		return response.getStatusCode();
	}
}
