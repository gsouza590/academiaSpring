package gabriel.com.academy.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.Matricula;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.repository.MatriculaRepository;
import gabriel.com.academy.service.IMatriculaService;
import gabriel.com.academy.service.exception.DatabaseException;
import gabriel.com.academy.service.exception.ObjectNotFoundException;
import gabriel.com.academy.service.exception.ResourceNotFoundException;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

	@Autowired
	private MatriculaRepository matriculaRepository;

	@Autowired
	private AlunoRepository alunoRepository;

	@Override
	public MatriculaForm create(MatriculaForm form) {
		Matricula matricula = new Matricula();
		Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

		matricula.setAluno(aluno);

		return new MatriculaForm(matriculaRepository.save(matricula));
	}

	@Override
	public MatriculaForm get(Long id) {
		Optional<Matricula> matricula = matriculaRepository.findById(id);
		Matricula newMatricula = matricula.orElseThrow(() -> new ObjectNotFoundException("Matricula não encontrada"));

		return new MatriculaForm(newMatricula);
	}

	@Override
	public List<MatriculaForm> getAll(String bairro) {

		if (bairro == null) {
			return matriculaRepository.findAll().stream().map(MatriculaForm::new).collect(Collectors.toList());
		} else {
			return matriculaRepository.findByAlunoBairro(bairro);
		}
	}

	@Override
	public void delete(Long id) {
		try {
			matriculaRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}