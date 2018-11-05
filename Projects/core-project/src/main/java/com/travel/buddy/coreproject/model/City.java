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

@Entity
@Table(name = "CITY")
public class City implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6003282412721549877L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_ID", unique = true, nullable = false)
    private long cityId;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "CITY_ID")
    private List<UserProfile> userProfiles;
    
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", referencedColumnName = "COUNTRY_ID", insertable=true, updatable=true)
    private Country country;

    public City() {
    	super();
    }

	public City(long cityId, String name, List<UserProfile> userProfiles, Country country) {
		super();
		this.cityId = cityId;
		this.name = name;
		this.userProfiles = userProfiles;
		this.country = country;
	}

	public City(String name, List<UserProfile> userProfiles, Country country) {
		super();
		this.name = name;
		this.userProfiles = userProfiles;
		this.country = country;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
