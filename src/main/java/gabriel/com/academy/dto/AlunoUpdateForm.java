package gabriel.com.academy.dto;

import java.io.Serializable;
import java.time.LocalDate;

import gabriel.com.academy.entity.Aluno;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class AlunoUpdateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String bairro;
	private LocalDate dataDeNascimento;
	
	
	public AlunoUpdateForm(Aluno aluno) {
		
		nome = aluno.getNome();
		bairro =aluno.getBairro();
		dataDeNascimento=aluno.getDataDeNascimento();
	}
}
