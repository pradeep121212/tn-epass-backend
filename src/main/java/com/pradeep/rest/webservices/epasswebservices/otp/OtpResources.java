package com.pradeep.rest.webservices.epasswebservices.otp;


import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//import com.shri.service.MyEmailService;
//import com.shri.service.OtpService;
//import com.shri.utility.EmailTemplate;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins="http://tnepass.us-west-2.elasticbeanstalk.com")
public class OtpResources {

private final Logger logger = LoggerFactory.getLogger(this.getClass());

@Autowired
public OtpService otpService;

//@Autowired
//public MyEmailService myEmailService;
@GetMapping("/generateOtp/{number}")
public OTP generateOtp(@PathVariable String number)
{
int otp = otpService.generateOTP(number);
return new OTP(otp,number);
}

@RequestMapping(value ="/validateOtp/{number}", method = RequestMethod.GET)
public @ResponseBody String validateOtp(@RequestParam("otpnum") int otpnum, @PathVariable String number){
final String SUCCESS = "Wrong number";
final String FAIL = "Re generate otp";

logger.info(" Otp Number : "+otpnum);

if(otpnum >= 0){
int serverOtp = otpService.getOtp(number);
logger.info(" server Number : "+serverOtp);
if(serverOtp > 0){
if(otpnum == serverOtp){
otpService.clearOTP(number);
return ("SUCCESS");
}else{
return "Wrong OTP";
}
}else {
return "OTP Expired";
}
}else {
return "Invalid";
}
}
}
