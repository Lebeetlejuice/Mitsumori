package com.example.Mistumori.security.service;

import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EstimationService {

    @Autowired
    EstimationRepo estimationRepo;

    public Estimation getEstimation(Long id) {
        return estimationRepo.findById(id).get();
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
