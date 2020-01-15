package br.com.examplo.clinica.functions;

import java.util.Objects;
import java.util.function.Function;

import br.com.examplo.clinica.domain.Especialidade;
import br.com.examplo.clinica.domain.dto.EspecialidadeDTO;

public class EspecialidadeToEspecialidadeDTOFunction implements Function<Especialidade, EspecialidadeDTO> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EspecialidadeDTO apply(final Especialidade especialidade) {
		if (Objects.nonNull(especialidade)) {
			return new EspecialidadeDTO(especialidade.getId(), especialidade.getNome());
		}
		return null;
	}

}
