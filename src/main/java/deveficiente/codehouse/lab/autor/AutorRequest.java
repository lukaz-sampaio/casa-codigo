package deveficiente.codehouse.lab.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author lucas
 */
public class AutorRequest {

    @NotBlank
    private String nome;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String descricao;

    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor novoAutor() {
        Autor autor = new Autor(nome, email, descricao);
        return autor;
    }
}
