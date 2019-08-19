package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Version;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.CreditCard;
import com.example.demo.models.Flight;
import com.example.demo.models.User;
import com.example.demo.service.FlightService;


@Controller
@SessionAttributes({"flightList","flightNumber","selectedFlight"})

public class FlightController {
	
	
	Iterable<Flight> flightList;
	
	Flight selectedFlight;
	
	long flightNumber;
	
	int tickets;
	
	@Autowired
	private Flight flight;

	@Autowired
	private FlightService service;
	
	@Autowired
	private ModelAndView mdlView;
	
	@GetMapping("/findFlights")
	public ModelAndView initForm() {
		
		mdlView.setViewName("findflight");
		mdlView.addObject("command", flight);
		return mdlView;
	}
	
	@PostMapping("/findMyFlight")
	public String onSubmit(@Valid @ModelAttribute("command") Flight flight,Model model, BindingResult result) {
	
		flightList=this.service.findAll(flight.getSource(),flight.getDestination());
		
		 model.addAttribute("flightlist", flightList);
		 
			return "bookticket";
		  
//		 ${flightlist}
	}
	
//	@RequestMapping("/enterDetails")
//	public String enterCardDetails(@Valid @ModelAttribute("command") User user) {
//		//System.out.println("session : "+flightList);
//		
//		//System.out.println("flight number: "+id);
//		//System.out.println("flight number : "+flightList[0].flightNumber);
//		return "cardDetails";
//	}
	
	@RequestMapping("/showDetails/{id}")
	public String enterCardDetails(@PathVariable("id") long id,@Valid @ModelAttribute("command") User user,Model model) {
		flightNumber=id;
		//System.out.println("flight Number : "+flightNumber);
		System.out.println("All flights : "+flightList);
		for (Flight flight : flightList) {
			if(flight.getFlightNumber()==flightNumber) {
				
				selectedFlight=flight;
				model.addAttribute("selectedFlight", flight);  
			}
		}
		
		return "showFlightDetails";
	}
	
	
//	@RequestMapping("/enterCardDetails")
//	public String cardDetails(@Valid @ModelAttribute("command") User user, Flight flight)
//	{
//		return "cardDetails";
//	}
	
	@RequestMapping("/enterUserDetails")
	public String userDetails(@Valid @ModelAttribute("command") User user)
	{
		return "userDetails";
	}
	
	@PostMapping("/enterCardDetails")
	public String cardDetails(@Valid @ModelAttribute("command") User user, CreditCard card,Model model)
	{
		//tickets=user.getNumberOfTickets();
		model.addAttribute("User", user);
		System.out.println("tickets : "+tickets);
		return "proceedToPay";
	}
	
	@RequestMapping("/payment")
	public String cardDetails(@Valid @ModelAttribute("command") CreditCard card)
	{
		return "cardDetails";
	}
	
	@PostMapping("/validateCardDetails")
	public String onBooking(@Valid @ModelAttribute("command")CreditCard card,BindingResult result) {
		
		List<Integer> cvvList= new ArrayList<>();
		this.service.validateCardDetails(card.getCvv(),card.getCardNumber(),card.getExpiryDate()).forEach(eachObject -> {
			cvvList.add(eachObject);
		});
		System.out.println(cvvList);
		System.out.println("selected flight : "+selectedFlight);
		if(!cvvList.isEmpty()) {
				int availableSeats=selectedFlight.getAvailableSeats();
				System.out.println("available seats : "+availableSeats);
				int row=this.service.updateAvailableSeats(flightNumber,availableSeats-tickets);
				return "valid";
		}
		else
			return "invalid";
	}
	
	

}
