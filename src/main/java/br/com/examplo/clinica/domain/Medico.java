package br.com.examplo.clinica.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.querydsl.core.annotations.Config;

@Entity
@Table(name = "tb_medico")
@Config(listAccessors = true, entityAccessors = true)
public class Medico implements DomainEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@OneToOne
	@JoinColumn(name = "cd_especialidade")
	private Especialidade especialidade;

	@Column(name = "data_demissao")
	private LocalDate dataDemissao;

	@Column(name = "data_registro")
	private LocalDateTime dataRegistro;

	private String crm;

	@Embedded
	private Endereco endereco;

	private Boolean ativo = Boolean.TRUE;

	public Medico() {
		super();
	}

	public String getCrm() {
		return crm;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(final Boolean ativo) {
		if (Objects.nonNull(ativo)) {
			this.ativo = ativo;
		}
	}

	public void setCrm(final String crm) {
		this.crm = crm;
	}

	public void setDataDemissao(final LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public void setDataRegistro(final LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
	}

	public void setEspecialidade(final Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

	public void setSexo(final Sexo sexo) {
		this.sexo = sexo;
	}

}
