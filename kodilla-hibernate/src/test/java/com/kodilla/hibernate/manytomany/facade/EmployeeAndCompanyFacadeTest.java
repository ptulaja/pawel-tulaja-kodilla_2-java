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
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeAndCompanyFacade employeeAndCompanyFacade;

    @Test
    public void retrieveEmployeeLastname() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        employeeDao.save(johnSmith);
        int employeeOneId = johnSmith.getId();
        employeeDao.save(stephanieClarckson);
        int employeeTwoId = stephanieClarckson.getId();
        employeeDao.save(lindaKovalsky);
        int employeeThreeId = lindaKovalsky.getId();

        //when
        List<Employee> showLastname = employeeAndCompanyFacade.retrieveEmployeeLastname("Kov");

        //Then
        Assert.assertEquals("Kovalsky", showLastname.get(0).getLastname());
        Assert.assertEquals(1, showLastname.size());

        //cleanUp
        employeeDao.deleteAll();
    }

    @Test
    public void retrieveCompanyNameFirstLetters() {
        //Given
        Company softwareMachinee = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        companyDao.save(softwareMachinee);
        int companyOneId = softwareMachinee.getId();
        companyDao.save(dataMaesters);
        int companyTwoId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int companyThreeId = greyMatter.getId();

        //When
        List<Company> showCompanyName = employeeAndCompanyFacade.retrieveCompanyNameFirstLetters("Dat%");

        //Then
        Assert.assertEquals("Data Maesters", showCompanyName.get(1).getName());
        Assert.assertEquals(38, showCompanyName.size());

        //cleanUp
        companyDao.deleteAll();
    }
}
