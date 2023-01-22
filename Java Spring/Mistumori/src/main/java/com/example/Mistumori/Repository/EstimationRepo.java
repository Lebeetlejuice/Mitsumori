package com.example.Mistumori.Repository;

import com.example.Mistumori.model.Estimation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstimationRepo extends JpaRepository<Estimation, Long> {
}
