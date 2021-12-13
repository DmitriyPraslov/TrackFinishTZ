package com.example.trackfinishtz.data;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> departmentWorker;
    private int startWorkTime;
    private boolean synchroWork;
    private boolean changeWorkTimePermission;

    public Department(String departmentName, int startWorkTime, boolean synchroWork, boolean changeWorkTimePermission) {
        departmentWorker = new ArrayList<>();
        this.departmentName = departmentName;
        this.startWorkTime = startWorkTime;
        this.synchroWork = synchroWork;
        this.changeWorkTimePermission = changeWorkTimePermission;
    }

    public void addEmployee(Employee newEmployee){
        newEmployee.synchronizedWork(startWorkTime);
        departmentWorker.add(newEmployee);
    }

    public void removeEmployee(String employeeName){
        for (Employee tempEmployee : departmentWorker){
            if ((tempEmployee.getFirstName()+ " " + tempEmployee.getLastName()).equals(employeeName)){
                departmentWorker.remove(tempEmployee);
            }
        }
    }

    public void removeEmployee(Employee employee){
            departmentWorker.remove(employee);
    }

    public void changeWorkTime (int startWorkTime){
        if (changeWorkTimePermission==false){
            return;
        }
        this.startWorkTime = startWorkTime;
        if (synchroWork==true){
            synchronizedWorkByDepartment(startWorkTime);
        }
    }

    public void synchronizedWorkByDepartment(int startWorkTime) {
        for (Employee tempEmployee : departmentWorker){
            tempEmployee.synchronizedWork(startWorkTime);
        }
    }

    public double getEffectivityWorkTimeByDepartment (){
        double result = 0;
        synchronizedWorkByDepartment(startWorkTime);
        for (Employee tempEmployee : departmentWorker){
            result += tempEmployee.getEffectivityWorkTime();
        }
        return result;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public List<Employee> getDepartmentWorker() {
        return departmentWorker;
    }

    public int getStartWorkTime() {
        return startWorkTime;
    }

    public boolean isSynchroWork() {
        return synchroWork;
    }

    public boolean isChangeWorkTimePermission() {
        return changeWorkTimePermission;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setDepartmentWorker(List<Employee> departmentWorker) {
        this.departmentWorker = departmentWorker;
    }

    public void setStartWorkTime(int startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public void setSynchroWork(boolean synchroWork) {
        this.synchroWork = synchroWork;
    }

    public void setChangeWorkTimePermission(boolean changeWorkTimePermission) {
        this.changeWorkTimePermission = changeWorkTimePermission;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", departmentWorker=" + departmentWorker +
                ", startWorkTime=" + startWorkTime +
                ", synchroWork=" + synchroWork +
                ", changeWorkTimePermission=" + changeWorkTimePermission +
                '}';
    }
}
