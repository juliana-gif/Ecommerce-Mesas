package br.unitins.tp1.resource;

import br.unitins.tp1.dto.MesaDTO;
import br.unitins.tp1.dto.MesaResponseDTO;
import br.unitins.tp1.model.Fornecedor;
import br.unitins.tp1.model.Mesa;
import br.unitins.tp1.service.FornecedorService;
import br.unitins.tp1.service.MesaService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/mesas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MesaResource {

    @Inject
    MesaService service;
    @Inject
    FornecedorService fornecedorService;

    @GET
    public Response listar() {
        return Response.ok(service.findAll().stream()
        .map(MesaResponseDTO::FromEntity)
        .toList()).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        return Response.ok(MesaResponseDTO.FromEntity(service.findById(id))).build();
    }

    @GET
    @Path("/material/{material}")
    public Response buscarPorMaterial(@PathParam("material") String material) {
        return Response.ok(service.findByMaterial(material).stream().map(MesaResponseDTO::FromEntity).toList()).build();
    }

    @GET
    @Path("/modelo/{modelo}")
    public Response buscarPorModelo(@PathParam("modelo") String modelo) {
        return Response.ok(service.findByModelo(modelo).stream().map(MesaResponseDTO::FromEntity).toList()).build();
    }

    @POST
    public Response inserir(@Valid MesaDTO dto) {
        Mesa mesa = new Mesa();
        mesa.setMaterial(dto.material());
        mesa.setModelo(dto.modelo());

        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId());
        mesa.setFornecedor(fornecedor);
        
        return Response.status(Response.Status.CREATED).entity(MesaResponseDTO.FromEntity(service.create(mesa))).build();
    } 

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") Long id, @Valid MesaDTO dto) {
        Mesa mesa = new Mesa();
        mesa.setMaterial(dto.material());
        mesa.setModelo(dto.modelo());
        
        Fornecedor fornecedor = fornecedorService.findById(dto.fornecedorId());
        mesa.setFornecedor(fornecedor);

        service.update(id, mesa);
        return Response.noContent().build();
    } 

    @DELETE
    @Path("/{id}")
    public Response excluir(@PathParam("id") Long id) {
        service.delete(id);
        return Response.noContent().build();
    }


}
