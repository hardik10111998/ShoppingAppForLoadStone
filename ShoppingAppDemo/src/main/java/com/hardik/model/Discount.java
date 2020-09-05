package com.hardik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Discount {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int discountId ;
	
	private float discountAmount;
	
	public Discount(int discountId, float discountAmount) {
		super();
		this.discountId = discountId;
		this.discountAmount = discountAmount;
	}
	public Discount() {
		
	}
	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public float getDiscountAmount() {
		return discountAmount;
	}
	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}
	
	
	

}
