package com.qa.utlis;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GenerateSessionId 
{

	public static String JIRALogin()
	{
		
		RestAssured.baseURI="http://localhost:8090";
	
	Response Resp=given().
		header("Content-Type","application/json").  
		body("{ \"username\": \"ankurj\", \"password\": \"Manish42#\" } ").
		when().
		post("/rest/auth/1/session").  
		then().assertThat().statusCode(200). 
		extract(). 
		response();
	
	String ResponseVariable=Resp.asString();
	System.out.println("Response as String Format is\t"+ResponseVariable);

	Long RespTime=Resp.time();
	System.out.println("Response Time in Mili Second for Request is\t"+RespTime);

	JsonPath js=new JsonPath(ResponseVariable);
	String Sessionid1=js.get("session.value");
	System.out.println("Value of Session id is"+Sessionid1);
	return Sessionid1;

	}
	
	
}
