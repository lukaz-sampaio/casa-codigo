package deveficiente.codehouse.lab.autor;

import deveficiente.codehouse.lab.autor.validadores.EmailUnicoAutorValidator;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

    @Autowired
    EmailUnicoAutorValidator emailUnicoAutorValidator;

    public AutorController(EntityManager entityManager, EmailUnicoAutorValidator emailUnicoAutorValidator) {
        this.entityManager = entityManager;
        this.emailUnicoAutorValidator = emailUnicoAutorValidator;
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(emailUnicoAutorValidator);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Autor> cadastrarAutor(@RequestBody @Valid AutorRequest autorForm) {
        Autor novoAutor = autorForm.novoAutor();
        entityManager.persist(novoAutor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAutor);
    }
}
