package br.com.prova.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Campanha implements Serializable {

	private static final long serialVersionUID = 3891074676558867564L;

	@Id
	@GeneratedValue          
	private Long idCampanha;

	private String nome;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
    @JoinColumn(name="time_coracao_id")
	private TimeCoracao timeCoracao;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInicioVigencia;

	@Column(nullable = false)
	@JsonFormat(pattern = "yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataFimVigencia;

	public Campanha(Long idCampanha, String nome, TimeCoracao timeCoracao, Date dataInicioVigencia,
			Date dataFimVigencia) {
		super();
		this.idCampanha = idCampanha;
		this.nome = nome;
		this.timeCoracao = timeCoracao;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataFimVigencia = dataFimVigencia;
	}

	/**
	 * @return the idCampanha
	 */
	public Long getIdCampanha() {
		return idCampanha;
	}

	/**
	 * @param idCampanha
	 *            the idCampanha to set
	 */
	public void setIdCampanha(Long idCampanha) {
		this.idCampanha = idCampanha;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the timeCoracao
	 */
	public TimeCoracao getTimeCoracao() {
		return timeCoracao;
	}

	/**
	 * @param timeCoracao
	 *            the timeCoracao to set
	 */
	public void setTimeCoracao(TimeCoracao timeCoracao) {
		this.timeCoracao = timeCoracao;
	}

	/**
	 * @return the dataInicioVigencia
	 */
	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	/**
	 * @param dataInicioVigencia
	 *            the dataInicioVigencia to set
	 */
	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	/**
	 * @return the dataFimVigencia
	 */
	public Date getDataFimVigencia() {
		return dataFimVigencia;
	}

	/**
	 * @param dataFimVigencia
	 *            the dataFimVigencia to set
	 */
	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

}
