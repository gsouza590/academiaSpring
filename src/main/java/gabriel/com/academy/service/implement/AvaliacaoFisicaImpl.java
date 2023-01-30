package gabriel.com.academy.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.dto.AvaliacaoFisicaUpdateForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.AvaliacaoFisica;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.repository.AvaliacaoRepository;
import gabriel.com.academy.service.IAvaliacaoFisicaService;

@Service
public class AvaliacaoFisicaImpl implements IAvaliacaoFisicaService{

	@Autowired
	AvaliacaoRepository repository;
	
	@Autowired
	AlunoRepository alunoRepository;
	
	@Override
	public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
		AvaliacaoFisica avaliacao = new AvaliacaoFisica();
		Aluno aluno = alunoRepository.findById(form.alunoId()).get();
		
		avaliacao.setAluno(aluno);
		avaliacao.setPeso(form.peso());
		avaliacao.setAltura(form.altura());
		
		return repository.save(avaliacao);
	}

	@Override
	public AvaliacaoFisica get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvaliacaoFisica> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
