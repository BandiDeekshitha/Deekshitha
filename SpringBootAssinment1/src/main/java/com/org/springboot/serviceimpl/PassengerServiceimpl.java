package com.org.springboot.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.company.springboot.entity.Trainer;
import com.company.springboot.exception.TrainerNotFoundByIdException;
import com.company.springboot.utility.ResponseStructure;
import com.org.springboot.Entity.Passenger;
import com.org.springboot.repository.PassengerRepository;
import com.org.springboot.service.PassengerService;
@Service
public class PassengerServiceimpl implements PassengerService{
	
	@Autowired
	private PassengerRepository passengerRepository;

	@Override
	public ResponseEntity<ResponseStructure<Passenger>> addPassenger(Passenger passenger) {
		 Passenger passenger1 = passengerRepository.save(passenger);
		ResponseStructure<Passenger> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Passenger object created successfully ");
		responseStructure.setData(passenger1);
		return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<Passenger>> findPassenger(int passengerId) {
		Optional<Passenger> optional = passengerRepository.findById(passengerId);

		if(optional.isPresent()) {
			 Passenger passenger = optional.get();

			ResponseStructure<Passenger> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Passenger object found successfully ");
			responseStructure.setData(passenger);
			return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.FOUND);

		}else {
			throw new TrainerNotFoundByIdException("Passenger with the given id is not Found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<List<Passenger>>> findAll() {
		List<Passenger> list = passengerRepository.findAll();

		ResponseStructure<List<Passenger>> responseStructure=new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.FOUND.value());
		responseStructure.setMessage("All Passengers objects are found successfully ");
		responseStructure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Passenger>>>(responseStructure,HttpStatus.FOUND);

	}

	@Override
	public ResponseEntity<ResponseStructure<Passenger>> deletePassenger(int passengerId) {
		Optional<Passenger> optional = passengerRepository.findById(passengerId);

		if(optional.isPresent()) {
			Passenger passenger = optional.get();
			passengerRepository.delete(passenger);

			ResponseStructure<Passenger> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Passenger object deleted successfully ");
			responseStructure.setData(passenger);
			return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);

		}else {
			throw new TrainerNotFoundByIdException("Passenger with the given id is not Found");
		}
	}

	@Override
	public ResponseEntity<ResponseStructure<Passenger>> updatePassenger(int passengerId, Passenger passenger) {
		Optional<Passenger> optional = passengerRepository.findById(passengerId);

		if(optional.isPresent()) {
			Passenger passenger2 = optional.get();
			passenger.setPassengerId(passenger2.getPassengerId());
			passengerRepository.save(passenger);

			ResponseStructure<Passenger> responseStructure=new ResponseStructure<>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Passenger object updated successfully ");
			responseStructure.setData(passenger);
			return new ResponseEntity<ResponseStructure<Passenger>>(responseStructure,HttpStatus.OK);

		}else {
			throw new TrainerNotFoundByIdException("Passenger with the given id is not Found");
		}
	}

}
