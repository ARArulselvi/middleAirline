package com.example.demo.repos;


import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Flight;
import com.example.demo.models.User;

@Repository

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query(value="SELECT * FROM flight WHERE source=?1 AND destination=?2",nativeQuery = true)
	public List<Flight> findAll(String source,String destination);

	@Query(value="SELECT cvv FROM credentials WHERE cvv=?1 AND cardNumber=?2 AND expiryDate=?3", nativeQuery = true)
	public List<Integer> validate(int cvv,long cardNumber,String date);

	@Transactional
	@Modifying
	@Query(value="UPDATE flight SET availableSeats=?2 WHERE flightNumber=?1",nativeQuery = true)
	public int updatebyFlightNumber(long flightNumber,int seats);
}
//public interface FlightRepository extends CrudRepository<Flight, Long> {
//
////	@Query(value="select * from flight")
////	public List<Flight> findAll1();
//}


