package com.valentina.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.valentina.modelos.Cancion;
import com.valentina.servicios.ServicioCanciones;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

	private ServicioCanciones servicio;

	public ControladorCanciones(ServicioCanciones servicio) {
		this.servicio = servicio;
	}

//mostrar canciones
	@GetMapping("/canciones")
	public String desplegarCanciones(Model model) {
		model.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
		return "canciones.jsp";
	}
// mostrar detalle de una canción
	@GetMapping("/canciones/detalle/{idCancion}")
	public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
		Cancion cancion = servicio.obtenerCancionPorId(idCancion);
		model.addAttribute("cancion", cancion);
		return "detalleCancion.jsp";
	}
//formulario para agregar una cancion
    @GetMapping("/canciones/formulario/agregar/{idCancion}")
    public String formularioAgregarCancion(@PathVariable("idCancion") Long idCancion,
        @ModelAttribute("cancion") Cancion cancion) {
        return "agregarCancion.jsp";
}

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
//si hay errores, se regresa al formulario
        if (result.hasErrors()) {
        return "agregarCancion.jsp";
    }
//si no hay errores, se guarda la canción y se redirige a la lista de canciones
    servicio.agregarCancion(cancion);
        return "redirect:/canciones";
}
//formulario para editar una canción
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion,
        @ModelAttribute("cancion") Cancion cancion, Model model) {
        Cancion cancionExistente = servicio.obtenerCancionPorId(idCancion);
        model.addAttribute("cancion", cancionExistente);
        return "editarCancion.jsp";
}

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable("idCancion") Long idCancion,
        @Valid @ModelAttribute("cancion") Cancion cancion, BindingResult result) {
//si hay errores, se regresa al formulario
        if (result.hasErrors()) {
        return "editarCancion.jsp";
    }
//si no hay errores, se actualiza la canción y se redirige a la lista de canciones
    cancion.setId(idCancion);
        servicio.actualizaCancion(cancion);
        return "redirect:/canciones";
}
//procesar eliminar una cancion
@GetMapping("/canciones/eliminar/{idCancion}")
public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
    servicio.eliminaCancion(idCancion);
    return "redirect:/canciones";
}

}
