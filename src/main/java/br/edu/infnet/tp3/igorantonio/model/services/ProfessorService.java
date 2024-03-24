package br.edu.infnet.tp3.igorantonio.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    
    public void incluirProfessor(int idDaEscola ,Professor professor) {
    	Escola escola = escolaService.getEscolaByIdEspecifico(idDaEscola);
    	
    	for(Escola outraEscola : escolaService.getEscolas()) {
    		if(outraEscola != escola && outraEscola.getProfessores().contains(professor) || 
    				outraEscola.getNomeDosProfessores().contains(professor.getNome())) {
    			System.out.println("Professor já está cadastrado em uma escola!");
    			return;
    		}
    	}
    	
    	escola.getProfessores().add(professor);
    }
    
    public void getProfessoresCadastrados(String nomeDaEscola) {
    	
    	Set<Professor> meuSet = escolaService.getEscolaByNomeDaEscola("EscolaDoIguinho").getProfessores();
    	Professor[] array = meuSet.toArray(new Professor[meuSet.size()]);
    	
    	for(Professor professor : array) {
    		 System.out.println(professor);	
    	}
    }
    	
   public Set<Professor> getListaDeProfessoresByIdDaEscola(int id) {
	   
	   for(int i = 0; i < escolaService.getEscolas().size(); i++) {
		   List<Escola> escolas = escolaService.getEscolas();
		   
		   if(escolas.get(i).getId() == id) {
			   Set<Professor> professores = escolas.get(i).getProfessores();
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
	    Set<Professor> professores = escolaSelecionada.getProfessores();

	    List<Professor> copiaProfessores = new ArrayList<>(professores);

	    for (Professor professor : copiaProfessores) {
	        if (professor.getId() == id) {
	            professores.remove(professor);
	        }
	    }
	}
}


  