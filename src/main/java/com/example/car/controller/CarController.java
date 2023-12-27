package com.example.car.controller;

import com.example.car.model.WVOS.CarWVO;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.example.car.constants.ENDPOINTS.*;
import static com.example.car.constants.PARAMS.OWNER_ID;

@RestController
@RequestMapping(path = CAR_ENDPOINT)
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(path = CARS_BY_DRIVER)
    public List<CarWVO> getCarsbyDrivers(@RequestParam(name = OWNER_ID) Long driverId) {
        return carService.getCarsByDriversId(driverId);
    }

    @GetMapping(path = CARS_UNLICENCED_BY_DRIVER)
    public List<CarWVO> get_unlicencedCarsByDriversId(@RequestParam(name = OWNER_ID) Long driverId){
        return carService.getUnlicencedCarsByDriversId(driverId);
    }

}
