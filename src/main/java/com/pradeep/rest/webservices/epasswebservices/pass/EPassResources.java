package com.pradeep.rest.webservices.epasswebservices.pass;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
//@CrossOrigin(origins="http://localhost:4201")
public class EPassResources {
	
	@Autowired
	private EPassHardCodedService epassService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/passes")
	public List<EPass> getAllPasses (){
		return epassService.findAll();
	}
	
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	@GetMapping("/passes/mobile/{mobileNo}")
	public List<EPass> getPassesByMobileNo (@PathVariable String mobileNo){
		return epassService.findbyMobileNo(mobileNo);
	}
	
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	@GetMapping("/passes/{id}")
	public EPass getPass (@PathVariable String id){
		return epassService.findbyId(id);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/passes/{id}")
	public ResponseEntity<EpassUpdateRequest> approveOrRejectPass (@PathVariable String id,@RequestBody EpassUpdateRequest request ){
		epassService.updateStatus(id, request.getStatus());
		
		return new ResponseEntity<EpassUpdateRequest>(request,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_USER') || hasRole('ROLE_ADMIN')")
	@PostMapping("/passes")
	public ResponseEntity<Void> saveEpass (@RequestBody EPass epass ){
		EPass createdEpass = epassService.saveEpass(epass);
		//location
		//get current resource
		//id
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdEpass.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	
}

