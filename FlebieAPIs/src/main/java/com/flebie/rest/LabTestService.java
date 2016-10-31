package com.flebie.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flebie.classes.GenerateKeys;
import com.flebie.classes.LabTest;

@Path("/json")
public class LabTestService {

	@POST
	@Path("/addLabTest")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addLabTest(LabTest labTest, @QueryParam("accessKey") String accessKey) {
		String decrypted = null;
		try {
			decrypted = new GenerateKeys().decrypt(accessKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Decrypted access key is: "+decrypted);
		labTest.setId(UUID.randomUUID().toString());
		System.out.println("Posted lab test is: "+labTest);
		String encrypted = null;
		try {
			encrypted = new GenerateKeys().encrypt(labTest.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(encrypted).build();
	}
	
	@POST
	@Path("/doLogin")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public Response doLogin(String loginString) {
		
		String decrypted = null;
		try {
			decrypted = new GenerateKeys().decrypt(loginString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Decrypted login key is: "+decrypted);
		if(decrypted.equals("adarsha89:ADAshe89"))
		{
			String sessionKey = null;
			try {
				GenerateKeys generateKeys = new GenerateKeys();
				generateKeys.setKeyValue("MyFirstAccessKey");
				generateKeys.shuffle();
				sessionKey = generateKeys.encrypt(UUID.randomUUID().toString());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return Response.status(200).entity(sessionKey).build();
		}
		else
		{
			return Response.status(200).entity("Failed").build();
		}
		
		
	}
	
	@GET
	@Path("/getCredentials")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String getCredentials(@QueryParam("username") String username, @QueryParam("password") String password ) {
		String encrypted = null;
		try {
			encrypted = new GenerateKeys().encrypt(username+":"+password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encrypted;
	}
	
	
	
	
	@GET
	@Path("/getLabTestByName/{labTestName}")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLabTestByName(@PathParam("labTestName") String labTestName ) {
		
		System.out.println("LabTest parameter is: "+labTestName);
		List<String> tests = new ArrayList<String>();
		tests.add("Test123");
		tests.add("Test1234");
		LabTest labTest = new LabTest( tests, "ALP12", 23, false, 25, "UIXVN2", 15, new Date(), "LAB234", new Date(), false, "alala");
		return Response.status(200).entity(labTest).build();
	}
	
	@POST
	@Path("/getLabTestsByIds")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLabTestsByIds(List<String> labTestIds ) {
		
		System.out.println("LabTest parameter is: "+labTestIds);
		List<String> tests = new ArrayList<String>();
		tests.add("Test123");
		tests.add("Test1234");
		LabTest labTest1 = new LabTest( tests, "ALP12", 23, false, 25, "UIXVN2", 15, new Date(), "LAB234", new Date(), false, "alala");
		LabTest labTest2 = new LabTest( tests, "ALPss12", 23, false, 25, "UIXVLpN2", 15, new Date(), "LAB234", new Date(), false, "alala");
		List<LabTest> labTests = new ArrayList<LabTest>();
		labTests.add(labTest1);
		labTests.add(labTest2);
		return Response.status(200).entity(labTests).build();
	}
	
	@POST
	@Path("/addLabTests")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addLabTests(List<LabTest> labTests, @QueryParam("accessKey") String accessKey) {
		String decrypted = null;
		try {
			decrypted = new GenerateKeys().decrypt(accessKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<String> labTestIds = new ArrayList<String>();
		for(LabTest labTest: labTests )
		{
			labTest.setId(UUID.randomUUID().toString());
			labTestIds.add(labTest.getId());
		}
		
		
		System.out.println("Posted lab test is: "+labTests);
		String encrypted = null;
		try {
			encrypted = new GenerateKeys().encrypt(labTestIds.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Response.status(200).entity(encrypted).build();
	}
}
