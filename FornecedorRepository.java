package br.unitins.topicos1.guitar.repository;
import java.util.List;
import br.unitins.topicos1.guitar.model.Fornecedor;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FornecedorRepository implements PanacheRepository<Fornecedor> {

    public List<Fornecedor> findByCnpj(String cnpj) {
        return find("SELECT f FROM Fornecedor f WHERE f.cnpj LIKE ?1 ", "%"+cnpj+"%").list();
    }
    
}
