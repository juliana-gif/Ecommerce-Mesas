package br.unitins.tp1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MesaDTO(
        @NotBlank(message = "O material deve ser informado")
        @Size(min = 3, max=40, message = "O material deve ter entre 3 e 40 caracteres")
        String material,
        @NotBlank(message = "O modelo deve ser informado")
        @Size(min = 5, max=30, message = "O modelo deve ter entre 5 e 30 caracteres")
        String modelo,

        @NotNull(message = "O fornecedor deve ser informado")
        Long fornecedorId
    ) {
}
