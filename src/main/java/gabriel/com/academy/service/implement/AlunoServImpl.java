package gabriel.com.academy.service.implement;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.dto.AlunoUpdateForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.AvaliacaoFisica;
import gabriel.com.academy.infra.jackson.utils.JavaTimeUtils;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.service.IAlunoService;

@Service
public class AlunoServImpl implements IAlunoService {

	@Autowired
	private AlunoRepository rep;

	@Override
	public Aluno create(AlunoForm form) {
		Aluno aluno = new Aluno();
		aluno.setNome(form.nome());
		aluno.setCpf(form.cpf());
		aluno.setBairro(form.bairro());
		aluno.setDataDeNascimento(form.dataDeNascimento());
		return rep.save(aluno);

	}

	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	  public List<Aluno> getAll(String dataDeNascimento) {

	    if(dataDeNascimento == null) {
	      return rep.findAll();
	    } else {
	      LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
	      return rep.findByDataDeNascimento(localDate);
	    }

	  }

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
		Aluno aluno = rep.findById(id).get();
		return aluno.getAvaliacoes();
	}

	@Override
	public List<Aluno> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
