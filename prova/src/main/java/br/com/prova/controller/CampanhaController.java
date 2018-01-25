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

import br.com.prova.model.Campanha;
import br.com.prova.service.CampanhaService;

@Controller
@RequestMapping("/campanha")
public class CampanhaController {

	@Autowired
	CampanhaService campanhaService;

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campanha> cadastrarCampanha(@RequestBody Campanha campanha) {
		Campanha campanhaCadastrado = campanhaService.cadastrar(campanha);
		return new ResponseEntity<Campanha>(campanhaCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/buscarTodasVigentes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Campanha>> buscarTodasAtivas() {
		Collection<Campanha> campanhasAtivas = campanhaService.buscarTodasEmVigencia();
		if (campanhasAtivas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(campanhasAtivas, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscarTodas", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Campanha>> buscarTodasCampanhas() {
		Collection<Campanha> campanhasBuscadas = campanhaService.buscarTodas();
		if (campanhasBuscadas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(campanhasBuscadas, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campanha> buscarCampanha(@PathVariable Long id) {
		Campanha campanha = campanhaService.buscarPorId(id);
		if (campanha == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(campanha, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscarDataFim/{strDataFim}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Campanha>> buscarMesmaDataFim(@PathVariable String strDataFim) {
		Collection<Campanha> campanhasBuscadas = campanhaService.obterCampanhasMesmaDataFim(strDataFim);
		if (campanhasBuscadas.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(campanhasBuscadas, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<Campanha> excluirCampanha(@PathVariable Long id) {
		Campanha campanhaEncontrada = campanhaService.buscarPorId(id);
		if (campanhaEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		campanhaService.excluir(campanhaEncontrada);
		return new ResponseEntity<Campanha>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Campanha> alterarCampanha(@RequestBody Campanha campanha) {
		Campanha campanhaAlterado = campanhaService.alterar(campanha);
		return new ResponseEntity<Campanha>(campanhaAlterado, HttpStatus.OK);
	}
}