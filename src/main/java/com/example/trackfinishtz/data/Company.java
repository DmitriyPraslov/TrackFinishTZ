package com.example.trackfinishtz.data;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String companyName;
    private int startWorkTime;
    List<Department> departments;

    public Company(String companyName) {
        departments = new ArrayList<>();
        startWorkTime = 9;
        this.companyName = companyName;
    }

    public void changeWorkTimeByCompany (){
        for (Department departmentTemp : departments){
            departmentTemp.synchronizedWorkByDepartment(startWorkTime);
        }
    }

    public void addDepartment (Department department){
        departments.add(department);
    }

    public void removeDepartment (Department department){
        departments.remove(department);
    }

    public void removeDepartmentByName (String departmentName){
        for (Department departmentTemp : departments){
            if (departmentTemp.getDepartmentName().equals(departmentName)){
                departments.remove(departmentTemp);
            }
        }
    }

    public double getEffectivityWorkTimeByCompany (){
        double result = 0;
        for (Department departmentTemp : departments){
            result += departmentTemp.getEffectivityWorkTimeByDepartment();
        }
        return result;
    }

    public String getCompanyName() {
        return companyName;
    }

    public int getStartWorkTime() {
        return startWorkTime;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setStartWorkTime(int startWorkTime) {
        this.startWorkTime = startWorkTime;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
