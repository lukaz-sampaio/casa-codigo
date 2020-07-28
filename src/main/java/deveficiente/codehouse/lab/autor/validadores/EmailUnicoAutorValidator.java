package deveficiente.codehouse.lab.autor.validadores;

import deveficiente.codehouse.lab.autor.Autor;
import deveficiente.codehouse.lab.autor.AutorRepository;
import deveficiente.codehouse.lab.autor.AutorRequest;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author lucas
 */
@Component
public class EmailUnicoAutorValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return AutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()) {
            return;
        }

        AutorRequest autorRequest = (AutorRequest) target;
        java.util.Optional<Autor> autor = autorRepository.findByEmail(autorRequest.getEmail());
        if (autor.isPresent()) {
            errors.reject("email", null,
                    String.format("Autor com e-mail '%s' já cadastrado",
                            autorRequest.getEmail())
            );
        }
//        Autor autor = null;
//        AutorRequest autorRequest = (AutorRequest) target;
//        try {
//            final String sql = "SELECT a FROM Autor a WHERE a.email = ?1";
//            javax.persistence.Query query = entityManager.createQuery(sql);
//            query.setParameter(1, autorRequest.getEmail());
//            autor = (Autor) query.getSingleResult();
//        } catch (javax.persistence.NoResultException e) {
//        }
//
//        if (autor != null) {
//            errors.reject("email", null,
//                    String.format("E-mail '%s' já está em uso.",
//                            autorRequest.getEmail())
//            );
//        }
    }
}
