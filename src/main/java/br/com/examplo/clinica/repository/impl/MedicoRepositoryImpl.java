package br.com.examplo.clinica.repository.impl;

import static br.com.examplo.clinica.domain.QMedico.medico;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;

import br.com.examplo.clinica.domain.Medico;
import br.com.examplo.clinica.repository.MedicoRepository;
import br.com.examplo.clinica.repository.query.IQueryFactoryHelper;

@Repository
public class MedicoRepositoryImpl implements MedicoRepository {

	private final IQueryFactoryHelper queryHelper;

	@Inject
	public MedicoRepositoryImpl(final IQueryFactoryHelper queryHelper) {
		super();
		this.queryHelper = queryHelper;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long count() {
		return queryHelper.factory() //
				.select() //
				.from(medico) //
				.fetchCount();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long remover(final Long id) {
		if (Objects.isNull(id)) {
			return 0l;
		}
		return queryHelper.factory() //
				.delete(medico) //
				.where(medico.id.eq(id)) //
				.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Medico buscaPorId(final Long id) {
		if (Objects.isNull(id)) {
			return null;
		}
		return queryHelper.factory() //
				.select(medico) //
				.from(medico) //
				.where(medico.id.eq(id)) //
				.fetchOne();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Medico> listAll() {
		return queryHelper.factory() //
				.select(medico) //
				.from(medico) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Medico> list(final long first, final long count) {
		return queryHelper.factory() //
				.select(medico) //
				.from(medico) //
				.offset(first) //
				.limit(count) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Long> medicosPorEspecialidade() {
		final List<Tuple> list = queryHelper.factory() //
				.select(medico.especialidade().nome, medico.count()) //
				.from(medico) //
				.groupBy(medico.especialidade().nome) //
				.fetch();
		final Map<String, Long> result = new TreeMap<>();
		list.stream().forEach((r) -> result.put(r.get(medico.especialidade().nome), r.get(medico.count())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Medico save(final Medico medicoObj) {
		return queryHelper.save(medicoObj);
	}

}
