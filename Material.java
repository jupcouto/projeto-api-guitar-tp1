package br.unitins.topicos1.guitar.model;
import jakarta.persistence.Entity;

@Entity
public class Material extends DefaultEntity {
    String descricao;

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

