
public class WeatherTestResponse {
	
	private String responseCode;
	private String description;
	private String maxTemp;
	private String humidity;
	private String minTemp;
	private String temp;
	
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getMaxTemp() {
		return maxTemp;
	}
	public void setMaxTemp(String maxTemp) {
		this.maxTemp = maxTemp;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getMinTemp() {
		return minTemp;
	}
	public void setMinTemp(String minTemp) {
		this.minTemp = minTemp;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}

	
	
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String toString() {
			
		return 
				"Response Code:" + responseCode +
				" Temp  : "+ temp +
				" Humidity  : "+ humidity + 
				" Description : "+ description +
				" Temp Min : "+ minTemp +
				" Temp Max : "+ maxTemp +
				" City : " + city ;
				
		
	}
}
