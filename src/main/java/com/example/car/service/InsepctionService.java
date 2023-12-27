package com.example.car.service;

import com.example.car.model.VO.InspectionVO;
import com.example.car.model.WVOS.CarWVO;
import com.example.car.model.WVOS.InspectionWVO;
import com.example.car.repository.InspectionRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InsepctionService {

    private final InspectionRepository inspectionRepository;
    private final Mapper mapper;

    @Autowired
    public InsepctionService(InspectionRepository inspectionRepository, Mapper mapper) {
        this.inspectionRepository = inspectionRepository;
        this.mapper = mapper;
    }

    public InspectionWVO getInspectionById(Long inspectionId) {
        CarWVO carWVO = mapper.map(inspectionRepository.findById(inspectionId).get().getCarVO(), CarWVO.class);

        InspectionWVO inspectionWVO = mapper.map(inspectionRepository.findById(inspectionId).get(), InspectionWVO.class);
        inspectionWVO.setCarWVO(carWVO);
        return inspectionWVO;
    }

    public void createNewInspection(InspectionWVO inspectionWVO) {
        try {
            InspectionVO inspectionVO = new InspectionVO(inspectionWVO.isWheelPass(),
                    inspectionWVO.isWindowsPass(), inspectionWVO.isIsbrakepass(), inspectionWVO.isIsmechanicpass(),
                    inspectionWVO.getObtentionDate(), inspectionWVO.getExpirationDate());
            inspectionRepository.saveAndFlush(inspectionVO);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }
}
