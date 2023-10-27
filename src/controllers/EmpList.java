/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Employee;
import view.Menu;

/**
 *
 * @author tung
 */
public class EmpList {

    ArrayList<Employee> listEmployee;
    ArrayList<String> listRole;
    Menu menu;
    MyDateBooleanTools tool;
    ArrayList<String> ask;
    Validation validation;

    public EmpList() {
        listEmployee = new ArrayList<>();
        menu = new Menu();
        ask = new ArrayList<>();
        tool = new MyDateBooleanTools();
        validation = new Validation();
        listRole = new ArrayList<>();
        ask.add("Continue");
        ask.add("Back to menu");
    }

    public void loadFromFileEmployees(String pathName) {
        try {
            listEmployee.clear();
            File f = new File(pathName);
            if (!f.exists()) {
                System.out.println("File Employee is not Exist");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
                    String parts[] = line.split(", ");
                    String id = parts[0].trim();

                    String name = parts[1].trim();

                    String phone = parts[2].trim();

                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    LocalDate bDate = LocalDate.parse(parts[3], dtf);

                    String role = parts[4].trim();

                    LocalDate hiredDate = LocalDate.parse(parts[5], dtf);

                    int salary = Integer.parseInt(parts[6].trim());

                    int contractTime = Integer.parseInt(parts[7].trim());
                    LocalDate resignDate = null;
                    if (parts[8].trim().equalsIgnoreCase("null")) {
                        resignDate = null;
                    } else {
                        resignDate = LocalDate.parse(parts[8].trim(), dtf);
                    }

                    Employee employee = new Employee(id, name, phone, bDate, role, hiredDate, salary, contractTime, resignDate);
                    listEmployee.add(employee);
                }
                br.close();

            }

        } catch (FileNotFoundException f) {
            System.out.println("File Employees is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Load File !, File Passenger is not found");
        }
    }

    public void loadFromFileRoles(String pathName) {
        try {
            listRole.clear();
            File f = new File(pathName);
            if (!f.exists()) {
                System.out.println("File Passenger is not Exist");
            } else {
                BufferedReader br = new BufferedReader(new FileReader(f));
                String line;
                while ((line = br.readLine()) != null && (!br.equals(""))) {
                    listRole.add(line);
                }
                br.close();

            }

        } catch (FileNotFoundException f) {
            System.out.println("File Employees is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Load File !, File Passenger is not found");
        }
    }

    public void viewAllList() {
        menu.printMenuEmployee(listEmployee);
    }

    public void addNewEmployee() {

            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("+                           Add Employee                                +");
            System.out.println("+-----------------------------------------------------------------------+");
            boolean flag = true;
            int choice;
            Employee employee = new Employee();
            while (flag) {
                String id = tool.inputString("EMxxxx (x: number):");
                if (id.equalsIgnoreCase("")) {
                    return;
                } else if (validation.hasSpace(id) == false && validation.isDuplicateId(id, listEmployee) == false
                        && validation.isFormEmployee(id) == true) {
                    employee.setId(id);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            id = tool.inputString("EMxxxx (x: number):");
                            if (id.equalsIgnoreCase("")) {
                                return;
                            } else if (validation.hasSpace(id) == false && validation.isDuplicateId(id, listEmployee) == false
                                    && validation.isFormEmployee(id) == true) {;
                                employee.setId(id);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);
                }

            }
            flag = true;

            while (flag) {
                String name = tool.inputString("Name:");
                if (name.equalsIgnoreCase("")) {
                    return;
                } else if (validation.isUpperCaseName(name) == true) {
                    employee.setName(name.toUpperCase());
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            name = tool.inputString("Name:");
                            if (name.equalsIgnoreCase("")) {
                                return;
                            } else if (validation.isUpperCaseName(name) == true) {
                                employee.setName(name.toUpperCase());
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;

            while (flag) {
                String phone = tool.inputString("Phone Number (9-11):");
                if (phone.equalsIgnoreCase("")) {
                    return;
                } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                    employee.setPhone(phone);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            phone = tool.inputString("Phone Number (9-11):");
                            if (phone.equalsIgnoreCase("")) {
                                return;
                            } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                                employee.setPhone(phone);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;
            while (flag) {
                LocalDate bDate = tool.inputDate("Birthday (dd/mm/yyyy):");
                if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                    return;
                } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                    employee.setbDate(bDate);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            bDate = tool.inputDate("Birthday (dd/mm/yyyy):");

                            if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                                return;
                            } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                                employee.setbDate(bDate);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;
            while (flag) {
                String role = menu.getChoiceRole(listRole);
                if (role == null) {
                    return;
                } else if (role != null) {
                    employee.setRole(role);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            role = menu.getChoiceRole(listRole);
                            if (role == null) {
                                return;
                            } else if (role != null) {
                                employee.setRole(role);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;

            while (flag) {
                LocalDate hiredDay = tool.inputDate("Hired Date (dd/mm/yyyy):");
                if (hiredDay != null && hiredDay.isEqual(LocalDate.of(2, 2, 2))) {
                    return;
                } else if (hiredDay != null && validation.isValidHireDay(hiredDay, employee.getbDate())) {
                    employee.setHiredDate(hiredDay);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            hiredDay = tool.inputDate("Hired Date (dd/mm/yyyy):");
                            if (hiredDay != null && hiredDay.isEqual(LocalDate.of(2, 2, 2))) {
                                return;
                            } else if (hiredDay != null && validation.isValidHireDay(hiredDay, employee.getbDate())) {
                                employee.setHiredDate(hiredDay);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;

            while (flag) {
                int max = 8000;
                int min = 100;
                int salary = tool.inputIntAcceptEnter("Salary ("
                        + min
                        + "$-"
                        + max
                        + "$):");
                if (salary == -1) {
                    return;
                } else if (validation.isValidSalary(salary, 100, 8000) == true) {
                    employee.setSalary(salary);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            salary = tool.inputIntAcceptEnter("Salary ("
                                    + min
                                    + "$-"
                                    + max
                                    + "$):");
                            if (salary == -1) {
                                return;
                            } else if (validation.isValidSalary(salary, 100, 8000) == true) {
                                employee.setSalary(salary);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;

            while (flag) {
//            int startYear = employee.getHiredDate().getYear();
//            int endYear = LocalDate.now().getYear();
//            int range = endYear - startYear;
//            int max = 30;
//            int min = 1;
//            if (range > 30) {
//                range = 30;
//            }
//            int contractTime = 0;
//            if (range != 1) {
//                contractTime = tool.inputInt("Contact Time ("
//                        + min
//                        + " year - "
//                        + range
//                        + " year):");
//            } else {
//                contractTime = tool.inputInt("Contact Time:");
//            }
                int contractTime = tool.inputIntAcceptEnter("Contract Time (1-30):");
                if (contractTime == -1) {
                    return;
                } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                        ) {
                    employee.setContractTime(contractTime);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            contractTime = tool.inputIntAcceptEnter("Contract Time (1-30):");
                            if (contractTime == -1) {
                                return;
                            } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                                    ) {
                                employee.setContractTime(contractTime);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            flag = true;

            while (flag) {
                LocalDate resignDate = tool.inputResignDate("Resign Date (dd/mm/yyyy):");
                LocalDate notResign = LocalDate.of(1, 1, 1);
                if (resignDate != null && resignDate.isEqual(LocalDate.of(2, 2, 2))) {
                    return;
                } else if (resignDate != null && resignDate.isEqual(notResign)) {
                    employee.setResignDate(null);
                    flag = false;
                } else if (resignDate != null && validation.isValidResignDate(resignDate, employee.getHiredDate(), employee.getbDate())) {
                    employee.setResignDate(resignDate);
                    flag = false;
                } else {
                    do {
                        choice = menu.getChoiceAskForBack(ask);
                        if (choice == 1) {
                            resignDate = tool.inputResignDate("Resign Date (dd/mm/yyyy):");
                            if (resignDate != null && resignDate.isEqual(LocalDate.of(2, 2, 2))) {
                                return;
                            } else if (resignDate != null && resignDate.isEqual(notResign)) {
                                employee.setResignDate(null);
                                flag = false;
                            } else if (resignDate != null && validation.isValidResignDate(resignDate, employee.getHiredDate(), employee.getbDate())) {
                                employee.setResignDate(resignDate);
                                flag = false;
                            } else {
                                flag = true;
                            }
                        } else {
                            return;
                        }
                    } while (flag);

                }
            }
            listEmployee.add(employee);
            System.out.println("");
            System.out.println("+----------------------------+");
            System.out.println("+  Add Employee Succesfully  +");
            System.out.println("+----------------------------+");
            System.out.println("");

    }

    public void updateEmployee() {
        ArrayList<String> listRolesUpdate = new ArrayList<>();
        listRolesUpdate.add("Admin");
        listRolesUpdate.add("User");

        String roleFromList = menu.getChoiceRole(listRolesUpdate);
        if (roleFromList != null && roleFromList.equalsIgnoreCase("admin")) {
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                      Update Employee By Id                            +");
                System.out.println("+-----------------------------------------------------------------------+");
                String id = tool.inputString("EMxxxx (x: number):");
                Employee employee = validation.takeEmployeeById(id, listEmployee);
                menu.printMenuEmployeeByDelete(employee, listEmployee);
                boolean flag = true;
                int choice = 0;
                if (employee != null) {
                    String name = "";
                    String phone = "";
                    LocalDate bDate = null;
                    String role = "";
                    int contractTime = 0;
                    while (flag) {
                         name = tool.inputString("Name Old("
                                + employee.getName() + ")"
                                + " :");
                        if (name.equalsIgnoreCase("")) {
                            return;
                        } else if (validation.isUpperCaseName(name) == true) {
                            flag = false;
                        } else {
                            do {
                                choice = menu.getChoiceAskForBack(ask);
                                if (choice == 1) {
                                    name = tool.inputString("Name Old("
                                            + employee.getName() + ")"
                                            + " :");
                                    if (name.equalsIgnoreCase("")) {
                                        return;
                                    } else if (validation.isUpperCaseName(name) == true) {
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);

                        }
                    }
                    flag = true;

                    while (flag) {
                         phone = tool.inputString("Phone Number (9-11) Old("
                                + employee.getPhone() + "):");
                        if (phone.equalsIgnoreCase("")) {
                            return;
                        } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                            flag = false;
                        } else {
                            do {
                                choice = menu.getChoiceAskForBack(ask);
                                if (choice == 1) {
                                    phone = tool.inputString("Phone Number (9-11) Old("
                                            + employee.getPhone() + "):");
                                    if (phone.equalsIgnoreCase("")) {
                                        return;
                                    } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);

                        }
                    }
                    flag = true;
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    while (flag) {
                         bDate = tool.inputDate("Birthday (dd/mm/yyyy) Old("
                                + employee.getbDate().format(dtf) + "):");
                        if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                            return;
                        } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                            flag = false;
                        } else {
                            do {
                                choice = menu.getChoiceAskForBack(ask);
                                if (choice == 1) {
                                    bDate = tool.inputDate("Birthday (dd/mm/yyyy) Old("
                                            + employee.getbDate().format(dtf) + "):");
                                    if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                                        return;
                                    } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);

                        }
                    }
                    flag = true;

                    while (flag) {
                        role = menu.getChoiceRole(listRole);
                        if (role == null) {
                            return;
                        } else if (role != null) {
                            flag = false;
                        } else {
                            do {
                                choice = menu.getChoiceAskForBack(ask);
                                if (choice == 1) {
                                    role = menu.getChoiceRole(listRole);
                                    if (role == null) {
                                        return;
                                    } else if (role != null) {
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);

                        }
                    }
                    flag = true;

                    while (flag) {

                        contractTime = tool.inputIntAcceptEnter("Contract Time (1-30) Old("
                                + employee.getContractTime() + "):");
                        if (contractTime == -1) {
                            return;
                        } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                                ) {
                            flag = false;
                        } else {
                            do {
                                choice = menu.getChoiceAskForBack(ask);
                                if (choice == 1) {
                                    contractTime = tool.inputIntAcceptEnter("Contract Time (1-30) Old("
                                            + employee.getContractTime() + "):");
                                    if (contractTime == -1) {
                                        return;
                                    } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                                            ) {
                                        flag = false;
                                    } else {
                                        flag = true;
                                    }
                                } else {
                                    return;
                                }
                            } while (flag);

                        }
                    }
                    
                    employee.setName(name.toUpperCase());
                    employee.setPhone(phone);
                    employee.setbDate(bDate);
                    employee.setRole(role);
                    employee.setContractTime(contractTime);
                    
                    System.out.println("");
                    System.out.println("+--------===--------------------+");
                    System.out.println("+  Update Employee Succesfully  +");
                    System.out.println("+-----------===-----------------+");
                    System.out.println("");
                }

            
        } else if (roleFromList != null && roleFromList.equalsIgnoreCase("User")) {
            ArrayList<String> listFieldForUpdate = new ArrayList<>();
//             name, phone, bDate, role, contract time
            listFieldForUpdate.add("Name");
            listFieldForUpdate.add("Phone");
            listFieldForUpdate.add("Birthday");
            listFieldForUpdate.add("Role");
            listFieldForUpdate.add("Contract Time");
            String select = menu.getChoiceRole(listFieldForUpdate);
            if (select == null) {
                return;
            }
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("+                      Update Employee By Id                            +");
            System.out.println("+-----------------------------------------------------------------------+");
            String id = tool.inputString("EMxxxx (x: number):");
            Employee employee = validation.takeEmployeeById(id, listEmployee);
            menu.printMenuEmployeeByDelete(employee, listEmployee);
            boolean flag = true;
            int choice = 0;
            if (employee != null && select.equalsIgnoreCase("name")) {
                while (flag) {
                    String name = tool.inputString("Name Old("
                            + employee.getName() + ")"
                            + " :");
                    if (name.equalsIgnoreCase("")) {
                        return;
                    } else if (validation.isUpperCaseName(name) == true) {
                        employee.setName(name.toUpperCase());
                        flag = false;
                    } else {
                        do {
                            choice = menu.getChoiceAskForBack(ask);
                            if (choice == 1) {
                                name = tool.inputString("Name Old("
                                        + employee.getName() + ")"
                                        + " :");
                                if (name.equalsIgnoreCase("")) {
                                    return;
                                } else if (validation.isUpperCaseName(name) == true) {
                                    employee.setName(name.toUpperCase());
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                return;
                            }
                        } while (flag);

                    }
                }
                System.out.println("");
                System.out.println("+--------===--------------------+");
                System.out.println("+  Update Employee Succesfully  +");
                System.out.println("+-----------===-----------------+");
                System.out.println("");
            } else if (employee != null && select.equalsIgnoreCase("Phone")) {

                while (flag) {
                    String phone = tool.inputString("Phone Number (9-11) Old("
                            + employee.getPhone() + "):");
                    if (phone.equalsIgnoreCase("")) {
                        return;
                    } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                        employee.setPhone(phone);
                        flag = false;
                    } else {
                        do {
                            choice = menu.getChoiceAskForBack(ask);
                            if (choice == 1) {
                                phone = tool.inputString("Phone Number (9-11) Old("
                                        + employee.getPhone() + "):");
                                if (phone.equalsIgnoreCase("")) {
                                    return;
                                } else if (validation.isNumber(phone) && validation.isValidLenghPhoneNumber(phone, 9, 11) == true) {
                                    employee.setPhone(phone);
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                return;
                            }
                        } while (flag);

                    }
                }
                System.out.println("");
                System.out.println("+--------===--------------------+");
                System.out.println("+  Update Employee Succesfully  +");
                System.out.println("+-----------===-----------------+");
                System.out.println("");
            } else if (employee != null && select.equalsIgnoreCase("Birthday")) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                while (flag) {
                    LocalDate bDate = tool.inputDate("Birthday (dd/mm/yyyy) Old("
                            + employee.getbDate().format(dtf) + "):");
                    if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                        return;
                    } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                        employee.setbDate(bDate);
                        flag = false;
                    } else {
                        do {
                            choice = menu.getChoiceAskForBack(ask);
                            if (choice == 1) {
                                bDate = tool.inputDate("Birthday (dd/mm/yyyy) Old("
                                        + employee.getbDate().format(dtf) + "):");
                                if (bDate != null && bDate.isEqual(LocalDate.of(2, 2, 2))) {
                                    return;
                                } else if (bDate != null && validation.isValidBirthDay(bDate) == true) {
                                    employee.setbDate(bDate);
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                return;
                            }
                        } while (flag);

                    }
                }
                System.out.println("");
                System.out.println("+--------===--------------------+");
                System.out.println("+  Update Employee Succesfully  +");
                System.out.println("+-----------===-----------------+");
                System.out.println("");
            } else if (employee != null && select.equalsIgnoreCase("Role")) {
                while (flag) {
                    String role = menu.getChoiceRole(listRole);
                    if (role == null) {
                        return;
                    } else if (role != null) {
                        employee.setRole(role);
                        flag = false;
                    } else {
                        do {
                            choice = menu.getChoiceAskForBack(ask);
                            if (choice == 1) {
                                role = menu.getChoiceRole(listRole);
                                if (role == null) {
                                    return;
                                } else if (role != null) {
                                    employee.setRole(role);
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                return;
                            }
                        } while (flag);

                    }
                }
                System.out.println("");
                System.out.println("+--------===--------------------+");
                System.out.println("+  Update Employee Succesfully  +");
                System.out.println("+-----------===-----------------+");
                System.out.println("");
            } else if (employee != null && select.equalsIgnoreCase("Contract Time")) {
                while (flag) {

                    int contractTime = tool.inputIntAcceptEnter("Contract Time (1-30) Old("
                            + employee.getContractTime() + "):");
                    if (contractTime == -1) {
                        return;
                    } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                            ) {
                        employee.setContractTime(contractTime);
                        flag = false;
                    } else {
                        do {
                            choice = menu.getChoiceAskForBack(ask);
                            if (choice == 1) {
                                contractTime = tool.inputIntAcceptEnter("Contract Time (1-30) Old("
                                        + employee.getContractTime() + "):");
                                if (contractTime == -1) {
                                    return;
                                } else if (validation.isValidContractTime(contractTime, 1, 30) == true //                    && validation.isValidContactYear(contractTime, employee.getbDate(), range)
                                        ) {
                                    employee.setContractTime(contractTime);
                                    flag = false;
                                } else {
                                    flag = true;
                                }
                            } else {
                                return;
                            }
                        } while (flag);

                    }
                }
                System.out.println("");
                System.out.println("+--------===--------------------+");
                System.out.println("+  Update Employee Succesfully  +");
                System.out.println("+-----------===-----------------+");
                System.out.println("");
            } else {
                return;
            }
        }

    }

    public void searchEmployee() {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("+                      Search Employee By Id                            +");
        System.out.println("+-----------------------------------------------------------------------+");
        String id = tool.inputString("EMxxxx (x: number):");
        ArrayList<Employee> listSearch = validation.takeListEmployeeById(id, listEmployee);
        menu.printMenuEmployeeBySearch(listSearch, listEmployee);
    }

    public void removeEmployee() {
        System.out.println("+-----------------------------------------------------------------------+");
        System.out.println("+                      Remove Employee By Id                            +");
        System.out.println("+-----------------------------------------------------------------------+");
        String id = tool.inputStringByRemove("EMxxxx (x: number):");

        Employee employee = validation.takeEmployeeById(id, listEmployee);
        if (employee != null) {
            if (employee.getResignDate() == null) {
                ArrayList<String> confirm = new ArrayList<>();
                confirm.add("Yes");
                confirm.add("No");
                menu.printMenuEmployeeByDelete(employee, listEmployee);
                int choice = menu.confirmDelete(confirm);
                if (choice == 1) {
                    employee.setResignDate(LocalDate.now());
                    System.out.println("");
                    System.out.println("+-------------------------------+");
                    System.out.println("+  Remove Employee Succesfully  +");
                    System.out.println("+-------------------------------+");
                    System.out.println("");
                } else {
                    System.out.println("");
                    System.out.println("+--------------------------------------+");
                    System.out.println("+       Cancel Remove Employee         +");
                    System.out.println("+--------------------------------------+");
                    System.out.println("");
                    return;
                }
            } else {
                System.out.println("");
                System.out.println("+-----------------------+");
                System.out.println("+   Employee Resigned   +");
                System.out.println("+-----------------------+");
                System.out.println("");
            }

        } else {
            menu.printMenuEmployeeByDelete(employee, listEmployee);
//            System.out.println("");
//            System.out.println("+-----------------------+");
//            System.out.println("+       Not Found       +");
//            System.out.println("+-----------------------+");
//            System.out.println("");
        }

    }

    public void viewResignList() {
        ArrayList<Employee> listResign = new ArrayList<>();
        listResign = validation.takeResignList(listEmployee);
        menu.printMenuEmployeeBySearch(listResign, listEmployee);
    }

    public void viewTakeOnList() {
        ArrayList<Employee> listTakeOn = new ArrayList<>();
        listTakeOn = validation.takeOnList(listEmployee);
        menu.printMenuEmployeeBySearch(listTakeOn, listEmployee);
    }

    public void viewDoctorList() {
        ArrayList<Employee> listDoctor = new ArrayList<>();
        listDoctor = validation.takeDoctorList(listEmployee);
        menu.printMenuEmployeeBySearch(listDoctor, listEmployee);
    }

    public void viewNurseList() {
        ArrayList<Employee> listNurse = new ArrayList<>();
        listNurse = validation.takeNurseList(listEmployee);
        menu.printMenuEmployeeBySearch(listNurse, listEmployee);
    }

    public void viewTechnicianList() {
        ArrayList<Employee> listTechnician = new ArrayList<>();
        listTechnician = validation.takeTechnicianList(listEmployee);
        menu.printMenuEmployeeBySearch(listTechnician, listEmployee);
    }

    public void saveToFile(String pathName) {

        try {
//                            *****
//           
            LocalDateTime time = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
            String datetime = time.format(dtf);
            pathName = "./Employee_" + datetime + ".dat";
            File f = new File(pathName);
            f.createNewFile();
            if (!f.exists()) {
                System.err.println("File Employee is not Exist");
            } else {
                BufferedWriter bw = new BufferedWriter(new FileWriter(f));

                for (Employee employee : listEmployee) {
                    bw.write(employee.toFileString() + "\n");
                }
                bw.close();
                System.out.println("");
                System.out.println("+-------------------------------+");
                System.out.println("+      Save File Succesfully    +");
                System.out.println("+-------------------------------+");
                System.out.println("");
                System.out.println("Your file is " + pathName);

            }
        } catch (FileNotFoundException f) {
            System.out.println("File Employees is not found");
        } catch (Exception e) {
            System.out.println("ERROR to Save File !");
        }

    }

    public boolean quit(String pathName) {
        ArrayList<String> confirmQuit = new ArrayList<>();
        confirmQuit.add("Save and Exit");
        confirmQuit.add("Exit");
        confirmQuit.add("Cancel");
        int choice = menu.confirmQuit(confirmQuit);
        if (choice == 1) {
            saveToFile(pathName);
            System.out.println("BYE !");
            return true;
        } else if (choice == 2) {
            System.out.println("BYE !");
            return true;
        } else {
            return false;
        }
    }

}
