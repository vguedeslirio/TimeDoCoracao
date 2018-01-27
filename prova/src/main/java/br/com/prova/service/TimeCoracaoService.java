package br.com.prova.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prova.model.TimeCoracao;
import br.com.prova.repository.TimeCoracaoRepository;

@Service
public class TimeCoracaoService {

	@Autowired
	TimeCoracaoRepository timeCoracaoRepository;
	
	@Autowired
	CampanhaService campanhaService;

	public TimeCoracao cadastrar(TimeCoracao timeCoracao) {
		return timeCoracaoRepository.save(timeCoracao);
	}

	public Collection<TimeCoracao> buscarTodos() {
		return timeCoracaoRepository.findAll();
	}

	public void excluir(TimeCoracao timeCoracao) {
		timeCoracaoRepository.delete(timeCoracao);
	}

	public TimeCoracao buscarPorId(Long id) {
		return timeCoracaoRepository.findOne(id);
	}

	public TimeCoracao alterar(TimeCoracao timeCoracao) {
		return timeCoracaoRepository.save(timeCoracao);
	}
}
