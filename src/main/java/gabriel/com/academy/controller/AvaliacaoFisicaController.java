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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.dto.AvaliacaoFisicaUpdateForm;
import gabriel.com.academy.service.implement.AvaliacaoFisicaImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaImpl service;

	

	@PostMapping
	@Transactional
	public ResponseEntity<AvaliacaoFisicaForm> create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		AvaliacaoFisicaForm avaliacao = service.create(form);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(avaliacao.getAltura()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<List<AvaliacaoFisicaForm>> getAll() {
		return ResponseEntity.ok().body(service.getAll());

	}
	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<AvaliacaoFisicaForm> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.get(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AvaliacaoFisicaUpdateForm> update(@RequestBody AvaliacaoFisicaUpdateForm form, @PathVariable Long id) {

		AvaliacaoFisicaUpdateForm dto = service.update(id, form);

		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
