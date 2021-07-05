package stepDefinitions;

import org.junit.Assert;
import apiEngine.SearchPolicy;
import bodyResponseFields.BodyResponse;
import cucumber.api.java.en.Given;
import io.restassured.response.Response;
import shareContext.TestContext;

public class VerifyPOLICY_OWNER extends BaseSteps {

	public VerifyPOLICY_OWNER(TestContext testContext) {
		super(testContext);
	}

	private Response response;
	private BodyResponse body;

	@Given("^I search a policy \"([^\"]*)\"$")
	public void iSearchAPolicy(String policyNumber) throws Throwable {
		SearchPolicy search = new SearchPolicy();
		response = search.getPolicyInfo(policyNumber);
		body = response.body().as(BodyResponse.class);	
	}
	@Given("^I get correct clientNumber \"([^\"]*)\"$")
	public void iGetCorrectClientNumber(String clientNumber) throws Throwable {			
	    String clientNum = body.policyOwner.clientNumber;
	    Assert.assertEquals(clientNumber, clientNum);
	   
	}

	@Given("^I get correct clientName$")
	public void iGetCorrectClientName() throws Throwable {
	    String clientNm = body.policyOwner.clientName;
	    Assert.assertNotEquals(0, clientNm.length());
	}

	@Given("^I get correct idNumber$")
	public void iGetCorrectIdNumber() throws Throwable {
	    String idNumber = body.policyOwner.idNumber;
	    Assert.assertNotEquals(0, idNumber.length());  
	}

	@Given("^I get correct idIssueDate$")
	public void iGetCorrectIdIssueDate() throws Throwable {
	    String issueDate = body.policyOwner.idIssueDate;
	    Assert.assertEquals(8, issueDate.length());
	   
	}

	@Given("^I get correct idIssuePlace$")
	public void iGetCorrectIdIssuePlace() throws Throwable {
	    String issuePlace= body.policyOwner.idIssuePlace;
	    Assert.assertNotEquals(0, issuePlace.length());
	   
	}

	@Given("^I get correct sexCode$")
	public void iGetCorrectSexCode() throws Throwable {
	    String sexCode= body.policyOwner.sexCode; 
	    Assert.assertTrue(sexCode.equalsIgnoreCase("F") || sexCode.equalsIgnoreCase("M"));
	}

	@Given("^I get correct birthdate$")
	public void iGetCorrectBirthdate() throws Throwable {
	    String birthdate= body.policyOwner.birthdate;
	    Assert.assertEquals(8, birthdate.length());
	   
	}

	@Given("^I get correct vipInd$")
	public void iGetCorrectVipInd() throws Throwable {
		  String vipInd= body.policyOwner.vipInd;
		  Assert.assertEquals(1, vipInd.length());
	   
	}
	

}
