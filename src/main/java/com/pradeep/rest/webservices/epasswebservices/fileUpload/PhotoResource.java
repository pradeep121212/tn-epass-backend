package com.pradeep.rest.webservices.epasswebservices.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;

import javax.annotation.security.RolesAllowed;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pradeep.rest.webservices.epasswebservices.pass.EPassHardCodedService;


@RestController
@CrossOrigin(origins="http://localhost:4201")
public class PhotoResource {
	
    @Autowired
    private PhotoRepository photoRepo;
    
    @Autowired
	private PhotoService photoService;
 
	
    private static final Logger logger = LoggerFactory.getLogger(PhotoResource.class);


    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String uploadFile(@RequestParam MultipartFile file) throws IOException {
    	Photo photo = new Photo("P1Document"); 
        photo.setImage(
          new Binary(BsonBinarySubType.BINARY, file.getBytes())); 
        photo = photoRepo.insert(photo); 
        return photo.getId(); 
    }
    @RolesAllowed("ADMIN")
    @GetMapping("/download/{photoId}")
    public String downloadFile1(@PathVariable String photoId, Model model) throws IOException {
        
        Photo photo = photoService.getPhoto(photoId);
        
        return  Base64.getEncoder().encodeToString(photo.getImage().getData());
    }

}
