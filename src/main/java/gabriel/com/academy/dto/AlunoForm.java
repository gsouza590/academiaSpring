package gabriel.com.academy.dto;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

public record AlunoForm(
		@NotBlank(message = "Preencha o campo de forma correta.")
		String nome, 
		@CPF
		String cpf,
		@NotBlank(message = "Preencha o campo de forma correta.")
		String bairro,
		@Past
		LocalDate dataDeNascimento) {

}
