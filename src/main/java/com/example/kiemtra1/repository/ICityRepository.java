package com.example.kiemtra1.repository;

import com.example.kiemtra1.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Integer> {
}
