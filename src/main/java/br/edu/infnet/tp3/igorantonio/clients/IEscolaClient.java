package br.edu.infnet.tp3.igorantonio.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infnet.tp3.igorantonio.model.domain.TodasAsEscolas;

@FeignClient(value = "getEscolaAPI", url = "https://simcaq.c3sl.ufpr.br/api/v1")
public interface IEscolaClient {
	
	@GetMapping(value = "/school?filter=state:{idDoEstado}")
	TodasAsEscolas getEscolasPorEstado(@PathVariable int idDoEstado);
	
}
