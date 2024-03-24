package br.edu.infnet.tp3.igorantonio.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.tp3.igorantonio.model.domain.Professor;
import br.edu.infnet.tp3.igorantonio.model.services.EscolaService;
import br.edu.infnet.tp3.igorantonio.model.services.ProfessorService;

@RestController
@RequestMapping("/api/v1")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;
	
	@Autowired
	EscolaService escolaService;
	
	@GetMapping("/{idDaEscola}/professores")
	Set<Professor> obterProfessores(@PathVariable int idDaEscola) {
		return professorService.getListaDeProfessoresByIdDaEscola(idDaEscola);
	}
	
	@PostMapping("/{idDaEscola}/professores")
	void incluirProfessor(@PathVariable int idDaEscola, @RequestBody Professor professor) {
		professorService.incluirProfessor(idDaEscola, professor);
	}
	
	@DeleteMapping("/{idDaEscola}/{idDoProfessor}")
	void excluirProfessor(@PathVariable int idDaEscola, @PathVariable int idDoProfessor) {
		professorService.excluirProfessorEmUmaEscolaEspecifica(escolaService.getEscolaByIdEspecifico(idDaEscola).getName(), idDoProfessor);
	}
	
}
