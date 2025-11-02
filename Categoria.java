package br.unitins.topicos1.guitar.model;

import jakarta.persistence.Entity;

@Entity
public class Categoria extends DefaultEntity {
    private String classificacao;

    public String getClassificacao() {
        return classificacao;
    }
    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }
}
