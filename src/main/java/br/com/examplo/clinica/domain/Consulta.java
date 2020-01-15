package br.com.examplo.clinica.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.querydsl.core.annotations.Config;

@Entity
@Table(name = "tb_consulta")
@Config(listAccessors = true, entityAccessors = true)
public class Consulta implements DomainEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "cd_medico")
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "cd_paciente")
	private Paciente paciente;

	@Column(name = "data_hora_consulta")
	private LocalDateTime dataHoraConsulta;

	@Column(name = "data_registro")
	private LocalDateTime dataRegistro;

	@Column(name = "status_consulta")
	@Enumerated(EnumType.STRING)
	private StatusConsulta status;

	private BigDecimal valor;

	private String descricao;

	public Consulta() {
		super();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(final Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(final Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getDataHoraConsulta() {
		return dataHoraConsulta;
	}

	public void setDataHoraConsulta(final LocalDateTime dataHoraConsulta) {
		this.dataHoraConsulta = dataHoraConsulta;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(final LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public StatusConsulta getStatus() {
		return status;
	}

	public void setStatus(final StatusConsulta status) {
		this.status = status;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(final BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (dataHoraConsulta == null ? 0 : dataHoraConsulta.hashCode());
		result = prime * result + (dataRegistro == null ? 0 : dataRegistro.hashCode());
		result = prime * result + (descricao == null ? 0 : descricao.hashCode());
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (medico == null ? 0 : medico.hashCode());
		result = prime * result + (paciente == null ? 0 : paciente.hashCode());
		result = prime * result + (status == null ? 0 : status.hashCode());
		result = prime * result + (valor == null ? 0 : valor.hashCode());
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Consulta)) {
			return false;
		}
		final Consulta other = (Consulta) obj;
		if (dataHoraConsulta == null) {
			if (other.dataHoraConsulta != null) {
				return false;
			}
		} else if (!dataHoraConsulta.equals(other.dataHoraConsulta)) {
			return false;
		}
		if (dataRegistro == null) {
			if (other.dataRegistro != null) {
				return false;
			}
		} else if (!dataRegistro.equals(other.dataRegistro)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (medico == null) {
			if (other.medico != null) {
				return false;
			}
		} else if (!medico.equals(other.medico)) {
			return false;
		}
		if (paciente == null) {
			if (other.paciente != null) {
				return false;
			}
		} else if (!paciente.equals(other.paciente)) {
			return false;
		}
		if (status != other.status) {
			return false;
		}
		if (valor == null) {
			if (other.valor != null) {
				return false;
			}
		} else if (!valor.equals(other.valor)) {
			return false;
		}
		return true;
	}

}
