package com.wgc.green.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Document(collection = "senseor_data")
public class SensorData {
	@Id
	private String id;
	@Indexed(direction = IndexDirection.ASCENDING)    // @Indexed(unique = true)
    private long sensorId;
//	@Transient	
//  @Field("Model")
//  @JsonProperty("unit")
    private String unit;
    private String model;
    private String seriesNum;
    private String data;
	@Indexed(direction = IndexDirection.ASCENDING) 
    private String type;
	@Indexed(direction = IndexDirection.ASCENDING)
    private Date date;
	
	@Indexed(direction = IndexDirection.ASCENDING)
	private long nodeId;		   
	@Indexed(direction = IndexDirection.ASCENDING)
	private long clusterId;
	@Indexed(direction = IndexDirection.ASCENDING)
	private long roomId;		   
	@Indexed(direction = IndexDirection.ASCENDING)
	private long floorId;
	private long buildingId;		   

	
	public long getSensorId() {
		return sensorId;
	}

	public void setSensorId(long sensorId) {
		this.sensorId = sensorId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getSeriesNum() {
		return seriesNum;
	}

	public void setSeriesNum(String seriesNum) {
		this.seriesNum = seriesNum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	public long getNodeId() {
		return nodeId;
	}

	public void setNodeId(long nodeId) {
		this.nodeId = nodeId;
	}

	public long getClusterId() {
		return clusterId;
	}

	public void setClusterId(long clusterId) {
		this.clusterId = clusterId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public long getFloorId() {
		return floorId;
	}

	public void setFloorId(long floorId) {
		this.floorId = floorId;
	}

	public long getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(long buildingId) {
		this.buildingId = buildingId;
	}
		
}
