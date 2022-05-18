package com.codegym.testmd4c12.repository;

import com.codegym.testmd4c12.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends JpaRepository<City,Long> {
}
