package apiEngine;

import org.junit.Assert;

import bodyRequests.TokenRequests;
import io.restassured.response.Response;
import managers.ConfigFileReader;

public class SearchPolicy {
	private EndPoints endPoints = new EndPoints(ConfigFileReader.getInstance().getBaseUrl());
	private GenerateToken tokens = new GenerateToken(ConfigFileReader.getInstance().getTokenUrl());
	
	public Response getPolicyInfo(String policyNumber) {	
		TokenRequests tokenRequest = new TokenRequests(ConfigFileReader.getInstance().client_id(),
				ConfigFileReader.getInstance().client_secret(), ConfigFileReader.getInstance().grant_type());
		String token = tokens.genToken(tokenRequest);
		Response response =endPoints.searchPolicy(policyNumber, token);
		Assert.assertEquals(200, response.statusCode());		
		return response;  		
	}
	
	
}
