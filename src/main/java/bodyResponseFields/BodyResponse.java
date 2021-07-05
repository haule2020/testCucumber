package bodyResponseFields;

import java.util.List;

//POJO class to store fields and values converted from  body response JSON file
public class BodyResponse {
	
	//List of field names coverted from body reponse 
	public Policy policy;
	public PolicyOwner policyOwner;
	public List<PolicyInsured> policyInsureds;
}
