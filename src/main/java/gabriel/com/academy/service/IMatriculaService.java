package gabriel.com.academy.service;

import java.util.List;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Matricula;

public interface IMatriculaService  {

	 Matricula create(MatriculaForm form);
	 Matricula get(Long id);
	 List<Matricula> getAll(String bairro);
	 void delete(Long id);
	
}
