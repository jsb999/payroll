package org.example;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    double hoursUserWorked = 0;
    int userDependents = 0;

    System.out.println("Welcome to the payroll calculator!");
    System.out.println("----------------------------------");
    System.out.println("Please enter the number of hours/nyou have worked this week:");
    hoursUserWorked = scanner.nextDouble();
    System.out.println("How many dependents do you have?");
    userDependents = scanner.nextInt();

    Payroll payroll = new Payroll(hoursUserWorked, userDependents);
    System.out.println("----------------------------------");
    System.out.println("Here is your payroll information:");
    System.out.println("you have worked " + payroll.getHours() + " hours at $" + Payroll.EMPLOYEE_HOURLY_PAY + " per hour.");
    System.out.println("Your gross pay is: $" + payroll.getGrossRate());
    System.out.println("Your net pay is: $" + payroll.getUserNetPay());
    
    System.out.println("\n");
    
    System.out.println("you payed " + payroll.getExpenses() + " dollars for your expenses.");
    System.out.println("you payed " + Payroll.UNION_DUES_DOLLARS + " dollars for your union dues.\n");
    
    System.out.println("you payed " + Payroll.SS_TAX_PERCENT + "% for your social security tax. for a total of " + (payroll.getGrossRate()*Payroll.SS_TAX_PERCENT)/100 + " dollars.");
    System.out.println("you payed " + Payroll.FEDERAL_INCOME_TAX_PERCENT + "% for your federal income tax. for a total of " + (payroll.getGrossRate()*Payroll.FEDERAL_INCOME_TAX_PERCENT)/100 + " dollars.");
    System.out.println("you payed " + Payroll.STATE_INCOME_TAX_PERCENT + "% for your state income tax. for a total of " + (payroll.getGrossRate()*Payroll.STATE_INCOME_TAX_PERCENT)/100 + " dollars.");
    System.out.println("\n");
    
    System.out.println("----------------------------------");
    System.out.println("Thank you for using the payroll calculator!");
    
  }  
}
