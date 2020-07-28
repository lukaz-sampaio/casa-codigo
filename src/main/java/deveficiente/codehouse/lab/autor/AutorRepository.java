package deveficiente.codehouse.lab.autor;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lucas
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    public Optional<Autor> findByEmail(String email);
}
