package com.wgc.green.manager;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.wgc.green.entity.SensorData;

@Component
public class RequestIotConfig {
    RestTemplate restTemplate = new RestTemplate();
     
	public List<Long> getSensorIDListBy(int id) {
		final String uri = "http://localhost:8080/ IOT Config /room.json";
	    String result = this.restTemplate.getForObject(uri, String.class);

	    System.out.println(result);
		return null;
	}
	
	
	public List<SensorData> getSensorList() {
		final String uri = "http://localhost:8080/sensor_data/room.json";
//		SensorData result = this.restTemplate.getForEntity(url, responseType, uriVariables)  .getForObject(uri, SensorData.class);
//
//	    System.out.println(result);
		return null;
	}

}
