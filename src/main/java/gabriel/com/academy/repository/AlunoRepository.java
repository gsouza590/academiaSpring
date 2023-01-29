package gabriel.com.academy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import gabriel.com.academy.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno,Long>{

}
