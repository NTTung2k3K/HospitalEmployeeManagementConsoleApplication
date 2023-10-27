/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tung
 */
public class Employee {

    private String id;
    private String name;
    private String phone;
    private LocalDate bDate;
    private String role;
    private LocalDate hiredDate;
    private int salary;
    private int contractTime;
    private LocalDate resignDate;

    public Employee(String id, String name, String phone, LocalDate bDate, String role, LocalDate hiredDate, int salary, int contractTime, LocalDate resignDate) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.bDate = bDate;
        this.role = role;
        this.hiredDate = hiredDate;
        this.salary = salary;
        this.contractTime = contractTime;
        this.resignDate = resignDate;
    }

    public Employee() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id.toUpperCase();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getHiredDate() {
        return hiredDate;
    }

    public void setHiredDate(LocalDate hiredDate) {
        this.hiredDate = hiredDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getContractTime() {
        return contractTime;
    }

    public void setContractTime(int contractTime) {
        this.contractTime = contractTime;
    }

    public LocalDate getResignDate() {
        return resignDate;
    }

    public void setResignDate(LocalDate resignDate) {
        this.resignDate = resignDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", name=" + name + ", phone=" + phone + ", bDate=" + bDate + ", role=" + role + ", hiredDate=" + hiredDate + ", salary=" + salary + ", contractTime=" + contractTime + ", resignDate=" + resignDate + '}';
    }

    public String toFileString() {
        String resignDate = null;
        if (this.resignDate != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            resignDate = this.resignDate.format(dtf);
        }

        String birthDay = null;
        if (this.bDate != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            birthDay = this.bDate.format(dtf);
        }
        String hireDay = null;
        if (this.hiredDate != null) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            hireDay = this.hiredDate.format(dtf);
        }
        return id + ", " + name + ", "
                + phone + ", "
                + birthDay + ", "
                + role + ", "
                + hireDay + ", "
                + salary + ", "
                + contractTime + ", "
                + resignDate;

    }

}
