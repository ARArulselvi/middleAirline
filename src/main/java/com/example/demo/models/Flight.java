package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="flight")
public class Flight {
	
	@Id
	private long flightNumber;
	private String flightName;
	private double price;
	private int travelTime;
	private String source;
	private String destination;
	private int availableSeats;

}
