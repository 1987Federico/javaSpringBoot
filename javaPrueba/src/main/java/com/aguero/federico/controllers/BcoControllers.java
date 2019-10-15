package com.aguero.federico.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.aguero.federico.model.Bco;
import com.aguero.federico.services.BcoServices;

@RestController
public class BcoControllers {

	@Autowired
	private BcoServices bcoServices;

	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "Hello World!";
	}

	@RequestMapping(value = "/bancos", method = RequestMethod.GET)
	public ResponseEntity<Bco> list() {
		List<Bco> bco = bcoServices.list();

		return new ResponseEntity(bco, HttpStatus.OK);
	}

	@RequestMapping(value = "/postalCode", method = RequestMethod.GET)
	public ResponseEntity<Bco> bcoById(@RequestParam(value = "postalCode") String postalCode) {
		List<Bco> bco = bcoServices.getPostalCode(postalCode);
		return new ResponseEntity(bco, HttpStatus.OK);
	}

	@RequestMapping(value = "/bancoLatAndLong", method = RequestMethod.GET)
	public ResponseEntity<Bco> bcoBylatAndLong(@RequestParam(value = "lat") double lat,
			@RequestParam(value = "lng") double lng) {
		Bco bco = bcoServices.getGeoLocation(lat, lng);
		return new ResponseEntity(bco, HttpStatus.OK);
	}

	

	@RequestMapping(value = "/bulk_create", method = RequestMethod.POST)
	public ResponseEntity<Bco> bulkcreate(@Valid @RequestBody List<Bco> bcoList) {
		List<Bco> bcoCreated = bcoServices.bulkCreate(bcoList);

		return new ResponseEntity(bcoCreated, HttpStatus.CREATED);
	}

}
