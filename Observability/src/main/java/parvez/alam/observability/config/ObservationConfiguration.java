package parvez.alam.observability.config;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import parvez.alam.observability.handler.SimpleLoggingHandler;

@Configuration
public class ObservationConfiguration {

    @Bean
    public ObservationRegistry observationRegistry () {

        ObservationRegistry observationRegistry = ObservationRegistry.create();
        observationRegistry
                .observationConfig()
                .observationHandler(new SimpleLoggingHandler());
        return observationRegistry;
    }

    @Bean
    public Observation appObservation(ObservationRegistry observationRegistry) {
        return Observation.createNotStarted("App_Observation" , observationRegistry);
    }
}
