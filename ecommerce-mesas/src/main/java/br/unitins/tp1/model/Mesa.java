package br.unitins.tp1.model;

import jakarta.persistence.Entity;

@Entity
public class Mesa extends DefaultEntity {
    
    private String material;
    private String modelo;

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }  
  
}
