package br.unitins.topicos1.guitar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Violao extends DefaultEntity {

    private Double preco;

    @ManyToOne
    @JoinColumn(name = "id_modelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "id_cor")
    private Cor cor;

    
    @OneToMany(mappedBy = "violao")
    private List<ComposicaoViolao> composicoes;


    @ManyToMany
    @JoinTable(
        name = "violao_fornecedor",
        joinColumns = @JoinColumn(name = "id_violao"),
        inverseJoinColumns = @JoinColumn(name = "id_fornecedor")
    )
    private List<Fornecedor> fornecedores;


    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public List<ComposicaoViolao> getComposicoes() {
        return composicoes;
    }

    public void setComposicoes(List<ComposicaoViolao> composicoes) {
        this.composicoes = composicoes;
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }
}
