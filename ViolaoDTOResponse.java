package br.unitins.topicos1.guitar.dto;

import br.unitins.topicos1.guitar.model.Violao;

public record ViolaoDTOResponse(
    String cor,
    Double preco,
    ModeloDTOResponse modelo
) {

    public static ViolaoDTOResponse valueOf(Violao violao) {
        return new ViolaoDTOResponse(
            violao.getCor().getNome(),
            violao.getPreco(),
            ModeloDTOResponse.valueOf(violao.getModelo())
        );
    }
}
