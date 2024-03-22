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
    
    
    @PostConstruct //faz com que essa função inicialize automaticamente após a injeção de dependência do escolaClient
    public void init() {
       
    }
    
    public void incluirProfessor(String nomeDaEscola ,Professor professor) {
    	escolaService.getEscolaByNomeDaEscola(nomeDaEscola).setProfessor(professor);
    }
    
    public void getProfessoresCadastrados(String nomeDaEscola) {
    	
    	for(int i = 0; i < escolaService.getEscolaByNomeDaEscola("EscolaDoIguinho").getProfessores().size(); i++) {
    		 		
    		System.out.println(escolaService.getEscolaByNomeDaEscola("EscolaDoIguinho").getProfessores().get(i));
    		
    	}
    }
    	
   public List<Professor> getListaDeProfessoresByIdDaEscola(int id) {
	   
	   for(int i = 0; i < escolaService.getEscolas().size(); i++) {
		   List<Escola> escolas = escolaService.getEscolas();
		   
		   if(escolas.get(i).getId() == id) {
			   List<Professor> professores = escolas.get(i).getProfessores();
			   return professores;
		   }
		   
	   }
	   return null;
   }
   
   public void incluirNovoProfessorEmUmaEscolaEspecificaPeloIdDaEscola(Professor professor, int idDaEscola ) {
	   Escola escola = escolaService.getEscolaByIdEspecifico(idDaEscola);
	   escola.setProfessor(professor);
	   escolaService.getEscolaByNomeDaEscola("EscolaDoIguinho").setProfessor(professor);
   }
   
   public void excluirProfessorEmUmaEscolaEspecifica(String nomeDaEscola, int id) {
	    Escola escolaSelecionada = escolaService.getEscolaByNomeDaEscola(nomeDaEscola);
	    List<Professor> professores = escolaSelecionada.getProfessores();

	    List<Professor> copiaProfessores = new ArrayList<>(professores);

	    for (Professor professor : copiaProfessores) {
	        if (professor.getId() == id) {
	            professores.remove(professor);
	        }
	    }
	}
}


  