package restassured;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class Restsample {

	@Test(description = "Test simple GET request and number of responces one ", priority = 1)
	public void testsample() {
		Response res = get("https://reqres.in/api/users?page=2");

		System.out.println(res.getStatusCode());
		System.out.println(res.getTime());
		System.out.println(res.getContentType());
		System.out.println(res.header("content-type"));
		System.out.println(res.getBody());
		System.out.println(res.getTime());
		int statuscode = res.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}

	@Test(description = "Test number two GET request with status and given when format", priority = 2)
	public void testsmaple2() {
		get("https://reqres.in/api/users?page=2").then().statusCode(201);
	}

	@Test(description = "Test the 3rd with  GET Given when and body part validations", priority = 3)
	public void testsmaple3() {
		given().get("https://reqres.in/api/users?page=1").then().statusCode(200).body("data.id[1]", equalTo(2)).and()
				.body("data.first_name", hasItems("Janet"));
		// .log().all();

	}

	@Test(description = "Try the POST request ", priority = 4)
	public void testpost() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Swapnil");
		map.put("Job", "Engg");
		System.out.println(map);

		JSONObject req = new JSONObject();

		req.put("name", "Swapnil");
		req.put("Job", "Engg");
		given().body(req.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();

	}

	@Test(description = "Try the PUT request ", priority = 5)
	public void testput() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Swapnil");
		map.put("Job", "Engg");
		System.out.println(map);

		JSONObject req = new JSONObject();

		req.put("name", "Swapnil");
		req.put("Job", "Engg");
		given().body(req.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();

	}

	@Test(description = "Try the PATCH request ", priority = 6)
	public void testpatch() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Swapnil");
		map.put("Job", "Engg");
		System.out.println(map);

		JSONObject req = new JSONObject();

		req.put("name", "Swapnil");
		req.put("Job", "Engg");
		given().body(req.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}

	@Test(description = "Try the DELETE request ", priority = 7)
	public void testdelete() {
		/*Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "Swapnil");
		map.put("Job", "Engg");
		System.out.println(map);

		JSONObject req = new JSONObject();

		req.put("name", "Swapnil");
		req.put("Job", "Engg");*/
		
		given()
		.delete("https://reqres.in/api/users/2").then().statusCode(204).log()
				.all();

	}
}
