package com.org.springboot.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.company.springboot.entity.Trainer;
import com.company.springboot.utility.ResponseStructure;
import com.org.springboot.Entity.Passenger;

public interface PassengerService {

	ResponseEntity<ResponseStructure<Passenger>> addPassenger(Passenger passenger);

	ResponseEntity<ResponseStructure<Passenger>> findPassenger(int passengerId);

	ResponseEntity<ResponseStructure<List<Passenger>>> findAll();

	ResponseEntity<ResponseStructure<Passenger>> deletePassenger(int passengerId);

	ResponseEntity<ResponseStructure<Passenger>> updatePassenger(int passengerId, Passenger passenger);

	

}
