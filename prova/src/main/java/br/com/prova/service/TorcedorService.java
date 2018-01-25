package br.com.prova.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prova.model.Torcedor;
import br.com.prova.repository.TorcedorRepository;
	
@Service
public class TorcedorService {

	@Autowired
	TorcedorRepository torcedorRepository;
	
	@Autowired
	TimeCoracaoService timeCoracaoService;

	public Torcedor cadastrar(Torcedor torcedor) throws Exception {
		return torcedorRepository.save(torcedor);
	}

	public Collection<Torcedor> buscarTodos() {
		return torcedorRepository.findAll();
	}

	public void excluir(Torcedor torcedor) {
		torcedorRepository.delete(torcedor);
	}

	public Torcedor buscarPorId(Long id) {
		return torcedorRepository.findOne(id);
	}

	public Torcedor alterar(Torcedor torcedor) {	
		return torcedorRepository.save(torcedor);
	}
}
