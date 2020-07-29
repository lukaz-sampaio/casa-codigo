package deveficiente.codehouse.lab.categoria;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Optional<Categoria> findByNome(String nome);
}
