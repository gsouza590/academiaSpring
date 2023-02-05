package gabriel.com.academy.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.dto.AlunoUpdateForm;
import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.service.implement.AlunoServImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoServImpl service;

	@GetMapping
	@Transactional
	public ResponseEntity<List<AlunoForm>> getAll(
			@RequestParam(value = "dataDeNascimento", required = false) String dataDeNacimento) {

		return ResponseEntity.ok().body(service.getAll(dataDeNacimento));

	}

	@PostMapping
	@Transactional
	public ResponseEntity<AlunoForm> create(@Valid @RequestBody AlunoForm form) {
		AlunoForm aluno = service.create(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluno.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoForm> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.get(id));
	}

	@GetMapping("/avaliacoes/{id}")
	@Transactional
	public List<AvaliacaoFisicaForm> getAllAvaliacoes(@PathVariable Long id) {
		return service.getAllAvaliacaoFisicaId(id);
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AlunoUpdateForm> update(@RequestBody AlunoUpdateForm form, @PathVariable Long id) {

		AlunoUpdateForm dto = service.update(form, id);

		return ResponseEntity.ok(dto);
	}

	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
