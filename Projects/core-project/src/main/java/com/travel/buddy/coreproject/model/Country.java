package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "COUNTRY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Country implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1560400239082472395L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    
    @Column(name = "COUNTRY_CODE", unique = true, nullable = false)
    private String countryCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "COUNTRY_ID")
    @JsonBackReference
    private List<City> cities;

    public Country() {
    	super();
    }

	public Country(long id, String name, String countryCode, List<City> cities) {
		super();
		this.id = id;
		this.name = name;
		this.countryCode = countryCode;
		this.cities = cities;
	}

	public Country(String name, String countryCode, List<City> cities) {
		super();
		this.name = name;
		this.countryCode = countryCode;
		this.cities = cities;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
//	@JsonIgnore
	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
}
