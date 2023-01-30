package gabriel.com.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.entity.AvaliacaoFisica;
import gabriel.com.academy.service.implement.AvaliacaoFisicaImpl;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaImpl service;

	

	
	@PostMapping
	public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
		return service.create(form);
	}
}
