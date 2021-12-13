package com.example.trackfinishtz.data;

public class Employee {
    private String firstName;
    private String lastName;
    private Department department;
    private Position position;
    private Preference preference;
    private int salary;

    public Employee(String firstName, String lastName, Department department, Position position, int salary, int startWorkTime, boolean workFromHome) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        if (workFromHome==true) {
            this.preference = Preference.createHomePreference();
        } else {
            this.preference = Preference.createPreference(startWorkTime);
        }
        this.salary = salary;
    }

    public void synchronizedWork (int startWorkTime){
        department.setStartWorkTime(startWorkTime);
    }

    public double getEffectivityWorkTime (){
        double result = 0;
        int startWorkTimeByDepartment = department.getStartWorkTime();
        if ((department.isSynchroWork()==true || department.isChangeWorkTimePermission()==false) || position.isChangeWorkTimePermission()==false){
            int differentTime = Math.abs(startWorkTimeByDepartment - preference.getStartWorkTime());
            result = (differentTime * 0.8) + (8 - differentTime);
        } else if (startWorkTimeByDepartment == preference.getStartWorkTime()){
            result = 8;
        } else {
            int differentTime = Math.abs(startWorkTimeByDepartment - preference.getStartWorkTime());
            result = (differentTime * 1.2) + (8 - differentTime);
        }
        return result;
    }

    public String getEmployeeFullName(){
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
