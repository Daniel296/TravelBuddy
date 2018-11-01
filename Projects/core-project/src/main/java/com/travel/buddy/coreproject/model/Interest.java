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
@Table(name = "INTEREST")
public class Interest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6970159409094671856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTEREST_ID", unique = true, nullable = false)
    private long interestId;


    //activities
    @Column(name = "CAN_SWIM")
    private boolean canSwim;
    @Column(name = "CAN_CYCLE")
    private boolean canCycle;
    @Column(name = "CAN_DRIVE")
    private boolean canDrive;
    @Column(name = "CAN_FISHING")
    private boolean canFishing;
    @Column(name = "CAN_CAMPING")
    private boolean canCamping;




    //environment
    @Column(name = "IS_MOUNTAIN")
    private boolean isMountain;
    @Column(name = "IS_SEA")
    private boolean isSea;
    @Column(name = "IS_OCEAN")
    private boolean isOcean;
    @Column(name="IS_JUNGLE")
    private boolean isJungle;


    //weather
    @Column(name = "IS_COLD")
    private boolean isCold;
    @Column(name = "IS_HOT")
    private boolean isHot;
    @Column(name = "IS_RAINING")
    private boolean isRaining;


    //building types
    @Column(name = "ARE_CHURCHES")
    boolean areChurches;
    @Column(name = "ARE_CASTLES")
    boolean areCastles;
    @Column(name = "ARE_WATERFALLS")
    boolean areWaterfalls;
    @Column(name = "ARE_CAVES")
    boolean areCaves;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_LOGIN_ID", referencedColumnName = "USER_LOGIN_ID", insertable=true, updatable=true)
    private UserLogin userLogin;
}
