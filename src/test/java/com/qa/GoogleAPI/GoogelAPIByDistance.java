package com.qa.GoogleAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GoogelAPIByDistance
{
	Response Resp;

	@Test(priority=1,description="Validation of Basic JSON Request")
	public void FirstAPITest()
	{

		RestAssured.baseURI ="https://maps.googleapis.com";

		Resp=given().
				param("placeid","ChIJN1t_tDeuEmsRUsoyG83frY4").
				param("fields","name,rating,formatted_phone_number").
				param("key","AIzaSyBvNFIoSqZPlKJa7T3a9_-rlhndc").
				when().
				get("/maps/api/place/details/json").
				then().
				assertThat().statusCode(200).and().
				contentType(ContentType.JSON).and().
				header("Server", "scaffolding on HTTPServer2").and().
				header("Content-length","149").and().
				header("content-encoding","gzip").and(). 
				body("status",equalTo("OK")).and(). 
				body("result.name",equalTo("Google")).and(). 
				
				
				
				
			//	body(("result.rating").trim(),equalTo("4.2")).and().
				extract(). 
				response();
		
	//	System.out.println(" RESP : " +Resp.toString());
		
	//	System.out.println(" RESP : " +Resp);
		
	//	String res=Resp.asString();
		
		//JsonPath js=new JsonPath(res);
		//System.out.println(" RESP : " +res);
		
		

	}

	@Test(priority=2,description="Validation of Basic Complete JSON Response")
	public void SecondAPITest()
	{
		System.out.println("Reponse of JSON File is"+Resp.asString());
	}

	@Test(priority=3,description="Validation of Time Taken By JSON Request")
	public void ThirdAPITest()
	{
		Long Time=Resp.time();
		System.out.println("Response Code for health Check API is "+Time + "MiliSecond");
	}


}










