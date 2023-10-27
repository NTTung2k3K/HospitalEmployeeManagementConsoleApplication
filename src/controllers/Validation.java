/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import model.Employee;

/**
 *
 * @author tung
 */
public class Validation {

    public boolean hasSpace(String infor) {
        if (infor.contains(" ")) {
            System.out.println("Employee Id has a space");
            return true;
        } else {
            return false;
        }
    }

    public boolean isFormEmployee(String id) {
        if (id.matches("^[Ee][Mm]\\d{4}$")) {
            return true;
        } else {
            System.out.println("Employee Id must on the form (EMxxxx) (x: number)");
            return false;
        }
    }

    public boolean isDuplicateId(String id, ArrayList<Employee> listEmployee) {
        for (Employee employee : listEmployee) {
            if (employee.getId().equalsIgnoreCase(id)) {
                System.out.println("Employee Id is Duplicated");
                return true;
            }
        }
        return false;
    }

    public boolean isMaxLengthName(String name, int max) {
        if (name.length() >= 0 && name.length() <= max) {
            return true;
        } else {
            System.out.println("The max-length is " + max);
            return false;
        }
    }

    public boolean isUpperCaseName(String name) {
        if (name.equals(name.toUpperCase())) {
            return true;
        } else {
            System.out.println("Name must be UpperCase");
            return false;
        }
    }

    public boolean isNumber(String infor) {
        if (infor.matches("^\\d+$")) {
            return true;
        } else {
            System.out.println("Phone Number only accept Number");
            return false;
        }
    }

    public boolean isValidLenghPhoneNumber(String infor, int min, int max) {
        if (infor.length() >= min && infor.length() <= max) {
            return true;
        } else {
            System.out.println("The suitable length is from " + min + " to " + max);
            return false;
        }
    }

    public boolean isValidSalary(int infor, int min, int max) {
        if (infor >= min && infor <= max) {
            return true;
        } else {
            System.out.println("The suitable salary is from " + min + " to " + max);
            return false;
        }
    }

    public boolean isValidContractTime(int infor, int min, int max) {
        if (infor >= min && infor <= max) {
            return true;
        } else {
            System.out.println("The suitable contract time is from " + min + " to " + max);
            return false;
        }
    }

    public boolean isValidBirthDay(LocalDate birthDay) {
        LocalDate before18Year = LocalDate.now().minusYears(18);
        LocalDate before65Year = LocalDate.now().minusYears(65);
        if ((birthDay.isBefore(before18Year) || birthDay.isEqual(before18Year)) && (birthDay.isAfter(before65Year) || birthDay.isEqual(before65Year))) {
            return true;
        } else {
            System.out.println("The valid birthday date must from " + before65Year.getDayOfMonth() + "/" + before65Year.getMonthValue() + "/" + before65Year.getYear()
                    + " to " + before18Year.getDayOfMonth() + "/" + before18Year.getMonthValue() + "/" + before18Year.getYear());
            return false;
        }
    }

    public boolean isValidHireDay(LocalDate hireDay, LocalDate birthDay) {
        LocalDate before18Year = birthDay.plusYears(18);
        LocalDate after65Year = birthDay.plusYears(65);
        if ((hireDay.isEqual(before18Year) || hireDay.isAfter(before18Year)) && (hireDay.isEqual(after65Year) || hireDay.isBefore(after65Year))) {
            return true;
        } else {
            System.out.println("The hire date must from " + before18Year.getDayOfMonth() + "/" + before18Year.getMonthValue() + "/" + before18Year.getYear()
                    + " to " + after65Year.getDayOfMonth() + "/" + after65Year.getMonthValue() + "/" + after65Year.getYear());
            return false;
        }
    }

    public boolean isValidContactYear(int year, LocalDate bDate, int range) {
        if (range >= 30) {
            if (year >= 1 && year <= 30) {
                return true;
            } else {
                if (range == 1) {
                    System.out.println("The maximum contact year is 1");
                    return false;
                } else {
                    System.out.println("The suitable contact year is in range (1-" + range + ")!");
                    return false;
                }

            }
        } else {
            if (year >= 1 && year <= range) {
                return true;

            } else {
                if (range == 1) {
                    System.out.println("The maximum contact year is 1");
                    return false;
                } else {
                    System.out.println("The suitable contact year is in range (1-" + range + ")!");
                    return false;
                }
            }
        }
    }

    public boolean isValidResignDate(LocalDate resignDate, LocalDate hiredDate, LocalDate birthDay) {
//        4
//        01/01/2000
//      max = 01/01/2004
//        System.out.println(resignDate);
//        System.out.println(hiredDate);
//        System.out.println(max);
//        System.out.println("1 "+resignDate.isEqual(hiredDate));
//        System.out.println("2 "+resignDate.isAfter(hiredDate));
//        System.out.println("3 "+resignDate.isAfter(max));
        LocalDate after65Year = birthDay.plusYears(65);
        
        if (resignDate.isEqual(hiredDate) || (resignDate.isAfter(hiredDate)) && (resignDate.isBefore(after65Year) || resignDate.isEqual(after65Year))) {
            return true;
        } else {
            if (hiredDate.isEqual(after65Year)) {
                System.out.println("Resign date must be after " + after65Year.getDayOfMonth() + "/" + after65Year.getMonthValue() + "/" + after65Year.getYear());
                return false;
            } else {

                System.out.println("Resign date must from " + hiredDate.getDayOfMonth() + "/" + hiredDate.getMonthValue() + "/" + hiredDate.getYear()
                        + " to " + after65Year.getDayOfMonth() + "/" + after65Year.getMonthValue() + "/" + after65Year.getYear());
                return false;
            }

        }
    }

    public ArrayList takeListEmployeeById(String id, ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();
        for (Employee employee : listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                listResult.add(employee);
            }
        }
        return listResult;
    }

    public Employee takeEmployeeById(String id, ArrayList<Employee> listEmployees) {
        for (Employee employee : listEmployees) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    public ArrayList takeOnList(ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();

        for (Employee employee : listEmployees) {
            if (employee.getResignDate() == null) {
                listResult.add(employee);
            }
        }
        return listResult;
    }

    public ArrayList takeResignList(ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();

        for (Employee employee : listEmployees) {
            if (employee.getResignDate() != null) {
                listResult.add(employee);
            }
        }
        return listResult;
    }

    public ArrayList takeDoctorList(ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();

        for (Employee employee : listEmployees) {
            if (employee.getRole().equalsIgnoreCase("Doctor")) {
                listResult.add(employee);
            }
        }
        return listResult;
    }

    public ArrayList takeNurseList(ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();

        for (Employee employee : listEmployees) {
            if (employee.getRole().equalsIgnoreCase("Nurse")) {
                listResult.add(employee);
            }
        }
        return listResult;
    }

    public ArrayList takeTechnicianList(ArrayList<Employee> listEmployees) {
        ArrayList listResult = new ArrayList();

        for (Employee employee : listEmployees) {
            if (employee.getRole().equalsIgnoreCase("Technician")) {
                listResult.add(employee);
            }
        }
        return listResult;
    }
}
