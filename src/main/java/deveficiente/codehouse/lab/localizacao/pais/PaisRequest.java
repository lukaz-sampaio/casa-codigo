package deveficiente.codehouse.lab.localizacao.pais;

import deveficiente.codehouse.lab.constraints.Unique;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author lucas
 */
public class PaisRequest {

    @NotBlank
    @Unique(domain = Pais.class, property = "nome")
    private String nome;

    @Deprecated
    public PaisRequest() {
    }

    public PaisRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Pais paisForm() {
        return new Pais(nome);
    }
}
