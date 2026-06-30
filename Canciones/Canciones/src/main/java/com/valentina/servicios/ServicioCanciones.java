package com.valentina.servicios;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.valentina.modelos.Cancion;
import com.valentina.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {

	private final RepositorioCanciones repoCanciones;

	public ServicioCanciones(RepositorioCanciones repoCanciones) {
		this.repoCanciones = repoCanciones;
	}

	public List<Cancion> obtenerTodasLasCanciones() {
		return this.repoCanciones.findAll();
	}

	public Cancion obtenerCancionPorId(Long id) {
		Objects.requireNonNull(id, "El id no puede ser null");
		return repoCanciones.findById(id).orElseThrow(() -> new IllegalArgumentException("No se encontró la canción con id " + id));
	}
	
	public Cancion agregarCancion(Cancion cancion) {
    return repoCanciones.save(cancion);
    }
	public Cancion actualizaCancion(Cancion cancion) {
    return repoCanciones.save(cancion);
    }

	public void eliminaCancion(Long id) {
    repoCanciones.deleteById(id);
}

}
