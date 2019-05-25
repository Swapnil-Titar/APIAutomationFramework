package com.qa.GoogleAPI;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GoogelAPI_IncompelteAddress 
{

	@Test
	public void IncompleteAddr()
	{
      
		
		RestAssured.baseURI="https://maps.googleapis.com";

		Response Resp=given().
				param("query","123+main+street").
				param("location","42.3675294,-71.186966").
				param("radius","10000").
				param("key","AIzaSyBvNFIoNVI1ZPlKJa7T3a9_-rlhndc").   
				when().
				get("/maps/api/place/textsearch/json").   
				then().  
				assertThat().statusCode(200).and().  
				contentType(ContentType.JSON).and().  
				header("content-encoding", "gzip").and().  
				header("server", "scaffolding on HTTPServer2").and().  
				body("status",equalTo("OK")).and().  
				body("results[5].name",equalTo("123 Main St")).and(). 
				body("results[8].formatted_address",equalTo("123 Main St, Concord, MA 01742, USA")).and().
				//     body("results[8].types",equalTo("[street_address]")).and(). 
				extract().
				response();
	
		System.out.println("Response from Raw Format is\t"+Resp);

		String ResponseVariable=Resp.asString();
		System.out.println("Response as String Format is\t"+ResponseVariable);

		Long RespTime=Resp.time();
		System.out.println("Response Time in Mili Second for Request is\t"+RespTime);

		JsonPath js=new JsonPath(ResponseVariable);

		int count=js.get("results.size()");
		System.out.println("Total size is\t"+count);

		for (int i=0;i<count;i++)
		{
			String PlaceName=js.get("results["+i+"].formatted_address");
			System.out.println("Formated Address in JSON Response is\t"+PlaceName);
		}














	}







}
