package nl.inholland.guitarshopapi.configuration;

import nl.inholland.guitarshopapi.controller.GuitarController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        register(GuitarController.class);
    }
}
