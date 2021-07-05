//API engine pachge
package apiEngine;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.ConfigFileReader;

//API request methods used in the test
public class EndPoints {

	private final RequestSpecification request;
	public Response response;
	private final String searchPath = ConfigFileReader.getInstance().searchPath();

	public EndPoints(final String baseUrl) {
		RestAssured.baseURI = baseUrl;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	public Response searchPolicy(String policyNumber, String token) {
		request.header("Authorization", "Bearer " + token);
		return response = request.get(searchPath + policyNumber);
	}

	// Function call api request to get ResponseTime
	public long getResponseTime(String policyNumber) {
		long responseTime = request.get(searchPath + policyNumber).timeIn(TimeUnit.MILLISECONDS);
		return responseTime;
	}
}
