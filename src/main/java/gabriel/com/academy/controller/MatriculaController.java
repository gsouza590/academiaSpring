package gabriel.com.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Matricula;
import gabriel.com.academy.service.implement.MatriculaServiceImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl service;
	
	@PostMapping
	public Matricula create (@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}
	
	@GetMapping
	public List<Matricula> getAll(@RequestParam(value= "bairro", required=false) String bairro){
		return service.getAll(bairro);
	}
	
}
