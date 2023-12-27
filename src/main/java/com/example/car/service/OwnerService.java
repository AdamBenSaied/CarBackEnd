package com.example.car.service;

import com.example.car.model.VO.InspectionVO;
import com.example.car.model.VO.OwnerVO;
import com.example.car.model.WVOS.CarWVO;
import com.example.car.model.WVOS.OwnerWVO;
import com.example.car.repository.OwnerRepository;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final Mapper mapper;

    @Autowired
    public OwnerService(OwnerRepository ownerRepository, Mapper mapper) {
        this.ownerRepository = ownerRepository;
        this.mapper = mapper;
    }


    public OwnerWVO VOToWVOOptional(Optional<OwnerVO> ownerVO) {
        List<CarWVO> carWVOList = new ArrayList<>();

        ownerVO.get().getCarVOList().forEach(carVO -> {
            CarWVO carWVO = mapper.map(carVO, CarWVO.class);
            carWVOList.add(carWVO);
        });

        OwnerWVO ownerWVO = new OwnerWVO(ownerVO.get().getName(),
                ownerVO.get().getSurname(), ownerVO.get().getMail(), ownerVO.get().getDob(), carWVOList);

        return ownerWVO;
    }


    public OwnerWVO getDriverDetails(Long id) {

        Optional<OwnerVO> ownerVO = ownerRepository.findById(id);
        OwnerWVO ownerWVO = VOToWVOOptional(ownerVO);

        return ownerWVO;
    }

    public void createNewDriver(OwnerWVO ownerWVO) {
        OwnerVO ownerVO = new OwnerVO(ownerWVO.getName(), ownerWVO.getSurname(), ownerWVO.getMail(), ownerWVO.getDob());

        try {
            ownerRepository.saveAndFlush(ownerVO);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public OwnerWVO update_owner_details_byId(OwnerWVO ownerWVO) {
        OwnerVO ownerVO = ownerRepository.findByMail(ownerWVO.getMail());
        try {
            if (ownerWVO.getDob() != null) ownerVO.setDob(ownerWVO.getDob());
            if (ownerWVO.getName() != null) ownerVO.setName(ownerWVO.getName());
            if (ownerWVO.getSurname() != null) ownerVO.setSurname(ownerWVO.getSurname());


        } catch (Exception exception) {
            exception.printStackTrace();
        }
        ;
        ownerRepository.saveAndFlush(ownerVO);
        return mapper.map(ownerVO, OwnerWVO.class);
    }
}
