package com.example.car.model.VO;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "car")
public class CarVO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MANUFACTURER")
    private String manufacturer;

    @Column(name = "MODEL")
    private String model;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_OWNER", referencedColumnName = "ID")
    private OwnerVO ownerVO;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carVO")
    private List<InspectionVO> inspectionVOList;


    public Long getId() {
        return id;
    }

    public List<InspectionVO> getInspectionVOList() {
        return inspectionVOList;
    }

    public void setInspectionVOList(List<InspectionVO> inspectionVOList) {
        this.inspectionVOList = inspectionVOList;
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

    public OwnerVO getOwnerVO() {
        return ownerVO;
    }

    public void setOwnerVO(OwnerVO ownerVO) {
        this.ownerVO = ownerVO;
    }

    public CarVO(String manufacturer, String model, OwnerVO ownerVO) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ownerVO = ownerVO;
    }

    public CarVO(Long id, String manufacturer, String model, OwnerVO ownerVO) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.ownerVO = ownerVO;
    }

    public CarVO(String manufacturer, String model, OwnerVO ownerVO, List<InspectionVO> inspectionVOList) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.ownerVO = ownerVO;
        this.inspectionVOList = inspectionVOList;
    }

    public CarVO() {
    }
}
