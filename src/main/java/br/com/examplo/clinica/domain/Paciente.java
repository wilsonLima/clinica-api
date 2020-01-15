package br.com.examplo.clinica.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.querydsl.core.annotations.Config;

@Entity
@Table(name = "tb_paciente")
@Config(listAccessors = true, entityAccessors = true)
public class Paciente implements DomainEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Sexo sexo;

	@Column(name = "data_registro")
	private LocalDateTime dataRegistro;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	private String cpf;

	@Embedded
	private Endereco endereco;

	private Boolean ativo = Boolean.TRUE;

	public Paciente() {
		super();
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public Endereco getEndereco() {
		return endereco;
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
		this.ativo = ativo;
	}

	public void setCpf(final String cpf) {
		this.cpf = cpf;
	}

	public void setDataNascimento(final LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setDataRegistro(final LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public void setEndereco(final Endereco endereco) {
		this.endereco = endereco;
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
