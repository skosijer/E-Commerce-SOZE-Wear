package com.example.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Price")
public class Price implements Serializable{
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable = false)
    private int price_value;
	
	@Column(nullable = false)
	private int discount;
	
	@ManyToOne
	@JoinColumn (name="pricelist_id", nullable= false, referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_pricelist_price"))
	private PriceList pricelist_id;
	
	@OneToMany(mappedBy = "price_id", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@PriceProduct")
    private Set<Product> products;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getPrice_value() {
		return price_value;
	}

	public void setPrice_value(int price_value) {
		this.price_value = price_value;
	}
	
	@JsonIgnore
	public PriceList getPricelist_id() {
		return pricelist_id;
	}

	public void setPricelist_id(PriceList pricelist_id) {
		this.pricelist_id = pricelist_id;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
