package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.model.Estimation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EstimationService {

    private final EstimationRepo estimationRepo;

    public EstimationService(EstimationRepo estimationRepo) {
        this.estimationRepo = estimationRepo;
    }


    public Optional<Estimation> getEstimation(Long id) {
        return estimationRepo.findById(id);
    }
    public Estimation saveEstimation(Estimation estimation) {
        return estimationRepo.save(estimation);
    }
    public List<Estimation> listAllEstimation() {
        return estimationRepo.findAll();
    }

    public void deleteEstimation(Long id) {
        estimationRepo.deleteById(id);
    }
}
