package co.ke.collengine.springbootapiexample.controller;

import co.ke.collengine.springbootapiexample.entity.CarParkDetails;
import co.ke.collengine.springbootapiexample.repository.CarParkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class CarParkController {
    private final CarParkRepository carParkRepository;

    public CarParkController(CarParkRepository themeParkRideRepository) {
        this.carParkRepository = themeParkRideRepository;
    }

    @GetMapping(value = "/ride", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<CarParkDetails> getRides() {
        return carParkRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CarParkDetails getRide(@PathVariable long id){
        return carParkRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid ride id %s", id)));
    }

    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public CarParkDetails createRide(@Valid @RequestBody CarParkDetails themeParkRide) {
        return carParkRepository.save(themeParkRide);
    }
}
