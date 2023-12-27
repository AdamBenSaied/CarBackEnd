package com.example.car.controller;

import com.example.car.model.VO.InspectionVO;
import com.example.car.model.WVOS.InspectionWVO;
import com.example.car.service.InsepctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static com.example.car.constants.ENDPOINTS.*;
import static com.example.car.constants.PARAMS.INSPECTION_ID;

@RestController()
@RequestMapping(path = INSPECTION_ENDPOINT)
public class InspctionController {

    private final InsepctionService insepctionService;

    @Autowired
    public InspctionController(InsepctionService insepctionService) {
        this.insepctionService = insepctionService;
    }

    @GetMapping(path = INSPECTION_BY_ID)
    public InspectionWVO getInspectionById(@RequestParam(name = INSPECTION_ID) Long inspectionId) {
        return insepctionService.getInspectionById(inspectionId);
    }

    @PostMapping(path = INSPECTION_NEW)
    public String createNewInspection(@RequestBody(required = true) InspectionWVO inspectionWVO) {
         insepctionService.createNewInspection(inspectionWVO);
         return "Inspection created Successfuly";
    }

}
