package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import shareContext.TestContext;

public class CheckResponseTime extends BaseSteps {
	private long actualResponseTime;
	public CheckResponseTime(TestContext testContext) {
		super(testContext);
	}
	@Given("^I call the API \"([^\"]*)\"$")
	public void iCallTheAPI(String policyNumber) throws Throwable {
		// Call server to get response time
		actualResponseTime = getEndPoints().getResponseTime(policyNumber);		
	}
	@Then("^response time should not exceed \"([^\"]*)\" miliseconds$")
	public void response_time_should_not_exceed_seconds(String arg1) {
		// Check that actualResponseTime should < timeExpected
		long timeExpected = Long.valueOf(arg1);
		Assert.assertFalse(actualResponseTime > timeExpected);
	}
}
