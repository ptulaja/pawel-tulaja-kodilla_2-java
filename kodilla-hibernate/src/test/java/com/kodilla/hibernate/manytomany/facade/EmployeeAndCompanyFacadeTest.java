package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeAndCompanyFacadeTest {

    @Autowired
    private EmployeeAndCompanyFacade employeeAndCompanyFacade;
    @Autowired
    private CompanyDao companyDao;

    @Test
    public void testFacade() {

        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");
        Employee paulSmitho =new Employee("Paul", "Smitho");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");
        Company greyoMaster = new Company("Greyo Master");

        softwareMachine.getEmployees().add(johnSmith);
        softwareMachine.getEmployees().add(paulSmitho);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);
        greyoMaster.getEmployees().add(paulSmitho);


        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);
        paulSmitho.getCompanies().add(greyoMaster);
        paulSmitho.getCompanies().add(softwareMachine);

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();
        companyDao.save(greyoMaster);
        int greyoMasterId=greyoMaster.getId();

        //When
        List<Employee> employees= employeeAndCompanyFacade.retrieveEmployeeWithPartLastname("sky");
        List<Company> companies= employeeAndCompanyFacade.retrieveCompanyWithPartName("oft");

        //Then
        Assert.assertEquals(1, employees.size());
        Assert.assertEquals("Kovalsky", employees.get(0).getLastname());

        Assert.assertEquals(1, companies.size());
        Assert.assertEquals("Software Machine", companies.get(0).getName());

        //CleanUp
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(dataMaestersId);
            companyDao.delete(greyMatterId);
            companyDao.delete(greyoMasterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
