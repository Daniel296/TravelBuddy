package com.travel.buddy.coreproject.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "INTEREST")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Interest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6970159409094671856L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTEREST_ID", unique = true, nullable = false)
    private long id;
    
    @OneToOne(mappedBy = "interest", cascade = CascadeType.ALL,fetch = FetchType.LAZY, optional = false)
    @JsonBackReference
    private UserProfile userProfile;


    @Column(name = "AMUSEMENT_PARK")
    private boolean amusement_park;

    @Column(name = "AQUARIUM")
    private boolean aquarium;

    @Column(name = "ART_GALLERY")
    private boolean art_gallery;

    @Column(name = "BEACH")
    private boolean beach;

    @Column(name = "BAR")
    private boolean bar;

    @Column(name = "BOWLING_ALLEY")
    private boolean bowling_alley;

    @Column(name = "BRIDGE")
    private boolean bridge;

    @Column(name = "CAFE")
    private boolean cafe;

    @Column(name = "CASINO")
    private boolean casino;

    @Column(name = "CEMETERY")
    private boolean cemetery;

    @Column(name = "CHURCH")
    private boolean church;

    @Column(name = "EMBASSY")
    private boolean embassy;

    @Column(name = "HINDU_TEMPLE")
    private boolean hindu_temple;

    @Column(name = "LAKE")
    private boolean lake;

    @Column(name = "LIBRARY")
    private boolean library;

    @Column(name = "LIQUOR_STORE")
    private boolean liquor_store;

    @Column(name = "MALL")
    private boolean mall;

    @Column(name = "MOSQUE")
    private boolean mosque;

    @Column(name = "MOUNTAIN")
    private boolean mountain;

    @Column(name = "MOVIE_THEATER")
    private boolean movie_theater;

    @Column(name = "MUSEUM")
    private boolean museum;

    @Column(name = "NIGHT_CLUB")
    private boolean night_club;

    @Column(name = "OCEAN")
    private boolean ocean;

    @Column(name = "PALACE")
    private boolean palace;

    @Column(name = "PARK")
    private boolean park;

    @Column(name = "RESTAURANT")
    private boolean restaurant;

    @Column(name = "SCHOOL")
    private boolean school;

    @Column(name = "STADIUM")
    private boolean stadium;

    @Column(name = "SYNAGOGUE")
    private boolean synagogue;

    @Column(name = "SEA")
    private boolean sea;

    @Column(name = "SKI")
    private boolean ski;

    @Column(name = "THEATER")
    private boolean theater;

    @Column(name = "TOWER")
    private boolean tower;

    @Column(name = "TRADITION")
    private boolean tradition;

    @Column(name = "ZOO")
    private boolean zoo;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public boolean isAmusement_park() {
        return amusement_park;
    }

    public void setAmusement_park(boolean amusement_park) {
        this.amusement_park = amusement_park;
    }

    public boolean isAquarium() {
        return aquarium;
    }

    public void setAquarium(boolean aquarium) {
        this.aquarium = aquarium;
    }

    public boolean isArt_gallery() {
        return art_gallery;
    }

    public void setArt_gallery(boolean art_gallery) {
        this.art_gallery = art_gallery;
    }

    public boolean isBeach() {
        return beach;
    }

    public void setBeach(boolean beach) {
        this.beach = beach;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isBowling_alley() {
        return bowling_alley;
    }

    public void setBowling_alley(boolean bowling_alley) {
        this.bowling_alley = bowling_alley;
    }

    public boolean isBridge() {
        return bridge;
    }

    public void setBridge(boolean bridge) {
        this.bridge = bridge;
    }

    public boolean isCafe() {
        return cafe;
    }

    public void setCafe(boolean cafe) {
        this.cafe = cafe;
    }

    public boolean isCasino() {
        return casino;
    }

    public void setCasino(boolean casino) {
        this.casino = casino;
    }

    public boolean isCemetery() {
        return cemetery;
    }

    public void setCemetery(boolean cemetery) {
        this.cemetery = cemetery;
    }

    public boolean isChurch() {
        return church;
    }

    public void setChurch(boolean church) {
        this.church = church;
    }

    public boolean isEmbassy() {
        return embassy;
    }

    public void setEmbassy(boolean embassy) {
        this.embassy = embassy;
    }

    public boolean isHindu_temple() {
        return hindu_temple;
    }

    public void setHindu_temple(boolean hindu_temple) {
        this.hindu_temple = hindu_temple;
    }

    public boolean isLake() {
        return lake;
    }

    public void setLake(boolean lake) {
        this.lake = lake;
    }

    public boolean isLibrary() {
        return library;
    }

    public void setLibrary(boolean library) {
        this.library = library;
    }

    public boolean isLiquor_store() {
        return liquor_store;
    }

    public void setLiquor_store(boolean liquor_store) {
        this.liquor_store = liquor_store;
    }

    public boolean isMall() {
        return mall;
    }

    public void setMall(boolean mall) {
        this.mall = mall;
    }

    public boolean isMosque() {
        return mosque;
    }

    public void setMosque(boolean mosque) {
        this.mosque = mosque;
    }

    public boolean isMountain() {
        return mountain;
    }

    public void setMountain(boolean mountain) {
        this.mountain = mountain;
    }

    public boolean isMovie_theater() {
        return movie_theater;
    }

    public void setMovie_theater(boolean movie_theater) {
        this.movie_theater = movie_theater;
    }

    public boolean isMuseum() {
        return museum;
    }

    public void setMuseum(boolean museum) {
        this.museum = museum;
    }

    public boolean isNight_club() {
        return night_club;
    }

    public void setNight_club(boolean night_club) {
        this.night_club = night_club;
    }

    public boolean isOcean() {
        return ocean;
    }

    public void setOcean(boolean ocean) {
        this.ocean = ocean;
    }

    public boolean isPalace() {
        return palace;
    }

    public void setPalace(boolean palace) {
        this.palace = palace;
    }

    public boolean isPark() {
        return park;
    }

    public void setPark(boolean park) {
        this.park = park;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    public boolean isStadium() {
        return stadium;
    }

    public void setStadium(boolean stadium) {
        this.stadium = stadium;
    }

    public boolean isSynagogue() {
        return synagogue;
    }

    public void setSynagogue(boolean synagogue) {
        this.synagogue = synagogue;
    }

    public boolean isSea() {
        return sea;
    }

    public void setSea(boolean sea) {
        this.sea = sea;
    }

    public boolean isSki() {
        return ski;
    }

    public void setSki(boolean ski) {
        this.ski = ski;
    }

    public boolean isTheater() {
        return theater;
    }

    public void setTheater(boolean theater) {
        this.theater = theater;
    }

    public boolean isTower() {
        return tower;
    }

    public void setTower(boolean tower) {
        this.tower = tower;
    }

    public boolean isTradition() {
        return tradition;
    }

    public void setTradition(boolean tradition) {
        this.tradition = tradition;
    }

    public boolean isZoo() {
        return zoo;
    }

    public void setZoo(boolean zoo) {
        this.zoo = zoo;
    }
}