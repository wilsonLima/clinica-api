package br.com.examplo.clinica.repository.impl;

import static br.com.examplo.clinica.domain.QConsulta.consulta;
import static br.com.examplo.clinica.domain.QPaciente.paciente;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.Tuple;

import br.com.examplo.clinica.domain.Paciente;
import br.com.examplo.clinica.domain.Sexo;
import br.com.examplo.clinica.repository.PacienteRepository;
import br.com.examplo.clinica.repository.query.IQueryFactoryHelper;

@Repository
public class PacienteRepositoryImpl implements PacienteRepository {

	private final IQueryFactoryHelper queryHelper;

	@Inject
	public PacienteRepositoryImpl(final IQueryFactoryHelper queryHelper) {
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
				.from(paciente) //
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
				.delete(paciente) //
				.where(paciente.id.eq(id)) //
				.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long atualizarStatus(final Long idPaciente, final Boolean status) {
		if (Objects.isNull(idPaciente) || Objects.isNull(status)) {
			return 0l;
		}
		return queryHelper.factory() //
				.update(paciente) //
				.set(paciente.ativo, status) //
				.where(paciente.id.eq(idPaciente)) //
				.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Paciente> listAll() {
		return queryHelper.factory() //
				.select(paciente) //
				.from(paciente) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Paciente> list(final long first, final long count) {
		return queryHelper.factory() //
				.select(paciente) //
				.from(paciente) //
				.offset(first) //
				.limit(count) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paciente buscaPorId(final Long id) {
		if (Objects.isNull(id)) {
			return null;
		}
		return queryHelper.factory() //
				.select(paciente) //
				.from(paciente) //
				.where(paciente.id.eq(id)) //
				.fetchOne();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Sexo, Long> pacientesPorSexo() {
		final Map<Sexo, Long> result = new TreeMap<>();
		final List<Tuple> list = queryHelper.factory() //
				.select(paciente.sexo, paciente.count()) //
				.from(paciente) //
				.groupBy(paciente.sexo) //
				.fetch();
		list.stream().forEach(t -> result.put(t.get(paciente.sexo), t.get(paciente.count())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Boolean, Long> pacientesPorStatus() {
		final Map<Boolean, Long> result = new TreeMap<>();
		final List<Tuple> list = queryHelper.factory() //
				.select(paciente.ativo, paciente.count()) //
				.from(paciente) //
				.groupBy(paciente.ativo) //
				.fetch();
		list.stream().forEach(t -> result.put(t.get(paciente.ativo), t.get(paciente.count())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existemConsultasParaOPaciente(final Long idPaciente) {
		if (Objects.isNull(idPaciente)) {
			return false;
		}
		final long count = queryHelper.factory() //
				.select() //
				.from(paciente) //
				.where(paciente.id.eq(idPaciente), //
						queryHelper.factory().select() //
								.from(consulta) //
								.where(consulta.paciente().id.eq(paciente.id)) //
								.exists()) //
				.fetchCount();
		return count > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> listaPacientesPorSexo(final Sexo sexo) {
		if (Objects.isNull(sexo)) {
			return new ArrayList<>();
		}
		return queryHelper.factory() //
				.select(paciente.nome) //
				.from(paciente) //
				.where(paciente.sexo.eq(sexo)) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Paciente save(final Paciente pacienteObj) {
		return queryHelper.save(pacienteObj);
	}

}
