package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

    public boolean isCanSwim() {
        return canSwim;
    }

    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    public boolean isCanCycle() {
        return canCycle;
    }

    public void setCanCycle(boolean canCycle) {
        this.canCycle = canCycle;
    }

    public boolean isCanDrive() {
        return canDrive;
    }

    public void setCanDrive(boolean canDrive) {
        this.canDrive = canDrive;
    }

    public boolean isCanFishing() {
        return canFishing;
    }

    public void setCanFishing(boolean canFishing) {
        this.canFishing = canFishing;
    }

    public boolean isCanCamping() {
        return canCamping;
    }

    public void setCanCamping(boolean canCamping) {
        this.canCamping = canCamping;
    }

    public boolean isMountain() {
        return isMountain;
    }

    public void setMountain(boolean mountain) {
        isMountain = mountain;
    }

    public boolean isSea() {
        return isSea;
    }

    public void setSea(boolean sea) {
        isSea = sea;
    }

    public boolean isOcean() {
        return isOcean;
    }

    public void setOcean(boolean ocean) {
        isOcean = ocean;
    }

    public boolean isJungle() {
        return isJungle;
    }

    public void setJungle(boolean jungle) {
        isJungle = jungle;
    }

    public boolean isCold() {
        return isCold;
    }

    public void setCold(boolean cold) {
        isCold = cold;
    }

    public boolean isHot() {
        return isHot;
    }

    public void setHot(boolean hot) {
        isHot = hot;
    }

    public boolean isRaining() {
        return isRaining;
    }

    public void setRaining(boolean raining) {
        isRaining = raining;
    }
}