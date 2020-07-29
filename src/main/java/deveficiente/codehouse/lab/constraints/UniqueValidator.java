package deveficiente.codehouse.lab.constraints;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

/**
 *
 * @author lucas
 */
public class UniqueValidator implements ConstraintValidator<Unique, Object> {

    public Class<?> domain;
    public String property;

    @PersistenceContext
    public EntityManager entityManager;

    @Override
    public void initialize(Unique constraintAnnotation) {
        this.domain = constraintAnnotation.domain();
        this.property = constraintAnnotation.property();
    }

    @Override
    @Transactional
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String sql = String.format("SELECT 1 FROM %s WHERE %s = :property", domain.getName(), property);
        Query query = entityManager.createQuery(sql);
        query.setParameter("property", value);
        List result = query.getResultList();
        Assert.state(result.size() <= 1,
                String.format("%s com %s '%s' já existe", domain.getName(), property, value));
        return result.isEmpty();
    }
}
