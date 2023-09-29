package com.pradeep.rest.webservices.epasswebservices;

import com.pradeep.rest.webservices.epasswebservices.otp.SMSService;

public class TestClass {
	public static void main(String[] args) {
		SMSService.sendSMS("HelloWorld!","9003085016");
	}

}
