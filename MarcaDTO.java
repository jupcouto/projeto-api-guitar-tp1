package br.unitins.topicos1.guitar.dto;

import jakarta.validation.constraints.NotBlank;

public record MarcaDTO(
    @NotBlank(message = "O nome da marca não pode ser vazio")
    String nome
) {}

