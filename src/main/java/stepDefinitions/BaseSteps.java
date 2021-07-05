package stepDefinitions;

import apiEngine.EndPoints;
import apiEngine.GenerateToken;
import shareContext.TestContext;

public class BaseSteps {

	private EndPoints endPoints;
	private GenerateToken tokens;
	
	// Base steps to be extended in other test steps
	public BaseSteps(TestContext testContext) {
		endPoints = testContext.getEndPoints();
		tokens =testContext.getToken();
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}
	
	public GenerateToken getTokens() {
		return tokens;
	}
}
