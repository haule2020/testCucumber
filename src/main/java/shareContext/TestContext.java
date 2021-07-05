package shareContext;

import apiEngine.EndPoints;
import apiEngine.GenerateToken;
import managers.ConfigFileReader;

public class TestContext {

	private EndPoints endPoints = new EndPoints(ConfigFileReader.getInstance().getBaseUrl());
	private GenerateToken tokens = new GenerateToken(ConfigFileReader.getInstance().getTokenUrl());
	
	public TestContext() {
	}

	public EndPoints getEndPoints() {
		return endPoints;
	}
	
	public GenerateToken getToken() {
		return tokens;
	}

}
