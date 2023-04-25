/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Legion
 */
public class PaymentTest {

    public PaymentTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Payment.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Payment instance = new Payment();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Payment.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Payment instance = new Payment();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoan method, of class Payment.
     */
    @Test
    public void testGetLoan() {
        System.out.println("getLoan");
        Payment instance = new Payment();
        Loan expResult = null;
        Loan result = instance.getLoan();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLoan method, of class Payment.
     */
    @Test
    public void testSetLoan() {
        System.out.println("setLoan");
        Loan loan = null;
        Payment instance = new Payment();
        instance.setLoan(loan);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmount_per_month method, of class Payment.
     */
    @Test
    public void testGetAmount_per_month() {
        System.out.println("getAmount_per_month");
        Payment instance = new Payment();
        double expResult = 0.0;
        double result = instance.getAmount_per_month();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmount_per_month method, of class Payment.
     */
    @Test
    public void testSetAmount_per_month() {
        System.out.println("setAmount_per_month");
        double amount_per_month = 0.0;
        Payment instance = new Payment();
        instance.setAmount_per_month(amount_per_month);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInterest_per_month method, of class Payment.
     */
    @Test
    public void testGetInterest_per_month() {
        System.out.println("getInterest_per_month");
        Payment instance = new Payment(123, 321, "");
        double expResult = 321;
        double result = instance.getInterest_per_month();
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of setInterest_per_month method, of class Payment.
     */
    @Test
    public void testSetInterest_per_month() {
        System.out.println("setInterest_per_month");
        double interest_per_month = 0.0;
        Payment instance = new Payment(123, 321, "");
        instance.setInterest_per_month(interest_per_month);
        double expResult = 0;
        double result = instance.getInterest_per_month();
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of getFine method, of class Payment.
     */
    @Test
    public void testGetFine() {
        System.out.println("getFine");
        Payment instance = new Payment(1, null, 0, 0, 321, true, "22/12/2023", 0, "");
        double expResult = 321;
        double result = instance.getFine();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setFine method, of class Payment.
     */
    @Test
    public void testSetFine() {
        System.out.println("setFine");
        double fine = 0.0;
        Payment instance = new Payment(1, null, 0, 0, 321, true, "22/12/2023", 0, "");
        instance.setFine(fine);
        double expResult = 321;
        double result = instance.getFine();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of isStatus method, of class Payment.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        Payment instance = new Payment(1, null, 0, 0, 321, true, "22/12/2023", 0, "");
        boolean expResult = true;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class Payment.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = true;
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "");
        instance.setStatus(status);
        boolean expResult = true;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPayment_date method, of class Payment.
     */
    @Test
    public void testGetPayment_date() {
        System.out.println("getPayment_date");
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "");
        String expResult = "22/12/2023";
        String result = instance.getPayment_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPayment_date method, of class Payment.
     */
    @Test
    public void testSetPayment_date() {
        System.out.println("setPayment_date");
        String payment_date = "";
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "");
        instance.setPayment_date(payment_date);
        String expResult = "22/12/2023";
        String result = instance.getPayment_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPayment_amount method, of class Payment.
     */
    @Test
    public void testGetPayment_amount() {
        System.out.println("getPayment_amount");
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "");
        long expResult = 0L;
        long result = instance.getPayment_amount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPayment_amount method, of class Payment.
     */
    @Test
    public void testSetPayment_amount() {
        System.out.println("setPayment_amount");
        long payment_amount = 1000L;
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "");
        instance.setPayment_amount(payment_amount);
        long expResult = 1000L;
        long result = instance.getPayment_amount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPay_date method, of class Payment.
     */
    @Test
    public void testGetPay_date() {
        System.out.println("getPay_date");
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "21/12/2023");
        String expResult = "21/12/2023";
        String result = instance.getPay_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPay_date method, of class Payment.
     */
    @Test
    public void testSetPay_date() {
        System.out.println("setPay_date");
        String pay_date = "20/12/2023";
        Payment instance = new Payment(1, null, 0, 0, 321, false, "22/12/2023", 0, "21/12/2023");
        instance.setPay_date(pay_date);
        String expResult = "20/12/2023";
        String result = instance.getPay_date();
        assertEquals(expResult, result);
    }

}
