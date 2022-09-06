package com.pradeep.rest.webservices.epasswebservices.mongoDB;

import java.net.URI;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.management.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MappedDocument;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pradeep.rest.webservices.epasswebservices.otp.SMSService;
import com.pradeep.rest.webservices.epasswebservices.pass.EPass;
import com.pradeep.rest.webservices.epasswebservices.pass.EPassHardCodedService;
import com.pradeep.rest.webservices.epasswebservices.pass.EpassUpdateRequest;

@RestController
@CrossOrigin(origins="http://localhost:4201")
public class EpassJpaResource {
	
	@Autowired
	private EpassRepository epassRepository;

	 @RolesAllowed("ADMIN")
	@GetMapping("/jpa/passes")
	public List<EPass> getAllPasses (){
		return epassRepository.findAll();
	}
	 
	 @RolesAllowed("ADMIN")
	@DeleteMapping("/jpa/passes")
	public ResponseEntity<Void> deleteAll(){
		epassRepository.deleteAll();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/jpa/passes/mobile/{mobileNo}")
	public List<EPass> getPassesByMobileNo (@PathVariable String mobileNo){

		return epassRepository.findByMobileNo(mobileNo);
	}
	
	@GetMapping("/jpa/passes/{id}")
	public EPass getPass (@PathVariable String id){
		return epassRepository.findById(id).get();
	}
	
	
	@PutMapping("/jpa/passes/{id}")
	public ResponseEntity<EpassUpdateRequest> approveOrRejectPass (@PathVariable String id,@RequestBody EpassUpdateRequest request ){
		
		EPass ePass = epassRepository.findById(id).get();
		ePass.setStatus(request.getStatus()); 
		epassRepository.save(ePass);
		String msg = "Your-Application-Of-Id-"+id+"-is-"+request.getStatus();
		SMSService.sendSMS(msg, ePass.getMobileNo());
		
		return new ResponseEntity<EpassUpdateRequest>(request,HttpStatus.OK);
	}	
	
	@PostMapping("/jpa/passes")
	public ResponseEntity<Void> saveEpass (@RequestBody EPass epass ){
		EPass createdEpass = epassRepository.save(epass);
		
		String msg = "Your-Application-Of-Id-"+createdEpass.getId()+"-is-submitted-for-review";
		SMSService.sendSMS(msg, createdEpass.getMobileNo());
		//location
		//get current resource
		//id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEpass.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
}
