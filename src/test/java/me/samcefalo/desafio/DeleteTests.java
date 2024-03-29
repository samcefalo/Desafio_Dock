package me.samcefalo.desafio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DeleteTests {

    @Autowired
    private MockMvc mockMvc;

    /*
     * DELETE
     * Expect 405 - Method not allowed
     */
    @Test
    void case1() throws Exception {
        mockMvc.perform(delete("/"))
                .andDo(print())
                .andExpect(status().isMethodNotAllowed());
    }

}
