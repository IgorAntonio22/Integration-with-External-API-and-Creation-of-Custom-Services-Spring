package br.edu.infnet.tp3.igorantonio.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.tp3.igorantonio.clients.IEscolaClient;
import br.edu.infnet.tp3.igorantonio.model.domain.Escola;
import br.edu.infnet.tp3.igorantonio.model.domain.Professor;
import br.edu.infnet.tp3.igorantonio.model.services.EscolaService;

@Component
public class EscolaLoader implements ApplicationRunner {
	
	@Autowired
	EscolaService escolaService;
	
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
			
			
			Escola escolaIgor = new Escola();
			
			escolaIgor.setId(11111);
			escolaIgor.setName("EscolaDoIguinho");
			escolaIgor.setYear("2002");	
			Professor professorFabio = new Professor("Fabio", escolaIgor);
			escolaIgor.setProfessor(professorFabio);
			
			escolaService.incluirUmaEscola(escolaIgor);
			System.out.println(escolaService.getEscolas());
			
			escolaService.excluirUmaEscolaPeloNome("EscolaDoIguinho");
			System.out.println(escolaService.getEscolas());
	}
	
	
}
