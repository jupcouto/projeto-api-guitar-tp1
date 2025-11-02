package br.unitins.topicos1.guitar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ComposicaoViolao extends DefaultEntity {

    @Enumerated(EnumType.STRING)
    private CorpoViolao parte;

    @ManyToOne
    @JoinColumn(name = "id_material")
    private Material material;

    @ManyToOne
    @JoinColumn(name = "id_violao")
    private Violao violao;


    public CorpoViolao getParte() {
        return parte;
    }

    public void setParte(CorpoViolao parte) {
        this.parte = parte;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Violao getViolao() {
        return violao;
    }

    public void setViolao(Violao violao) {
        this.violao = violao;
    }
    
}
