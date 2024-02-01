package com.example.kiemtra1.repository;

import com.example.kiemtra1.model.HomeStay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IHomeStayRepository extends JpaRepository<HomeStay,Integer> {
    List<HomeStay> findAllByNameContaining(String name);
}
