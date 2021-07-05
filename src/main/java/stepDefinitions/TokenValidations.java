package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import shareContext.TestContext;

public class TokenValidations extends BaseSteps {
	
	public TokenValidations(TestContext testContext) {
		super(testContext);
	}

	private Response response;

	@Given("^I search policyNumber \"([^\"]*)\" with invalid token \"([^\"]*)\"$")
	public void iSearchPolicyNumberWithInvalidToken(String policyNumber, String token) throws Throwable {
		response =  getEndPoints().searchPolicy(policyNumber, token);	   
	}

	@Then("^I get statusCode \"([^\"]*)\"$")
	public void iGetStatusCode(int statusCode) throws Throwable {
		Assert.assertEquals(statusCode, response.statusCode());
	    
	}

	@Then("^I get error message \"([^\"]*)\"$")
	public void iGetErrorMessage(String errorMessage) throws Throwable {
		String message = response.jsonPath().get("error");
		Assert.assertEquals(errorMessage.toLowerCase(), message.toLowerCase());
	    
	}


}
