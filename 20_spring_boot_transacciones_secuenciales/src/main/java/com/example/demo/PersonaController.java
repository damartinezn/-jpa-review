package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {

	@Autowired
	private Servicio servicio;

    @Value("${spring.jpa.open-in-view}")
    private String openInView;
    
	@RequestMapping(path="/consulta")
	@ResponseBody
	public boolean consulta (long id) {
		log();
		Persona primera = servicio.consulta(id);
		Persona segunda = servicio.consulta(id);
		
		return primera == segunda;
	}
	
    
	@RequestMapping(path="/modifica")
	@ResponseBody
	public String modifica (long id, String nombre) {
		log();
		
		servicio.modifica(id, nombre);
		return servicio.consulta(id).getNombre();
		
	}

	private void log() {
		System.out.println("------- usando : spring.jpa.open-in-view=" + openInView);
	}
}
