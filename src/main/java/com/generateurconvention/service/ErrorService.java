package com.generateurconvention.service;

import com.generateurconvention.model.Convention;
import com.generateurconvention.repository.ErrorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.generateurconvention.model.Error;


import java.util.List;

@Service
public class ErrorService {
    @Autowired
    private ErrorRepository errorRepository;

    public Error addErrorToConvention(Convention convention, String errorDetails) {
        Error error = new Error();
        error.setConvention(convention);
        error.setErrorDetails(errorDetails);
        return errorRepository.save(error);
    }

    public List<Error> getErrorsByConvention(Long conventionId) {
        return errorRepository.findByConventionId(conventionId);
    }
}


