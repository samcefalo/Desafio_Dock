package me.samcefalo.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GetTests {

    @Autowired
    private MockMvc mockMvc;

    /*
     * GET
     * Expect 200 - OK
     * Retorna uma lista de todas entidades paginadas
     */
    @Test
    void case1() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /*
     * /(version)/(model/nome)/(logic)
     * GET /8.00b3/PWWIN/44332211
     * Expect 200 - OK
     * Retorna atributos da Entidade
     */
    @Test
    void case2() throws Exception {
        mockMvc.perform(get("/8.00b3/PWWIN/44332211"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    /*
     * /(version)/(model/nome)/(logic)
     * GET /6.00b1/BAIN/52332200
     * Expect 404 - Not Found
     * Busca por uma entidade que não foi criada
     */
    @Test
    void case3() throws Exception {
        mockMvc.perform(get("/6.00b1/BAIN/52332200"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

}
