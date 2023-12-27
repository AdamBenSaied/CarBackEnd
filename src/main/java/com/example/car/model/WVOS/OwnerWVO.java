package com.example.car.model.WVOS;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class OwnerWVO implements Serializable {


    private String name;
    private String surname;
    private String mail;
    private Date dob;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CarWVO> carWVOList;

    public List<CarWVO> getCarWVOList() {
        return carWVOList;
    }

    public void setCarWVOList(List<CarWVO> carWVOList) {
        this.carWVOList = carWVOList;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getMail() {
        return mail;
    }

    public Date getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public OwnerWVO(String name, String surname, String mail, Date dob, List<CarWVO> carWVOList) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dob = dob;
        this.carWVOList = carWVOList;
    }

    public OwnerWVO(String name, String surname, String mail, Date dob) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dob = dob;
    }

    public OwnerWVO() {
    }
}
