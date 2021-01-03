package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {

	@Autowired
	private Servicio servicio;

	@RequestMapping(path="/antecedentes")
	@ResponseBody
	public String antecedentes (long id) {
		
		String resultado = servicio.consultaAntencedentes(id);
		return resultado;
		
	}
	
	@RequestMapping(path="/nombre")
	@ResponseBody
	public String nombre (long id) {
		return servicio.consultaNombre(id);
	}

}
