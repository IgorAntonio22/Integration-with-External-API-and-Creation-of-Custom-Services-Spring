package br.edu.infnet.tp3.igorantonio.model.domain;

import java.util.List;

public class TodasAsEscolas {

	private List<Escola> result;

	@Override
	public String toString() {
		return "Resultado" + result;
	}
	
	public List<Escola> getResult() {
		return result;
	}

	public void setResult(List<Escola> result) {
		this.result = result;
	}
	
	
}
