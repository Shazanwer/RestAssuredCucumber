package stepDefs;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APITestSteps {

	Response response;
	RequestSpecification request;

	Map<String, Object> MapObj = new HashMap<String, Object>();

	@Given("The Base URI is {string}")
	public void the_Base_URI_is(String URI) {

		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {

		response = request.get();
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
	}

	@Then("GET Response Code should be {int}")
	public void GET_response_Code_should_be(int StatusCode) {

		Assert.assertEquals(response.statusCode(), StatusCode);
	}

	@When("I perform the POST Operation")
	public void i_perform_the_POST_Operation() {

		MapObj.put("name", "Eclipse-Cucumber");
		MapObj.put("salary", "5000");

		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).post("/create");
		String ResponseBody = response.getBody().asString();
		System.out.println(ResponseBody);
	}

	@Then("POST Response Code should be {int}")
	public void POST_response_Code_should_be(int StatusCode) {

		Assert.assertEquals(response.statusCode(), StatusCode);
	}

	@When("I perform the PUT Operation")
	public void i_perform_the_PUT_Operation() {

		MapObj.put("name", "Eclipse-Cucumber-Updated11");
		MapObj.put("salary", "15000");

		response = request.contentType(ContentType.JSON).accept(ContentType.JSON).body(MapObj).put("/17");

	}

	@Then("PUT Response Code should be {int}")
	public void PUT_response_Code_should_be(int StatusCode) {

		Assert.assertEquals(response.getStatusCode(), StatusCode);
	}

	@When("I perform the DELETE Operation")
	public void i_perform_the_DELETE_Operation() {

		response = request.delete("/23");
	}

	@Then("DELETE Response Code should be {int}")
	public void DELETE_response_Code_should_be(int StatusCode) {
		Assert.assertEquals(response.statusCode(), StatusCode);
	}

}
