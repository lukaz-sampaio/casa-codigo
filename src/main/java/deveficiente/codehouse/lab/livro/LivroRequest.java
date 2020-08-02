package deveficiente.codehouse.lab.livro;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import deveficiente.codehouse.lab.autor.Autor;
import deveficiente.codehouse.lab.categoria.Categoria;
import deveficiente.codehouse.lab.constraints.Unique;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author lucas
 */
public class LivroRequest {

    @NotBlank
    @Unique(domain = Livro.class, property = "titulo")
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @Min(value = 20)
    private BigDecimal preco;
    @Min(value = 100)
    private int numeroPaginas;
    @Unique(domain = Livro.class, property = "isbn")
    private String isbn;
    @Future
    @JsonFormat(pattern = "yyyy-MM-dd", shape = Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    private Long idCategoria;
    @NotNull
    private Long idAutor;

    public LivroRequest(String titulo, String resumo, String sumario,
            BigDecimal preco, int numeroPaginas, String isbn,
            LocalDate dataPublicacao, Long idCategoria, Long idAutor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.idCategoria = idCategoria;
        this.idAutor = idAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public Livro livroForm(EntityManager entityManager) {
        Autor autor = entityManager.find(Autor.class, idAutor);
        Categoria categoria = entityManager.find(Categoria.class, idCategoria);

        return new Livro(titulo, resumo, sumario, preco,
                numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
