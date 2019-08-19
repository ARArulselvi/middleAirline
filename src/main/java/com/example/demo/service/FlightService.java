package com.example.demo.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Flight;
import com.example.demo.models.User;
import com.example.demo.repos.FlightRepository;

@Service
public class FlightService {
	
	@Autowired
	private FlightRepository repo;

	public Iterable<Flight> findAll(String source, String destination) {
		
	
		return repo.findAll(source,destination);
	}

	public List<Integer> validateCardDetails(int cvv,long cardNumber,String date) {
		// TODO Auto-generated method stub
		return repo.validate(cvv,cardNumber,date);
	}
	
	public int updateAvailableSeats(long flightNumber,int availableSeats) {
		return repo.updatebyFlightNumber(flightNumber,availableSeats);
	}


}
