package gabriel.com.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.AvaliacaoFisica;
import gabriel.com.academy.service.implement.AlunoServImpl;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoServImpl service;

	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {
		return service.getAll(dataDeNacimento);
	}

	@PostMapping
	public Aluno create(@Valid @RequestBody AlunoForm form) {
		return service.create(form);
	}

	@GetMapping("/avaliacoes/{id}")
	public List<AvaliacaoFisica> getAllAvaliacoes(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}

}
