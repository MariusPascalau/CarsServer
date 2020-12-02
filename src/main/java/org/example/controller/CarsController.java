package org.example.controller;

import org.example.config.exception.CarException;
import org.example.model.Car;
import org.example.model.dto.CarDTO;
import org.example.model.dto.UpdateCarDTO;
import org.example.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getAllCars(@PathVariable final Long id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @PostMapping()
    public ResponseEntity<Car> registerCar(UriComponentsBuilder componentsBuilder, @RequestBody CarDTO carDTO) throws CarException {
        Long carId = carService.createCar(carDTO);
        UriComponents uriComponents = componentsBuilder.path("/cars/" + carId).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody UpdateCarDTO updateCarDTO, @PathVariable Long id) throws CarException {
        return ResponseEntity.ok(carService.updateCarById(updateCarDTO, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Car> deleteCar(@PathVariable Long id) throws CarException {
        carService.deleteCarById(id);
        return ResponseEntity.noContent().build();
    }
}
