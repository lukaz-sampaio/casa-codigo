package deveficiente.codehouse.lab.localizacao.pais;

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
@RequestMapping(path = "/pais")
public class PaisController {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @PostMapping
    @Transactional
    public ResponseEntity<Pais> cadastrarPais(@RequestBody @Valid PaisRequest request){
        Pais paisCadastrado = request.paisForm();
        entityManager.persist(paisCadastrado);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisCadastrado);
    }
}
