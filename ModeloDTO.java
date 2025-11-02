package br.unitins.topicos1.guitar.dto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


public record ModeloDTO(
    @NotBlank(message = "Nome não pode ser vazio")
    String nome,

    @Min(value = 1900, message = "Ano de fabricação inválido")
    int anoFabricacao,

    @NotBlank(message = "Escala não pode ser vazia")
    String escala
) {}
