package com.pradeep.rest.webservices.epasswebservices.otp;

public class OTP {
	
	private int otp;
	private String number;
	
	public OTP(int otp, String number) {
		super();
		this.otp = otp;
		this.number = number;
	}
	public int getOtp() {
		return otp;
	}
	public void setOtp(int otp) {
		this.otp = otp;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	

}
