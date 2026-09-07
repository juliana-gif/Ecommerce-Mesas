package br.unitins.tp1.repository;

import java.util.List;

import br.unitins.tp1.model.Mesa;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MesaRepository implements PanacheRepository<Mesa> {
    public List<Mesa> findByMaterial(String material) {
        // return find("SELECT e FROM Mesa e WHERE e.material LIKE ?", material).list();
        return find("upper(material) LIKE upper(?1)", "%" + material + "%").list();
    }

    public List<Mesa> findByModelo(String modelo) {
        // return find("SELECT e FROM Mesa e WHERE e.modelo LIKE ?", modelo).list();
        return find("upper(modelo) LIKE upper(?1)", "%" + modelo + "%").list();
    }
}
