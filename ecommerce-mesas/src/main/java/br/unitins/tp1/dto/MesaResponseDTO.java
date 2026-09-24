package br.unitins.tp1.dto;

import br.unitins.tp1.model.Mesa;

public record MesaResponseDTO(
    Long id,
    String material,
    String modelo,
    Long fornecedorId
) {
    
    public static MesaResponseDTO FromEntity(Mesa mesa) {
        return new MesaResponseDTO(
            mesa.getId(),
            mesa.getMaterial(),
            mesa.getModelo(),
            mesa.getFornecedor().getId()
        );
    }
}
