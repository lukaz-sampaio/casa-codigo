package deveficiente.codehouse.lab.livro;

import deveficiente.codehouse.lab.root.AbstractControllerTest;

/**
 *
 * @author lucas
 */
public class LivroControllerTest extends AbstractControllerTest {

//    private LivroRequest livroRequest = new LivroRequest(
//            "Livro Teste", "Resumo Livro Teste", "Sumario Livro Teste",
//            new BigDecimal(10), 100, "ISBN-0000L", LocalDate.now(), 1L, 1L
//    );
//
//    @Test
//    public void listarLivros() throws Exception {
//        MockHttpServletRequestBuilder builder = get("/livro")
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult wrapper = mockMvc.perform(builder)
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andReturn();
//        MockHttpServletResponse response = wrapper.getResponse();
//        System.out.println("response.getContentAsString(): " + response.getContentAsString());
//        // asserts aqui
//    }
//
//    @Test
//    public void detalheLivro() throws Exception {
//        mockMvc.perform(get("/livro").accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void cadastrarLivro() throws Exception {
//            String map = mapToJson(livroRequest);
//            mockMvc.perform(
//                    post("/livro")
//                            .content(map)
//                            .contentType(MediaType.APPLICATION_JSON)
//                            .accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isCreated());
//    }
}
