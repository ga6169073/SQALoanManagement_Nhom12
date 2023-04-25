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
public class BankAccountTest {

    public BankAccountTest() {
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
     * Test of getId method, of class BankAccount.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        int expResult = 7;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class BankAccount.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        instance.setId(id);
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class BankAccount.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        String expResult = "0345678123";
        String result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNumber method, of class BankAccount.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        String number = "0123";
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        instance.setNumber(number);
        String expResult = "0123";
        String result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBalance method, of class BankAccount.
     */
    @Test
    public void testGetBalance() {
        System.out.println("getBalance");
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        long expResult = 0L;
        long result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBalance method, of class BankAccount.
     */
    @Test
    public void testSetBalance() {
        System.out.println("setBalance");
        long balance = 1000;
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        instance.setBalance(balance);
        long expResult = 1000;
        long result = instance.getBalance();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomer method, of class BankAccount.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        BankAccount instance = new BankAccount(7, "0345678123", 0, null);
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCustomer method, of class BankAccount.
     */
    @Test
    public void testSetCustomer() {
        System.out.println("setCustomer");
        Customer customer = null;
        BankAccount instance = new BankAccount(7, "0345678123", 0, new Customer());
        instance.setCustomer(customer);
        Customer expResult = null;
        Customer result = instance.getCustomer();
        assertEquals(expResult, result);
    }

}
