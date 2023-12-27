package com.example.car.repository;

import com.example.car.model.VO.InspectionVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionRepository extends JpaRepository<InspectionVO,Long> {


}
