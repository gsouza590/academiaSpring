package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.AlunoForm;
import gabriel.com.academy.dto.AlunoUpdateForm;
import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.entity.AvaliacaoFisica;

public interface IAlunoService {

	AlunoForm get(Long id);
	void delete(Long id);
	List<AvaliacaoFisicaForm> getAllAvaliacaoFisicaId(Long id);
	List<AlunoForm> getAll(String dataDeNascimento);
	AlunoUpdateForm update(AlunoUpdateForm form, Long id);
	AlunoForm create(AlunoForm form);

}
