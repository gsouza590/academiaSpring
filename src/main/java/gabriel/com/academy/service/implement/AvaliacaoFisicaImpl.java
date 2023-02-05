package gabriel.com.academy.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.dto.AvaliacaoFisicaUpdateForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.AvaliacaoFisica;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.repository.AvaliacaoRepository;
import gabriel.com.academy.service.IAvaliacaoFisicaService;
import gabriel.com.academy.service.exception.DatabaseException;
import gabriel.com.academy.service.exception.ObjectNotFoundException;
import gabriel.com.academy.service.exception.ResourceNotFoundException;

@Service
public class AvaliacaoFisicaImpl implements IAvaliacaoFisicaService {

	@Autowired
	AvaliacaoRepository repository;

	@Autowired
	AlunoRepository alunoRepository;

	@Override
	public AvaliacaoFisicaForm create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		avaliacao.setAluno(aluno);
		avaliacao.setPeso(form.getPeso());
		avaliacao.setAltura(form.getAltura());

		return new AvaliacaoFisicaForm(repository.save(avaliacao));
	}

	@Override
	public AvaliacaoFisicaForm get(Long id) {
		Optional<AvaliacaoFisica> avaliacao = repository.findById(id);
		AvaliacaoFisica newavaliacao = avaliacao.orElseThrow(()-> new ObjectNotFoundException("Avaliacao não encontrada"));
		return new AvaliacaoFisicaForm(newavaliacao);
	}

	@Override
	public List<AvaliacaoFisicaForm> getAll() {
		return  repository.findAll().stream().map(AvaliacaoFisicaForm::new).collect(Collectors.toList());
	}

	@Override
	public AvaliacaoFisicaUpdateForm update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		Optional<AvaliacaoFisica> avaliacao = repository.findById(id);
		AvaliacaoFisica newavaliacao = avaliacao.orElseThrow(()-> new ObjectNotFoundException("Avaliacao não encontrada"));
	
		newavaliacao.setPeso(formUpdate.getPeso());
		newavaliacao.setAltura(formUpdate.getAltura());
		return new AvaliacaoFisicaUpdateForm(newavaliacao);
	}

	@Override
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		

	}
}
