package deveficiente.codehouse.lab.categoria;

import deveficiente.codehouse.lab.constraints.Unique;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author lucas
 */
public class CategoriaRequest implements Serializable {

    @NotBlank()
    @Unique(domain = Categoria.class, property = "nome")
    private String nome;

    @Deprecated
    public CategoriaRequest() {
    }

    public CategoriaRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria formCategoria() {
        return new Categoria(nome);
    }
}
