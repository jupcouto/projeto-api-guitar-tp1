package br.unitins.topicos1.guitar.resource;

import java.util.List;

import br.unitins.topicos1.guitar.dto.TelefoneDTO;
import br.unitins.topicos1.guitar.model.Telefone;
import br.unitins.topicos1.guitar.service.TelefoneService;
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

@Path("/telefones")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefoneResource {

    @Inject
    TelefoneService service;

    @GET
    public List<Telefone> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/find/{numero}")
    public List<Telefone> buscarPorNumero(@PathParam("numero") String numero) {
        return service.findByNumero(numero);
    }

    @POST
    public Telefone incluir( @Valid TelefoneDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, @Valid TelefoneDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id")  Long id) {
        service.delete(id);
    }
}
