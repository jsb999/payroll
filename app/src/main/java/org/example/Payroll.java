package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Payroll{
    private double hoursUserWorked;
    private int userDependents;
    private double userGrossPay;
    private double userNetPay;

    public static final double EMPLOYEE_HOURLY_PAY = 16.78;
    public static final double OVERTIME_RATE = 1.5;
    public static final double SS_TAX_PERCENT = 6;
    public static final double FEDERAL_INCOME_TAX_PERCENT = 14;
    public static final double STATE_INCOME_TAX_PERCENT = 5;
    public static final double UNION_DUES_DOLLARS = 10;

    public Payroll(double hoursUserWorked_,int userDependents_){
        this.hoursUserWorked = hoursUserWorked_;
        this.userDependents = userDependents_;
    }

    public double getHours(){
        return this.hoursUserWorked;
    }
    

    public double getGrossRate(){
        userGrossPay = 0;
        if(hoursUserWorked >40){
            userGrossPay += (hoursUserWorked-40)*(EMPLOYEE_HOURLY_PAY*OVERTIME_RATE);
            userGrossPay += 40*EMPLOYEE_HOURLY_PAY;
        } else {
            userGrossPay += hoursUserWorked*EMPLOYEE_HOURLY_PAY;
        }

        return userGrossPay;
    }

    public double getUserNetPay(){
        userNetPay = userGrossPay;
        BigDecimal originalValue;
        BigDecimal roundedValue;
        
        originalValue = new BigDecimal((userGrossPay*SS_TAX_PERCENT)/100);
        roundedValue = originalValue.setScale(2, RoundingMode.HALF_UP);
        userNetPay -= roundedValue.doubleValue();
        
        originalValue = new BigDecimal((userGrossPay*FEDERAL_INCOME_TAX_PERCENT)/100);
        roundedValue = originalValue.setScale(2, RoundingMode.HALF_UP);
        userNetPay -= roundedValue.doubleValue();
        
        originalValue = new BigDecimal((userGrossPay*STATE_INCOME_TAX_PERCENT)/100);
        roundedValue = originalValue.setScale(2, RoundingMode.HALF_UP);
        userNetPay -= roundedValue.doubleValue();

        originalValue = new BigDecimal(userNetPay);
        userNetPay = originalValue.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return userNetPay;
    }

    public double getExpenses(){
        if(userDependents>=3){
            return 35;
        } else{
            return 15;
        }
    }
}