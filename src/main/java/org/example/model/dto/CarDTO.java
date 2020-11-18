package org.example.model.dto;

import org.example.model.Brand;

public class CarDTO {
    private Brand brand;
    private Long birthYear;
    private Double enginePower;
    private String engineType;

    public CarDTO(Brand brand, Long birthYear, Double enginePower, String engineType) {
        this.brand = brand;
        this.birthYear = birthYear;
        this.enginePower = enginePower;
        this.engineType = engineType;
    }

    public CarDTO() {
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Long getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Long birthYear) {
        this.birthYear = birthYear;
    }

    public Double getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Double enginePower) {
        this.enginePower = enginePower;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
