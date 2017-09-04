package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {
	
	@Id
	@GeneratedValue
	private Long id;
	
//	@OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
//	@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@WishlistProduct")
//    private Set<Product> products;
	
//	@OneToOne(cascade = CascadeType.ALL, optional = true)
//	@JoinColumn(name = "user_id")
//	private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	public Set<Product> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<Product> products) {
//		this.products = products;
//	}

	
}
