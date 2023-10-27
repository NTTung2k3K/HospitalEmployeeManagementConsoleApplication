/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Employee;

/**
 *
 * @author tung
 */
public class Menu {

    Scanner sc = new Scanner(System.in);

    public int getChoiceBackMenu(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                            Back To Menu                               +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int confirmQuit(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                         Exit the program                              +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoice(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                        HOSPITAL HR PROGRAM                            +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Choose (1.." + listInfor.size() + "):  ");

                }
                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public int getChoiceAskForBack(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+       Continue Input       +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+----------------------------+");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    sc.nextLine();
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

    public void printMenuEmployee(ArrayList<Employee> listEmployee) {
        if (!listEmployee.isEmpty()) {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            int i = 0;
            Collections.sort(listEmployee, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            for (Employee employee : listEmployee) {
                String birthDay = null;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (employee.getbDate() != null) {
                    birthDay = employee.getbDate().format(dtf);
                }

                String hiredDate = null;
                if (employee.getHiredDate() != null) {
                    hiredDate = employee.getHiredDate().format(dtf);
                }

                String resignDate = null;
                if (employee.getResignDate() != null) {
                    resignDate = employee.getResignDate().format(dtf);
                }
                
                System.out.println(String.format("+ %6d | %13s | %18s | %16s | %13s | %12s | %13s | %14d | %15d | %15s +",
                        ++i, employee.getId().toUpperCase(), employee.getName().toUpperCase(),
                        employee.getPhone(),
                        birthDay, employee.getRole(), hiredDate,
                        employee.getSalary(), employee.getContractTime(),
                        resignDate
                ));
            }
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+                                                                             EMPTY LIST                                                                             +");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        }
    }

    public void printMenuEmployeeBySearch(ArrayList<Employee> listEmployee, ArrayList<Employee> listEmployeeMain) {

        if (listEmployeeMain.isEmpty()) {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+                                                                             EMPTY LIST                                                                             +");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
            return;
        }

        if (!listEmployee.isEmpty()) {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            int i = 0;
            Collections.sort(listEmployee, new Comparator<Employee>() {
                @Override
                public int compare(Employee o1, Employee o2) {
                    return o1.getId().compareTo(o2.getId());
                }
            });
            for (Employee employee : listEmployee) {
                String birthDay = null;
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                if (employee.getbDate() != null) {
                    birthDay = employee.getbDate().format(dtf);
                }

                String hiredDate = null;
                if (employee.getHiredDate() != null) {
                    hiredDate = employee.getHiredDate().format(dtf);
                }

                String resignDate = null;
                if (employee.getResignDate() != null) {
                    resignDate = employee.getResignDate().format(dtf);
                }

                System.out.println(String.format("+ %6d | %13s | %18s | %16s | %13s | %12s | %13s | %14d | %15d | %15s +",
                        ++i, employee.getId().toUpperCase(), employee.getName().toUpperCase(),
                        employee.getPhone(),
                        birthDay, employee.getRole(), hiredDate,
                        employee.getSalary(), employee.getContractTime(),
                        resignDate
                ));
            }
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+                                                                              NOT FOUND                                                                             +");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        }
    }

    public String getChoiceRole(ArrayList<String> listInfor) {
        int choice = 0;
        String input;
        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+------------------------------+");
                System.out.println("+         Select Option        +");
                System.out.println("+-----+------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-23s|", ++i, infor));
                }
                System.out.println("+-----+------------------------+");
                System.out.println("You can input 0 to back");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                input = sc.nextLine();
//                if (input.isEmpty()) {
//                    // Clear the input buffer
//
//                    return null;
//                }
                if (input.equalsIgnoreCase("0")) {
//                    while (sc.hasNextLine()) {
//                        sc.nextLine();
//                    }
                    return null;
                }
                try {

                    choice = Integer.parseInt(input);

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
//                    sc.nextLine();
                }
            }
        }

        return listInfor.get(choice - 1);
    }
    
    
    public String getChoiceFieldUpdate(ArrayList<String> listInfor) {
        int choice = 0;
        String input;
        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+        Select Field        +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+-----+----------------------+");
                System.out.println("You can input 0 or \"\" to back");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }
                input = sc.nextLine();
                if (input.isEmpty()) {
                    // Clear the input buffer

                    return null;
                }
                if (input.equalsIgnoreCase("0")) {
//                    while (sc.hasNextLine()) {
//                        sc.nextLine();
//                    }
                    return null;
                }
                try {

                    choice = Integer.parseInt(input);

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
//                    sc.nextLine();
                }
            }
        }

        return listInfor.get(choice - 1);
    }

    public String getChoiceRoleUpdate(Employee employee, ArrayList<String> listInfor) {

        int choice = 0;
        String input = "";
        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+----------------------------+");
                System.out.println("+         Select Role        +");
                System.out.println("+-----+----------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-21s|", ++i, infor));
                }
                System.out.println("+-----+----------------------+");
                System.out.println("You can input 0 or \"\" to back");
                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option Old("
                            + employee.getRole() + "): ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + " Old(" + employee.getRole() + "): ");

                }

                try {
                    input = sc.nextLine();
                    if (input.equalsIgnoreCase("")) {
                        return null;
                    }

                    choice = Integer.parseInt(input);
                    if (choice == 0) {
                        return null;
                    }

                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }

        return listInfor.get(choice - 1);
    }

    public void printMenuEmployeeByDelete(Employee employee, ArrayList<Employee> listEmployeeMain) {

        if (listEmployeeMain.isEmpty()) {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+                                                                             EMPTY LIST                                                                             +");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
            return;
        }

        if (employee != null) {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            int i = 0;
            String birthDay = null;
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            if (employee.getbDate() != null) {
                birthDay = employee.getbDate().format(dtf);
            }

            String hiredDate = null;
            if (employee.getHiredDate() != null) {
                hiredDate = employee.getHiredDate().format(dtf);
            }

            String resignDate = null;
            if (employee.getResignDate() != null) {
                resignDate = employee.getResignDate().format(dtf);
            }
            

            System.out.println(String.format("+ %6d | %13s | %18s | %16s | %13s | %12s | %13s | %14d | %15d | %15s +",
                    ++i, employee.getId().toUpperCase(), employee.getName().toUpperCase(),
                    employee.getPhone(),
                    birthDay, employee.getRole(), hiredDate,
                    employee.getSalary(), employee.getContractTime(),
                    resignDate
            ));
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        } else {
            System.out.println("");
            System.out.println("+--------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println("+                                                                        Employees Information                                                                       +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+ Number |  Employee Id  |        Name        |   Phone Number   |    Birthday   |     Role     |  Day of Hire  |     Salary     |  Contract Time  |   Resign Date   +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+                                                                              NOT FOUND                                                                             +");
            System.out.println("+                                                                                                                                                                    +");
            System.out.println("+--------+---------------+--------------------+------------------+---------------+--------------+---------------+----------------+-----------------+-----------------+");

            System.out.println("");
        }
    }

    public int confirmDelete(ArrayList<String> listInfor) {
        int choice = 0;

        while (true) {
            if (listInfor != null) {
                int listLength = listInfor.size();
                int i = 0;
                System.out.println("+-----------------------------------------------------------------------+");
                System.out.println("+                      Do you want to delete it                         +");
                System.out.println("+-----+-----------------------------------------------------------------+");

                for (String infor : listInfor) {
                    System.out.println(
                            String.format("|%3s  | %-64s|", ++i, infor));
                }
                System.out.println("+-----+-----------------------------------------------------------------+");

                if (listInfor.size() == 1) {
                    System.out.print("Please choose an option: ");
                } else {
                    System.out.print("Please choose an option from 1..." + listInfor.size() + ": ");

                }

                try {
                    choice = sc.nextInt();
                    if (choice == 0 || choice >= (listInfor.size() + 1) || choice < 0) {
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.println("Your choice must be in range (1-" + listInfor.size() + ")");
                    sc.nextLine();
                }
            }
        }
        return choice;
    }

}
