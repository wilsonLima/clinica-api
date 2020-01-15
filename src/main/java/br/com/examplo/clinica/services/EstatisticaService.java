package br.com.examplo.clinica.services;

import java.math.BigDecimal;
import java.util.Map;

public interface EstatisticaService {

	public static final String ATIVO = "ATIVO";

	public static final String INATIVO = "INATIVO";

	Map<String, Double> quantidadesDeConsultasPorEspecialidade();

	Map<String, BigDecimal> valoresDasConsultasPorEspecialidade();

	Map<String, Double> medicosPorEspecialidade();

	Map<String, Double> pacientesPorSexo();

	Map<String, Double> pacientesPorStatus();
}
