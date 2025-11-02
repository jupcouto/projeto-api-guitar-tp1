package br.unitins.topicos1.guitar.dto;

import br.unitins.topicos1.guitar.model.Fornecedor;

public record FornecedorDTOResponse(
        Long id,
        String nome,
        String cnpj,
        String razaoSocial) {

    public static FornecedorDTOResponse valueOf(Fornecedor fornecedor) {
        return new FornecedorDTOResponse(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getCnpj(),
            fornecedor.getRazaoSocial()
        );
    }
}
