package br.com.prova.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prova.model.Campanha;
import br.com.prova.repository.CampanhaRepository;

@Service
public class CampanhaService {

	@Autowired
	CampanhaRepository campanhaRepository;
	
	@Autowired
	TimeCoracaoService timeCoracaoService;

	public Campanha cadastrar(Campanha campanha) {
		aplicarRegrasVigencia(campanha);
		return campanhaRepository.save(campanha);
	}

	public List<Campanha> obterCampanhasMesmaDataFim(String strDataFim) {
		Date dataFimVigencia = null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			dataFimVigencia = sdf.parse(strDataFim);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return campanhaRepository.obterCampanhasDataFimIgual(dataFimVigencia);
	}

	public Collection<Campanha> buscarTodasEmVigencia() {
		return campanhaRepository.buscarPorVigenciasAtivas(new Date());
	}

	public Collection<Campanha> buscarTodasPorTime(Long idTimeCoracao) {
		return campanhaRepository.buscarTodasPorTime(idTimeCoracao);
	}
	
	public Collection<Campanha> buscarTodas() {
		return campanhaRepository.findAll();
	}
	
	public List<Campanha> buscarTodasOrdenadasDataFim() {
		return campanhaRepository.buscarTodasOrdenadasDataFim();
	}

	public void excluir(Campanha campanha) {
		campanhaRepository.delete(campanha);
	}

	public Campanha buscarPorId(Long id) {
		return campanhaRepository.findOne(id);
	}

	public Campanha alterar(Campanha campanha) {
		return campanhaRepository.save(campanha);
	}
	
	private void aplicarRegrasVigencia(Campanha campanha) {
		List<Campanha> todasCampanhas = buscarTodasOrdenadasDataFim();

		if (isExisteFimVigenciaIgual(campanha, todasCampanhas)) {
			todasCampanhas = acrescentaDiaTodasVigencias(todasCampanhas);
			todasCampanhas = acrescentaDiaTodasVigenciasIguais(campanha, todasCampanhas);
			salvaTodasCampanhas(todasCampanhas);
		}
	} 
	
	private List<Campanha> acrescentaDiaTodasVigenciasIguais(Campanha campanha, List<Campanha> todasCampanhas) {
		Calendar calendar = Calendar.getInstance();
		
		for (int i = 0; i< todasCampanhas.size(); i++) {
			if(0 == campanha.getDataFimVigencia().compareTo(todasCampanhas.get(i).getDataFimVigencia())) {
				calendar.setTime(todasCampanhas.get(i).getDataFimVigencia());
				calendar.add(Calendar.DATE, 1);	
				todasCampanhas.get(i).setDataFimVigencia(calendar.getTime());

			}
			
			if((i+1) < todasCampanhas.size() && 
					(0 == todasCampanhas.get(i).getDataFimVigencia().compareTo(todasCampanhas.get(i+1).getDataFimVigencia()))){
				
				calendar.setTime(todasCampanhas.get(i+1).getDataFimVigencia());
				calendar.add(Calendar.DATE, 1);
				todasCampanhas.get(i+1).setDataFimVigencia(calendar.getTime());				
			}
		}
		return todasCampanhas;
	}
	
	private void salvaTodasCampanhas(Collection<Campanha> todasCampanhas) {
		for(Campanha item : todasCampanhas) {
			campanhaRepository.save(item);
		}
	}
	
	private List<Campanha> acrescentaDiaTodasVigencias(List<Campanha> todasCampanhas) {
		Calendar calendar = Calendar.getInstance();

		for (Campanha item : todasCampanhas) {
			calendar.setTime(item.getDataFimVigencia());
			calendar.add(Calendar.DATE, 1);
			item.setDataFimVigencia(calendar.getTime());
		}
		
		return todasCampanhas;
	}

	private Boolean isExisteFimVigenciaIgual(Campanha campanha, Collection<Campanha> todasCampanhas) {
		Boolean finalVigenciaIgual = Boolean.FALSE;

		for (Campanha item : todasCampanhas) {
			if (0 == item.getDataFimVigencia().compareTo(campanha.getDataFimVigencia())) {
				finalVigenciaIgual = Boolean.TRUE;
				break;
			}
		}
		return finalVigenciaIgual;
	}
	
}
