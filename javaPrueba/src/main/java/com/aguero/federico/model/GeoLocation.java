package com.aguero.federico.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class GeoLocation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4298344654542334543L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("lat")
    private double lat;

    @JsonProperty("lng")
    private double lng;

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    /*public Long getId() {
        return id;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

}
