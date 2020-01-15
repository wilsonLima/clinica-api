package br.com.examplo.clinica.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.examplo.clinica.domain.Medico;
import br.com.examplo.clinica.repository.MedicoRepository;
import br.com.examplo.clinica.services.MedicoService;

@Service
public class MedicoServiceImpl implements MedicoService {

	private final MedicoRepository medicoRepository;

	@Inject
	public MedicoServiceImpl(final MedicoRepository medicoRepository) {
		super();
		this.medicoRepository = medicoRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long count() {
		return medicoRepository.count();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long delete(final Medico medicoObj) {
		if (Objects.nonNull(medicoObj)) {
			return delete(medicoObj.getId());
		}
		return 0l;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long delete(final Long id) {
		if (Objects.nonNull(id)) {
			medicoRepository.remover(id);
		}
		return 0l;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Medico findById(final Long id) {
		if (Objects.nonNull(id)) {
			return medicoRepository.buscaPorId(id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Medico> list(final long first, final long count) {
		return medicoRepository.list(first, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Medico> listAll() {
		return medicoRepository.listAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Medico save(final Medico medicoObj) {
		if (Objects.nonNull(medicoObj)) {
			if (Objects.isNull(medicoObj.getId())) {
				medicoObj.setDataRegistro(LocalDateTime.now());
			}
			return medicoRepository.save(medicoObj);
		}
		return medicoObj;
	}

}
