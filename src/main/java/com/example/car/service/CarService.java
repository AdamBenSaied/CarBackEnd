package com.example.car.service;

import com.example.car.model.VO.CarVO;
import com.example.car.model.WVOS.CarWVO;
import com.example.car.model.WVOS.InspectionWVO;
import com.example.car.model.WVOS.OwnerWVO;
import com.example.car.repository.CarRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CarService {

    private final CarRepository carRepository;
    private final Mapper mapper;

    @Autowired
    public CarService(CarRepository carRepository, Mapper mapper) {
        this.carRepository = carRepository;
        this.mapper = mapper;
    }

    public List<CarWVO> getCarsByDriversId(Long driverId) {
        List<CarVO> carVOList = carRepository.findAllByOwnerVO_Id(driverId);
        List<CarWVO> carWVOList = new ArrayList<>();
        carVOList.forEach(carVO -> {
            OwnerWVO ownerWVO = mapper.map(carVO.getOwnerVO(), OwnerWVO.class);
            List<InspectionWVO> inspectionWVOList = new ArrayList<>();
            carVO.getInspectionVOList().forEach(inspectionVO -> {
                InspectionWVO inspectionWVO = mapper.map(inspectionVO, InspectionWVO.class);
                inspectionWVOList.add(inspectionWVO);
            });
            CarWVO carWVO = mapper.map(carVO, CarWVO.class);
            carWVO.setOwnerWVO(ownerWVO);
            carWVO.setInsepctionWVOList(inspectionWVOList);
            carWVOList.add(carWVO);
        });
        return carWVOList;
    }

    public List<CarWVO> getUnlicencedCarsByDriversId(Long driverId) {
        List<CarVO> carVOList = carRepository.findAllByOwnerVO_Id(driverId);
        var ref = new Object() {
            boolean licensed = false;
        };
        AtomicReference<LocalDate> lastExpiration = new AtomicReference<>(carVOList.get(0).getInspectionVOList().get(0).getExpirationDate());
        List<CarWVO> carWVOList = new ArrayList<>();
        carVOList.forEach(carVO -> {
            ref.licensed = false;
            List<InspectionWVO> inspectionWVOList = new ArrayList<>();
            carVO.getInspectionVOList().forEach(inspectionVO -> {
                if (inspectionVO.getExpirationDate().isAfter(lastExpiration.get())) {
                    lastExpiration.set(inspectionVO.getExpirationDate());
                    InspectionWVO inspectionWVO = mapper.map(inspectionVO, InspectionWVO.class);
                    inspectionWVOList.clear();
                    inspectionWVOList.add(inspectionWVO);
                }
                if (inspectionVO.getExpirationDate().isAfter(ChronoLocalDate.from(LocalDateTime.now()))) {
                    ref.licensed = true;

                }
            });
            if (!ref.licensed) {
                OwnerWVO ownerWVO = mapper.map(carVO.getOwnerVO(), OwnerWVO.class);

                CarWVO carWVO = mapper.map(carVO, CarWVO.class);
                carWVO.setOwnerWVO(ownerWVO);
                carWVO.setInsepctionWVOList(inspectionWVOList);
                carWVOList.add(carWVO);
            }
        });
        return carWVOList;
    }


}
