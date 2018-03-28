package org.milfist.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.milfist.services", "org.milfist.controllers"})
public class AppConfig {

}
