package deveficiente.codehouse.lab.autor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
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
@RequestMapping(path = "/autor")
public class AutorController {

    @PersistenceContext
    private final EntityManager entityManager;

    public AutorController(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAutor(@RequestBody @Valid AutorRequest autorForm) {
        Autor novoAutor = autorForm.novoAutor();
        entityManager.persist(novoAutor);
        return ResponseEntity.ok(novoAutor);
    }
}
