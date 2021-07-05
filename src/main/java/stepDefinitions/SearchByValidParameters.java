package stepDefinitions;

import org.junit.Assert;
import bodyRequests.TokenRequests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import managers.ConfigFileReader;
import shareContext.TestContext;

public class SearchByValidParameters extends BaseSteps {

	public SearchByValidParameters(TestContext testContext) {
		super(testContext);
	}

	private Response response;
	private String token;

	@Given("^I already get authorization$")
	public void iAlreadyAuthorozied() throws Throwable {		
		TokenRequests tokenRequest = new TokenRequests(ConfigFileReader.getInstance().client_id(), ConfigFileReader.getInstance().client_secret(), ConfigFileReader.getInstance().grant_type());
		token=  getTokens().genToken(tokenRequest); 
	}
	@When("^I call API to search by inputing valid policy number \"([^\"]*)\"$")
	public void iCallAPIToSearchByInputingValidPolicyNumber(String policyNumber) throws Throwable {	
		response = getEndPoints().searchPolicy(policyNumber, token);
	}

	@Then("^system response with status code \"([^\"]*)\"$")
	public void systemResponseWithStatusCode(String statusCode) throws Throwable {
		int code = Integer.valueOf(statusCode);		
		Assert.assertEquals(code, response.statusCode());    
	}

}
