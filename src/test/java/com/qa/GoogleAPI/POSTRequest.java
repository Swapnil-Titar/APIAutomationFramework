package com.qa.GoogleAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class POSTRequest 
{

	String bo=" '   {  '  + \r\n" + 
			" '       \"name\": \"morpheus\",  '  + \r\n" + 
			" '       \"job\": \"leader\"  '  + \r\n" + 
			" '  }  ' ; ";

	@Test
	public void RegisterUserPOSTAPI()
	{

		RestAssured.baseURI="https://reqres.in";

		String Resp=given().
				body("bo").
				when().
				post("/api/users").
				then().assertThat(). 
				statusCode(201).and().
				contentType(ContentType.JSON).and().
				header("server", "cloudflare").and(). 
				header("content-length", "51").
				extract().
				response().asString();

		System.out.println("Response is\t"+Resp);






	}






}
