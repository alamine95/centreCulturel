package com.centre.cuturel.service;


import java.util.List;

import com.centre.cuturel.model.Adhesion;

public interface AdhesionService {

	public Adhesion saveAdhesion(Adhesion adhesion);
	public List<Adhesion> getAllAdhesions();
	public Adhesion getAdhesionById(Long id);
	public Adhesion updateAdhesion(Adhesion adhesion, long id);
	public void deleteAdhesion(long id);
}
