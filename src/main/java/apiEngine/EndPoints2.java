//API engine pachge
package apiEngine;

import java.util.concurrent.TimeUnit;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import managers.ConfigFileReader;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;



//API request methods used in the test
public class EndPoints2 {
	
	

	
	
	
	public static void main(String[] args) {
		String url = "https://swapi-graphql.netlify.app";
		String path = 		"/.netlify/functions/index";
		System.out.println("test");
		
		
		//String query =  "{"query":"{\n  allFilms{\n    films{\n      title\n    }   \n  }\n}","variables":null}";
//
//		RestAssured.baseURI=url;
//		
//		given().log().all()
//		.contentType("application/json")
//		.body(query)
//			.when().log().all()
//				.post(path).then().log().all()
//					.assertThat()
//						.statusCode(200);
//			
//		
	}
	
	

}
