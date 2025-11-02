package br.unitins.topicos1.guitar.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaDTO(

        @NotBlank(message = "Classificação não pode ser vazia") 
        String classificacao) {
}
