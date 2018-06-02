package com.kodilla.patterns2.Observer.Homework;

public class Mentor implements Observer {
    private final String username;
    private int uptadeCount;

    public Mentor(String username) {
        this.username = username;
    }

    public void uptade(StudentTasks studentTasks) {
        System.out.println(username + " masz do sprawdzenia zadanie (" + studentTasks.getKodillaTasks().getLast() + ") wysłane przez: "
                + studentTasks.getStudentName() + "\n" +
                " (" + studentTasks.getKodillaTasks().size() + ")");
        uptadeCount++;
    }

    public String getUsername() {
        return username;
    }

    public int getUptadeCount() {
        return uptadeCount;
    }
}
