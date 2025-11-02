package br.unitins.topicos1.guitar.resource;

import java.util.List;

import br.unitins.topicos1.guitar.model.Categoria;
import br.unitins.topicos1.guitar.repository.CategoriaRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/categorias")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoriaResource {

    @Inject
    CategoriaRepository repository;

    @GET
    public List<Categoria> buscarTodos() {
        return repository.listAll();
    }

    @GET
    @Path("/find/{classificacao}")
    public List<Categoria> buscarPorClassificacao(@PathParam("classificacao") String classificacao) {
        return repository.findByClassificacao(classificacao);
    }

    @POST
    @Transactional
    public Categoria incluir(Categoria categoria) {
        Categoria novaCategoria = new Categoria();
        novaCategoria.setClassificacao(categoria.getClassificacao());
        repository.persist(novaCategoria);
        return novaCategoria;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public void alterar(@PathParam("id") Long id, Categoria categoria) {
        Categoria edicaoCategoria = repository.findById(id);
        edicaoCategoria.setClassificacao(categoria.getClassificacao());
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void apagar(@PathParam("id") Long id) {
        repository.deleteById(id);
    }
}
