package com.qa.JiraAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import com.qa.utlis.GenerateSessionId;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import resources.JIRAPayload;

public class JIRA_ProjectIssue extends Jira_Login
{
	String IssueNo,commentid;
	
	@Test(priority=5,description="Create Issue in JIRA Tool")
	public void CreateIssue()
	{
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		Response resp=given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.CreateIssuePayload()).log().all().
		when().
		post("/rest/api/2/issue").
		then().
		assertThat().statusCode(201).extract().response();
		
		String IssueId=resp.asString();
		
		JsonPath js=new JsonPath(IssueId);
		IssueNo=js.get("id");
		
		logger.info("Issue Created with id \t"+IssueNo);

	}
	
	@Test(priority=6,description="Assign Bug to user")
	public void AssignIssue()
	{
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
	
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.AssignIssuePayload()).log().all().
		when().
		put("/rest/api/2/issue/"+IssueNo+"/assignee").
		then().assertThat().statusCode(204).and().
		contentType(ContentType.JSON).and().
		header("x-ausername", "ankurj").
		log().all();
		
		logger.info("Bug has been assigned to Right user");
		
	}
	
	@Test(priority=7,description="Create Comment to Bug")
	public void CreateComment()
	{
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		Response resp=given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.CreateCommentPayload()).log().all().
		when().
		post("/rest/api/2/issue/"+IssueNo+"/comment").
		then().assertThat().statusCode(201).and().
		contentType(ContentType.JSON).and().
		header("x-ausername", "ankurj").
		log().all().
		extract().response();
		
		String commid=resp.asString();
		JsonPath js=new JsonPath(commid);
		
		commentid=js.get("id");
		
		logger.info("Bug has been update with comment id \t"+commentid);
	}
	
	@Test(priority=8,description="Update Defect with new Comment")
	public void UpdateComment()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.updateCommentPayload()).log().all().
		when().
		put("/rest/api/2/issue/"+IssueNo+"/comment/"+commentid).
		then().assertThat().statusCode(200).and().
		contentType(ContentType.JSON).and().
		header("vary", "User-Agent").log().all();
		logger.info("Defect has been updated with new comment \t"+IssueNo);
		
		
		
	}
	
	@Test(priority=9,description="Remove Watcher from Bug")
	public void RemoveWatcher()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		delete("/rest/api/2/issue/"+IssueNo+"/watchers?username=ankurj").then().
		assertThat().statusCode(204).log().all();
		
		
		logger.info("Watcher has been sucesfully Removed from Defect id \t"+IssueNo);
		
	}
	
	@Test(priority=10,description="Add watcher into Defect")
	public void AddWatcher()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).
		body(JIRAPayload.AddWatcherPayload()).log().all().
		when().
		post("/rest/api/2/issue/"+IssueNo+"/watchers").then().
		assertThat().statusCode(204).log().all();
		
		
		logger.info("Watcher has been sucesfully Added into Defect id");
		
	}
	
	@Test(priority=11,description="Get Watcher in the Bug")
	public void GetWatcher()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		get("/rest/api/2/issue/"+IssueNo+"/watchers").
		then().
		assertThat().statusCode(200).and().
		body("isWatching",equalTo(true)).
		log().all();
		
		logger.info("Watcher is there in the issue");
		
	}
	
	@Test(priority=12,description="Add Voter to Issue")
	public void AddVote()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		post("/rest/api/2/issue/"+IssueNo+"/votes").
		then().
		assertThat().statusCode(404).and().
		log().all();
		
		logger.info("You cannot vote for an issue you have reported");
		
	}
	
	
	@Test(priority=13,description="Remove Comment from Bug")
	public void RemoveComment()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		delete("/rest/api/2/issue/"+IssueNo+"/comment/"+commentid).
		then().
		assertThat().statusCode(204).and().
		log().all();
		
		logger.info("Comment has been removed from the issue \t"+IssueNo);
		
	}
	
	@Test(priority=14,description="Remove Bug from JIRA")
	public void RemoveIssue()
	{
		
		RestAssured.baseURI=pro.getProperty("JIRAHOST");
		
		given().
		header("Content-Type","application/json").
		header("cookie","JSESSIONID="+GenerateSessionId.JIRALogin()).log().all().
		when().
		delete("/rest/api/2/issue/"+IssueNo).
		then().
		assertThat().statusCode(204).and().
		log().all();
		
		logger.info(IssueNo+"\t issue has been removed from JIRA");
		
	}
	
	
	
	
}
