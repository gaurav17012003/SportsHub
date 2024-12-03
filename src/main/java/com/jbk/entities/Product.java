package com.jbk.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	@Id
	@Column(name="p_id", nullable=false, unique=true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long pId;
	
	@Column(name="p_name", nullable=false)
	private String pName;
	
	@Column(name="p_price", nullable=false)
	private double pPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "c_id"  )
	private Category category;

	public Product() {
		
	}

	public Product(long pId, String pName, double pPrice, Category category) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pPrice = pPrice;
		this.category = category;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public double getpPrice() {
		return pPrice;
	}

	public void setpPrice(double pPrice) {
		this.pPrice = pPrice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [pId=" + pId + ", pName=" + pName + ", pPrice=" + pPrice + ", category=" + category + "]";
	}
	
}