package com.example.car.model.WVOS;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class InspectionWVO implements Serializable {

    private boolean isWheelPass;
    private boolean isWindowsPass;
    private boolean isbrakepass;
    private boolean ismechanicpass;
    private LocalDate obtentionDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CarWVO carWVO;

    private LocalDate expirationDate;

    public InspectionWVO() {
    }

    public InspectionWVO(boolean isWheelPass, boolean isWindowsPass, boolean isbrakepass,
                         boolean ismechanicpass, LocalDate obtentionDate, CarWVO carWVO, LocalDate expirationDate) {
        this.isWheelPass = isWheelPass;
        this.isWindowsPass = isWindowsPass;
        this.isbrakepass = isbrakepass;
        this.ismechanicpass = ismechanicpass;
        this.obtentionDate = obtentionDate;
        this.carWVO = carWVO;
        this.expirationDate = expirationDate;
    }

    public InspectionWVO(boolean isWheelPass, boolean isWindowsPass,
                         boolean isbrakepass, boolean ismechanicpass, LocalDate obtentionDate, CarWVO carWVO) {
        this.isWheelPass = isWheelPass;
        this.isWindowsPass = isWindowsPass;
        this.isbrakepass = isbrakepass;
        this.ismechanicpass = ismechanicpass;
        this.obtentionDate = obtentionDate;
        this.carWVO = carWVO;
    }




    public boolean isWheelPass() {
        return isWheelPass;
    }

    public void setWheelPass(boolean wheelPass) {
        isWheelPass = wheelPass;
    }

    public boolean isWindowsPass() {
        return isWindowsPass;
    }

    public void setWindowsPass(boolean windowsPass) {
        isWindowsPass = windowsPass;
    }

    public boolean isIsbrakepass() {
        return isbrakepass;
    }

    public void setIsbrakepass(boolean isbrakepass) {
        this.isbrakepass = isbrakepass;
    }

    public boolean isIsmechanicpass() {
        return ismechanicpass;
    }

    public void setIsmechanicpass(boolean ismechanicpass) {
        this.ismechanicpass = ismechanicpass;
    }

    public LocalDate getObtentionDate() {
        return obtentionDate;
    }

    public void setObtentionDate(LocalDate obtentionDate) {
        this.obtentionDate = obtentionDate;
    }

    public CarWVO getCarWVO() {
        return carWVO;
    }

    public void setCarWVO(CarWVO carWVO) {
        this.carWVO = carWVO;
    }

    public LocalDate getExpirationDate() {
      return obtentionDate.plusYears(1);
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate=obtentionDate.plusYears(1);
    }
}
