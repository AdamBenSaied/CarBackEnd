package com.example.car.model.VO;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "driver")
public class OwnerVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "MAIL")
    private String mail;

    @Column(name = "DOB")
    private Date dob;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ownerVO")
    List<CarVO> carVOList;

    public OwnerVO() {
    }

    public OwnerVO(String name, String surname, String mail, Date dob) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dob = dob;
    }

    public OwnerVO(String name, String surname, String mail, Date dob, List<CarVO> carVOList) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.dob = dob;
        this.carVOList = carVOList;
    }

    public List<CarVO> getCarVOList() {
        return carVOList;
    }

    public void setCarVOList(List<CarVO> carVOList) {
        this.carVOList = carVOList;
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
