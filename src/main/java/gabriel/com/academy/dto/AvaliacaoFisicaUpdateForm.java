package gabriel.com.academy.dto;

import java.io.Serializable;

import gabriel.com.academy.entity.AvaliacaoFisica;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoFisicaUpdateForm implements Serializable {

	private static final long serialVersionUID = 1L;

	private double peso;
	private double altura;

	public AvaliacaoFisicaUpdateForm(AvaliacaoFisica avaliacao) {

		peso = avaliacao.getPeso();
		altura = avaliacao.getAltura();

	}
}