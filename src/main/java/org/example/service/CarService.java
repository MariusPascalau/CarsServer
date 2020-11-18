package org.example.service;

import org.example.config.CarException;
import org.example.model.Brand;
import org.example.model.Car;
import org.example.model.dto.CarDTO;
import org.example.model.dto.UpdateCarDTO;
import org.example.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    public Long createCar(CarDTO carDTO) throws CarException {
//        Validation
        if (Objects.isNull(carDTO)) {
            throw new CarException("Body can not be null", 400);
        }

        if (Objects.isNull(carDTO.getBirthYear())) {
            throw new CarException("BirthYear can not be null", 400);
        }

        validateInput(carDTO.getBrand(), carDTO.getEnginePower(), carDTO.getEngineType());

        //New object

        Car car = new Car();

        car.setBirthYear(carDTO.getBirthYear());
        car.setBrand(carDTO.getBrand());
        car.setEnginePower(carDTO.getEnginePower());
        car.setEngineType(carDTO.getEngineType());

        // Save
        Car createCar = carRepository.save(car);
        return createCar.getId();
    }

    public Car updateCarById(UpdateCarDTO updateCarDTO, Long id) throws CarException {
        Car existingCar = carRepository.findById(id).orElse(null);

        if (Objects.isNull(existingCar)) {
            throw new CarException("Car not found", 404);
        }

        if (Objects.isNull(updateCarDTO)) {
            throw new CarException("Body can not be null", 400);
        }

        validateInput(updateCarDTO.getBrand(), updateCarDTO.getEnginePower(), updateCarDTO.getEngineType());

        existingCar.setEngineType(updateCarDTO.getEngineType());
        existingCar.setEnginePower(updateCarDTO.getEnginePower());
        existingCar.setBrand(updateCarDTO.getBrand());

        return carRepository.save(existingCar);
    }

    private void validateInput(Brand brand, Double enginePower, String engineType) throws CarException {
        if (Objects.isNull(brand)) {
            throw new CarException("Brand can not be null", 400);
        }

        if (Objects.isNull(enginePower)) {
            throw new CarException("EnginePower can not be null", 400);
        }

        if (Objects.isNull(engineType)) {
            throw new CarException("EngineType can not be null", 400);
        }
    }

    public void deleteCarById(Long id) throws CarException {
        Car existingCar = carRepository.findById(id).orElse(null);

        if (Objects.isNull(existingCar)) {
            throw new CarException("Car not found", 404);
        }
        carRepository.deleteById(id);
    }
}
