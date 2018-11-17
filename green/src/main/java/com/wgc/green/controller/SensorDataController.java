package com.wgc.green.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wgc.green.entity.SensorData;
import com.wgc.green.manager.RequestIotConfig;
import com.wgc.green.manager.SensorDataManager;
import com.wgc.green.repository.SensorDataRepository;

@RestController
@RequestMapping("/sensor_data")
public class SensorDataController {
	@Autowired
	private SensorDataManager sdManager;
	@Autowired
	private RequestIotConfig reqIotConfig;
	
	@Autowired
	private SensorDataRepository sensorDataRepository;

	@CrossOrigin(origins = "*")
	@GetMapping("/building/{id}")
	public List<SensorData> getSensorDataByBuildingId(@PathVariable ("id") int buildId) {
		// dummy
		List<Long> sensorIDList = reqIotConfig.getSensorIDListBy(buildId);
		List<SensorData> sensorDataList = new LinkedList<>();
		sensorDataList = new ArrayList<>();
		SensorData sd = new SensorData();
		sensorDataList.add(sd); 
		sensorDataList.add(sd); 
		return sensorDataList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/floor/{id}")
	public List<SensorData> getSensorDataByFloorId(@PathVariable ("id") int floorId) {
		// dummy
		List<Long> sensorIDList = reqIotConfig.getSensorIDListBy(floorId);
		List<SensorData> sensorDataList = new LinkedList<>();
		sensorDataList = new ArrayList<>();
		SensorData sd = new SensorData();
		sensorDataList.add(sd); 
		sensorDataList.add(sd); 
		return sensorDataList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/room/{id}")
	public List<SensorData> getSensorDataByRoomId(@PathVariable ("id") int roomId, @RequestParam(value="startTime") Date startTime, @RequestParam(value="endTime") Date endTime) {
		List<SensorData> sensorDataList = new LinkedList<>();
		List<Long> sensorIdList = reqIotConfig.getSensorIDListBy(roomId);
		for(Long sensorId : sensorIdList) {
			sensorDataList.addAll( sdManager.getSensorDataBySensorIdAndTime(sensorId, startTime, endTime));
		}		
		return sensorDataList;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/sensor/{id}")
	public List<SensorData> getSensorDataBySensorId(@PathVariable ("id") long id, @RequestParam(value="startTime") Date startTime, @RequestParam(value="endTime") Date endTime) {
		return sdManager.getSensorDataBySensorIdAndTime(id, startTime, endTime);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/testget")
	public List<SensorData> getSensorDataTest() {
		return sdManager.testGet();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/testpost")
	public void addSensorDataTest() {
		List<SensorData> sensorDataList = new LinkedList<>();
		SensorData sd1 = new SensorData();
		sd1.setDate(new Date("Sat Nov 17 00:00:00 PST 2018"));
		sd1.setData("data1");
		sd1.setSensorId(1);
		
		SensorData sd2 = new SensorData();
		sd2.setDate(new Date("Sat Nov 17 00:00:01 PST 2018"));
		sd2.setSensorId(1);
		sd2.setData("data2");
		
		SensorData sd3 = new SensorData();
		sd3.setDate(new Date("Sat Nov 17 00:00:02 PST 2018"));
		sd3.setSensorId(2);
		
		sensorDataList.add(sd1);
		sensorDataList.add(sd2);
		sensorDataList.add(sd3);
		sdManager.addSensorData(sensorDataList);
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping  
	public void addSensorData(@RequestBody List<SensorData> sensorDataList) {		
		sdManager.addSensorData(sensorDataList);
	} 

	@CrossOrigin(origins = "*")
	@PutMapping
	public void updateSensorData(@RequestBody SensorData sensorData) {
		sdManager.updateSensorData(sensorData);
	}
	
	@CrossOrigin(origins = "*")
	@DeleteMapping("/{id}")
	public void deleteSensorData(@PathVariable ("id") String id ) {
		sdManager.deleteSensorData(id);
	}
	
	
}
