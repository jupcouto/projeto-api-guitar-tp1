package br.unitins.topicos1.guitar.dto;
import br.unitins.topicos1.guitar.model.Material;

public record MaterialDTOResponse(
        String descricao) {

    public static MaterialDTOResponse valueOf(Material material) {
        return new MaterialDTOResponse(
            material.getDescricao()
        );
    }
}
