package com.kodilla.patterns2.Observer.Homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class StudentTasks implements Observable {
    private final List<Observer> observers=new ArrayList<>();
    private final Deque<String> kodillaTasks=new ArrayDeque<>();
    private final String studentName;

    public StudentTasks(String studentName) {
        this.studentName = studentName;
    }

    public void addNewTask(String newTask){
        kodillaTasks.offerLast(newTask);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observers){
            observer.uptade(this);
        }
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public Deque<String> getKodillaTasks() {
        return kodillaTasks;
    }

    public String getStudentName() {
        return studentName;
    }

}
