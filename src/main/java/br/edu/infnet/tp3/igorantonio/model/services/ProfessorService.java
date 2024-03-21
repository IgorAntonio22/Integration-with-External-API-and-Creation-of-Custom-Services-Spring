package br.edu.infnet.tp3.igorantonio.model.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.tp3.igorantonio.clients.IEscolaClient;
import br.edu.infnet.tp3.igorantonio.model.domain.Escola;
import br.edu.infnet.tp3.igorantonio.model.domain.Professor;
import jakarta.annotation.PostConstruct;

@Service
public class ProfessorService {
	@Autowired
    IEscolaClient escolaClient;
    
    @Autowired
    EscolaService escolaService;
    
    private static List<Professor> professores = new ArrayList<Professor>();
    
    @PostConstruct //faz com que essa função inicialize automaticamente após a injeção de dependência do escolaClient
    public void init() {
       
    }
    
    public void incluirProfessor(Professor professor) {
    	professores.add(professor);
    }
    
    public void getProfessoresCadastrados() {
    	
    	for(int i = 0; i < professores.size(); i++) {
    		 		
    		System.out.println(professores.get(i));
    		
    	}
    }
    	
   public void getListaDeProfessoresByIdDaEscola(int id) {
	   
	   for(int i = 0; i < escolaService.getListaDeEscolas().size(); i++) {
		   List<Escola> escolas = escolaService.getListaDeEscolas();
		   
		   if(escolas.get(i).getId() == id) {
			   List<Professor> professores = escolas.get(i).getProfessores();
			   System.out.println(professores.toString());   
		   }
		   
	   }
   }
}

  