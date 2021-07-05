package apiEngine;

import org.apache.http.HttpStatus;

import bodyRequests.TokenRequests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.ConfigFileReader;

public class GenerateToken {

	private RequestSpecification request;
	private final String tokenUrlpath = ConfigFileReader.getInstance().getTokenUrlPath();

	public GenerateToken(String url) {
		RestAssured.baseURI = url;
		request = RestAssured.given();
		request.header("Content-Type", "application/json");
	}

	public String genToken(TokenRequests tokenRequest) {
		Response response = request.body(tokenRequest).post(tokenUrlpath);
		if (response.statusCode() != HttpStatus.SC_OK)
			throw new RuntimeException(
					"Authentication failed. " + response.asString() + ", Status code: " + response.statusCode());
		String responseString = response.asString();
		String token = JsonPath.from(responseString).get("token");
		// System.out.println(token);
		return token;
	}
}
