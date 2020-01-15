package br.com.examplo.clinica.repository;

import java.util.List;
import java.util.Map;

import br.com.examplo.clinica.domain.Medico;

public interface MedicoRepository {

	long count();

	long remover(Long id);

	Medico buscaPorId(Long id);

	List<Medico> listAll();

	List<Medico> list(final long first, final long count);

	Map<String, Long> medicosPorEspecialidade();

	Medico save(Medico medicoObj);

}
