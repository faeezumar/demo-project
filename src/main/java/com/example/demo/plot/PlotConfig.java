package com.example.demo.plot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlotConfig {

    @Bean
    CommandLineRunner preConfigurePlots(PlotRepository plotRepository) {
        return args -> {
            Plot p1 = new Plot(
                    200,
                    600,
                    0,
                    "Banana Island",
                    "Huge Banana farming area");

            Plot p2 = new Plot(
                    400,
                    800,
                    0,
                    "Apple Land",
                    "Apple cultivation area");

            Plot p3 = new Plot(
                    600,
                    1000,
                    0,
                    "Grains Land",
                    "Arewa for growing all types of grains");

            plotRepository.saveAll(List.of(p1, p2, p3));
        };
    }
}
