package com.org.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.company.springboot.entity.Trainer;
//import com.company.springboot.utility.ResponseStructure;
import com.org.springboot.Entity.Passenger;
import com.org.springboot.service.PassengerService;
import com.org.springboot.utility.ResponseStructure;
@RestController
@RequestMapping(value ="/passengers")
public class PassengerController {

	@Autowired
	private PassengerService passengerSrevice;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Passenger>> addTrainer(@RequestBody Passenger passenger){
		return passengerSrevice.addPassenger(passenger);
	}
	
	@GetMapping("/{passengerId}")
	public ResponseEntity<ResponseStructure<Passenger>> finfTrainer(@PathVariable int passengerId){
		return passengerSrevice.findPassenger(passengerId);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<ResponseStructure<List<Passenger>>> findAll(){
		return passengerSrevice.findAll();
	}
	
	@DeleteMapping("/{passengerId}")
	public ResponseEntity<ResponseStructure<Passenger>> deleteTrainer(@PathVariable int passengerId){
		return passengerSrevice.deletePassenger(passengerId);
		
	}
	
	@PutMapping("/{passengerId}")
	public ResponseEntity<ResponseStructure<Passenger>> updateTrainer(@PathVariable int passengerId,@RequestBody Passenger passenger){
		return passengerSrevice.updatePassenger(passengerId,passenger);
	}
}
