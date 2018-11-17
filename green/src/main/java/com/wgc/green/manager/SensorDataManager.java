package com.wgc.green.manager;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wgc.green.entity.SensorData;
import com.wgc.green.repository.SensorDataRepository;

@Component
public class SensorDataManager {
	@Autowired
	private SensorDataRepository sensorDataRepository;
	
	public List<SensorData> getSensorDataBySensorIdAndTime(long sensorId, Date startTime, Date endTime) {
		if(sensorId < 0 || startTime == null || endTime == null || startTime.compareTo(endTime) > 0) { 
			return null;
		}
		return sensorDataRepository.findBySensorIdAndTime(sensorId, startTime, endTime);
	}

	public void addSensorData(List<SensorData> sensorDataList) {
		System.out.println(sensorDataList);
		sensorDataRepository.insert(sensorDataList);  
	}

	public void updateSensorData(SensorData sensorData) {
		sensorDataRepository.save(sensorData);   // save = upsert;  insert
		
	}

	public void deleteSensorData(String id) {
		sensorDataRepository.deleteById(id);
	}

	public List<SensorData> testGet() {
		// TODO Auto-generated method stub
		return sensorDataRepository.findAll();
	}



}
