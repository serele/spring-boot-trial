package com.sreyes.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Items_")
public class Item {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String description;
		
	@Column(precision=10, scale=2)
	private double price;
		
	@Enumerated(EnumType.STRING)
	private State state = State.Active;
	
	@Column(nullable = false)
	private Date creation_date;
	private int creator;
	
	public Item() {}
	
	public Item(String description, double price, State state) {
		super();
		this.description = description;
		this.price = price;
		this.state = state;
		this.creation_date = new Date();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public int getId() {
		return id;
	}
	
	
	
}
