package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
  // You can put your JUnit tests here
  // Feel free to create other files, as needed, to organize your tests

  @Test
  void twentyAndOneTest() {
    Payroll payroll = new Payroll(20, 1);
    assertEquals(251.7, payroll.getUserNetPay());
    assertEquals(335.6, payroll.getGrossRate());
    assertEquals(15, payroll.getExpenses());
  }

  @Test
  void fortyAndThreeTest(){
    Payroll payroll = new Payroll(40, 3);
    assertEquals(503.4, payroll.getUserNetPay());
    assertEquals(670.8, payroll.getGrossRate());
    assertEquals(35, payroll.getExpenses());
  }
}
