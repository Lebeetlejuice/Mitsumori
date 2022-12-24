package com.example.Mistumori.api;


import com.example.Mistumori.Repository.EstimationRepo;
import com.example.Mistumori.Repository.UserRepo;
import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.model.User;
import com.example.Mistumori.payload.response.MessageResponse;
import com.example.Mistumori.security.service.EstimationService;
import com.example.Mistumori.security.service.UserDetailsImpl;
import com.example.Mistumori.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("api/products/")
public class EstimationController{

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    EstimationService estimationService;

    @Autowired
    EstimationRepo estimationRepo;


    @PostMapping("/post")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String createEstimation(@RequestBody Estimation estimation, HttpServletRequest request) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Long userid = userDetails.getId();
        estimation.setUsers_id(userid);
        estimationService.saveEstimation(estimation);

        return "votre estimation a bien été sauvegarder " + userDetails.getId();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<String> put(@PathVariable("id") Long id,@RequestBody Estimation estimation ) {
        Estimation updateEstimation = estimationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Error: estimation is not found id."));
        updateEstimation.setName(estimation.getName());
        estimationService.saveEstimation(estimation);
        return new ResponseEntity<String>("Estimation is updated successfully.!", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        estimationService.deleteEstimation(id);
        return new ResponseEntity<String>("Estimation is deleted successfully.!", HttpStatus.OK);
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public List<Estimation> listestimation() {
        return estimationService.listAllEstimation();
    }


}