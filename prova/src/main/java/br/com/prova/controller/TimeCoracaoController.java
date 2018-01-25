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

import br.com.prova.model.TimeCoracao;
import br.com.prova.service.TimeCoracaoService;

@Controller
@RequestMapping("/timeCoracao")
public class TimeCoracaoController {

	@Autowired
	TimeCoracaoService timeCoracaoService;

	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeCoracao> cadastrarTimeCoracao(@RequestBody TimeCoracao timeCoracao) throws Exception {
		TimeCoracao timeCoracaoCadastrado;
		
		timeCoracaoCadastrado = timeCoracaoService.cadastrar(timeCoracao);
		
		return new ResponseEntity<TimeCoracao>(timeCoracaoCadastrado, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/buscarTodos", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<TimeCoracao>> buscarTodasTimeCoracaos() {
		Collection<TimeCoracao> timeCoracaosBuscados = timeCoracaoService.buscarTodos();
		if (timeCoracaosBuscados.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<>(timeCoracaosBuscados, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/buscar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeCoracao> buscarTimeCoracao(@PathVariable Long id) {
		TimeCoracao timeCoracao = timeCoracaoService.buscarPorId(id);
		if (timeCoracao == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(timeCoracao, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/excluir/{id}")
	public ResponseEntity<TimeCoracao> excluirTimeCoracao(@PathVariable Long id) {
		TimeCoracao timeCoracaoEncontrada = timeCoracaoService.buscarPorId(id);
		if (timeCoracaoEncontrada == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		timeCoracaoService.excluir(timeCoracaoEncontrada);
		return new ResponseEntity<TimeCoracao>(HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/alterar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TimeCoracao> alterarTimeCoracao(@RequestBody TimeCoracao timeCoracao) {
		TimeCoracao timeCoracaoAlterado = timeCoracaoService.alterar(timeCoracao);
		return new ResponseEntity<TimeCoracao>(timeCoracaoAlterado, HttpStatus.OK);
	}
}