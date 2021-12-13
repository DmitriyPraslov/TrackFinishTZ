package com.example.trackfinishtz.beans;

import com.example.trackfinishtz.data.Department;

import java.util.List;

public class DepartmentBean {
    private List<Department> departments;

    public DepartmentBean() {
    }

    public DepartmentBean(List<Department> departments) {
        this.departments = departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public int getSize(){
        return departments.size();
    }


}
