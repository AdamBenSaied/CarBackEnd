package com.example.car.model.VO;

import jakarta.persistence.*;
import org.apache.commons.lang3.time.DateUtils;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "inspection")
public class InspectionVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ISWHEELSPASS")
    private boolean isWheelPass;

    @Column(name = "ISWINDOWSPASS")
    private boolean isWindowsPass;

    @Column(name = "ISBRAKEPASS")
    private boolean isbrakepass;

    @Column(name = "ISMECHANICPASS")
    private boolean ismechanicpass;

    @Column(name = "OBTENTION_DATE")
    private LocalDate obtentionDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_CAR")
    private CarVO carVO;

    @Transient
    private LocalDate expirationDate;


    public InspectionVO() {
    }



    public Long getId() {
        return id;
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


    public InspectionVO(boolean isWheelPass, boolean isWindowsPass, boolean isbrakepass,
                        boolean ismechanicpass, LocalDate obtentionDate, LocalDate expirationDate) {
        this.isWheelPass = isWheelPass;
        this.isWindowsPass = isWindowsPass;
        this.isbrakepass = isbrakepass;
        this.ismechanicpass = ismechanicpass;
        this.obtentionDate = obtentionDate;
        this.expirationDate = expirationDate;
    }

    public InspectionVO(boolean isWheelPass, boolean isWindowsPass, boolean isbrakepass,
                        boolean ismechanicpass, LocalDate obtentionDate, CarVO carVO, LocalDate expirationDate) {
        this.isWheelPass = isWheelPass;
        this.isWindowsPass = isWindowsPass;
        this.isbrakepass = isbrakepass;
        this.ismechanicpass = ismechanicpass;
        this.obtentionDate = obtentionDate;
        this.carVO = carVO;
        this.expirationDate = expirationDate;
    }

    public CarVO getCarVO() {
        return carVO;
    }

    public void setCarVO(CarVO carVO) {
        this.carVO = carVO;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public LocalDate getObtentionDate() {
        return obtentionDate;
    }

    public void setObtentionDate(LocalDate obtentionDate) {
        this.obtentionDate = obtentionDate;
    }

    public LocalDate getExpirationDate() {
        return obtentionDate.plusYears(1);
    }

    public void setExpirationDate() {
        this.expirationDate=obtentionDate.plusYears(1);
    }


}
