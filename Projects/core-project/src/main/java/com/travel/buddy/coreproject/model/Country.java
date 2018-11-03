package com.travel.buddy.coreproject.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COUNTRY")
public class Country implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1560400239082472395L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COUNTRY_ID", unique = true, nullable = false)
    private long countryId;

    @Column(name = "NAME", unique = true, nullable = false)
    private String name;
    
    @Column(name = "COUNTRY_CODE", unique = true, nullable = false)
    private String countryCode;

    public Country() { super(); }

    public Country(long countryId, String name, String countryCode) {
        super();
        this.countryId = countryId;
        this.name = name;
        this.countryCode = countryCode;
    }

    public Country(String name, String countryCode) {
        super();
        this.name = name;
        this.countryCode = countryCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
