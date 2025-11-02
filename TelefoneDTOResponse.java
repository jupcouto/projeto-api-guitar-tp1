package br.unitins.topicos1.guitar.dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record TelefoneDTOResponse(
    @NotBlank(message = "O código de área não pode ser vazio")
    @Pattern(regexp = "\\d{2}", message = "O código de área deve ter exatamente 2 dígitos")
    String codigoArea,

    @NotBlank(message = "O número não pode ser vazio")
    @Pattern(regexp = "\\d{8,9}", message = "O número deve ter 8 ou 9 dígitos")
    String numero
) {}
