package br.edu.infnet.tp3.igorantonio.loaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.tp3.igorantonio.clients.IEscolaClient;
import br.edu.infnet.tp3.igorantonio.model.domain.Escola;
import br.edu.infnet.tp3.igorantonio.model.domain.Professor;
import br.edu.infnet.tp3.igorantonio.model.services.EscolaService;
import br.edu.infnet.tp3.igorantonio.model.services.ProfessorService;

@Component
public class EscolaLoader implements ApplicationRunner {
	
	@Autowired
	EscolaService escolaService;
	
	@Autowired
	ProfessorService professorService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
			
			
			Escola escolaIgor = new Escola();
			
			escolaIgor.setId(11111);
			escolaIgor.setName("EscolaDoIguinho");
			escolaIgor.setYear("2002");	
			Professor professorFabio = new Professor("Fabio o tonin", escolaIgor);
			escolaIgor.setProfessor(professorFabio);
			
			escolaService.incluirUmaEscola(escolaIgor);			
			//System.out.println(escolaService.getEscolas());
			
			professorService.incluirProfessor(professorFabio);
			
			//professorService.getProfessoresCadastrados();
			//professorService.getListaDeProfessoresByIdDaEscola(11111);
			//professorService.getListaDeProfessoresByIdDaEscola(31335045);
			
			Professor professoraAlexia = new Professor("Alexia", escolaService.getEscolaByIdEspecifico(11111));
			professorService.incluirProfessor(professoraAlexia);
			
			System.out.println(escolaService.getEscolas());
			professorService.getProfessoresCadastrados();
			
	}
	
	
}
