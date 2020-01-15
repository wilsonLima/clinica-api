package br.com.examplo.clinica.repository.impl;

import static br.com.examplo.clinica.domain.QConsulta.consulta;
import static br.com.examplo.clinica.domain.QMedico.medico;
import static br.com.examplo.clinica.domain.QPaciente.paciente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;

import br.com.examplo.clinica.domain.Consulta;
import br.com.examplo.clinica.repository.ConsultaRepository;
import br.com.examplo.clinica.repository.query.IQueryFactoryHelper;

@Repository
public class ConsultaRepositoryImpl implements ConsultaRepository {

	private final IQueryFactoryHelper queryHelper;

	@Inject
	public ConsultaRepositoryImpl(final IQueryFactoryHelper queryHelper) {
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
				.from(consulta) //
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
				.delete(consulta) //
				.where(consulta.id.eq(id)) //
				.execute();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Consulta buscaPorId(final Long id) {
		if (Objects.isNull(id)) {
			return null;
		}
		return queryHelper.factory() //
				.select(consulta) //
				.from(consulta) //
				.where(consulta.id.eq(id)) //
				.fetchOne();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> listAll() {
		return queryHelper.factory() //
				.select(consulta) //
				.from(consulta) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> list(final long first, final long count) {
		return queryHelper.factory() //
				.select(consulta) //
				.from(consulta) //
				.offset(first) //
				.limit(count) //
				.fetch();
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
				.from(consulta) //
				.where(consulta.paciente().id.eq(idPaciente)) //
				.fetchCount();

		return count > 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> listaConsultasDoPaciente(final Long idPaciente) {
		if (Objects.isNull(idPaciente)) {
			return new ArrayList<>();
		}
		return queryHelper.factory() //
				.select(consulta) //
				.from(consulta) //
				.join(consulta.paciente(), paciente) //
				.where(paciente.id.eq(idPaciente)) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> listaConsultasDoPacienteEMedico(final Long idPaciente, final Long idMedico) {
		if (Objects.isNull(idPaciente) || Objects.isNull(idMedico)) {
			return new ArrayList<>();
		}
		final BooleanBuilder restricoes = new BooleanBuilder();
		restricoes.and(consulta.paciente().id.eq(idPaciente));
		restricoes.and(consulta.medico().id.eq(idMedico));
		return queryHelper.factory() //
				.select(consulta) //
				.from(consulta) //
				.where(restricoes) //
				.fetch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Long> consultasPorEspecialidade() {
		final List<Tuple> list = queryHelper.factory() //
				.select(consulta.medico().especialidade().nome, consulta.count()) //
				.from(consulta) //
				.groupBy(consulta.medico().especialidade().nome) //
				.fetch();
		final Map<String, Long> result = new TreeMap<>();
		list.stream().forEach((r) -> result.put(r.get(consulta.medico().especialidade().nome), r.get(consulta.count())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, BigDecimal> somaValoresDeConsultasPorEspecialidade() {
		final List<Tuple> list = queryHelper.factory() //
				.select(consulta.medico().especialidade().nome, consulta.valor.sum()) //
				.from(consulta) //
				.groupBy(consulta.medico().especialidade().nome) //
				.fetch();
		final Map<String, BigDecimal> result = new TreeMap<>();
		list.stream().forEach((r) -> result.put(r.get(consulta.medico().especialidade().nome), r.get(consulta.valor.sum())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, BigDecimal> somaValoresDeConsultasPorMedico() {
		final Map<String, BigDecimal> result = new HashMap<>();
		final List<Tuple> tuples = queryHelper.factory() //
				.select(medico.nome, consulta.valor.sum()) //
				.from(medico, consulta) //
				.where(consulta.medico().id.eq(medico.id)) //
				.groupBy(medico.nome, consulta.valor) //
				.fetch();
		tuples.stream().forEach(t -> result.put(t.get(medico.nome), t.get(consulta.valor.sum())));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public BigDecimal somaValoresDeTodasConsultas() {
		return queryHelper.factory() //
				.select(consulta.valor.sum()) //
				.from(consulta) //
				.fetchOne();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Consulta save(final Consulta consultaObj) {
		return queryHelper.save(consultaObj);
	}

}
