package br.unitins.topicos1.guitar.dto;
import br.unitins.topicos1.guitar.model.Marca;

public record MarcaDTOResponse(
        String nome) {

    public static MarcaDTOResponse valueOf(Marca marca) {
        return new MarcaDTOResponse(
            marca.getNome()
        );
    }
}

