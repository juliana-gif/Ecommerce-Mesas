package br.unitins.tp1.service;

import java.util.List;

import br.unitins.tp1.model.Mesa;
import br.unitins.tp1.repository.MesaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MesaServiceImpl implements MesaService {

    @Inject
    MesaRepository repository;

    @Override
    @Transactional
    public Mesa create(Mesa mesa) {
        repository.persist(mesa);
        return mesa;
    }

    @Override
    @Transactional
    public void update(Long id, Mesa mesa) {
        Mesa mesaBanco = repository.findById(id);
        if (mesaBanco == null) {
            throw new RuntimeException("Mesa não encontrada");
        }
        mesaBanco.setMaterial(mesa.getMaterial());
        mesaBanco.setModelo(mesa.getModelo());
        mesaBanco.setFornecedor(mesa.getFornecedor());
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Mesa findById(Long id) {
       return repository.findById(id);
    }

    @Override
    public List<Mesa> findByMaterial(String material) {
        return repository.findByMaterial(material);
    }

    @Override
    public List<Mesa> findByModelo(String modelo) {
        return repository.findByModelo(modelo);
    }

    @Override
    public List<Mesa> findAll() {
        return repository.listAll();
    }
    
}
