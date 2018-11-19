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
	
	public List<SensorData> getSensorDataByNodeIdAndTime(long nodeId, Date startTime, Date endTime) {
		if(nodeId < 0 || startTime == null || endTime == null || startTime.compareTo(endTime) > 0) { 
			return null;
		}
		return sensorDataRepository.findByNodeIdAndTime(nodeId, startTime, endTime);
	}
	
	public List<SensorData> getSensorDataByClusterIdAndTime(long clusterId, Date startTime, Date endTime) {
		if(clusterId < 0 || startTime == null || endTime == null || startTime.compareTo(endTime) > 0) { 
			return null;
		}
		return sensorDataRepository.findByClusterIdAndTime(clusterId, startTime, endTime);
	}


	
	public void addSensorData(List<SensorData> sensorDataList) {
		System.out.println(sensorDataList);
		sensorDataRepository.insert(sensorDataList);  
	}

	public void updateSensorData(List<SensorData> sensorDataList) {
		sensorDataRepository.saveAll(sensorDataList);   // save = upsert;  insert
		
	}

	public void deleteSensorData(String id) {
		sensorDataRepository.deleteById(id);
	}

	public List<SensorData> testGet() {
		// TODO Auto-generated method stub
		return sensorDataRepository.findAll();
	}



}
