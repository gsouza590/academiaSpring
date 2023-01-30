package gabriel.com.academy.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriel.com.academy.dto.MatriculaForm;
import gabriel.com.academy.entity.Aluno;
import gabriel.com.academy.entity.Matricula;
import gabriel.com.academy.repository.AlunoRepository;
import gabriel.com.academy.repository.MatriculaRepository;
import gabriel.com.academy.service.IMatriculaService;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

  @Autowired
  private MatriculaRepository matriculaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  @Override
  public Matricula create(MatriculaForm form) {
    Matricula matricula = new Matricula();
    Aluno aluno = alunoRepository.findById(form.alunoId()).get();

    matricula.setAluno(aluno);

    return matriculaRepository.save(matricula);
  }

  @Override
  public Matricula get(Long id) {
    return matriculaRepository.findById(id).get();
  }

  @Override
  public List<Matricula> getAll(String bairro) {

    if(bairro == null){
      return matriculaRepository.findAll();
    }else{
      return matriculaRepository.findByAlunoBairro(bairro);
    }

  }

  @Override
  public void delete(Long id) {}



}