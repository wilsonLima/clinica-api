package br.com.examplo.clinica.repository;

import java.util.List;
import java.util.Map;

import br.com.examplo.clinica.domain.Paciente;
import br.com.examplo.clinica.domain.Sexo;

public interface PacienteRepository {

	long count();

	long remover(final Long id);

	long atualizarStatus(Long idPaciente, final Boolean b);

	List<Paciente> listAll();

	List<Paciente> list(long first, long count);

	Paciente buscaPorId(final Long id);

	Map<Sexo, Long> pacientesPorSexo();

	Map<Boolean, Long> pacientesPorStatus();

	boolean existemConsultasParaOPaciente(final Long idPaciente);

	List<String> listaPacientesPorSexo(final Sexo sex);

	Paciente save(final Paciente pacienteObj);
}
