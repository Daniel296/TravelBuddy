package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "CITY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6003282412721549877L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID", unique = true, nullable = false)
    private long id;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    
    @Column(name = "CITY_CODE", unique = true, nullable = false)
    private String cityCode;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CITY_ID")
//    @JsonBackReference
    @JsonIgnore
    private List<UserProfile> userProfiles;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable=true, updatable=true)
//    @JsonManagedReference
    private Country country;

    public City() {
    	super();
    }

	public City(long id, String name, String cityCode, List<UserProfile> userProfiles, Country country) {
		super();
		this.id = id;
		this.name = name;
		this.cityCode = cityCode;
		this.userProfiles = userProfiles;
		this.country = country;
	}

	public City(String name, String cityCode, List<UserProfile> userProfiles, Country country) {
		super();
		this.name = name;
		this.cityCode = cityCode;
		this.userProfiles = userProfiles;
		this.country = country;
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

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}
	
//	@JsonIgnore
	public List<UserProfile> getUserProfiles() {
		return userProfiles;
	}

	public void setUserProfiles(List<UserProfile> userProfiles) {
		this.userProfiles = userProfiles;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
