package deveficiente.codehouse.lab.livro;

/**
 *
 * @author lucas
 */
public class LivroListaResponse {

    private final Long id;
    private final String titulo;

    public LivroListaResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}
