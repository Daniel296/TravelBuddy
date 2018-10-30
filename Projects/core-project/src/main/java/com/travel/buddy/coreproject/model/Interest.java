package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INTERESTS")
public class Interest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6970159409094671856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTEREST_ID", unique = true, nullable = false)
    private long interestId;

    @Column(name = "IS_MOUNTAIN")
    private boolean isMountain;

    @Column(name = "IS_SEA")
    private boolean isSea;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_LOGIN_ID", referencedColumnName = "auditor_id", insertable=true, updatable=true)
    private UserLogin userLogin;
}
