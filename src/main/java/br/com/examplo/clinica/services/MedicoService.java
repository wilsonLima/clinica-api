package br.com.examplo.clinica.services;

import java.util.List;

import br.com.examplo.clinica.domain.Medico;

public interface MedicoService {

	long count();

	long delete(final Medico medicoObj);

	long delete(final Long id);

	Medico findById(final Long id);

	List<Medico> list(final long first, final long count);

	List<Medico> listAll();

	Medico save(final Medico medicoObj);
}
