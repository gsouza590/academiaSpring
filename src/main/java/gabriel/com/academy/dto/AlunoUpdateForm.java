package gabriel.com.academy.dto;

import java.time.LocalDate;

public record AlunoUpdateForm(
		String nome,
		String bairro,
		LocalDate dataDeNascimento ) {

}
