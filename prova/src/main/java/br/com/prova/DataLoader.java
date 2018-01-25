package br.com.prova;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.prova.model.TimeCoracao;
import br.com.prova.service.TimeCoracaoService;

@Component
public class DataLoader {

    private TimeCoracaoService timeCoracaoService;

    @Autowired
    public DataLoader(TimeCoracaoService timeCoracaoService) {
        this.timeCoracaoService = timeCoracaoService;
        LoadTimeCoracao();
    }

    private void LoadTimeCoracao() {
    	timeCoracaoService.cadastrar(new TimeCoracao("Corinthians"));
		timeCoracaoService.cadastrar(new TimeCoracao("Palmeiras"));
		timeCoracaoService.cadastrar(new TimeCoracao("Santos"));
		timeCoracaoService.cadastrar(new TimeCoracao("Bambis"));
    }
}