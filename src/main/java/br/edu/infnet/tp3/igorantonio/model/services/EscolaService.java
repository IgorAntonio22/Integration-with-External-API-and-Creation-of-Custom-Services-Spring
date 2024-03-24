package br.edu.infnet.tp3.igorantonio.model.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.tp3.igorantonio.clients.IEscolaClient;
import br.edu.infnet.tp3.igorantonio.model.domain.Escola;
import br.edu.infnet.tp3.igorantonio.model.domain.TodasAsEscolas;
import jakarta.annotation.PostConstruct;

@Service
public class EscolaService {
    
    @Autowired
    IEscolaClient escolaClient;
    
    private TodasAsEscolas escolasAPI;
    private Set<Escola> listaDeEscolas = new HashSet<>();
    private Set<Integer> idsProcessados = new HashSet<>();
    
    // Faz com que essa função inicialize automaticamente após a injeção de dependência do escolaClient
    @PostConstruct
    public void init() {
        escolasAPI = escolaClient.getEscolasPorEstado(31);

        for (Escola escola : escolasAPI.getResult()) {
            if (!idsProcessados.contains(escola.getId()) && !listaDeEscolas.stream().anyMatch(e -> e.getId() == escola.getId())) {
                listaDeEscolas.add(escola);
                idsProcessados.add(escola.getId());
            }
        }
    }

    public Set<Escola> getEscolas(){
        return listaDeEscolas;
    }   
    
    public void incluirUmaEscola(Escola escola) {
    	
    	for(Escola outraEscola : getEscolas()) {
    		if(getEscolas().contains(escola) || 
    				outraEscola.getName().contains(escola.getName())) {
    			System.out.println("Essa escola já está cadastrada!");
    			return;
    		}
    	}

    	listaDeEscolas.add(escola);
    }
    
    public void excluirUmaEscolaPeloNome(String nome) {
        listaDeEscolas.removeIf(escola -> escola.getName().equals(nome));
    }

    public Escola getEscolaByIdEspecifico(int id) {
        for(Escola escola : listaDeEscolas) {
            if(escola.getId() == id) {
                return escola;
            }
        }
        return null;
    }
    
    public Escola getEscolaByNomeDaEscola(String nome) {
        for(Escola escola : listaDeEscolas) {
            if(escola.getName().equals(nome)) {
                return escola;
            }
        }
        return null;
    }
    
	public TodasAsEscolas getEscolasAPI() {
		return escolasAPI;
	}

	public void setEscolasAPI(TodasAsEscolas escolasAPI) {
		this.escolasAPI = escolasAPI;
	}


	public void setListaDeEscolas(Set<Escola> listaDeEscolas) {
		this.listaDeEscolas = listaDeEscolas;
	}
}
