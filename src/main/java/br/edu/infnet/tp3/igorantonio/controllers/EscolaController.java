package br.edu.infnet.tp3.igorantonio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.tp3.igorantonio.model.domain.Escola;
import br.edu.infnet.tp3.igorantonio.model.services.EscolaService;

@RestController
@RequestMapping("/api/v1")
public class EscolaController {
	
	@Autowired
	EscolaService escolaService;
	
	@GetMapping(value = "/escolas", name = "getTodasAsEscolas")
	List<Escola> obterEscolas() {
		return escolaService.getEscolas();
	}
	
	
	@PostMapping(value =  "/escolas" , name = "postEscola")
	void incluirEscola(@RequestBody Escola escola) {
		escolaService.incluirUmaEscola(escola);
	}
	
	@DeleteMapping(value = "/escolas/{id}", name = "deletarEscolaById")
	void deletarEscolaPeloId(@PathVariable int id) {
		escolaService.excluirUmaEscolaPeloNome(escolaService.getEscolaByIdEspecifico(id).getName());
	}
}
