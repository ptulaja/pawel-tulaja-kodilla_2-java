package com.kodilla.patterns2.Observer.Homework;

import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTasksTest {
    @Test
    public void testUptade(){
        //Given
        StudentTasks pawel1=new StudentTasks("Pawel1");
        StudentTasks pawel2=new StudentTasks("Pawel2");
        StudentTasks pawel3=new StudentTasks("Pawel3");

        Mentor mentor1=new Mentor("Mentor1");
        Mentor mentor2=new Mentor("Mentor2");

        pawel1.registerObserver(mentor1);
        pawel2.registerObserver(mentor2);
        pawel3.registerObserver(mentor2);

        pawel1.addNewTask("1");
        pawel2.addNewTask("2");
        pawel3.addNewTask("3");


        assertEquals(1,mentor1.getUptadeCount());
        assertEquals(2,mentor2.getUptadeCount());
    }
}