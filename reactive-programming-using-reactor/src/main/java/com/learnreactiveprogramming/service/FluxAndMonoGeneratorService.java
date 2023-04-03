package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {
    public Flux<String> namesFlux() {
        return Flux.fromIterable(List.of("Bhushan", "Kumar", "Prajapati")).log();
    }
    public Flux<String> namesFlux_immutablity() {
        var namesList = List.of("alex", "ben", "chloe");
        //return Flux.just("alex", "ben", "chloe");
        var namesFlux = Flux.fromIterable(namesList);
        namesFlux.map(String::toUpperCase);
        return namesFlux;
    }
    public Mono<String> nameMono() {
        return Mono.just("Karandeep").log();
    }

    public static void main(String[] args) {
        FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

        fluxAndMonoGeneratorService.namesFlux()
                .subscribe(name -> {
                    System.out.println("Full name comprimise of "+name);
                });


        fluxAndMonoGeneratorService.nameMono()
                .subscribe(name -> {
                    System.out.println("First Name is: "+name);
                });
    }
}
