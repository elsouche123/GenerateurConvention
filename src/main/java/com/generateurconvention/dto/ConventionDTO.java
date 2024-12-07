package com.generateurconvention.dto;

import java.util.List;

public class ConventionDTO {
    private Long id;
    private String studentName;
    private String studentYear;
    private Long modelId;
    private String status;
    private List<ErrorDTO> errors;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentYear() {
        return studentYear;
    }

    public void setStudentYear(String studentYear) {
        this.studentYear = studentYear;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ErrorDTO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDTO> errors) {
        this.errors = errors;
    }
}
