package deveficiente.codehouse.lab.livro;

import deveficiente.codehouse.lab.exception.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucas
 */
@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping
    public ResponseEntity<List<LivroListaResponse>> listarLivros() {
        Query query = entityManager.createQuery("SELECT l FROM Livro l");
        List<Livro> resultList = query.getResultList();
        List<LivroListaResponse> response = new ArrayList<>();
        resultList.forEach(result -> {
            response.add(new LivroListaResponse(result.getId(), result.getTitulo()));
        });
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> detalheLivro(@PathVariable("id") Long idLivro) {
        Livro livro = entityManager.find(Livro.class, idLivro);
        if (livro == null) {
            throw new EntityNotFoundException(Livro.class, idLivro);
        }
        return ResponseEntity.ok(livro);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Livro> cadastrarLivro(@RequestBody @Valid LivroRequest livroRequest) {
        Livro novoLivro = livroRequest.livroForm(entityManager);
        entityManager.persist(novoLivro);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLivro);
    }
}
