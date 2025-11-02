package br.unitins.topicos1.guitar.dto;

import jakarta.validation.constraints.NotBlank;

public record CorDTO(

        @NotBlank(message = "Nome não pode ser vazio") 
        String nome) {
}
