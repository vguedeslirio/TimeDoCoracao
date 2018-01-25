package br.com.prova.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Campanha {

	@Id
	@GeneratedValue
    @Column(name = "id_campanha")
	private Long idCampanha;
		
	private String nome;
	
	@ManyToOne
	@JsonIgnore
	private TimeCoracao timeCoracao;
	
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataInicioVigencia;
	  
	@Column(nullable=false)
	@JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataFimVigencia;

	/**
	 * @return the idCampanha
	 */
	public Long getIdCampanha() {
		return idCampanha;
	}

	/**
	 * @param idCampanha the idCampanha to set
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
	 * @param nome the nome to set
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
	 * @param timeCoracao the timeCoracao to set
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
	 * @param dataInicioVigencia the dataInicioVigencia to set
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
	 * @param dataFimVigencia the dataFimVigencia to set
	 */
	public void setDataFimVigencia(Date dataFimVigencia) {
		this.dataFimVigencia = dataFimVigencia;
	}

}
