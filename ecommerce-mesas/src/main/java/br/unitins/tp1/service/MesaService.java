package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Mesa;

public interface MesaService {
    Mesa create(Mesa mesa);
    void update(Long id, Mesa mesa);
    void delete(Long id);
    Mesa findById(Long id);
    List<Mesa> findByMaterial(String material);
    List<Mesa> findByModelo(String modelo);
    List<Mesa> findAll();
}
