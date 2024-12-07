package com.generateurconvention.service;

import com.generateurconvention.model.Convention;
import com.generateurconvention.repository.ConventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConventionService {

    @Autowired
    private ConventionRepository conventionRepository;

    public List<Convention> getAllConventions() {
        return conventionRepository.findAll();
    }

    public List<Convention> getConventionsWithErrors() {
        return conventionRepository.findAll().stream()
                .filter(convention -> !convention.getErrors().isEmpty())
                .collect(Collectors.toList());
    }



    public Convention saveConvention(Convention convention) {
        return conventionRepository.save(convention);
    }

    public void deleteConvention(Long id) {
        conventionRepository.deleteById(id);
    }

    public Convention getConventionById(Long id) {
        return conventionRepository.findById(id).orElse(null);
    }

}
