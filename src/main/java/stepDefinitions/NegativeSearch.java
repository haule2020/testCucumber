package stepDefinitions;

import org.junit.Assert;
import bodyRequests.TokenRequests;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.ConfigFileReader;
import shareContext.TestContext;

public class NegativeSearch extends BaseSteps {

	public NegativeSearch(TestContext testContext) {
		super(testContext);
	}

	Response response;
	RequestSpecification request;
	String token;

	@Given("^I already authorozied$")
	public void iAlreadyAuthorozied() throws Throwable {
		TokenRequests tokenRequest = new TokenRequests(ConfigFileReader.getInstance().client_id(),
				ConfigFileReader.getInstance().client_secret(), ConfigFileReader.getInstance().grant_type());
		token = getTokens().genToken(tokenRequest);
	}

	@When("^I call API to search by inputing invalid policy number \"([^\"]*)\"$")
	public void iCallAPIToSearchByInputingInvalidPolicyNumber(String policyNumber) throws Throwable {
		response = getEndPoints().searchPolicy(policyNumber, token);

	}

	@Then("^system response no content with status code \"([^\"]*)\"$")
	public void systemResponseNoContentWithStatusCode(String statusCode) throws Throwable {
		int code = Integer.valueOf(statusCode);
		Assert.assertEquals(code, response.statusCode());
	}

}
