package deveficiente.codehouse.lab.localizacao.pais;

import com.fasterxml.jackson.core.JsonProcessingException;
import deveficiente.codehouse.lab.exception.ApiError;
import deveficiente.codehouse.lab.root.AbstractControllerTest;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 *
 * @author lucas
 */
public class PaisControllerTest extends AbstractControllerTest {

    private static final String ENDPOINT = "/pais";
    private final PaisRequest paisRequest = new PaisRequest("Pais Teste");

    @Test
    public void cadastrarPaisSucesso_returnStatus201() throws JsonProcessingException, Exception {
        String request = mapToJson(paisRequest);
        mockMvc.perform(post(ENDPOINT)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void cadastrarPaisExistente_returnStatus400() throws JsonProcessingException, Exception {
        String request = mapToJson(paisRequest);
        MvcResult wrapper = mockMvc.perform(post(ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        ApiError result = mapFromJson(wrapper.getResponse()
                .getContentAsString(StandardCharsets.UTF_8), ApiError.class);
        Assertions.assertTrue(result.getErrors().get(0)
                .getDefaultMessage().contains("must be unique"));
    }

    @Test
    public void cadastrarPaisNomeVazio_returnStatus400() throws JsonProcessingException, Exception {
        paisRequest.setNome("");
        String request = mapToJson(paisRequest);
        MvcResult wrapper = mockMvc.perform(post(ENDPOINT)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        ApiError result = mapFromJson(wrapper.getResponse()
                .getContentAsString(StandardCharsets.UTF_8), ApiError.class);
        Assertions.assertTrue(result.getErrors().get(0)
                .getDefaultMessage().contains("must not be blank"));
    }
}
