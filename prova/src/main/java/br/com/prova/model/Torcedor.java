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

@Entity
public class Torcedor {
	
	@Id
	@GeneratedValue
	@Column(name = "id_torcedor")
	private Long idTorcedor;
	
	private String nome;
	
	@Column(unique=true, nullable=false)
	private String email;
	
	@JsonFormat(pattern="yyyy-MM-dd", locale = "pt-BR", timezone = "Brazil/East")
	private Date dataNascimento;

	@ManyToOne(cascade= CascadeType.MERGE)
    @JoinColumn(name = "id_time_coracao")
	private TimeCoracao timeCoracao;

	/**
	 * @return the idTorcedor
	 */
	public Long getIdTorcedor() {
		return idTorcedor;
	}

	/**
	 * @param idTorcedor the idTorcedor to set
	 */
	public void setIdTorcedor(Long idTorcedor) {
		this.idTorcedor = idTorcedor;
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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


}
