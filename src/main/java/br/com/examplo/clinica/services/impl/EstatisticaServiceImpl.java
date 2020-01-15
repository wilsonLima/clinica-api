package br.com.examplo.clinica.services.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.examplo.clinica.repository.ConsultaRepository;
import br.com.examplo.clinica.repository.MedicoRepository;
import br.com.examplo.clinica.repository.PacienteRepository;
import br.com.examplo.clinica.services.EstatisticaService;

@Service
public class EstatisticaServiceImpl implements EstatisticaService {

	private final PacienteRepository pacienteRepository;

	private final MedicoRepository medicoRepository;

	private final ConsultaRepository consultaRepository;

	@Inject
	public EstatisticaServiceImpl(final PacienteRepository pacienteRepository, final MedicoRepository medicoRepository, final ConsultaRepository consultaRepository) {
		super();
		this.pacienteRepository = pacienteRepository;
		this.medicoRepository = medicoRepository;
		this.consultaRepository = consultaRepository;
	}

	private Map<String, Double> handlePercentResult(final long count, final Map<String, Long> data) {
		final Map<String, Double> result = new TreeMap<>();
		data.forEach((k, v) -> result.put(k, new BigDecimal(count == 0 ? 0.0 : v.doubleValue() * 100.0 / Double.valueOf(count)).setScale(2, RoundingMode.FLOOR).doubleValue()));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Double> quantidadesDeConsultasPorEspecialidade() {
		final long count = consultaRepository.count();
		if (count == 0) {
			return new HashMap<>();
		}
		return handlePercentResult(count, consultaRepository.consultasPorEspecialidade());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, BigDecimal> valoresDasConsultasPorEspecialidade() {
		return consultaRepository.somaValoresDeConsultasPorEspecialidade();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Double> medicosPorEspecialidade() {
		final long count = medicoRepository.count();
		if (count == 0) {
			return new HashMap<>();
		}
		return handlePercentResult(count, medicoRepository.medicosPorEspecialidade());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Double> pacientesPorSexo() {
		final long count = pacienteRepository.count();
		if (count == 0) {
			return new HashMap<>();
		}
		final Map<String, Long> result = new HashMap<>();
		pacienteRepository //
				.pacientesPorSexo() //
				.forEach((k, v) -> result.put(k.toString(), v));
		return handlePercentResult(count, result);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Double> pacientesPorStatus() {
		final long count = pacienteRepository.count();
		if (count == 0) {
			return new HashMap<>();
		}
		final Map<String, Long> result = new HashMap<>();
		pacienteRepository //
				.pacientesPorStatus() //
				.forEach((k, v) -> result.put(k ? ATIVO : INATIVO, v));
		return handlePercentResult(count, result);
	}

}
