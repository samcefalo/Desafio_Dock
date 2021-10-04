package me.samcefalo.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostTests {

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
     * POST text/html: 44332211;123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
     * Expect 400 - Bad Request
     * Post com sam < 0 (JSON-Schema)
     */
    @Test
    void case3() throws Exception {
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
    void case4() throws Exception {
        mockMvc.perform(post("/")
                .contentType(MediaType.TEXT_HTML)
                .content("123;PWWIN;-10;F04A2E4088B;4;8.00b3;0;16777216;PWWIN"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

}
