package gabriel.com.academy.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import gabriel.com.academy.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{

	List<Aluno>findByDataDeNascimento(LocalDate dataDeNascimento);

}
