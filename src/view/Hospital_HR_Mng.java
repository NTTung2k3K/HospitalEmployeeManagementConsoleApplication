/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controllers.EmpList;
import java.util.ArrayList;

/**
 *
 * @author tung
 */
public class Hospital_HR_Mng {

    public static void main(String[] args) {
        Menu menu = new Menu();
        ArrayList<String> listMenu = new ArrayList<>();
        EmpList el = new EmpList();
        listMenu.add("Add new employee");
        listMenu.add("Search employee");
        listMenu.add("Remove employee");
        listMenu.add("Update employee");
        listMenu.add("View all list");
        listMenu.add("View take-on list");
        listMenu.add("View resign list");
        listMenu.add("View doctor list");
        listMenu.add("View nurse list");
        listMenu.add("View technician list");
        listMenu.add("Write list to file");
        listMenu.add("Quit the program");

        ArrayList<String> ask = new ArrayList<>();
        ask.add("Continue");
        ask.add("Back To Menu");
        String role = "";
        int choice = 0;
        String pathNameEmployee = "./Employee.txt";
        String pathNameRoles = "./Roles.txt";
        el.loadFromFileEmployees(pathNameEmployee);
        el.loadFromFileRoles(pathNameRoles);
        do {
            choice = menu.getChoice(listMenu);
            switch (choice) {
                case 1:
                    int subChoice = 0;
                    el.addNewEmployee();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.addNewEmployee();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 2:
                    subChoice = 0;
                    el.searchEmployee();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.searchEmployee();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 3:

                    subChoice = 0;
                    el.removeEmployee();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.removeEmployee();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 4:
                    subChoice = 0;
                    el.updateEmployee();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.updateEmployee();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 5:
                    subChoice = 0;
                    el.viewAllList();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewAllList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 6:
                    subChoice = 0;
                    el.viewTakeOnList();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewTakeOnList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 7:
                    subChoice = 0;
                    el.viewResignList();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewResignList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 8:
                    subChoice = 0;
                    el.viewDoctorList();

                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewDoctorList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 9:
                    subChoice = 0;
                    el.viewNurseList();

                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewNurseList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 10:
                    subChoice = 0;
                    el.viewTechnicianList();
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.viewTechnicianList();
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 11:
                    subChoice = 0;
                    el.saveToFile(pathNameEmployee);
                    do {
                        subChoice = menu.getChoiceBackMenu(ask);
                        switch (subChoice) {
                            case 1:
                                el.saveToFile(pathNameEmployee);
                                break;
                        }
                    } while (subChoice > 0 && subChoice < ask.size());
                    break;
                case 12:

                    boolean confirm = el.quit(pathNameEmployee);
                    if (confirm == true) {
                        return;
                    }
                    break;
            }
        } while (choice > 0 && choice <= listMenu.size());

    }
}
