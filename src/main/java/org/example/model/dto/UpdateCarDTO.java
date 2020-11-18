package org.example.model.dto;

import org.example.model.Brand;

public class UpdateCarDTO {
    private Brand brand;
    private Double enginePower;
    private String engineType;

    public UpdateCarDTO() {
    }

    public UpdateCarDTO(Brand brand, Double enginePower, String engineType) {
        this.brand = brand;
        this.enginePower = enginePower;
        this.engineType = engineType;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
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
