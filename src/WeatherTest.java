
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WeatherTest {
	
	
	@Test
	public void verifyWeatherDetailsByCity() {
		
		//london
		this.getWeatherDetails("2643743", "metric", "en", "London");	
		//Paris
		this.getWeatherDetails("2988507", "metric", "fr", "Paris");
		//New York
		this.getWeatherDetails("5128581", "metric", "en", "New York");	
		//東京都
		this.getWeatherDetails("1850147", "metric", "ja", "東京都");
		//दिल्ली
		this.getWeatherDetails("2650225", "metric", "hi", "दिल्ली");
		
	}
	
	//utility method for retirving weather details for given city .
	private WeatherTestResponse getWeatherDetails(String cityId, String metric, String lang, String expectedResult) {
		WeatherTestResponse weather = new WeatherTestResponse();
		final String appID = "9d50450a48809637b4862bdcb125927d";
		
		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/";
		RequestSpecification request = RestAssured.given();
				
		Response response = request.queryParam("id", cityId).queryParam("appid", appID).queryParam("lang", lang).queryParam("units", metric).get("/weather");
		
		JsonPath Jsonpathevaluator = response.jsonPath();
		weather.setResponseCode(String.valueOf(response.getStatusCode()));
		weather.setCity(Jsonpathevaluator.getString("name"));
		weather.setDescription(Jsonpathevaluator.getString("weather.description"));
		weather.setTemp(Jsonpathevaluator.getString("main.temp"));
		weather.setHumidity(Jsonpathevaluator.getString("main.humidity"));
		weather.setMinTemp(Jsonpathevaluator.getString("main.temp_min"));	
		weather.setMaxTemp(Jsonpathevaluator.getString("main.temp_max"));;

		System.out.println(weather.toString());
		
		Assert.assertEquals(weather.getCity(), expectedResult);
		
		return weather;
	}
}