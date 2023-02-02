package gabriel.com.academy.dto;

import java.io.Serializable;

import gabriel.com.academy.entity.Matricula;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MatriculaForm implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Positive(message = "O id só aceita valores positivos")
	private long alunoId;

	public MatriculaForm(Matricula matricula) {
		alunoId= matricula.getAluno().getId();
	}
}