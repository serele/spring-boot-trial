package com.sreyes.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sreyes.model.State;

@Entity
@Table(name="items")
public class ItemEntity {
	
	
	private int id;	
	private String description;	
	private double price;	
	private State state;	
	private Date creation_date;	
	private String creator;

	public ItemEntity() {
		
	}
	
	
	public ItemEntity(String description, double price, State state, Date creation_date, String creator) {
		super();
		this.description = description;
		this.price = price;
		this.state = state;
		this.creation_date = creation_date;
		this.creator = creator;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", precision=10, scale=2)
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "state")
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}

	@Column(name = "creatio_date")
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	@Column(name = "creator")
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	
	 @Override
	    public String toString() {
	        return "Item [id=" + id + ", description=" + description+ ", price=" + price + ", state=" + state
	        		+ ", creation_date=" + creation_date  + ", creator=" + creator + "]";
	    }
}
