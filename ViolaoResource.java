package br.unitins.topicos1.guitar.resource;

import java.util.List;

import br.unitins.topicos1.guitar.dto.ViolaoDTO;
import br.unitins.topicos1.guitar.model.Violao;
import br.unitins.topicos1.guitar.service.ViolaoService;
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

@Path("/violoes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ViolaoResource {

    @Inject
    ViolaoService service;

    @GET
    public List<Violao> buscarTodos() {
        return service.findAll();
    }

 @GET
    @Path("/modelo/{nomeModelo}")
    public List<Violao> buscarPorModelo(@PathParam("nomeModelo") String nomeModelo) {
        return service.findByModelo(nomeModelo);
    }

    @POST
    public Violao incluir(@Valid ViolaoDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, @Valid ViolaoDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}



