package bodyResponseFields;

import java.util.List;

//POJO class to store fields and values converted from  body response JSON file
public class Coverages {	
	public String coverageEffectiveDate;
	public String coverageIssueDate;
	public String coverageXpryDate;
	public String coverageCode;
	public String mcStatusCode;
	public String mcEffectiveDate;
	public String coverageClass;
	public String coverageStatusCode;
	public Float coveragePrem;
	public String coverageLapseDate;
	public String coverageReinstateDate;
	public String coverageDeleteDate;
	public String planCode;
	public List<CoverageHistory> coverageHistories;
}
