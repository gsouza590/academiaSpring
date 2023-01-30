package gabriel.com.academy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gabriel.com.academy.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula,Long>{

	List<Matricula>findByAlunoBairro(String bairro);

	
}
