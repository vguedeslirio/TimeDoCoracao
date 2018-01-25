package br.com.prova.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.prova.model.Torcedor;
import br.com.prova.service.TorcedorService;

@Controller
@RequestMapping("/torcedor")
public class TorcedorController {

	@Autowired
	TorcedorService torcedorService;

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Torcedor> cadastrarTorcedor(@RequestBody Torcedor torcedor) throws Exception {
		Torcedor torcedorCadastrado;
		
		torcedorCadastrado = torcedorService.cadastrar(torcedor);
		
		return new ResponseEntity<Torcedor>(torcedorCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/buscarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Torcedor>> buscarTodasTorcedors() {
		Collection<Torcedor> torcedorsBuscados = torcedorService.buscarTodos();
		if (torcedorsBuscados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(torcedorsBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Torcedor> buscarTorcedor(@PathVariable Long id) {
		Torcedor torcedor = torcedorService.buscarPorId(id);
		if (torcedor == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(torcedor, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<Torcedor> excluirTorcedor(@PathVariable Long id) {
		Torcedor torcedorEncontrada = torcedorService.buscarPorId(id);
		if (torcedorEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		torcedorService.excluir(torcedorEncontrada);
		return new ResponseEntity<Torcedor>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Torcedor> alterarTorcedor(@RequestBody Torcedor torcedor) {
		Torcedor torcedorAlterado = torcedorService.alterar(torcedor);
		return new ResponseEntity<Torcedor>(torcedorAlterado, HttpStatus.OK);
	}
}