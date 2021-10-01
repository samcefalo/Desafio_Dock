package me.samcefalo.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DesafioApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    /*
     * POST text/html: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 201 - Created
     */
    @Test
    void case1() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.TEXT_HTML)
                .content("44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    /*
     * POST application/json: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 415 Unsupported MediaType - Progama não aceita POST em JSON
     */
    @Test
    void case2() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.APPLICATION_JSON)
                .content("44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());
    }

    /*
     * GET
     * Expect 200 - OK
     * Retorna uma lista de todas entidades paginadas
     */
    @Test
    void case3() throws Exception {
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
    void case4() throws Exception {
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
    void case5() throws Exception {
        mockMvc.perform(get("/6.00b1/BAIN/52332200"))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    /*
     * DELETE
     * Expect 405 - Method not allowed
     */
    @Test
    void case6() throws Exception {
        mockMvc.perform(delete("/"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

    /*
     * /(version)/(model/nome)/(logic)
     * PUT JSON /8.00b3/PWWIN/44332211
     * Expect 204 - No Content
     * PUT com todos elementos
     */
    @Test
    void case7() throws Exception {
        String jsonMessage = "{" +
                "    \"logic\": \"443322\"," +
                "    \"serial\": \"123\"," +
                "    \"model\": \"PWWIN\"," +
                "    \"sam\": 10," +
                "    \"ptid\": \"F04A2E4088B\"," +
                "    \"plat\": 40," +
                "    \"version\": \"8.00b3\"," +
                "    \"mxr\": 50," +
                "    \"mxf\": 46777216," +
                "    \"verfm\": \"PWWIN\"" +
                "}";
        mockMvc.perform(put("/8.00b3/PWWIN/44332211")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMessage))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    /*
     * /(version)/(model/nome)/(logic)
     * PUT TEXT /8.00b3/PWWIN/44332211
     * TEXT: 44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 415 Unsupported MediaType - Progama apenas aceita PUT em JSON
     */
    @Test
    void case8() throws Exception {
        mockMvc.perform(put("/8.00b3/PWWIN/44332211")
                .contentType(MediaType.TEXT_HTML)
                .content("44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isUnsupportedMediaType());
    }

    /*
     * /(version)/(model/nome)/(logic)
     * PUT JSON /8.00b3/PWWIN/44332211
     * Expect 400 - Bad Request
     * PUT sem model e com sam < 0 (JSON-Schema)
     */
    @Test
    void case9() throws Exception {
        String jsonMessage = "{" +
                "    \"logic\": \"443322\"," +
                "    \"serial\": \"123\"," +
                "    \"sam\": -5," +
                "    \"ptid\": \"F04A2E4088B\"," +
                "    \"plat\": 40," +
                "    \"version\": \"8.00b3\"," +
                "    \"mxr\": 50," +
                "    \"mxf\": 46777216," +
                "    \"verfm\": \"PWWIN\"" +
                "}";
        mockMvc.perform(put("/8.00b3/PWWIN/44332211")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonMessage))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /*
     * POST text/html: 44332211;123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 400 - Bad Request
     * Post com sam < 0 (JSON-Schema)
     */
    @Test
    void case10() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.TEXT_HTML)
                .content("44332211;123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    /*
     * POST text/html: 123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 400 - Bad Request
     * Post sem váriavel logic
     */
    @Test
    void case11() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.TEXT_HTML)
                .content("123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
