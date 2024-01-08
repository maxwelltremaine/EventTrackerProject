package com.skilldistillery.americanfolklore.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Folklore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String name;
	private String category;
	private String description;
	private String state;
	private String city;
	private String street;
	private boolean enabled;
	@Column(name = "lore_url")
	private String loreUrl;
	
	
	public Folklore() {
		super();
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getLoreUrl() {
		return loreUrl;
	}

	public void setLoreUrl(String loreUrl) {
		this.loreUrl = loreUrl;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Folklore other = (Folklore) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Folklore [id=" + id + ", name=" + name + ", category=" + category + ", description=" + description
				+ ", state=" + state + ", city=" + city + ", street=" + street + ", enabled=" + enabled + ", loreUrl="
				+ loreUrl + "]";
	}
	
	

}
