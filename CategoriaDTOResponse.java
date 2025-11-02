package br.unitins.topicos1.guitar.dto;
import br.unitins.topicos1.guitar.model.Categoria;

public record CategoriaDTOResponse(
        String classificacao) {

    public static CategoriaDTOResponse valueOf(Categoria categoria) {
        return new CategoriaDTOResponse(
            categoria.getClassificacao()
        );
    }
}
