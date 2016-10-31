package com.flebie.dataAccessObjects;

import java.util.List;

import com.flebie.classes.LabTest;

public interface LabTestDataAccessInterface {

	public String addLabTests(List<LabTest> listOfLabTests);
	public String addLabTest(LabTest labTest);
	public List<LabTest> getLabTestByName(String labTestName);
	public List<LabTest> getLabTestsByIds(List<String> labTestIds);
	public String updateLabTests(List<LabTest> listOfLabTests);
	public String deleteLabTests(List<LabTest> listOfLabTests);
	
}
