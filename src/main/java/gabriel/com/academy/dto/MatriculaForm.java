package gabriel.com.academy.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record MatriculaForm(
		@NotNull
		@Positive(message = "O id só aceita valores positivos")
		long alunoId) {

}
