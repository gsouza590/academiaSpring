package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Matricula;

public interface IMatriculaService  {

	 MatriculaForm create(MatriculaForm form);
	 MatriculaForm get(Long id);
	 List<MatriculaForm> getAll(String bairro);
	 void delete(Long id);
	
}
