package br.com.examplo.clinica.api;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.examplo.clinica.domain.Especialidade;
import br.com.examplo.clinica.domain.dto.EspecialidadeDTO;
import br.com.examplo.clinica.functions.EspecialidadeToEspecialidadeDTOFunction;
import br.com.examplo.clinica.services.EspecialidadeService;

@RestController
@RequestMapping("/especialidade")
public class EspecialidadeResource {

	@Inject
	private EspecialidadeService especialidadeService;

	@GetMapping
	public ResponseEntity<List<EspecialidadeDTO>> especialidades() {
		final List<Especialidade> lista = especialidadeService.listEspecialidades();
		if (Objects.isNull(lista) || lista.isEmpty()) {
			ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lista //
				.stream() //
				.map(new EspecialidadeToEspecialidadeDTOFunction()) //
				.collect(Collectors.toList()));
	}
}
