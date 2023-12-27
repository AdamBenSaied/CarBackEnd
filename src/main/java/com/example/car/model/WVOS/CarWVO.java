package com.example.car.model.WVOS;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

public class CarWVO implements Serializable {

    private String manufacturer;
    private String model;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private OwnerWVO ownerWVO;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<InspectionWVO> insepctionWVOList;

    public List<InspectionWVO> getInsepctionWVOList() {
        return insepctionWVOList;
    }

    public void setInsepctionWVOList(List<InspectionWVO> insepctionWVOList) {
        this.insepctionWVOList = insepctionWVOList;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public OwnerWVO getOwnerWVO() {
        return ownerWVO;
    }

    public void setOwnerWVO(OwnerWVO ownerWVO) {
        this.ownerWVO = ownerWVO;
    }

    public CarWVO(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public CarWVO(String manufacturer, String model, OwnerWVO ownerWVO) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ownerWVO = ownerWVO;
    }

    public CarWVO(String model, OwnerWVO ownerWVO, List<InspectionWVO> insepctionWVOList) {
        this.model = model;
        this.ownerWVO = ownerWVO;
        this.insepctionWVOList = insepctionWVOList;
    }

    public CarWVO() {
    }
}
