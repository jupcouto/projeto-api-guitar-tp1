package br.unitins.topicos1.guitar.resource;

import java.util.List;

import br.unitins.topicos1.guitar.dto.MarcaDTO;
import br.unitins.topicos1.guitar.model.Marca;
import br.unitins.topicos1.guitar.service.MarcaService;
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

@Path("/marcas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MarcaResource {

    @Inject
    MarcaService service;

    @GET
    public List<Marca> buscarTodos() {
        return service.findAll();
    }

    @GET
    @Path("/find/{nome}")
    public List<Marca> buscarPorNome(@PathParam("nome") String nome) {
        return service.findByNome(nome);
    }

    @POST
    public Marca incluir( @Valid MarcaDTO dto) {
        return service.create(dto);
    }

    @PUT
    @Path("/{id}")
    public void alterar(@PathParam("id") Long id, @Valid MarcaDTO dto) {
        service.update(id, dto);
    }

    @DELETE
    @Path("/{id}")
    public void apagar(@PathParam("id") Long id) {
        service.delete(id);
    }
}
