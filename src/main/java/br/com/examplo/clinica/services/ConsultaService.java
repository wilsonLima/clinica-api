package br.com.examplo.clinica.services;

import java.util.List;

import br.com.examplo.clinica.domain.Consulta;

public interface ConsultaService {

	long count();

	long delete(final Consulta consultaObj);

	long delete(final Long id);

	Consulta findById(final Long id);

	List<Consulta> list(final long first, final long count);

	List<Consulta> listAll();

	Consulta save(final Consulta consultaObj);
}
