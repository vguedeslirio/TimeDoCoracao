package br.com.prova.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.prova.model.Campanha;
import br.com.prova.model.TimeCoracao;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ServicesTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	CampanhaService campanhaService;
	
	@Before
    public void dataLoaderForTest() throws ParseException {
		this.entityManager.persist(new Campanha(null, "CorinthiansTest", new TimeCoracao("Corinthians"), new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-11")));
		
		this.entityManager.persist(new Campanha(null, "PalmeirasTest1", new TimeCoracao("Meirinhas"), new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-05-24")));
		
		this.entityManager.persist(new Campanha(null, "PalmeirasTest2", new TimeCoracao("Meirinhas"), new SimpleDateFormat("yyyy-MM-dd").parse("2014-02-14"),
				new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-11")));
    }
	
	@Test
	public void obterCampanhasMesmaDataFim(){
		List<Campanha> campanhasMesmaDataFim = campanhaService.obterCampanhasMesmaDataFim("2018-08-11");
		
		assertThat(campanhasMesmaDataFim.size()).isEqualTo(2);
		
	}
	
}
