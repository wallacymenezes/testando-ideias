// Local: src/main/java/com/wallacy/testandoideias/controller/ApiController.java
package com.wallacy.testandoideias.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/me")
    public String getMyInfo(Principal principal) {
        // A interface Principal contém os dados do usuário autenticado a partir do token
        return "Olá, seu nome de usuário é: " + principal.getName();
    }
}