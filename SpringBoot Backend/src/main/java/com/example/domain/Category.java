package com.example.domain;

import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "Category")
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 128)
	private String name;
	
	@Column(nullable = false)
	private String description;
	
	@ManyToOne
    private Category parent;
    @OneToMany(mappedBy="parent")
    private Collection<Category> children;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@CategoryProduct")
    private Set<Product> products;

	public Category getParent() {
		return parent;
	}

	public void setParent(Category parent) {
		this.parent = parent;
	}

	public Collection<Category> getChildren() {
		return children;
	}

	public void setChildren(Collection<Category> children) {
		this.children = children;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	public Set<Product> getProducts() {
		return products;
	}
	
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
}
