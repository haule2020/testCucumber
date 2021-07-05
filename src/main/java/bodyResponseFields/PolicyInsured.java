package bodyResponseFields;

import java.util.List;

//POJO class to store fields and values converted from  body response JSON file
public class PolicyInsured {
	public String clientNumber;
	public String clientName;
	public String birthdate;
	public String sexCode;
	public String mcIndicator;
	public String idNumber;
	public List<Coverages> coverages;
}
