package br.com.examplo.clinica.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import br.com.examplo.clinica.domain.Consulta;

public interface ConsultaRepository {

	long count();

	long remover(Long id);

	Consulta buscaPorId(Long id);

	List<Consulta> listAll();

	List<Consulta> list(long first, long count);

	boolean existemConsultasParaOPaciente(Long idPaciente);

	List<Consulta> listaConsultasDoPaciente(final Long idPaciente);

	List<Consulta> listaConsultasDoPacienteEMedico(final Long idPaciente, final Long idMedico);

	Map<String, Long> consultasPorEspecialidade();

	Map<String, BigDecimal> somaValoresDeConsultasPorEspecialidade();

	Map<String, BigDecimal> somaValoresDeConsultasPorMedico();

	BigDecimal somaValoresDeTodasConsultas();

	Consulta save(final Consulta consultaObj);

}
