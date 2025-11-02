package br.unitins.topicos1.guitar.dto;
import br.unitins.topicos1.guitar.model.Cor;

public record CorDTOResponse(
        String nome) {

    public static CorDTOResponse valueOf(Cor cor) {
        return new CorDTOResponse(
            cor.getNome()
        );
    }
}
