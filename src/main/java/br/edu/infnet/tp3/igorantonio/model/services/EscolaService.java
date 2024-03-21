package br.edu.infnet.tp3.igorantonio.model.services;

import java.util.List;

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
    
    @PostConstruct //faz com que essa função inicialize automaticamente após a injeção de dependência do escolaClient
    public void init() {
        escolasAPI = escolaClient.getEscolasPorEstado(31);
        listaDeEscolas = escolasAPI.getResult();
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

	public TodasAsEscolas getEscolasAPI() {
		return escolasAPI;
	}

	public void setEscolasAPI(TodasAsEscolas escolasAPI) {
		this.escolasAPI = escolasAPI;
	}

	public List<Escola> getListaDeEscolas() {
		return listaDeEscolas;
	}

	public void setListaDeEscolas(List<Escola> listaDeEscolas) {
		this.listaDeEscolas = listaDeEscolas;
	}
    
    
}
