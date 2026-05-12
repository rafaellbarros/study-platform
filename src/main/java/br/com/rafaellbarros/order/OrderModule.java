package br.com.rafaellbarros.order;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.ApplicationModule;

@ApplicationModule(displayName = "Order Module", allowedDependencies = {"integration", "shared"})
@ComponentScan(basePackages = "br.com.rafaellbarros.order")
public class OrderModule {

}