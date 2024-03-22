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
			
			escolaIgor.setId(01);
			escolaIgor.setName("EscolaDoIguinho");
			escolaIgor.setYear("2002");	
			//POST ESCOLA
		//escolaService.incluirUmaEscola(escolaIgor);
			
			
			
			//Professor professorFabio = new Professor(01, "Fabio o tonin", escolaService.getEscolaByIdEspecifico(01));			
			//System.out.println(escolaService.getEscolas());
		//professorService.incluirProfessor("EscolaDoIguinho", professorFabio);
		
			
			//professorService.getProfessoresCadastrados();
			
			//GET PROFESSORES DA ESCOLA POR ID DA ESCOLA
			//professorService.getListaDeProfessoresByIdDaEscola(11111);
			//professorService.getListaDeProfessoresByIdDaEscola(31335045);
			
			//INCLUIR PROFESSOR POR ID DA ESCOLA
			
		//Professor professoraAlexia = new Professor(02,"Alexia", escolaService.getEscolaByIdEspecifico(31376647));
		//escolaService.getEscolaByIdEspecifico(31376647).setProfessor(professoraAlexia);
		
		
			
			//DELETAR ESCOLA POR ID
			//escolaService.excluirUmaEscolaPeloNome(escolaService.getEscolaByIdEspecifico(01).getName());
			
			//GET ESCOLAS
			//System.out.println(escolaService.getEscolas());
			//professorService.getProfessoresCadastrados();
			
			//DELETE PROFESSOR POR ID DO PROFESSOR EM UMA ESCOLA ESPECIFICA			
			//professorService.excluirProfessorEmUmaEscolaEspecifica("EscolaDoIguinho", 01);
			//System.out.println(escolaService.getEscolaByNomeDaEscola("EscolaDoIguinho").getProfessores());
			

		//System.out.println(escolaService.getEscolas());
		//System.out.println(professoraAlexia);
		//System.out.println(escolaService.getEscolaByIdEspecifico(31376647).getProfessores());
			
			
	}
	
	
}
