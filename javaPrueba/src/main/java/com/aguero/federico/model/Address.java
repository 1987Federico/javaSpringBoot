package com.aguero.federico.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Address implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8145845456487401276L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("street")
//    @NotBlank
    private String bcoStreet;

    @JsonProperty("housenumber")
//    @NotNull
    private String bcoHousenumber;

    @JsonProperty("postalcode")
//    @NotBlank
    private String bcoPostalCode;

    @JsonProperty("city")
//    @NotBlank
    private String bcoCity;

    @JsonProperty("geoLocation")
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private GeoLocation bcoGeoLocation;

    /*public Long getId() {
        return id;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public String getBcoStreet() {
        return bcoStreet;
    }

    public void setBcoStreet(String bcoStreet) {
        this.bcoStreet = bcoStreet;
    }

    public String getBcoHousenumber() {
        return bcoHousenumber;
    }

    public void setBcoHousenumber(String bcoHousenumber) {
        this.bcoHousenumber = bcoHousenumber;
    }

    public String getBcoPostalCode() {
        return bcoPostalCode;
    }

    public void setBcoPostalCode(String bcoPostalCode) {
        this.bcoPostalCode = bcoPostalCode;
    }

    public String getBcoCity() {
        return bcoCity;
    }

    public void setBcoCity(String bcoCity) {
        this.bcoCity = bcoCity;
    }

    public GeoLocation getBcoGeoLocation() {
        return bcoGeoLocation;
    }

    public void setBcoGeoLocation(GeoLocation bcoGeoLocation) {
        this.bcoGeoLocation = bcoGeoLocation;
    }

}
