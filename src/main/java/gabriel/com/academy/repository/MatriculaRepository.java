package gabriel.com.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula,Long>{

	List<MatriculaForm> findByAlunoBairro(String bairro);

	
}
