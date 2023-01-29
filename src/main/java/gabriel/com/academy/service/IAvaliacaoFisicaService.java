package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.dto.AvaliacaoFisicaUpdateForm;
import gabriel.com.academy.entity.AvaliacaoFisica;

public interface IAvaliacaoFisicaService {

	  AvaliacaoFisica create(AvaliacaoFisicaForm form);
	  AvaliacaoFisica get(Long id);
	  List<AvaliacaoFisica> getAll();
	  AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate);
	  void delete(Long id);
}
