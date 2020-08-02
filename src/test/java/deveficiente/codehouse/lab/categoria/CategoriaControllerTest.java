package deveficiente.codehouse.lab.categoria;

import deveficiente.codehouse.lab.root.AbstractControllerTest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author lucas
 */
public class CategoriaControllerTest extends AbstractControllerTest {

    @Autowired
    private CategoriaRepository categoriaRepository;

    private final CategoriaRequest categoriaDefault = new CategoriaRequest("outra categoria");

    @Test
    public void cadastrarCategoria_status201() throws Exception {
        try {
            String map = mapToJson(categoriaDefault);
            mockMvc.perform(
                    post("/categoria")
                            .content(map)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
        } finally {
            Optional<Categoria> categoria = categoriaRepository.findByNome(categoriaDefault.getNome());
            categoriaRepository.delete(categoria.get());
        }
    }

//    @Test
//    public void cadastrarCategoriaExistente_status400() throws Exception {
//        String map = mapToJson(categoriaDefault);
//        mockMvc.perform(
//                post("/categoria")
//                        .content(map)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
}
