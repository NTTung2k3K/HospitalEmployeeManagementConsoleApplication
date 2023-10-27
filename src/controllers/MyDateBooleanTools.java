/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author tung
 */
public class MyDateBooleanTools {
    // Using scanner for user input from keyboard

    static Scanner sc = new Scanner(System.in);

    public boolean isValidDate(int day, int month, int year) {
        boolean isLeapYear = (year % 400 == 0) || ((year % 100 != 0) && (year % 4 == 0));
        if (year >= 1 && month >= 1 && month <= 12) {
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    return (day >= 1 && day <= 31);
                case 4:
                case 6:
                case 9:
                case 11:
                    return (day >= 1 && day <= 30);
                case 2:
                    if (isLeapYear) {
                        return (day >= 1 && day <= 29);
                    } else {
                        return (day >= 1 && day <= 28);
                    }
            }
        }
        return false;
    }

    public LocalDate inputDate(String msg) {
        String infor;
        LocalDate respond = null;
        while (true) {
            System.out.print(msg);
            infor = sc.nextLine().trim();
            if (infor.isEmpty()) {
                // Clear the input buffer
                
                return LocalDate.of(2, 2, 2);
            }
            try {
                if (infor.length() == 10) {
                    String[] date = infor.split("/");
                    int day = Integer.parseInt(date[0]);
                    int month = Integer.parseInt(date[1]);
                    int year = Integer.parseInt(date[2]);
                    if (isValidDate(day, month, year)) {
                        respond = LocalDate.of(year, month, day);
                        break;
                    } else {
                        System.out.println("The date is not valid");
                        return null;
                    }
                } else {
                    System.out.println("Input is not correct form (dd/mm/yyyy)");
                    return null;

                }

            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid date");
                return null;
            }
        }
        return respond;
    }

    public LocalDate inputResignDate(String msg) {
        String infor;
        LocalDate respond = null;
        while (true) {
            System.out.println("You can input 'null' to set employee not to resign");
            System.out.print(msg);
            infor = sc.nextLine();
            infor = infor.trim();
            if (infor.isEmpty()) {
                // Clear the input buffer
                return LocalDate.of(2, 2, 2);
            }
            if (infor.equalsIgnoreCase("null")) {
                return LocalDate.of(1, 1, 1);
            } else 

                try {

                    if (infor.length() == 10) {
                        String[] date = infor.split("/");
                        int day = Integer.parseInt(date[0]);
                        int month = Integer.parseInt(date[1]);
                        int year = Integer.parseInt(date[2]);
                        if (isValidDate(day, month, year)) {
                            respond = LocalDate.of(year, month, day);
                            break;
                        } else {
                            System.out.println("The date is not valid");
                            return null;
                        }
                    } else {
                        System.out.println("Input is not correct form (dd/mm/yyyy)");
                        return null;

                    }

                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid date");
                    return null;
                }
            }
            return respond;
        }

    

    

    public Integer inputInteger(String msg) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                return infor;

            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
                return null;
            }
        }
    }

    /**
     * Get input String and check valid
     *
     * @param msg
     * @return
     */
    public String inputString(String msg) {
        String infor = "";
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();

                break;
            } catch (Exception e) {
                System.out.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor.trim();
    }
    public String inputStringByRemove(String msg) {
        String infor = "";
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextLine();
                infor = infor.trim();
                if(infor.equalsIgnoreCase("")){
                    System.out.println("The input is empty, Try again");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Your input is not valid");
                System.out.println("Try Again");
                sc.nextLine();
            }
        }
        return infor.trim();
    }

    /**
     * Get input Double and check valid
     *
     * @param msg
     * @return
     */
    public double inputDouble(String msg) {
        double infor;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
        return infor;
    }

    /**
     * Get input Integer and check valid
     *
     * @param msg
     * @return
     */
    public int inputInt(String msg) {
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                infor = sc.nextInt();
                sc.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
        return infor;
    }

    public int inputIntAcceptEnter(String msg) {
        String result = "";
        int infor = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = sc.nextLine();
                if (result.equalsIgnoreCase("")) {
                    return -1;
                }
                infor = Integer.parseInt(result);
                break;
            } catch (Exception e) {
                System.out.println("Try Again .Your input must be Integer");
                sc.nextLine();
            }
        }
        return infor;
    }
}
