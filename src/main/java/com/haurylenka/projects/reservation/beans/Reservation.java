package com.haurylenka.projects.reservation.beans;

import java.util.List;

public class Reservation {

	private String code;
	private String description;
	private List<ResComponent> components;
	
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
	
}
