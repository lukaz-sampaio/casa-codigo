package deveficiente.codehouse.lab.autor;

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
public class AutorControllerTest extends AbstractControllerTest {

    @Autowired
    private AutorRepository autorRepository;

    private final AutorRequest autorRequest = new AutorRequest(
            "Autor Teste", "autorteste@email.com", "Descricao Autor Teste");

    @Test
    public void cadastrarAutor_status201() throws Exception {
        try {
            String map = mapToJson(autorRequest);
            mockMvc.perform(
                    post("/autor")
                            .content(map)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated());
        } finally {
            Optional<Autor> autor = autorRepository.findByEmail(autorRequest.getEmail());
            autorRepository.delete(autor.get());
        }
    }

    @Test
    public void cadastrarAutorEmailInvalido_status400() throws Exception {
        autorRequest.setEmail("autoremailinvalido.com");
        String map = mapToJson(autorRequest);
        mockMvc.perform(
                post("/autor")
                        .content(map)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
