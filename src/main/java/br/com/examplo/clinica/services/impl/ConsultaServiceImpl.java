package br.com.examplo.clinica.services.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.examplo.clinica.domain.Consulta;
import br.com.examplo.clinica.repository.ConsultaRepository;
import br.com.examplo.clinica.services.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	private final ConsultaRepository consultaRepository;

	@Inject
	public ConsultaServiceImpl(final ConsultaRepository consultaRepository) {
		super();
		this.consultaRepository = consultaRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public long count() {
		return consultaRepository.count();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public long delete(final Consulta consultaObj) {
		if (Objects.nonNull(consultaObj)) {
			return delete(consultaObj.getId());
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
			return consultaRepository.remover(id);
		}
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Consulta findById(final Long id) {
		if (Objects.nonNull(id)) {
			return consultaRepository.buscaPorId(id);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> list(final long first, final long count) {
		return consultaRepository.list(first, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Consulta> listAll() {
		return consultaRepository.listAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public Consulta save(final Consulta consultaObj) {
		if (Objects.nonNull(consultaObj)) {
			if (Objects.isNull(consultaObj.getId())) {
				consultaObj.setDataRegistro(LocalDateTime.now());
			}
			return consultaRepository.save(consultaObj);
		}
		return consultaObj;
	}

}
