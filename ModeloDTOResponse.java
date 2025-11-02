package br.unitins.topicos1.guitar.dto;
import br.unitins.topicos1.guitar.model.Modelo;

public record ModeloDTOResponse(
        String nome,
        int anoFabricacao,
        String escala) {

    public static ModeloDTOResponse valueOf(Modelo modelo) {
        return new ModeloDTOResponse(
            modelo.getNome(),
            modelo.getAnoFabricacao(),
            modelo.getEscala()
        );
    }
}

