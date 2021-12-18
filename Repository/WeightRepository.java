package com.example.registrationLoginSecurityThymeleaf.Repository;

import com.example.registrationLoginSecurityThymeleaf.Model.Weight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightRepository extends JpaRepository<Weight, Long> {
}
