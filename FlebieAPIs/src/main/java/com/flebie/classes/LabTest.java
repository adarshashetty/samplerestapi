package com.flebie.classes;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class LabTest {

	String id;
	List<String> tests;
	String labId;
	Integer price;
	Boolean isADrive;
	Integer listPrice;
	String testId;
	Integer cost;
	Date updatedAt;
	String labName;
	Date createdAt;
	Boolean isPopularPkg;
	String testName;
	
	public LabTest() {
		// TODO Auto-generated constructor stub
	}
  public LabTest(List<String> tests, String labId, Integer price, Boolean isADrive, Integer listPrice, String testId, Integer cost, Date updatedAt, String labName, Date createdAt, Boolean isPopularPkg, String testName) {
	this.id = UUID.randomUUID().toString();
	this.tests = tests;
	this.labId = labId;
	this.price = price;
	this.isADrive = isADrive;
	this.listPrice = listPrice;
	this.testId = testId;
	this.cost = cost;
	this.updatedAt = updatedAt;
	this.labName = labName;
	this.createdAt = createdAt;
	this.isPopularPkg = isPopularPkg;
	this.testName = testName;
	}
  public void setId(String id) {
	this.id = id;
}
  public String getId() {
	return id;
}
  public void setTests(List<String> tests) {
	this.tests = tests;
}
  public List<String> getTests() {
	return tests;
}
  public void setLabId(String labId) {
	this.labId = labId;
}
  public String getLabId() {
	return labId;
}
  public void setPrice(Integer price) {
	this.price = price;
}
  public Integer getPrice() {
	return price;
}
  
  public void setIsADrive(Boolean isADrive) {
	this.isADrive = isADrive;
}
  public Boolean getIsADrive() {
	return isADrive;
}
  public void setListPrice(Integer listPrice) {
	this.listPrice = listPrice;
}
  public Integer getListPrice() {
	return listPrice;
}
  public void setTestId(String testId) {
	this.testId = testId;
}
  public String getTestId() {
	return testId;
}
  public void setCost(Integer cost) {
	this.cost = cost;
}
  public Integer getCost() {
	return cost;
}
  public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}
  public Date getUpdatedAt() {
	return updatedAt;
}
  public void setLabName(String labName) {
	this.labName = labName;
}
  public String getLabName() {
	return labName;
}
  public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}
  public Date getCreatedAt() {
	return createdAt;
}
  public void setIsPopularPkg(Boolean isPopularPkg) {
	this.isPopularPkg = isPopularPkg;
}
  public Boolean getIsPopularPkg() {
	return isPopularPkg;
}
  public void setTestName(String testName) {
	this.testName = testName;
}
  public String getTestName() {
	return testName;
}
  @Override
public String toString() {
	// TODO Auto-generated method stub
	return id+""+tests+labId+price;
}
  
}
