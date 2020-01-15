package br.com.examplo.clinica.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private String rua;

	private Integer numero;

	private String distrito;

	private String cidade;

	private String estado;

	private String cep;

	public Endereco() {
		super();
	}

	public Endereco(final String rua, final Integer numero, final String distrito, final String cidade,
			final String estado, final String cep) {
		super();
		this.rua = rua;
		this.numero = numero;
		this.distrito = distrito;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(final String rua) {
		this.rua = rua;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(final String distrito) {
		this.distrito = distrito;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(final String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(final String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(final String cep) {
		this.cep = cep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (cep == null ? 0 : cep.hashCode());
		result = prime * result + (cidade == null ? 0 : cidade.hashCode());
		result = prime * result + (distrito == null ? 0 : distrito.hashCode());
		result = prime * result + (estado == null ? 0 : estado.hashCode());
		result = prime * result + (numero == null ? 0 : numero.hashCode());
		result = prime * result + (rua == null ? 0 : rua.hashCode());
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
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Endereco)) {
			return false;
		}
		final Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null) {
				return false;
			}
		} else if (!cep.equals(other.cep)) {
			return false;
		}
		if (cidade == null) {
			if (other.cidade != null) {
				return false;
			}
		} else if (!cidade.equals(other.cidade)) {
			return false;
		}
		if (distrito == null) {
			if (other.distrito != null) {
				return false;
			}
		} else if (!distrito.equals(other.distrito)) {
			return false;
		}
		if (estado == null) {
			if (other.estado != null) {
				return false;
			}
		} else if (!estado.equals(other.estado)) {
			return false;
		}
		if (numero == null) {
			if (other.numero != null) {
				return false;
			}
		} else if (!numero.equals(other.numero)) {
			return false;
		}
		if (rua == null) {
			if (other.rua != null) {
				return false;
			}
		} else if (!rua.equals(other.rua)) {
			return false;
		}
		return true;
	}

}