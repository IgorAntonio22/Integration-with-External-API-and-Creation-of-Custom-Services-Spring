package br.edu.infnet.tp3.igorantonio.model.domain;

public class Professor {
	
	private int id;
 	private String nome;
    private int idDaEscola;
    
    
    @Override
    public String toString() {
    	return "\nID do professor: " + this.id
    			+ "\nNome do Professor: " + this.nome +
    			"\nEscola no qual trabalha: " + idDaEscola + "\n";
    }
    
    public Professor() {
    	
    }
    
    public Professor(int id, String nome, int escola) {
    	this.id = id;
        this.nome = nome;
        this.idDaEscola = escola;
    }

    public String getNome() {
        return nome;
    }

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdDaEscola() {
		return idDaEscola;
	}

	public void setIdDaEscola(int idDaescola) {
		this.idDaEscola = idDaescola;
	}

	
}
