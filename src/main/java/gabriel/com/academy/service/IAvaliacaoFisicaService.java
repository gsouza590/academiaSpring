package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.AvaliacaoFisicaForm;
import gabriel.com.academy.dto.AvaliacaoFisicaUpdateForm;

public interface IAvaliacaoFisicaService {

	  AvaliacaoFisicaForm create(AvaliacaoFisicaForm form);
	  AvaliacaoFisicaForm get(Long id);
	  List<AvaliacaoFisicaForm> getAll();
	  AvaliacaoFisicaUpdateForm update(Long id, AvaliacaoFisicaUpdateForm formUpdate);
	  void delete(Long id);
}
