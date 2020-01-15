package br.com.examplo.clinica.repository.impl;

import static br.com.examplo.clinica.domain.QEspecialidade.especialidade;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import br.com.examplo.clinica.domain.Especialidade;
import br.com.examplo.clinica.repository.EspecialidadeRepository;
import br.com.examplo.clinica.repository.query.IQueryFactoryHelper;

@Repository
public class EspecialidadeRepositoryImpl implements EspecialidadeRepository {

	private final IQueryFactoryHelper queryHelper;

	@Inject
	public EspecialidadeRepositoryImpl(final IQueryFactoryHelper queryHelper) {
		super();
		this.queryHelper = queryHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Especialidade> listAll() {
		return queryHelper.factory() //
				.select(especialidade) //
				.from(especialidade) //
				.fetch();
	}
}
