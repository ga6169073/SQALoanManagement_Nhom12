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
public class InterestDetailTest {

    public InterestDetailTest() {
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
     * Test of getRate method, of class InterestDetail.
     */
    @Test
    public void testGetRate() {
        System.out.println("getRate");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        float expResult = 0.0F;
        float result = instance.getRate();
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of setRate method, of class InterestDetail.
     */
    @Test
    public void testSetRate() {
        System.out.println("setRate");
        float rate = 0.0F;
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        instance.setRate(rate);
        float expResult = 0.0F;
        float result = instance.getRate();
        assertEquals(expResult, result, 0.0f);
    }

    /**
     * Test of getId method, of class InterestDetail.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class InterestDetail.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 7;
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        instance.setId(id);
        int expResult = 7;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of isLoanType method, of class InterestDetail.
     */
    @Test
    public void testIsLoanType() {
        System.out.println("isLoanType");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        boolean expResult = true;
        boolean result = instance.isLoanType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLoanType method, of class InterestDetail.
     */
    @Test
    public void testSetLoanType() {
        System.out.println("setLoanType");
        boolean loanType = false;
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        boolean expResult = false;
        instance.setLoanType(loanType);
        boolean result = instance.isLoanType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTenor method, of class InterestDetail.
     */
    @Test
    public void testGetTenor() {
        System.out.println("getTenor");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        int expResult = 0;
        int result = instance.getTenor();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTenor method, of class InterestDetail.
     */
    @Test
    public void testSetTenor() {
        System.out.println("setTenor");
        int tenor = 1;
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 0, new Admin());
        int expResult = 1;
        instance.setTenor(tenor);
        int result = instance.getTenor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStatus method, of class InterestDetail.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 5, new Admin());
        int expResult = 5;
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of setStatus method, of class InterestDetail.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        int status = 0;
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 5, new Admin());
        int expResult = 0;
        instance.setStatus(status);
        int result = instance.getStatus();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAdmin method, of class InterestDetail.
     */
    @Test
    public void testGetAdmin() {
        System.out.println("getAdmin");
        InterestDetail instance = new InterestDetail();
        Admin expResult = null;
        Admin result = instance.getAdmin();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAdmin method, of class InterestDetail.
     */
    @Test
    public void testSetAdmin() {
        System.out.println("setAdmin");
        Admin admin = new Admin(1, "username", "password");
        InterestDetail instance = new InterestDetail(1, true, 0, 0, 5, new Admin());
        Admin expResult = new Admin(1, "username", "password");
        instance.setAdmin(admin);
        Admin result = instance.getAdmin();
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getUsername(), result.getUsername());

    }

}
