package com.generateurconvention.service;

import com.generateurconvention.dto.LogDTO;
import com.generateurconvention.model.Convention;
import com.generateurconvention.model.Log;
import com.generateurconvention.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogService {

    @Autowired
    private LogRepository logRepository;

    public Log createLog(Convention convention, LogDTO logDTO) {
        Log log = new Log();
        log.setCallType(logDTO.getCallType());
        log.setCaller(logDTO.getCaller());
        log.setDetails(logDTO.getDetails());
        log.setStatus(logDTO.getStatus());
        log.setTimestamp(logDTO.getTimestamp());
        log.setConvention(convention);
        return logRepository.save(log);
    }

    public List<Log> getLogsByConvention(Convention convention) {
        return logRepository.findByConventionId(convention.getId());
    }
}
