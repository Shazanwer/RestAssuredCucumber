package stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class APITestSteps {
	
	Response response;
	RequestSpecification request;
	
	@Given("The Base URI is {string}")
	public void the_Base_URI_is(String URI) {
	    // Write code here that turns the phrase above into concrete actions
		request = RestAssured.given().baseUri(URI);
	}

	@When("I perform the Get Operation")
	public void i_perform_the_Get_Operation() {
	    // Write code here that turns the phrase above into concrete actions
		response = request.get();
	}

	@Then("Response Code should be {int}")
	public void response_Code_should_be(Integer StatusCode) {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(response.statusCode(), 200);
	}

}
