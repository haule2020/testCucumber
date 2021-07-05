package stepDefinitions;


import org.junit.Assert;
import apiEngine.SearchPolicy;
import bodyResponseFields.BodyResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import shareContext.TestContext;

public class VerifyPOLICYItems extends BaseSteps {

	public VerifyPOLICYItems(TestContext testContext) {
		super(testContext);
	}

	private Response response;
	private BodyResponse body;

	@Given("^I can search a policy \"([^\"]*)\"$")
	public void iCanSearchAPolicy(String policyNumber) throws Throwable {
		SearchPolicy search = new SearchPolicy();
		response = search.getPolicyInfo(policyNumber); 
	}

	@Then("^I get correct policyNumber \"([^\"]*)\"$")
	public void iGetCorrectPolicyNumber(String policyNumber) throws Throwable {
	body = response.body().as(BodyResponse.class);		
	String polNum = body.policy.policyNumber;
	Assert.assertEquals(policyNumber, polNum);    
	}

	@Then("^I get correct excludeInfo$")
	public void iGetCorrectExcludeInfo() throws Throwable {
		String excludeInfo = body.policy.excludeInfo;	
		Assert.assertNotEquals(0, excludeInfo.length());	    
	}

	@Then("^I get correct bancaInd$")
	public void iGetCorrectBancaInd() throws Throwable {
		String bancaInd = body.policy.bancaInd;	
		Assert.assertEquals(1, bancaInd.length());
	    
	}
	@Then("^I get correct agentCode \"([^\"]*)\"$")
	public void iGetCorrectAgentCode(String agentCode) throws Throwable {
		String agCode= body.policy.agentCode;
		Assert.assertEquals(agentCode, agCode);	    
	}

	@Then("^I get correct agentMobile$")
	public void iGetCorrectAgentMobile() throws Throwable {
		String agentMobile= body.policy.agentMobile;  
		Assert.assertTrue(agentMobile.length()>0);
	}

	@Then("^I get correct agentName$")
	public void iGetCorrectAgentName() throws Throwable {
		String agentName= body.policy.agentName;
		Assert.assertTrue(agentName.length()>0);
	}

	@Then("^I get correct locationCode$")
	public void iGetCorrectLocationCode() throws Throwable {
		String locationCode= body.policy.locationCode; 
		Assert.assertEquals(5, locationCode.length());
	}

	@Then("^I get correct gracePeriod$")
	public void iGetCorrectGracePeriod() throws Throwable {
		String gracePeriod = body.policy.gracePeriod;
		Assert.assertEquals(1, gracePeriod.length());	    	    
	}

	@Then("^I get correct ostPrem$")
	public void iGetCorrectOstPrem() throws Throwable {
		Float ostPrem = body.policy.ostPrem;
		Assert.assertTrue(ostPrem>=0);
	}
			
}
