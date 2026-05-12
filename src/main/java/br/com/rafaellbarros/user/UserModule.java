package br.com.rafaellbarros.user;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.ApplicationModule;

@ApplicationModule(displayName = "User Module")
@ComponentScan(basePackages = "br.com.rafaellbarros.user")
public class UserModule {

}
