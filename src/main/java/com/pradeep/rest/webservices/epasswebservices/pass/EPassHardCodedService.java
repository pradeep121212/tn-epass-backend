package com.pradeep.rest.webservices.epasswebservices.pass;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class EPassHardCodedService {

	private static Long idCounter = (long) 0;
	private static List<EPass> EPasses = new ArrayList<EPass>();
	
	static {
		List<Passenger> _passengers = new ArrayList<Passenger>();
		_passengers.add(new Passenger("Pradeep","865726269191",21));
		EPasses.add(new EPass(""+ ++idCounter,"9003085016", "Stranded in a new Place", new Date(),"Pending", 1,"Chennai","fline1","fline2","Sivagangai","tline1","tline2","tn 01 1234","bike",_passengers));
		EPasses.add(new EPass(""+ ++idCounter,"9003085016", "Marriage", new Date(),"Pending", 1,"Chennai","fline1","fline2","Sivagangai","tline1","tline2","tn 01 1234","bike",_passengers));
		EPasses.add(new EPass(""+ ++idCounter,"9003085016", "Government Duty", new Date(),"Pending", 1,"Chennai","fline1","fline2","Sivagangai","tline1","tline2","tn 01 1234","bike",_passengers));
			
	}
	
	
	public static Long getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(Long idCounter) {
		EPassHardCodedService.idCounter = idCounter;
	}
	public static List<EPass> getEPasses() {
		return EPasses;
	}
	public static void setEPasses(List<EPass> ePasses) {
		EPasses = ePasses;
	}
	public List<EPass> findAll() {
		
		return EPasses;
	}
	public EPass findbyId(String id) {
		for(EPass epass : EPasses) {
			if(epass.getId() == id)return epass;
		}
		return null;
	}
	public void updateStatus(String id, String status) {
		for(EPass epass : EPasses) {
			if(epass.getId() == id)epass.setStatus(status);
		}
		
		
		
	}
	public EPass saveEpass(EPass epass) {
		epass.setId(""+ ++idCounter);
		EPasses.add(epass);
		return epass;
	}
	public List<EPass> findbyMobileNo(String mobileNo) {
		List<EPass> tempPasses = new ArrayList<EPass>();
		
		for(EPass epass : EPasses) {
			if(epass.getMobileNo().equals(mobileNo))tempPasses.add(epass);
		}
		
		return tempPasses;
	}


}
