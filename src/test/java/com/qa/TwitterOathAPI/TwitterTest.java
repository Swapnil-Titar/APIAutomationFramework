package com.qa.TwitterOathAPI;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import com.qa.JiraAPI.Jira_Login;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class TwitterTest extends Jira_Login
{
	String ConsumerKey="wuIhdFqFSnTYh5UEIJuBrRsj8";
	String ConsumerSecret="HJlxEv9NiO2u9VcIPiYtNGSkhpanf3dYpdlAfcfIEsbQXi";
	String Token="112083056-ebVpYLwZkO2zLC2nZnkXNONWCV1X7gIvUKe0M";
	String TokenSecret="QGTePhgEV08mV6wSNTWiNMiud2OnrA0Xu5Ydm0FTq";
	String Tweetid,id1;

	@Test(priority=1,description="Create a Tweet")
	public void CreateTweet()
	{
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

		Response Resp=	given().
				auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				queryParam("status", "New Tweet1").log().all().
				when().
				post("/update.json").
				then().assertThat().statusCode(200).log().all().
				extract().response();
		System.out.println("Hi");

		String CreateTwe=Resp.asString();
		JsonPath js=new JsonPath(CreateTwe);

		logger.info("id is"+js.get("id"));

		Tweetid=(js.get("id")).toString();

		logger.info("Id of newly Created Tweet is \t"+Tweetid);

	}

	@Test(priority=2,description="Delete a Tweet")
	public void DeleteTweet()
	{
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses";

		Response Resp=	given().
				auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				when().
				post("/destroy/"+Tweetid+".json").
				then().assertThat().statusCode(200).log().all().
				extract().response();

		String DelTwe=Resp.asString();
		JsonPath js1=new JsonPath(DelTwe);

		logger.info("Delted Tweet id is"+js1.get("id"));

		id1=(js1.get("id")).toString();
		
		logger.info("Tweet has been Delted Sucesfully\t"+id1);

	}
}
