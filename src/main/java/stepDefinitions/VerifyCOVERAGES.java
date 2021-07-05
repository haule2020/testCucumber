package stepDefinitions;


import org.junit.Assert;

import apiEngine.SearchPolicy;
import bodyResponseFields.BodyResponse;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import shareContext.TestContext;

public class VerifyCOVERAGES extends BaseSteps {

	public VerifyCOVERAGES(TestContext testContext) {
		super(testContext);
	}

	private Response response;
	private BodyResponse body;

	
	@Given("^I can search policy's COVERAGES \"([^\"]*)\"$")
	public void iCanSearchPolicySCOVERAGES(String policyNumber) throws Throwable {
	   SearchPolicy search = new SearchPolicy();
	   response = search.getPolicyInfo(policyNumber);
	   body =response.body().as(BodyResponse.class);	   
	}
	@Then("^I get coverageEffectiveDate \"([^\"]*)\"$")
	public void iGetCoverageEffectiveDate(String coverageEffectiveDate) throws Throwable {
	   String cvgEffDt = body.policyInsureds.get(0).coverages.get(0).coverageEffectiveDate;
	   Assert.assertEquals(coverageEffectiveDate, cvgEffDt);	    
	}
	@Then("^I get coverageIssueDate$")
	public void iGetCoverageIssueDate() throws Throwable {
		   String coverageIssueDate = body.policyInsureds.get(0).coverages.get(0).coverageIssueDate;
		   Assert.assertEquals(8, coverageIssueDate.length());	    
	}
	@Then("^I get coverageXpryDate$")
	public void iGetCoverageXpryDate() throws Throwable {
		   String coverageXpryDate = body.policyInsureds.get(0).coverages.get(0).coverageXpryDate;	
		   Assert.assertEquals(8, coverageXpryDate.length());	
	}
	@Then("^I get coverageCode$")
	public void iGetCoverageCode() throws Throwable {
		 String coverageCode = body.policyInsureds.get(0).coverages.get(0).coverageCode;	  
		 Assert.assertTrue( coverageCode.length() >0);	 
	}
	@Then("^I get mcStatusCode \"([^\"]*)\"$")
	public void iGetMcStatusCode(String ExpectedMcStatusCode) throws Throwable {
		 String mcStatusCode = body.policyInsureds.get(0).coverages.get(0).mcStatusCode;	 
		 Assert.assertEquals(ExpectedMcStatusCode, mcStatusCode);     
	}
	@SuppressWarnings("unused")
	@Then("^I get mcEffectiveDate$")
	public void iGetMcEffectiveDate() throws Throwable {
		 String mcEffectiveDate = body.policyInsureds.get(0).coverages.get(0).mcEffectiveDate;
			 
	}
	@Then("^I get coverageClass$")
	public void iGetCoverageClass() throws Throwable {	   
		 String coverageClass = body.policyInsureds.get(0).coverages.get(0).coverageClass;
		  Assert.assertEquals(1, coverageClass.length());	
	}
	@Then("^I get coverageStatusCode \"([^\"]*)\"$")
	public void iGetCoverageStatusCode(String coverageStatusCode) throws Throwable {
		 String cvgStatusCode = body.policyInsureds.get(0).coverages.get(0).coverageStatusCode; 		 
		 Assert.assertEquals(coverageStatusCode, cvgStatusCode);	    
	}

	@Then("^I get coveragePrem;$")
	public void iGetCoveragePrem() throws Throwable {
		 Float coveragePrem = body.policyInsureds.get(0).coverages.get(0).coveragePrem;		 
		 Assert.assertTrue(coveragePrem>0);		   	    
	}
}
