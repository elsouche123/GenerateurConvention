package com.generateurconvention;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

    @GetMapping()
    public String defaultPage() {
        return "Bienvenue sur GenerateurConvention !";
    }
}
