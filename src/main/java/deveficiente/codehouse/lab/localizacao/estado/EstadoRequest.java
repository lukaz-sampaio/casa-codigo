package deveficiente.codehouse.lab.localizacao.estado;

import deveficiente.codehouse.lab.constraints.Unique;
import deveficiente.codehouse.lab.localizacao.pais.Pais;
import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lucas
 */
public class EstadoRequest {

    @NotBlank
    @Unique(domain = Estado.class, property = "nome")
    private String nome;
    @NotNull
    private Long idPais;

    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Estado estadoForm(EntityManager entityManager) {
        Pais pais = entityManager.find(Pais.class, idPais);
        return new Estado(nome, pais);
    }
}
