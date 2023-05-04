package com.centre.cuturel.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.centre.cuturel.model.Adhesion;
import com.centre.cuturel.service.AdhesionService;

@RestController
@RequestMapping("/api/v1/adhesions")
public class AdhesionController {

	private AdhesionService adhesionService;

	public AdhesionController(AdhesionService adhesionService) {
		super();
		this.adhesionService = adhesionService;
	}
	
	@PostMapping
	public ResponseEntity<Adhesion> saveAdhesion(@RequestBody Adhesion adhesion){
		return new ResponseEntity<Adhesion>(adhesionService.saveAdhesion(adhesion), HttpStatus.OK);
	}
	
	@GetMapping
	public List<Adhesion> getAllAdhesions(){
		return adhesionService.getAllAdhesions();
	}
	
	@GetMapping("{id}")
    public ResponseEntity<Adhesion> getAdhesionById(@PathVariable("id") long adhesionId){
        return new ResponseEntity<Adhesion>(adhesionService.getAdhesionById(adhesionId), HttpStatus.OK);
    }
	
	@PutMapping("{id}")
    public ResponseEntity<Adhesion> updateAdhesion(@PathVariable("id") long id
                                                  ,@RequestBody Adhesion adhesion){
        return new ResponseEntity<Adhesion>(adhesionService.updateAdhesion(adhesion, id), HttpStatus.OK);
    }
	
	 @DeleteMapping("{id}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

	        // delete employee from DB
	        adhesionService.deleteAdhesion(id);;
	        return new ResponseEntity<String>("Adherant deleted successfully!.", HttpStatus.OK);
	    }
	
}
