package br.unitins.tp1.service;

import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.repository.FornecedorRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped 
public class FornecedorServiceImpl implements FornecedorService {
    
    @Inject
    FornecedorRepository repository;

    @Override
    public Fornecedor findById(Long id) {
        return repository.findById(id);
    }
    
}
