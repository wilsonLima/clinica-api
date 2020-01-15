package br.com.examplo.clinica.services;

import java.util.List;

import br.com.examplo.clinica.domain.Paciente;

public interface PacienteService {

	long count();

	long delete(final Long id);

	long delete(final Paciente pacienteObj);

	Paciente findById(final Long id);

	List<Paciente> list(final long first, final long count);

	List<Paciente> listAll();

	Paciente save(final Paciente pacienteObj);
}
