package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonaController {

	@Autowired
	private Servicio servicio;

	@PostConstruct
	public void init() {
		
		servicio.init();
		
	}
  
	@RequestMapping(path="/consulta")
	@ResponseBody
	public Integer consulta () {
		
		StopWatch sp = new StopWatch();
		sp.start("consulta");
		int nombre = servicio.consulta().size();
		sp.stop();
		System.out.println(sp.prettyPrint());
		return nombre;
		
	}

}
