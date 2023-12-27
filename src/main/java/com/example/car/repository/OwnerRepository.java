package com.example.car.repository;

import com.example.car.model.VO.OwnerVO;
import com.example.car.model.WVOS.OwnerWVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<OwnerVO, Long> {
    OwnerVO findByMail(String mail);

}
