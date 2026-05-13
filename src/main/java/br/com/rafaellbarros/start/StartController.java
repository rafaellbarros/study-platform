package br.com.rafaellbarros.start;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StartController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.application.version}")
    private String version;

    @Value("${spring.profiles.active}")
    private String profileActivated;

    @GetMapping
    public Start start() {
        return new Start(applicationName, version, profileActivated);
    }
}

record Start(String applicationName, String version, String profileActivated) {

}
