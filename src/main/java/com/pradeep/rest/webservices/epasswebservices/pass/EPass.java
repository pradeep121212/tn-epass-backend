package com.pradeep.rest.webservices.epasswebservices.pass;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "book")
public class EPass {
	@Id
	private String id;
	
	private String mobileNo;
	private String p1DocumentId;
	private String marriageDocumentId;
	


	private String reason;
	private Date createdAt;
	private String status;
	private int numberOfPassengers;
	private String fromDistrict;
	private String fromAddress1;
	private String fromAddress2;
	private String toDistrict;
	private String toAddress1;
	private String toAddress2;
	

	private List<Passenger> passengers;
	private String vehicleNo;
	private String vehicleType;
	
	protected EPass() {
		
	}
	
	public EPass(String id,String mobileNo, String reason, Date createdAt, String status, int numberOfPassengers, String fromDistrict,
			String fromAddress1, String fromAddress2, String toDistrict, String toAddress1, String toAddress2,String vehicleNo,String vehicleType,
			List<Passenger> passengers) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.reason = reason;
		this.createdAt = createdAt;
		this.status = status;
		this.numberOfPassengers = numberOfPassengers;
		this.fromDistrict = fromDistrict;
		this.fromAddress1 = fromAddress1;
		this.fromAddress2 = fromAddress2;
		this.toDistrict = toDistrict;
		this.toAddress1 = toAddress1;
		this.toAddress2 = toAddress2;
		this.setVehicleNo(vehicleNo);
		this.setVehicleType(vehicleType);
		this.passengers = passengers;
	}
	
	public EPass(String id, String mobileNo, String p1DocumentId, String marriageDocumentId, String reason,
			Date createdAt, String status, int numberOfPassengers, String fromDistrict, String fromAddress1,
			String fromAddress2, String toDistrict, String toAddress1, String toAddress2, List<Passenger> passengers,
			String vehicleNo, String vehicleType) {
		super();
		this.id = id;
		this.mobileNo = mobileNo;
		this.p1DocumentId = p1DocumentId;
		this.marriageDocumentId = marriageDocumentId;
		this.reason = reason;
		this.createdAt = createdAt;
		this.status = status;
		this.numberOfPassengers = numberOfPassengers;
		this.fromDistrict = fromDistrict;
		this.fromAddress1 = fromAddress1;
		this.fromAddress2 = fromAddress2;
		this.toDistrict = toDistrict;
		this.toAddress1 = toAddress1;
		this.toAddress2 = toAddress2;
		this.passengers = passengers;
		this.vehicleNo = vehicleNo;
		this.vehicleType = vehicleType;
	}

	public String getP1DocumentId() {
		return p1DocumentId;
	}

	public void setP1DocumentId(String p1DocumentId) {
		this.p1DocumentId = p1DocumentId;
	}

	public String getMarriageDocumentId() {
		return marriageDocumentId;
	}

	public void setMarriageDocumentId(String marriageDocumentId) {
		this.marriageDocumentId = marriageDocumentId;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	public String getFromDistrict() {
		return fromDistrict;
	}
	public void setFromDistrict(String fromDistrict) {
		this.fromDistrict = fromDistrict;
	}
	public String getFromAddress1() {
		return fromAddress1;
	}
	public void setFromAddress1(String fromAddress1) {
		this.fromAddress1 = fromAddress1;
	}
	public String getFromAddress2() {
		return fromAddress2;
	}
	public void setFromAddress2(String fromAddress2) {
		this.fromAddress2 = fromAddress2;
	}
	public String getToDistrict() {
		return toDistrict;
	}
	public void setToDistrict(String toDistrict) {
		this.toDistrict = toDistrict;
	}
	public String getToAddress1() {
		return toAddress1;
	}
	public void setToAddress1(String toAddress1) {
		this.toAddress1 = toAddress1;
	}
	public String getToAddress2() {
		return toAddress2;
	}
	public void setToAddress2(String toAddress2) {
		this.toAddress2 = toAddress2;
	}
	public List<Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	
	
	
	

	


}
