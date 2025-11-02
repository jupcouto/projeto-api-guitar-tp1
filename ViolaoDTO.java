package br.unitins.topicos1.guitar.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ViolaoDTO(
    @NotBlank(message = "A cor deve ser informada")
    String cor,

    @NotNull(message = "O preço deve ser informado")
    Double preco,

    @NotNull(message = "O modelo deve ser informado")
    Long idModelo
) {}


