package deveficiente.codehouse.lab.exception;

import org.springframework.util.StringUtils;

/**
 *
 * @author lucas
 */
public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Class entityClass, Long id) {
        super(message(entityClass, id));
    }

    public EntityNotFoundException(Class entityClass, Integer id) {
        super(message(entityClass, id));
    }

    private static String message(Class entityClass, long entityId) {
        return String.format("%s não encontrado(a) para o id %s",
                StringUtils.capitalize(entityClass.getSimpleName()), entityId);
    }
}
