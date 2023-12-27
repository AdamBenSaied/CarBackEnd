package com.example.car.repository;

import com.example.car.model.VO.CarVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<CarVO, Long> {
    List<CarVO> findAllByOwnerVO_Id(Long driverId);

}
