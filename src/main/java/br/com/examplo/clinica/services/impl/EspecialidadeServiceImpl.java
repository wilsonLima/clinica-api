package br.com.examplo.clinica.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import br.com.examplo.clinica.domain.Especialidade;
import br.com.examplo.clinica.repository.EspecialidadeRepository;
import br.com.examplo.clinica.services.EspecialidadeService;

@Service
public class EspecialidadeServiceImpl implements EspecialidadeService {

	private final EspecialidadeRepository especialidadeRepository;

	@Inject
	public EspecialidadeServiceImpl(final EspecialidadeRepository especialidadeRepository) {
		super();
		this.especialidadeRepository = especialidadeRepository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Especialidade> listEspecialidades() {
		return especialidadeRepository.listAll();
	}

}
