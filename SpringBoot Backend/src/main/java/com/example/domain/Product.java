package com.example.domain;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Skos
 *
 */

@Entity
@Table(name="Product")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String image;
	
	@Column(nullable = false)
	private int price_discount;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date createDate;
	
	@Column(nullable = true)
	private int lagger;
	
//	@ManyToOne
//	@JoinColumn (name="wishlist", nullable= false, referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_product_wishlist"))
//	private Wishlist wishlist;
	
	@ManyToOne
	@JoinColumn (name="category", nullable= false, referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_product_category"))
	private Category category;
	
	@ManyToOne
	@JoinColumn (name="price_id", referencedColumnName = "id", foreignKey = @ForeignKey(name="fk_product_price"))
	private Price price_id;
	
	@OneToMany(mappedBy = "product_id", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@ProductOrderDetails")
    private Set<OrderDetail> order_details;
	
	public int getLagger() {
		return lagger;
	}

	public void setLagger(int lagger) {
		this.lagger = lagger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getPrice_discount() {
		return price_discount;
	}

	public void setPrice_discount(int price_discount) {
		this.price_discount = price_discount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public Long getId() {
		return id;
	}

	public Price getPrice_id() {
		return price_id;
	}

	public void setPrice_id(Price price_id) {
		this.price_id = price_id;
	}
	
	@JsonIgnore
	public Set<OrderDetail> getOrder_details() {
		return order_details;
	}

	public void setOrder_details(Set<OrderDetail> order_details) {
		this.order_details = order_details;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
