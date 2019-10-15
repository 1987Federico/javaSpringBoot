package com.aguero.federico.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aguero.federico.model.Bco;
import com.aguero.federico.repository.BcoRepository;

@Service
public class BcoServices {

	@Autowired
	private BcoRepository repository;

	public List<Bco> getPostalCode(String postalCode) {
		Iterable<Bco> bco = repository.findAll();
		List<Bco> list=new ArrayList<>();
		for(Bco b:bco) {
			if(b.getAddress().getBcoPostalCode().contentEquals(postalCode))
				list.add(b);
		}
		
		return list;
	}

	public List<Bco> list() {
		Iterable<Bco> bco = repository.findAll();
		List<Bco> list = new ArrayList<>();
		bco.forEach(list::add);
		return list;
	}

	public Bco getGeoLocation(double lat, double lng) {
		Bco ban = null;
		Iterable<Bco> bco = repository.findAll();
		List<Bco> list = new ArrayList<>();
		System.out.println("latitud===" + lat + "longitu=== " + lng);
		bco.forEach(list::add);
		for (Bco b : list) {
			if (b.getAddress().getBcoGeoLocation().getLat() == lat
					&& (double) b.getAddress().getBcoGeoLocation().getLng() == lng)
				ban = b;
		}
		return ban;

	}

	public List<Bco> bulkCreate(List<Bco> bcoNuevo) {
		Iterable<Bco> bco = bcoNuevo;
		repository.saveAll(bco);
		bco = repository.findAll();
		List<Bco> list = new ArrayList<>();
		bco.forEach(list::add);
		return list;
	}
}
