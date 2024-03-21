package br.edu.infnet.tp3.igorantonio.model.domain;

public class Professor {
	
	
 	private String nome;
    private Escola escola;
    
    
    @Override
    public String toString() {
    	return "Nome do Professor: " + nome +
    			"\nEscola no qual trabalha: " + escola.getName();
    }
    
    public Professor(String nome, Escola escola) {
        this.nome = nome;
        this.escola = escola;
    }

    public String getNome() {
        return nome;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

}
