package com.valentina.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import com.valentina.modelos.Cancion;

public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {

	@Override
	@NonNull
	List<Cancion> findAll();
}
