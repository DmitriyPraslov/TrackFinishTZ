package com.example.trackfinishtz.beans;

import com.example.trackfinishtz.data.Employee;

import java.util.List;

public class EmployeeBean {
    private List<Employee> employees;

    public EmployeeBean() {
    }

    public EmployeeBean(List<Employee> employees) {
        this.employees = employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public int getSize(){
        return employees.size();
    }
}