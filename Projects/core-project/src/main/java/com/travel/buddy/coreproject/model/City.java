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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    private List<UserProfile> users;
    
    @OneToOne(fetch = FetchType.LAZY, cascade =  CascadeType.ALL, mappedBy = "city")
    private Attraction attraction;

    public City() { super(); }

    public City(long cityId, String name, List<UserProfile> users) {
        super();
        this.cityId = cityId;
        this.name = name;
        this.users = users;
    }

    public City(String name, List<UserProfile> users) {
        super();
        this.name = name;
        this.users = users;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<UserProfile> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<UserProfile> getUsers() {
        return users;
    }
}
