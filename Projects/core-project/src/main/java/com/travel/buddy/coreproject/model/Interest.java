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
    private long id;


    @Column(name = "ACCOUNTING")
    private boolean accounting;

    @Column(name = "AIRPORT")
    private boolean airport;

    @Column(name = "AMUSEMENT_PARK")
    private boolean amusement_park;

    @Column(name = "AQUARIUM")
    private boolean aquarium;

    @Column(name = "ART_GALLERY")
    private boolean art_gallery;

    @Column(name = "ATM")
    private boolean atm;

    @Column(name = "BAKERY")
    private boolean bakery;

    @Column(name = "BANK")
    private boolean bank;

    @Column(name = "BAR")
    private boolean bar;

    @Column(name = "BEAUTY_SALON")
    private boolean beauty_salon;

    @Column(name = "BICYCLE_STORE")
    private boolean bicycle_store;

    @Column(name = "BOOK_STORE")
    private boolean book_store;

    @Column(name = "BOWLING_ALLEY")
    private boolean bowling_alley;

    @Column(name = "BUS_STATION")
    private boolean bus_station;

    @Column(name = "CAFE")
    private boolean cafe;

    @Column(name = "CAMPGROUND")
    private boolean campground;

    @Column(name = "CAR_DEALER")
    private boolean car_dealer;

    @Column(name = "CAR_RENTAL")
    private boolean car_rental;

    @Column(name = "CAR_REPAIR")
    private boolean car_repair;

    @Column(name = "CAR_WASH")
    private boolean car_wash;

    @Column(name = "CASINO")
    private boolean casino;

    @Column(name = "CEMETERY")
    private boolean cemetery;

    @Column(name = "CHURCH")
    private boolean church;

    @Column(name = "CITY_HALL")
    private boolean city_hall;

    @Column(name = "CLOTHING_STORE")
    private boolean clothing_store;

    @Column(name = "CONVENIENCE_STORE")
    private boolean convenience_store;

    @Column(name = "COURTHOUSE")
    private boolean courthouse;

    @Column(name = "DENTIST")
    private boolean dentist;

    @Column(name = "DEPARTMENT_STORE")
    private boolean department_store;

    @Column(name = "DOCTOR")
    private boolean doctor;

    @Column(name = "ELECTRICIAN")
    private boolean electrician;

    @Column(name = "ELECTRONICS_STORE")
    private boolean electronics_store;

    @Column(name = "EMBASSY")
    private boolean embassy;

    @Column(name = "FIRE_STATION")
    private boolean fire_station;

    @Column(name = "FLORIST")
    private boolean florist;

    @Column(name = "FUNERAL_HOME")
    private boolean funeral_home;

    @Column(name = "FURNITURE_STORE")
    private boolean furniture_store;

    @Column(name = "GAS_STATION")
    private boolean gas_station;

    @Column(name = "GYM")
    private boolean gym;

    @Column(name = "HAIR_CARE")
    private boolean hair_care;

    @Column(name = "HARDWARE_STORE")
    private boolean hardware_store;

    @Column(name = "HINDU_TEMPLE")
    private boolean hindu_temple;

    @Column(name = "HOME_GOODS_STORE")
    private boolean home_goods_store;

    @Column(name = "HOSPITAL")
    private boolean hospital;

    @Column(name = "INSURANCE_AGENCY")
    private boolean insurance_agency;

    @Column(name = "JEWELRY_STORE")
    private boolean jewelry_store;

    @Column(name = "LAUNDRY")
    private boolean laundry;

    @Column(name = "LAWYER")
    private boolean lawyer;

    @Column(name = "LIBRARY")
    private boolean library;

    @Column(name = "LIQUOR_STORE")
    private boolean liquor_store;

    @Column(name = "LOCAL_GOVERNMENT_OFFICE")
    private boolean local_government_office;

    @Column(name = "LOCKSMITH")
    private boolean locksmith;

    @Column(name = "LODGING")
    private boolean lodging;

    @Column(name = "MEAL_DELIVERY")
    private boolean meal_delivery;

    @Column(name = "MEAL_TAKEAWAY")
    private boolean meal_takeaway;

    @Column(name = "MOSQUE")
    private boolean mosque;

    @Column(name = "MOVIE_RENTAL")
    private boolean movie_rental;

    @Column(name = "MOVIE_THEATER")
    private boolean movie_theater;

    @Column(name = "MOVING_COMPANY")
    private boolean moving_company;

    @Column(name = "MUSEUM")
    private boolean museum;

    @Column(name = "NIGHT_CLUB")
    private boolean night_club;

    @Column(name = "PAINTER")
    private boolean painter;

    @Column(name = "PARK")
    private boolean park;

    @Column(name = "PARKING")
    private boolean parking;

    @Column(name = "PET_STORE")
    private boolean pet_store;

    @Column(name = "PHARMACY")
    private boolean pharmacy;

    @Column(name = "PHYSIOTHERAPIST")
    private boolean physiotherapist;

    @Column(name = "PLUMBER")
    private boolean plumber;

    @Column(name = "POLICE")
    private boolean police;

    @Column(name = "POST_OFFICE")
    private boolean post_office;

    @Column(name = "REAL_ESTATE_AGENCY")
    private boolean real_estate_agency;

    @Column(name = "RESTAURANT")
    private boolean restaurant;

    @Column(name = "ROOFING_CONTRACTOR")
    private boolean roofing_contractor;

    @Column(name = "RV_PARK")
    private boolean rv_park;

    @Column(name = "SCHOOL")
    private boolean school;

    @Column(name = "SHOE_STORE")
    private boolean shoe_store;

    @Column(name = "SHOPPING_MALL")
    private boolean shopping_mall;

    @Column(name = "SPA")
    private boolean spa;

    @Column(name = "STADIUM")
    private boolean stadium;

    @Column(name = "STORAGE")
    private boolean storage;

    @Column(name = "STORE")
    private boolean store;

    @Column(name = "SUBWAY_STATION")
    private boolean subway_station;

    @Column(name = "SUPERMARKET")
    private boolean supermarket;

    @Column(name = "SYNAGOGUE")
    private boolean synagogue;

    @Column(name = "TAXI_STAND")
    private boolean taxi_stand;

    @Column(name = "TRAIN_STATION")
    private boolean train_station;

    @Column(name = "TRANSIT_STATION")
    private boolean transit_station;

    @Column(name = "TRAVEL_AGENCY")
    private boolean travel_agency;

    @Column(name = "VETERINARY_CARE")
    private boolean veterinary_care;

    @Column(name = "ZOO")
    private boolean zoo;


    public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}



    public boolean isAccounting() {
        return accounting;
    }

    public void setAccounting(boolean accounting) {
        this.accounting = accounting;
    }

    public boolean isAirport() {
        return airport;
    }

    public void setAirport(boolean airport) {
        this.airport = airport;
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

    public boolean isAtm() {
        return atm;
    }

    public void setAtm(boolean atm) {
        this.atm = atm;
    }

    public boolean isBakery() {
        return bakery;
    }

    public void setBakery(boolean bakery) {
        this.bakery = bakery;
    }

    public boolean isBank() {
        return bank;
    }

    public void setBank(boolean bank) {
        this.bank = bank;
    }

    public boolean isBar() {
        return bar;
    }

    public void setBar(boolean bar) {
        this.bar = bar;
    }

    public boolean isBeauty_salon() {
        return beauty_salon;
    }

    public void setBeauty_salon(boolean beauty_salon) {
        this.beauty_salon = beauty_salon;
    }

    public boolean isBicycle_store() {
        return bicycle_store;
    }

    public void setBicycle_store(boolean bicycle_store) {
        this.bicycle_store = bicycle_store;
    }

    public boolean isBook_store() {
        return book_store;
    }

    public void setBook_store(boolean book_store) {
        this.book_store = book_store;
    }

    public boolean isBowling_alley() {
        return bowling_alley;
    }

    public void setBowling_alley(boolean bowling_alley) {
        this.bowling_alley = bowling_alley;
    }

    public boolean isBus_station() {
        return bus_station;
    }

    public void setBus_station(boolean bus_station) {
        this.bus_station = bus_station;
    }

    public boolean isCafe() {
        return cafe;
    }

    public void setCafe(boolean cafe) {
        this.cafe = cafe;
    }

    public boolean isCampground() {
        return campground;
    }

    public void setCampground(boolean campground) {
        this.campground = campground;
    }

    public boolean isCar_dealer() {
        return car_dealer;
    }

    public void setCar_dealer(boolean car_dealer) {
        this.car_dealer = car_dealer;
    }

    public boolean isCar_rental() {
        return car_rental;
    }

    public void setCar_rental(boolean car_rental) {
        this.car_rental = car_rental;
    }

    public boolean isCar_repair() {
        return car_repair;
    }

    public void setCar_repair(boolean car_repair) {
        this.car_repair = car_repair;
    }

    public boolean isCar_wash() {
        return car_wash;
    }

    public void setCar_wash(boolean car_wash) {
        this.car_wash = car_wash;
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

    public boolean isCity_hall() {
        return city_hall;
    }

    public void setCity_hall(boolean city_hall) {
        this.city_hall = city_hall;
    }

    public boolean isClothing_store() {
        return clothing_store;
    }

    public void setClothing_store(boolean clothing_store) {
        this.clothing_store = clothing_store;
    }

    public boolean isConvenience_store() {
        return convenience_store;
    }

    public void setConvenience_store(boolean convenience_store) {
        this.convenience_store = convenience_store;
    }

    public boolean isCourthouse() {
        return courthouse;
    }

    public void setCourthouse(boolean courthouse) {
        this.courthouse = courthouse;
    }

    public boolean isDentist() {
        return dentist;
    }

    public void setDentist(boolean dentist) {
        this.dentist = dentist;
    }

    public boolean isDepartment_store() {
        return department_store;
    }

    public void setDepartment_store(boolean department_store) {
        this.department_store = department_store;
    }

    public boolean isDoctor() {
        return doctor;
    }

    public void setDoctor(boolean doctor) {
        this.doctor = doctor;
    }

    public boolean isElectrician() {
        return electrician;
    }

    public void setElectrician(boolean electrician) {
        this.electrician = electrician;
    }

    public boolean isElectronics_store() {
        return electronics_store;
    }

    public void setElectronics_store(boolean electronics_store) {
        this.electronics_store = electronics_store;
    }

    public boolean isEmbassy() {
        return embassy;
    }

    public void setEmbassy(boolean embassy) {
        this.embassy = embassy;
    }

    public boolean isFire_station() {
        return fire_station;
    }

    public void setFire_station(boolean fire_station) {
        this.fire_station = fire_station;
    }

    public boolean isFlorist() {
        return florist;
    }

    public void setFlorist(boolean florist) {
        this.florist = florist;
    }

    public boolean isFuneral_home() {
        return funeral_home;
    }

    public void setFuneral_home(boolean funeral_home) {
        this.funeral_home = funeral_home;
    }

    public boolean isFurniture_store() {
        return furniture_store;
    }

    public void setFurniture_store(boolean furniture_store) {
        this.furniture_store = furniture_store;
    }

    public boolean isGas_station() {
        return gas_station;
    }

    public void setGas_station(boolean gas_station) {
        this.gas_station = gas_station;
    }

    public boolean isGym() {
        return gym;
    }

    public void setGym(boolean gym) {
        this.gym = gym;
    }

    public boolean isHair_care() {
        return hair_care;
    }

    public void setHair_care(boolean hair_care) {
        this.hair_care = hair_care;
    }

    public boolean isHardware_store() {
        return hardware_store;
    }

    public void setHardware_store(boolean hardware_store) {
        this.hardware_store = hardware_store;
    }

    public boolean isHindu_temple() {
        return hindu_temple;
    }

    public void setHindu_temple(boolean hindu_temple) {
        this.hindu_temple = hindu_temple;
    }

    public boolean isHome_goods_store() {
        return home_goods_store;
    }

    public void setHome_goods_store(boolean home_goods_store) {
        this.home_goods_store = home_goods_store;
    }

    public boolean isHospital() {
        return hospital;
    }

    public void setHospital(boolean hospital) {
        this.hospital = hospital;
    }

    public boolean isInsurance_agency() {
        return insurance_agency;
    }

    public void setInsurance_agency(boolean insurance_agency) {
        this.insurance_agency = insurance_agency;
    }

    public boolean isJewelry_store() {
        return jewelry_store;
    }

    public void setJewelry_store(boolean jewelry_store) {
        this.jewelry_store = jewelry_store;
    }

    public boolean isLaundry() {
        return laundry;
    }

    public void setLaundry(boolean laundry) {
        this.laundry = laundry;
    }

    public boolean isLawyer() {
        return lawyer;
    }

    public void setLawyer(boolean lawyer) {
        this.lawyer = lawyer;
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

    public boolean isLocal_government_office() {
        return local_government_office;
    }

    public void setLocal_government_office(boolean local_government_office) {
        this.local_government_office = local_government_office;
    }

    public boolean isLocksmith() {
        return locksmith;
    }

    public void setLocksmith(boolean locksmith) {
        this.locksmith = locksmith;
    }

    public boolean isLodging() {
        return lodging;
    }

    public void setLodging(boolean lodging) {
        this.lodging = lodging;
    }

    public boolean isMeal_delivery() {
        return meal_delivery;
    }

    public void setMeal_delivery(boolean meal_delivery) {
        this.meal_delivery = meal_delivery;
    }

    public boolean isMeal_takeaway() {
        return meal_takeaway;
    }

    public void setMeal_takeaway(boolean meal_takeaway) {
        this.meal_takeaway = meal_takeaway;
    }

    public boolean isMosque() {
        return mosque;
    }

    public void setMosque(boolean mosque) {
        this.mosque = mosque;
    }

    public boolean isMovie_rental() {
        return movie_rental;
    }

    public void setMovie_rental(boolean movie_rental) {
        this.movie_rental = movie_rental;
    }

    public boolean isMovie_theater() {
        return movie_theater;
    }

    public void setMovie_theater(boolean movie_theater) {
        this.movie_theater = movie_theater;
    }

    public boolean isMoving_company() {
        return moving_company;
    }

    public void setMoving_company(boolean moving_company) {
        this.moving_company = moving_company;
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

    public boolean isPainter() {
        return painter;
    }

    public void setPainter(boolean painter) {
        this.painter = painter;
    }

    public boolean isPark() {
        return park;
    }

    public void setPark(boolean park) {
        this.park = park;
    }

    public boolean isParking() {
        return parking;
    }

    public void setParking(boolean parking) {
        this.parking = parking;
    }

    public boolean isPet_store() {
        return pet_store;
    }

    public void setPet_store(boolean pet_store) {
        this.pet_store = pet_store;
    }

    public boolean isPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(boolean pharmacy) {
        this.pharmacy = pharmacy;
    }

    public boolean isPhysiotherapist() {
        return physiotherapist;
    }

    public void setPhysiotherapist(boolean physiotherapist) {
        this.physiotherapist = physiotherapist;
    }

    public boolean isPlumber() {
        return plumber;
    }

    public void setPlumber(boolean plumber) {
        this.plumber = plumber;
    }

    public boolean isPolice() {
        return police;
    }

    public void setPolice(boolean police) {
        this.police = police;
    }

    public boolean isPost_office() {
        return post_office;
    }

    public void setPost_office(boolean post_office) {
        this.post_office = post_office;
    }

    public boolean isReal_estate_agency() {
        return real_estate_agency;
    }

    public void setReal_estate_agency(boolean real_estate_agency) {
        this.real_estate_agency = real_estate_agency;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isRoofing_contractor() {
        return roofing_contractor;
    }

    public void setRoofing_contractor(boolean roofing_contractor) {
        this.roofing_contractor = roofing_contractor;
    }

    public boolean isRv_park() {
        return rv_park;
    }

    public void setRv_park(boolean rv_park) {
        this.rv_park = rv_park;
    }

    public boolean isSchool() {
        return school;
    }

    public void setSchool(boolean school) {
        this.school = school;
    }

    public boolean isShoe_store() {
        return shoe_store;
    }

    public void setShoe_store(boolean shoe_store) {
        this.shoe_store = shoe_store;
    }

    public boolean isShopping_mall() {
        return shopping_mall;
    }

    public void setShopping_mall(boolean shopping_mall) {
        this.shopping_mall = shopping_mall;
    }

    public boolean isSpa() {
        return spa;
    }

    public void setSpa(boolean spa) {
        this.spa = spa;
    }

    public boolean isStadium() {
        return stadium;
    }

    public void setStadium(boolean stadium) {
        this.stadium = stadium;
    }

    public boolean isStorage() {
        return storage;
    }

    public void setStorage(boolean storage) {
        this.storage = storage;
    }

    public boolean isStore() {
        return store;
    }

    public void setStore(boolean store) {
        this.store = store;
    }

    public boolean isSubway_station() {
        return subway_station;
    }

    public void setSubway_station(boolean subway_station) {
        this.subway_station = subway_station;
    }

    public boolean isSupermarket() {
        return supermarket;
    }

    public void setSupermarket(boolean supermarket) {
        this.supermarket = supermarket;
    }

    public boolean isSynagogue() {
        return synagogue;
    }

    public void setSynagogue(boolean synagogue) {
        this.synagogue = synagogue;
    }

    public boolean isTaxi_stand() {
        return taxi_stand;
    }

    public void setTaxi_stand(boolean taxi_stand) {
        this.taxi_stand = taxi_stand;
    }

    public boolean isTrain_station() {
        return train_station;
    }

    public void setTrain_station(boolean train_station) {
        this.train_station = train_station;
    }

    public boolean isTransit_station() {
        return transit_station;
    }

    public void setTransit_station(boolean transit_station) {
        this.transit_station = transit_station;
    }

    public boolean isTravel_agency() {
        return travel_agency;
    }

    public void setTravel_agency(boolean travel_agency) {
        this.travel_agency = travel_agency;
    }

    public boolean isVeterinary_care() {
        return veterinary_care;
    }

    public void setVeterinary_care(boolean veterinary_care) {
        this.veterinary_care = veterinary_care;
    }

    public boolean isZoo() {
        return zoo;
    }

    public void setZoo(boolean zoo) {
        this.zoo = zoo;
    }
}