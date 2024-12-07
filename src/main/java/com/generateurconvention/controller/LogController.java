package com.generateurconvention.controller;

import com.generateurconvention.repository.LogRepository;
import com.generateurconvention.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogController {
    @Autowired
    private LogRepository logRepository;

    @GetMapping
    public List<Log> getAllLogs() {
        return logRepository.findAll();
    }

    @PostMapping
    public Log createLog(@RequestBody Log log) {
        return logRepository.save(log);
    }
}

