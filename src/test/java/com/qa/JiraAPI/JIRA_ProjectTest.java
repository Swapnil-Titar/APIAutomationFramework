package com.qa.JiraAPI;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.qa.utlis.GenerateSessionId;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.JIRAPayload;
import resources.JIRAResources;

public class JIRA_ProjectTest extends Jira_Login
{
	int Proid;
	String Proid1;

	@Test(priority=2,description="Creation of JIRA Project")
	public void JIRAProjectCreation()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		//Creating JIRA Project
		Response resp=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.JIRAProjectCreationPayload()).log().all().
		when().
		post(JIRAResources.Res1()).
		then().assertThat().statusCode(201).log().all().
		extract().response();
		
		String Projectid=resp.asString();
		
		logger.info("Project id string is"+Projectid);
		
		JsonPath js=new JsonPath(Projectid);
		 Proid=js.get("id");
		 logger.info("==========New Project Created with id=======\t"+Proid);
	}
	
	@Test(priority=3,description="Updation of JIRA Project")
	public void UpdateProject()
	{
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		//Updating JIRA Project
		Response Resp1=given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.JIRAProjectUpdatePayload()).log().all().
		when().
		put("/rest/api/2/project/"+Proid).
		then().assertThat().statusCode(200).extract().response();
		
		String UpdateBo=Resp1.asString();
		JsonPath js1=new JsonPath(UpdateBo);
		
		Proid1=js1.get("id");
		logger.info("======Project id======= \t"+Proid1+"\t updated");
		
	}
	
	@Test (priority=4,description="Deletion of JIRA Project")
	public void DeleteProject()
	{
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		//Deleting JIRA Project
		given().
		header("Content-Type","application/json").
		header("Cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		delete("/rest/api/2/project/"+Proid1).
		then().assertThat().statusCode(204).log().all();
		
		logger.info("=======Project id======= \t"+Proid1+"\t Deleted Sucesfully");
		
	}
		
		
	}
	

	

	
		
	
	
	
	
	
	
	
	

