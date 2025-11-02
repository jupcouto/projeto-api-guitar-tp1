package br.unitins.topicos1.guitar.dto;

import jakarta.validation.constraints.NotBlank;

public record MaterialDTO(
    @NotBlank(message = "Descrição não pode ser vazia")
    String descricao
) {}
