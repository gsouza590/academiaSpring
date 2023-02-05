package gabriel.com.academy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.service.implement.MatriculaServiceImpl;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

	@Autowired
	private MatriculaServiceImpl service;

	@PostMapping
	public MatriculaForm create(@Valid @RequestBody MatriculaForm form) {
		return service.create(form);
	}

	@GetMapping
	@Transactional
	public ResponseEntity<List<MatriculaForm>> getAll(@RequestParam(value = "bairro", required = false) String bairro) {

		return ResponseEntity.ok().body(service.getAll(bairro));

	}

	@GetMapping("/{id}")
	@Transactional
	public ResponseEntity<MatriculaForm> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.get(id));
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Long id) {

		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
