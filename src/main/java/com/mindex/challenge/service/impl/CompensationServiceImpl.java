package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CompensationServiceImpl implements CompensationService {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

    @Autowired
    private CompensationRepository compensationRepository;
 
    @Override
    public Compensation create(Compensation compensation) {
        LOG.debug("Creating employee [{}]", compensation);
        System.out.println(compensation.getEmployee());
        compensationRepository.insert(compensation);
      //  employeeRepository.insert(compensation.getEmployee());
//        System.out.print(compensation.getEmployee().getEmployeeId());
        return compensation;
    }

    @Override
    public Compensation read(String id) {
        LOG.debug("Reading employee with id [{}]", id);
        Compensation compensation = compensationRepository.findByEmployeeId(id);
        if (compensation == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return compensation;
    }

}