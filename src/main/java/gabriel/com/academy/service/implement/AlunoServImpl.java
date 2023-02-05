package gabriel.com.academy.service.implement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.dto.AlunoUpdateForm;
import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.infra.jackson.utils.JavaTimeUtils;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.service.IAlunoService;
import gabriel.com.academy.service.exception.DatabaseException;
import gabriel.com.academy.service.exception.ObjectNotFoundException;
import gabriel.com.academy.service.exception.ResourceNotFoundException;

@Service
public class AlunoServImpl implements IAlunoService {

	@Autowired
	private AlunoRepository rep;

	@Override
	public AlunoForm create(AlunoForm  form) {
		
		Aluno aluno = fromAlunoForm(form);
		return new AlunoForm(rep.save(aluno));

	}

	@Override
	public AlunoForm get(Long id) {
		
		Optional<Aluno> aluno = rep.findById(id);
		Aluno newAluno = aluno.orElseThrow(()-> new ObjectNotFoundException("Aluno não encontrado"));
		
		return new AlunoForm(newAluno);
	}

	 @Override
	  public List<AlunoForm> getAll(String dataDeNascimento) {

	    if(dataDeNascimento == null) {
	      return  rep.findAll().stream().map(AlunoForm::new).collect(Collectors.toList());
	    } else {
	      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
	      return rep.findByDataDeNascimento(localDate).stream().map(AlunoForm::new).collect(Collectors.toList());
	    }

	  }

	@Override
	public AlunoUpdateForm update(AlunoUpdateForm form, Long id) {
		Optional<Aluno> aluno = rep.findById(id);
		Aluno newAluno= aluno.orElseThrow(()-> new ObjectNotFoundException("aluno não encontrado"));
		
		newAluno.setNome(form.getNome());
		newAluno.setBairro(form.getBairro());
		newAluno.setDataDeNascimento(form.getDataDeNascimento());
		
		return new AlunoUpdateForm(newAluno);
	}
	


	@Override
	public void delete(Long id) {
		try {
			rep.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
		

	}

	@Override
	public List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(Long id) {
		Optional<Aluno> aluno = rep.findById(id);
		Aluno newAluno= aluno.orElseThrow(()-> new ObjectNotFoundException("aluno não encontrado"));

		return newAluno.getAvaliacoes().stream().map(AvaliacaoFisicaForm::new).collect(Collectors.toList());
	}


	public Aluno fromAlunoForm(AlunoForm form) {
		return new Aluno(form.getId(),form.getNome(), form.getCpf(), form.getBairro(),form.getDataDeNascimento(),null);
		
	}

	
}
