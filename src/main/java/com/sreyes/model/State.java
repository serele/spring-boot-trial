package com.sreyes.model;

public enum State {
	Active("Active"), 
	Discontinued("Discontinued");
	
	private String value;
	
	State(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
}
