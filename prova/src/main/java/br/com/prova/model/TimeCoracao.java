package br.com.prova.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class TimeCoracao {

	@Id
	@GeneratedValue
	@Column(name = "id_time_coracao")
	private Long idTimeCoracao;

	private String nome;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "timeCoracao")
	private Collection<Campanha> campanhas;

	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "timeCoracao")
	private Collection<Torcedor> torcedores;
	
	public TimeCoracao() {
		super();
	}

	public TimeCoracao(String nome) {
		super();
		this.nome = nome;
	}

	/**
	 * @return the idTimeCoracao
	 */
	public Long getIdTimeCoracao() {
		return idTimeCoracao;
	}

	/**
	 * @param idTimeCoracao the idTimeCoracao to set
	 */
	public void setIdTimeCoracao(Long idTimeCoracao) {
		this.idTimeCoracao = idTimeCoracao;
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
	 * @return the campanhas
	 */
	public Collection<Campanha> getCampanhas() {
		return campanhas;
	}

	/**
	 * @param campanhas the campanhas to set
	 */
	public void setCampanhas(Collection<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

	/**
	 * @return the torcedores
	 */
	public Collection<Torcedor> getTorcedores() {
		return torcedores;
	}

	/**
	 * @param torcedores the torcedores to set
	 */
	public void setTorcedores(Collection<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}

}
