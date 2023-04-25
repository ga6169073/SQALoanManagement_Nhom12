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
public class AdminTest {

    public AdminTest() {
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
     * Test of getId method, of class Admin.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Admin instance = new Admin(7, "admin", "admin");
        int expResult = 7;
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Admin.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Admin instance = new Admin(7, "admin", "admin");
        int expResult = 0;
        instance.setId(id);
        int result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Admin.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Admin instance = new Admin(7, "admin", "admin");
        String expResult = "admin";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Admin.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Admin instance = new Admin(7, "admin", "admin");
        instance.setUsername(username);
        String expResult = "";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Admin.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Admin instance = new Admin(7, "admin", "admin");
        String expResult = "admin";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Admin.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Admin instance = new Admin(7, "admin", "admin");
        instance.setPassword(password);
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

}
