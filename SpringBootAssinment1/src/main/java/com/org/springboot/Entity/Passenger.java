package com.org.springboot.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Passenger {
	@Id
	private int passengerId;
	private String passengerName;
	private String gender;
	private int passengerSeatNo;
	private int pnrNumber;
	
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPassengerSeatNo() {
		return passengerSeatNo;
	}
	public void setPassengerSeatNo(int passengerSeatNo) {
		this.passengerSeatNo = passengerSeatNo;
	}
	
	public int getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(int pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", passengerName=" + passengerName + ", gender=" + gender
				+ ", passengerSeatNo=" + passengerSeatNo + ", pnrNumber=" + pnrNumber + "]";
	}
	
	
	
	
	

}
