package br.edu.infnet.tp3.igorantonio.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Escola extends TodasAsEscolas {

	private String result = null;
	private int id;
	private String year;
	private String name;
	private static Set<Professor> professores = new HashSet<Professor>();
	private Set<String> nomeDosProfessores = new HashSet<String>();

	@Override
	public String toString() {
		return "ID da escola: " + this.id +
				"\nNome da escola: " + this.name +
				"\nAno de construção: " + this.year +
				"\nProfessores dessa escola:" + this.professores + "\n";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public Set<Professor> getProfessores() {
		return professores;
	}

	public void setProfessor(Professor professor) {
		Escola.professores.add(professor);
	}
	
	public Set<String> getNomeDosProfessores() {
		for(Professor professor : professores) {
			nomeDosProfessores.add(professor.getNome());
		}
		
		return nomeDosProfessores;
	}

	public void setNomeDosProfessores(Set<String> nomeDosProfessores) {
		this.nomeDosProfessores = nomeDosProfessores;
	}
	
	

}
