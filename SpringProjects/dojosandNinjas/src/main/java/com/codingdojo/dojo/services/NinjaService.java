package com.codingdojo.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.dojo.models.Ninja;
import com.codingdojo.dojo.repositories.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepository.findAll();
	}
	
	//create ninja
	public Ninja createNinja(Ninja N) {
		return ninjaRepository.save(N);
	}
	
	public Ninja ReadOne(Long id) {
		Optional<Ninja> ninja = ninjaRepository.findById(id);
		return ninja.isPresent()?ninja.get():null;
	}
	
	public List<Ninja> searchFor(Long id){
		return ninjaRepository.findAllNinjasByDojo_Id(id);
	}
}
