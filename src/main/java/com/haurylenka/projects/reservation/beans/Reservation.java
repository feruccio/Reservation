package com.haurylenka.projects.reservation.beans;

import java.util.List;

public class Reservation {

	private String code;
	private String description;
	private List<ResComponent> components;
	private Customer customer;
	private FareFamily fareFamily;
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<ResComponent> getComponents() {
		return components;
	}
	
	public void setComponents(List<ResComponent> components) {
		this.components = components;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FareFamily getFareFamily() {
		return fareFamily;
	}

	public void setFareFamily(FareFamily fareFamily) {
		this.fareFamily = fareFamily;
	}
	
}
