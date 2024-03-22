package br.edu.infnet.tp3.igorantonio.model.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Escola> listaDeEscolas;
    private Set<Integer> idsProcessados = new HashSet<>();
    
    //faz com que essa função inicialize automaticamente após a injeção de dependência do escolaClient
    @PostConstruct
    public void init() {
        escolasAPI = escolaClient.getEscolasPorEstado(31);
        listaDeEscolas = new ArrayList<>();

        for (Escola escola : escolasAPI.getResult()) {
            if (!idsProcessados.contains(escola.getId()) && !listaDeEscolas.stream().anyMatch(e -> e.getId() == escola.getId())) {
                listaDeEscolas.add(escola);
                idsProcessados.add(escola.getId());
            }
        }
    }

    
    public List<Escola> getEscolas(){
        return listaDeEscolas;
    }   
    
    public void incluirUmaEscola(Escola escola) {
        listaDeEscolas.add(escola);
    }
    
    public void excluirUmaEscolaPeloNome(String nome) {
        for (int i = 0; i < listaDeEscolas.size(); i++) {
            Escola escola = listaDeEscolas.get(i);
            if (nome.equals(escola.getName())) {
                listaDeEscolas.remove(i);
                i--; // Decrementa o índice para compensar a remoção do elemento
            }
        }
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
    		if(escola.getName() == nome) {
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


	public void setListaDeEscolas(List<Escola> listaDeEscolas) {
		this.listaDeEscolas = listaDeEscolas;
	}
    
    
}
