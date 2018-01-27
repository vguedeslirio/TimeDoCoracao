package br.com.prova.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TimeCoracao implements Serializable {

	private static final long serialVersionUID = -6433112997947048971L;

	@Id
	@GeneratedValue
	private Long idTimeCoracao;

	private String nome;

    @OneToMany(mappedBy="timeCoracao", cascade=CascadeType.REFRESH, fetch=FetchType.EAGER)
	private List<Campanha> campanhas;

	@OneToMany(mappedBy = "timeCoracao", cascade = CascadeType.REFRESH)
	private List<Torcedor> torcedores;
	
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


	public List<Campanha> getCampanhas() {
		return campanhas;
	}

	/**
	 * @return the torcedores
	 */
	public List<Torcedor> getTorcedores() {
		return torcedores;
	}

	/**
	 * @param torcedores the torcedores to set
	 */
	public void setTorcedores(List<Torcedor> torcedores) {
		this.torcedores = torcedores;
	}

	/**
	 * @param campanhas the campanhas to set
	 */
	public void setCampanhas(List<Campanha> campanhas) {
		this.campanhas = campanhas;
	}

}
