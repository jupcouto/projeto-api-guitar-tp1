package br.unitins.topicos1.guitar.dto;
import jakarta.validation.constraints.NotBlank;

public record FornecedorDTO(
    @NotBlank(message = "Nome não pode ser vazio")
    String nome,

    @NotBlank(message = "CNPJ não pode ser vazio")
    String cnpj,

    @NotBlank(message = "Razão Social não pode ser vazia")
    String razaoSocial
) {}
