package deveficiente.codehouse.lab.localizacao.estado;

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
public class EstadoControllerTest extends AbstractControllerTest {

    private static final String ENDPOINT = "/estado";
    private static final Long ID_PAIS_DEFAULT = 1L;

    EstadoRequest estadoRequest = new EstadoRequest("Estado Teste", ID_PAIS_DEFAULT);

    @Test
    public void cadastrarEstadoSucesso_returnStatus201() throws JsonProcessingException, Exception {
        String request = mapToJson(estadoRequest);
        mockMvc.perform(post(ENDPOINT)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void cadastrarEstadoExistente_returnStatus400() throws JsonProcessingException, Exception {
        String request = mapToJson(estadoRequest);
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
    public void cadastrarEstadoNomeVazio_returnStatus400() throws JsonProcessingException, Exception {
        estadoRequest.setNome("");
        String request = mapToJson(estadoRequest);
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

    @Test
    public void cadastrarEstadoSemPais_returnStatus400() throws JsonProcessingException, Exception {
        String request = mapToJson(new EstadoRequest("Never Land", null));
        MvcResult wrapper = mockMvc.perform(post(ENDPOINT)
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andReturn();

        ApiError result = mapFromJson(wrapper.getResponse()
                .getContentAsString(StandardCharsets.UTF_8), ApiError.class);

        Assertions.assertEquals(null, result.getErrors().get(0).getRejectedValue());
    }
}
