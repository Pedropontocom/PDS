
package br.edu.ifrn.sc.info.pds.pratica1.domain;

public class Aluno {
   
    private String matricula;
    private String nome;
    private double ira;

    public Aluno() {
    }
    
    public Aluno(String matricula, String nome, double ira) {
        this.matricula = matricula;
        this.nome = nome;
        this.ira = ira;
    }

    
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getIra() {
        return ira;
    }

    public void setIra(double ira) {
        this.ira = ira;
    }
    
    
    
}
