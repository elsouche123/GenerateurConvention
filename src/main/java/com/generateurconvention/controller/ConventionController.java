package com.generateurconvention.controller;

import com.generateurconvention.dto.ConventionDTO;
import com.generateurconvention.dto.LogDTO;
import com.generateurconvention.dto.ErrorDTO;
import com.generateurconvention.model.Convention;
import com.generateurconvention.model.Log;
import com.generateurconvention.service.ConventionService;
import com.generateurconvention.service.ErrorService;
import com.generateurconvention.service.LogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.generateurconvention.model.Error;



import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/conventions")
@Tag(name = "Conventions", description = "API pour gérer les conventions")
public class ConventionController {

    @Autowired
    private ConventionService conventionService;

    @Autowired
    private ErrorService errorService;

    @Autowired
    private LogService logService;

    @Operation(summary = "Lister toutes les conventions")
    @GetMapping
    public List<ConventionDTO> getAllConventions() {
        return conventionService.getAllConventions()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Lister les conventions avec erreurs")
    @GetMapping("/errors")
    public List<ConventionDTO> getConventionsWithErrors() {
        return conventionService.getConventionsWithErrors()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Ajouter une erreur à une convention")
    @PostMapping("/{id}/errors")
    public ResponseEntity<ErrorDTO> addErrorToConvention(@PathVariable Long id, @RequestBody String errorDetails) {
        Convention convention = conventionService.getConventionById(id);
        if (convention == null) {
            return ResponseEntity.notFound().build();
        }
        Error error = errorService.addErrorToConvention(convention, errorDetails);
        ErrorDTO errorDTO = convertToErrorDTO(error);
        return ResponseEntity.ok(errorDTO);
    }

    @Operation(summary = "Créer un log")
    @PostMapping("/{id}/logs")
    public ResponseEntity<LogDTO> createLog(@PathVariable Long id, @RequestBody LogDTO logDTO) {
        Convention convention = conventionService.getConventionById(id);
        if (convention == null) {
            return ResponseEntity.notFound().build();
        }

        Log savedLog = logService.createLog(convention, logDTO);
        return ResponseEntity.ok(convertToLogDTO(savedLog));
    }

    @Operation(summary = "Récupérer tous les logs d'une convention")
    @GetMapping("/{id}/logs")
    public ResponseEntity<List<LogDTO>> getLogsByConvention(@PathVariable Long id) {
        Convention convention = conventionService.getConventionById(id);
        if (convention == null) {
            return ResponseEntity.notFound().build();
        }

        List<LogDTO> logs = logService.getLogsByConvention(convention)
                .stream()
                .map(this::convertToLogDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(logs);
    }

    private ConventionDTO convertToDTO(Convention convention) {
        ConventionDTO dto = new ConventionDTO();
        dto.setId(convention.getId());
        dto.setStudentName(convention.getStudentName());
        dto.setStudentYear(convention.getStudentYear());
        dto.setModelId(convention.getModelId());
        dto.setStatus(convention.getStatus());
        dto.setErrors(convention.getErrors().stream()
                .map(this::convertToErrorDTO)
                .collect(Collectors.toList()));
        return dto;
    }

    private ErrorDTO convertToErrorDTO(Error error) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setId(error.getId());
        errorDTO.setErrorDetails(error.getErrorDetails());
        errorDTO.setCreatedAt(error.getCreatedAt());
        return errorDTO;
    }

    private LogDTO convertToLogDTO(Log log) {
        LogDTO logDTO = new LogDTO();
        logDTO.setId(log.getId());
        logDTO.setCallType(log.getCallType());
        logDTO.setCaller(log.getCaller());
        logDTO.setDetails(log.getDetails());
        logDTO.setStatus(log.getStatus());
        logDTO.setTimestamp(log.getTimestamp());
        return logDTO;
    }
}


