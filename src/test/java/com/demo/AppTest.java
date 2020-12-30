package com.demo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.services.NetflixService;
import com.services.PrimeService;
import com.services.Services;
import com.services.SonyService;
import com.services.Zee5Service;

public class AppTest {
	int budget;
	String[] services;

	enum providers {
		Prime,Zee5,SonyLiv,Netflix;
	}

	@BeforeClass
	void initialise() {

		
		budget = Integer.parseInt(System.getProperty("Budget"));
		services = System.getProperty("Service").split(",");
		System.out.println("Budget " + budget);
		System.out.print("Services ");
		for (String string : services) {
			System.out.print(string + " ");
		}
		System.out.println();
	}

	@Test
	public void print() {
		for (String string : services) {
			for (providers p : providers.values()) {
				if (string.equalsIgnoreCase(p.toString()))

					switch (p) {

					case Prime:
						
						Services service = new PrimeService();
						if (budget > service.getPrice()) {
							System.out.println(
									service.getName() + "  " + service.getDuration() + " subsciption- " + service.getPrice());
						}
						break;

					
					
					  case Netflix:  
					   service = new NetflixService(); 
					  if (budget >service.getPrice()) 
					  {
						  System.out.println( service.getName() + "  " +service.getDuration() + " subsciption- " + service.getPrice());  
					}break;
					 

					  case Zee5:  
						   service = new Zee5Service(); 
						  if (budget >service.getPrice()) 
						  {
							  System.out.println( service.getName() + "  " +service.getDuration() + " subsciption- " + service.getPrice());  
						}break;
						 
					  case SonyLiv:  
						   service = new SonyService(); 
						  if (budget >service.getPrice()) 
						  {
							  System.out.println( service.getName() + "  " +service.getDuration() + " subsciption- " + service.getPrice());  
						}break;
						 
					default:

					}	}
		}
	}
}
