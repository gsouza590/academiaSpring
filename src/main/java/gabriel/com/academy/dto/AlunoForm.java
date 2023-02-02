package gabriel.com.academy.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import gabriel.com.academy.entity.Aluno;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AlunoForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Preencha o campo de forma correta.")
	private String nome;
	@CPF
	private String cpf;
	@NotBlank(message = "Preencha o campo de forma correta.")
	private String bairro;
	@Past
	private LocalDate dataDeNascimento;

	public AlunoForm(Aluno aluno) {
		id= aluno.getId();
		nome = aluno.getNome();
		cpf= aluno.getCpf();
		bairro = aluno.getBairro();
		dataDeNascimento = aluno.getDataDeNascimento();
	}
}
