package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.dto.AlunoUpdateForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.AvaliacaoFisica;

public interface IAlunoService {

	Aluno create (AlunoForm form);
	Aluno get(Long id);
	List<Aluno> getAll(String dataDeNascimento);
	Aluno update(Long id, AlunoUpdateForm formUpdate);
	void delete(Long id);
	List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id);

}
