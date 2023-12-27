package com.example.car.controller;

import com.example.car.model.WVOS.CarWVO;
import com.example.car.model.WVOS.OwnerWVO;
import com.example.car.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.car.constants.ENDPOINTS.*;
import static com.example.car.constants.PARAMS.OWNERWVO;
import static com.example.car.constants.PARAMS.OWNER_ID;

@RestController
@RequestMapping(path = OWNER_ENDPOINT)
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping(path = OWNER_DETAILS)
    public OwnerWVO getDriverDetails(@RequestParam(name = OWNER_ID) Long id) {
        return ownerService.getDriverDetails(id);

    }


    @PostMapping(path = OWNER_CREATE)
    public String createNewDriver(@RequestBody(required = true) OwnerWVO ownerWVO) {
        ownerService.createNewDriver(ownerWVO);
        return "Driver created Successfully";
    }


    @PutMapping(path = OWNER_UPDATE_DETAILS)
    public OwnerWVO update_owner_details_byId(@RequestBody(required = true) OwnerWVO ownerWVO) {
        return ownerService.update_owner_details_byId(ownerWVO);
    }


}
