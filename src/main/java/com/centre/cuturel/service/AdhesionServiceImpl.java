package com.centre.cuturel.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.centre.cuturel.model.Adhesion;
import com.centre.cuturel.repository.AdhesionRepository;


@Service
public class AdhesionServiceImpl implements AdhesionService {
	
	private AdhesionRepository adhesionRepository;

	public AdhesionServiceImpl(AdhesionRepository adhesionRepository) {
		this.adhesionRepository = adhesionRepository;
	}

	@Override
	public Adhesion saveAdhesion(Adhesion adhesion) {
		return adhesionRepository.save(adhesion);
	}

	@Override
	public List<Adhesion> getAllAdhesions() {
		return (List<Adhesion>) adhesionRepository.findAll();
	}

	@Override
	public Adhesion getAdhesionById(Long id) {
		Optional<Adhesion> adhesion = adhesionRepository.findById(id);
		if(adhesion.isPresent()) {
			return adhesion.get();
		} else {
			throw new IllegalArgumentException("Adherant not found" +id);
		}
	}

	@Override
	public Adhesion updateAdhesion(Adhesion adhesion, long id) {
		Adhesion existingAdhesion = adhesionRepository.findById(id).orElseThrow(() ->
						new IllegalArgumentException("Adherant" +id + "is not present"));
		existingAdhesion.setNom(adhesion.getNom());
		existingAdhesion.setPrenom(adhesion.getPrenom());
		existingAdhesion.setEmail(adhesion.getEmail());
		existingAdhesion.setTel(adhesion.getTel());
		existingAdhesion.setProfession(adhesion.getProfession());
		adhesionRepository.save(existingAdhesion);
		return existingAdhesion;
	}

	@Override
	public void deleteAdhesion(long id) {
		adhesionRepository.findById(id).orElseThrow(() ->
		new IllegalArgumentException("Adherant" +id + "is not present"));
		adhesionRepository.deleteById(id);
	}
	

}
