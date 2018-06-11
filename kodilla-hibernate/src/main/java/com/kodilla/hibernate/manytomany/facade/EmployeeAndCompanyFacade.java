package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class EmployeeAndCompanyFacade {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    public List<Company> retrieveCompanyWithPartName(String partName) {
        return companyDao.retrieveCompanyWithPartName(partName);
    }

    public List<Employee> retrieveEmployeeWithPartLastname(String partLastName) {
        return employeeDao.retrieveEmployeeWithPartLastName(partLastName);
    }
}
