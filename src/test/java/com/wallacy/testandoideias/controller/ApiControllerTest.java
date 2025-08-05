// Local: src/test/java/com/wallacy/testandoideias/controller/ApiControllerTest.java
package com.wallacy.testandoideias.controller;

import com.wallacy.testandoideias.config.SecurityConfig;
import org.junit.jupiter.api.Test; // <-- Import para a anotação @Test (linha 12)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

// --- Imports ESTÁTICOS ESSENCIAIS ---
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.jwt;
// Importa métodos para construir a requisição e verificar os resultados
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
@Import(SecurityConfig.class)
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test // <-- Linha 25 (anteriormente linha 12 no seu erro)
    void quandoNaoAutenticado_deveRetornarUnauthorized() throws Exception {
        mockMvc.perform(get("/api/me"))
                .andExpect(status().isUnauthorized());
    }

    @Test // <-- Linha 32
    void quandoAutenticadoComJwt_deveRetornarOk() throws Exception {
        // Agora o método 'jwt()' será resolvido corretamente
        mockMvc.perform(get("/api/me").with(jwt())) // <-- Linha 35
                .andExpect(status().isOk());
    }

    @Test // <-- Linha 40
    void quandoAutenticadoComJwt_deveRetornarMensagemCorreta() throws Exception {
        // O método 'jwt()' e o '.subject()' também funcionarão
        mockMvc.perform(get("/api/me").with(jwt().jwt(token -> token.subject("wallacy")))) // <-- Linha 43
                .andExpect(status().isOk())
                .andExpect(content().string("Olá, seu nome de usuário é: wallacy"));
    }
}