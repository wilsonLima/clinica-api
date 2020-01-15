package br.com.examplo.clinica.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.examplo.clinica.domain.Paciente;
import br.com.examplo.clinica.repository.PacienteRepository;
import br.com.examplo.clinica.services.PacienteService;

@Service
public class PacienteServiceImpl implements PacienteService {

	private final PacienteRepository pacienteRepository;

	@Inject
	public PacienteServiceImpl(final PacienteRepository pacienteRepository) {
		super();
		this.pacienteRepository = pacienteRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long count() {
		return pacienteRepository.count();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long delete(final Long id) {
		if (Objects.nonNull(id)) {
			return pacienteRepository.remover(id);
		}
		return 0l;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long delete(final Paciente pacienteObj) {
		if (Objects.nonNull(pacienteObj)) {
			return delete(pacienteObj.getId());
		}
		return 0l;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Paciente findById(final Long id) {
		if (Objects.nonNull(id)) {
			return pacienteRepository.buscaPorId(id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Paciente> list(final long first, final long count) {
		return pacienteRepository.list(first, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Paciente> listAll() {
		return pacienteRepository.listAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Paciente save(final Paciente pacienteObj) {
		if (Objects.nonNull(pacienteObj)) {
			if (Objects.isNull(pacienteObj.getId())) {
				pacienteObj.setDataRegistro(LocalDateTime.now());
			}
			return pacienteRepository.save(pacienteObj);
		}
		return pacienteObj;
	}

}
