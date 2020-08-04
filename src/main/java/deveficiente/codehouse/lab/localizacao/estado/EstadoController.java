package deveficiente.codehouse.lab.localizacao.estado;

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
@RequestMapping("/estado")
public class EstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<Estado> cadastrarEstado(@RequestBody @Valid EstadoRequest request) {
        Estado novoEstado = request.estadoForm(entityManager);
        entityManager.persist(novoEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstado);
    }
}
