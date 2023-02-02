package gabriel.com.academy.dto;

import java.io.Serializable;

import gabriel.com.academy.entity.AvaliacaoFisica;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoFisicaForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long alunoId;
	private double peso;
	private double altura;
	
	
	public AvaliacaoFisicaForm(AvaliacaoFisica avaliacao) {
		
		alunoId = avaliacao.getAluno().getId();
		peso = avaliacao.getPeso();
		altura = avaliacao.getAltura();
		
	}
}
