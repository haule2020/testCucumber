package stepDefinitions;

import org.junit.Assert;

import apiEngine.SearchPolicy;
import bodyResponseFields.BodyResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import shareContext.TestContext;

public class VerifyPOLICY_INS extends BaseSteps {

	public VerifyPOLICY_INS(TestContext testContext) {
		super(testContext);
	}

	private Response response;
	private BodyResponse body;

	@Given("^I can get response of policyNumber \"([^\"]*)\"$")
	public void iCanGetResponseOfPolicyNumber(String policyNumber) throws Throwable {
	    SearchPolicy search = new SearchPolicy();
	    response =  search.getPolicyInfo(policyNumber);	
	    body = response.body().as(BodyResponse.class);
	    
	}

	@Then("^I get clientNumber \"([^\"]*)\"$")
	public void iGetClientNumber(String clientNumber) throws Throwable {
	    String cliNum = body.policyInsureds.get(0).clientNumber;
	    Assert.assertEquals(clientNumber, cliNum);
	}

	@Then("^I get clientName$")
	public void iGetClientName() throws Throwable {
		   String clientName = body.policyInsureds.get(0).clientName;
		    Assert.assertTrue(clientName.length()>0);
	    
	}

	@Then("^I get birthdate$")
	public void iGetBirthdate() throws Throwable {
		String birthdate = body.policyInsureds.get(0).birthdate;
	    Assert.assertEquals(8,birthdate.length());
	    
	}

	@Then("^I get sexCode$")
	public void iGetSexCode() throws Throwable {
		String sexCode= body.policyInsureds.get(0).sexCode;
	    Assert.assertTrue(sexCode.equalsIgnoreCase("M")||sexCode.equalsIgnoreCase("F") );
	    
	}

	@Then("^I get idNumber$")
	public void iGetIdNumber() throws Throwable {
	    
		String idNumber = body.policyInsureds.get(0).idNumber;
	    Assert.assertTrue(idNumber.length()>0);
	}


	
}
