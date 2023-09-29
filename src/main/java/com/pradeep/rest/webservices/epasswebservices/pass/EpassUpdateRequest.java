package com.pradeep.rest.webservices.epasswebservices.pass;

public class EpassUpdateRequest {
	private String status;
	protected EpassUpdateRequest() {}

	public EpassUpdateRequest(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
