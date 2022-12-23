/*package com.example.Mistumori.api;


import com.example.Mistumori.model.Estimation;
import com.example.Mistumori.security.service.UserDetailsImpl;
import com.example.Mistumori.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("api/products/")
public class EstimationController{

    @Autowired
    UserService userService;

    @Autowired
    EstimationService estimationService;


    @PostMapping("/post/")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public String createEstimation(@RequestBody Estimation estimation,@PathVariable Long id) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();



        System.out.println(userDetails.getId());

        return "votre estimation a bien été sauvegarder " + userDetails.getId();
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('ROLE_MODERATOR') or hasRole('ROLE_ADMIN')")
    public List<EstimationRepo> listestimation() {
        return estimationService.listAllEstimation();
    }


}*/