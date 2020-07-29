package deveficiente.codehouse.lab.categoria;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @PersistenceContext
    private final EntityManager entityManager;

    public CategoriaController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Categoria> cadastrarCategoria(
            @RequestBody @Valid CategoriaRequest request) {
        Categoria novaCategoria = request.formCategoria();
        entityManager.persist(novaCategoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }
}
