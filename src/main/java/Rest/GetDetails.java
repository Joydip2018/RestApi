package Rest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDetails 
{
	@Test
	 public void GetWeatherDetails()
	 {   
		 // Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://reqres.in";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a request to the server by specifying the method Type and the method URL.
		 // This will return the Response from the server. Store the response in a variable.
		 Response response = httpRequest.request(Method.GET, "api/users/2");	
		 
		 String str = response.header("Content-Type");
		 String str1 = response.header("Server");
		 String str2 = response.header("Content-Encoding");
		 
		 System.out.println(str +" "+str1+" "+str2);
		 
		 // Now let us print the body of the message to see what response
		 // we have recieved from the server
		 int code=response.getStatusCode();
		 String statusLine = response.getStatusLine();
		 String responseBody = response.body().asString();
		 System.out.println("Status Line : " +statusLine);
		 System.out.println("Status Code : " +code);
		 System.out.println("Response Body is : " + responseBody);
		 
	/*	// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();
		 
		// Then simply query the JsonPath object to get a String value of the node
		// specified by JsonPath: City (Note: You should not put $. in the Java code)
		int id=jsonPathEvaluator.get("id");
		
		String title = jsonPathEvaluator.get("title");
		
		boolean completed = jsonPathEvaluator.get("completed");
		// Let us print the city variable to see what we got
		System.out.println("ID received from Response : " + id);
		System.out.println("title received from Response : " + title);
		System.out.println("Completed received from Response : " + completed);
	    
		// Validate the response
		// Assert.assertEquals(city, "Hyderabad", "Correct city name received in the Response");
*/   }
}

