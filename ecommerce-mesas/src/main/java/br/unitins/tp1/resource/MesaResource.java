package br.unitins.tp1.resource;

import java.util.List;

import br.unitins.tp1.model.Mesa;
import br.unitins.tp1.service.MesaService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mesas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MesaResource {

    @Inject
    MesaService service;

    @GET
    public List<Mesa> listar() {
        return service.findAll();
    }

    @GET
    @Path("/{id}")
    public Mesa buscarPorId(@PathParam("id") Long id) {
        return service.findById(id);
    }

    @GET
    @Path("/material/{material}")
    public List<Mesa> buscarPorMaterial(@PathParam("material") String material) {
        return service.findByMaterial(material);
    }

    @GET
    @Path("/modelo/{modelo}")
    public List<Mesa> buscarPorModelo(@PathParam("modelo") String modelo) {
        return service.findByModelo(modelo);
    }

    @POST
    public Mesa inserir(Mesa mesa) {
        return service.create(mesa);
    } 

    @PUT
    @Path("/{id}")
    public void atualizar(@PathParam("id") Long id, Mesa mesa) {
       service.update(id, mesa);
    } 

    @DELETE
    @Path("/{id}")
    public void excluir(@PathParam("id") Long id) {
        service.delete(id);
    }


}
