package Rest;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostDetails 
{
	@Test
	public void PostWeatherDetails()
	{
		 RestAssured.baseURI ="https://reqres.in";
		 RequestSpecification request = RestAssured.given();
		 
		 JSONObject requestParams = new JSONObject();
		 requestParams.put("name", "morpheus");
		 requestParams.put("job", "leader");
		 //requestParams.put("title", "Test");
		 //requestParams.put("body", "For testing"); 
		 
		 request.body(requestParams.toJSONString());
		 Response response = request.post("/api/users/");
		 
		 
		 Response response1 = request.get("/api/users/");
		 int statusCode = response.getStatusCode();
		 System.out.println("The status code recieved: " + statusCode);
		 
		 System.out.println("Response body: " + response.body().asString());
		 
		 System.out.println("Response body: " + response1.body().asString());
	 }

}
