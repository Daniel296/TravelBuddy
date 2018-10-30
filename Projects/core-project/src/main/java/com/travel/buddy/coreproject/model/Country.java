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

    public Country() { super(); }

    public Country(long countryId, String name) {
        super();
        this.countryId = countryId;
        this.name = name;
    }

    public Country(String name) {
        super();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
