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
public class LoanTest {

    public LoanTest() {
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
     * Test of getId method, of class Loan.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Loan instance = new Loan(7, null, 0, null, "01/01/2023", true);
        int expResult = 7;
        int result = instance.getId();
        assertEquals(expResult, result);

    }

    /**
     * Test of setId method, of class Loan.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Loan instance = new Loan(7, null, 0, null, "01/01/2023", true);
        instance.setId(id);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBankAccount method, of class Loan.
     */
    @Test
    public void testGetBankAccount() {
        System.out.println("getBankAccount");
        Loan instance = new Loan();
        BankAccount expResult = null;
        BankAccount result = instance.getBankAccount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBankAccount method, of class Loan.
     */
    @Test
    public void testSetBankAccount() {
        System.out.println("setBankAccount");
        BankAccount bankAccount = null;
        Loan instance = new Loan(7, new BankAccount(), 0, null, "01/01/2023", true);
        instance.setBankAccount(bankAccount);
        BankAccount expResult = null;
        BankAccount result = instance.getBankAccount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAmount method, of class Loan.
     */
    @Test
    public void testGetAmount() {
        System.out.println("getAmount");
        Loan instance = new Loan(7, new BankAccount(), 1000, null, "01/01/2023", true);
        long expResult = 1000L;
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAmount method, of class Loan.
     */
    @Test
    public void testSetAmount() {
        System.out.println("setAmount");
        long amount = 0L;
        Loan instance = new Loan(7, new BankAccount(), 1000, null, "01/01/2023", true);
        instance.setAmount(amount);
        long expResult = 0L;
        long result = instance.getAmount();
        assertEquals(expResult, result);
    }

    /**
     * Test of getInterestDetail method, of class Loan.
     */
    @Test
    public void testGetInterestDetail() {
        System.out.println("getInterestDetail");
        Loan instance = new Loan(7, new BankAccount(), 1000, null, "01/01/2023", true);
        InterestDetail expResult = null;
        InterestDetail result = instance.getInterestDetail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInterestDetail method, of class Loan.
     */
    @Test
    public void testSetInterestDetail() {
        System.out.println("setInterestDetail");
        InterestDetail interestDetail = null;
        Loan instance = new Loan(7, new BankAccount(), 1000, new InterestDetail(), "01/01/2023", true);
        instance.setInterestDetail(interestDetail);
        InterestDetail expResult = null;
        InterestDetail result = instance.getInterestDetail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBegin_date method, of class Loan.
     */
    @Test
    public void testGetBegin_date() {
        System.out.println("getBegin_date");
        Loan instance = new Loan(7, new BankAccount(), 1000, new InterestDetail(), "01/01/2023", true);
        String expResult = "01/01/2023";
        String result = instance.getBegin_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBegin_date method, of class Loan.
     */
    @Test
    public void testSetBegin_date() {
        System.out.println("setBegin_date");
        String begin_date = "02/02/2024";
        Loan instance = new Loan(7, new BankAccount(), 1000, new InterestDetail(), "01/01/2023", true);
        instance.setBegin_date(begin_date);
        String expResult = "02/02/2024";
        String result = instance.getBegin_date();
        assertEquals(expResult, result);
    }

    /**
     * Test of isStatus method, of class Loan.
     */
    @Test
    public void testIsStatus() {
        System.out.println("isStatus");
        Loan instance = new Loan(7, new BankAccount(), 1000, new InterestDetail(), "01/01/2023", true);
        boolean expResult = true;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class Loan.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        boolean status = true;
        Loan instance = new Loan(7, new BankAccount(), 1000, new InterestDetail(), "01/01/2023", false);
        instance.setStatus(status);
        boolean expResult = true;
        boolean result = instance.isStatus();
        assertEquals(expResult, result);
    }

}
