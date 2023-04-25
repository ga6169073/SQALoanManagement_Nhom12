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
public class CustomerTest {

    public CustomerTest() {
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
     * Test of getId method, of class Customer.
     */
    @Test
    public void testGetId1() {
        System.out.println("1 getId: Khoi tao dung");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "09671958560", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        int expResult = 123;
        int result = instance.getId();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testGetId2() {
        System.out.println("2 getId: Khoi tao nhung khong truyen tham so");
        Customer instance = new Customer();
        int expResult = -1;
        int result = instance.getId();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Customer.
     */
    @Test
    public void testSetId1() {
        System.out.println("3 setId: Khoi tao dung");
        int id = 1;
        Customer instance = new Customer();
        instance.setId(id);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test(expected = Exception.class)
    public void testSetId2() {
        System.out.println("4 setId: Khoi tao voi so am");
        int id = -1;
        Customer instance = new Customer();
        instance.setId(id);
    }

    @Test(expected = Exception.class)
    public void testSetId3() {
        System.out.println("5 setId: Khoi tao voi so qua lon");
        int id = 1000000000;
        Customer instance = new Customer();
        instance.setId(id);
    }

    /**
     * Test of getName method, of class Customer.
     */
    @Test
    public void testGetName1() {
        System.out.println("6 getName: Khoi tao dung");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "09671958560", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "Nam";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetName2() {
        System.out.println("7 getName: Khoi tao nhung khong truyen tham so");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Customer.
     */
    @Test
    public void testSetName1() {
        System.out.println("8 setName: Khoi tao dung");
        String name = "Nam";
        Customer instance = new Customer();
        instance.setName(name);
        String expResult = "Nam";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetName2() {
        System.out.println("9 setName: Khoi tao voi chuoi rong");
        String name = "";
        Customer instance = new Customer();
        instance.setName(name);
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Customer.
     */
    @Test
    public void testGetAddress1() {
        System.out.println("10 getAddress: Khoi tao dung");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "09671958560", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "Ha Noi";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetAddress2() {
        System.out.println("11 getAddress: Khoi tao nhung khong khai bao tham so");
        Customer instance = new Customer();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAddress method, of class Customer.
     */
    @Test
    public void testSetAddress1() {
        System.out.println("12 setAddress: Khoi tao dung");
        String address = "Nam";
        Customer instance = new Customer();
        instance.setAddress(address);
        String expResult = "Nam";
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    @Test
    public void testSetAddress2() {
        System.out.println("13 setAddress: Khoi tao voi chuoi rong");
        String address = null;
        Customer instance = new Customer();
        instance.setAddress(address);
        String expResult = null;
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCard_id method, of class Customer.
     */
    @Test
    public void testGetCard_id() {
        System.out.println("getCard_id");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "09671958560", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "002177778888";
        String result = instance.getCard_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCard_id method, of class Customer.
     */
    @Test
    public void testSetCard_id() {
        System.out.println("setCard_id");
        String card_id = "0021";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "09671958560", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        instance.setCard_id(card_id);
        String expResult = "0021";
        String result = instance.getCard_id();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhonenumber method, of class Customer.
     */
    @Test
    public void testGetPhonenumber() {
        System.out.println("getPhonenumber");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "0967195850";
        String result = instance.getPhonenumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPhonenumber method, of class Customer.
     */
    @Test
    public void testSetPhonenumber() {
        System.out.println("setPhonenumber");
        String phonenumber = "0010000123";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        instance.setPhonenumber(phonenumber);
        String expResult = "0010000123";
        String result = instance.getPhonenumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Customer.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "abc@gmail.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEmail method, of class Customer.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        instance.setEmail(email);
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUsername method, of class Customer.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "customer";
        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUsername method, of class Customer.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String username = "";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "";
        instance.setUsername(username);

        String result = instance.getUsername();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Customer.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "customer";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPassword method, of class Customer.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "";
        instance.setPassword(password);

        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDob method, of class Customer.
     */
    @Test
    public void testGetDob() {
        System.out.println("getDob");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "28/09/2001";
        String result = instance.getDob();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDob method, of class Customer.
     */
    @Test
    public void testSetDob() {
        System.out.println("setDob");
        String dob = "";
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        String expResult = "28/09/2001";
        instance.setDob(dob);
        String result = instance.getDob();
        assertEquals(expResult, result);
    }

    /**
     * Test of isGender method, of class Customer.
     */
    @Test
    public void testIsGender() {
        System.out.println("isGender");
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        boolean expResult = true;
        boolean result = instance.isGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of setGender method, of class Customer.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        boolean gender = false;
        Customer instance = new Customer(123, "Nam", "Ha Noi", "002177778888", "0967195850", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        boolean expResult = false;
        instance.setGender(gender);
        boolean result = instance.isGender();
        assertEquals(expResult, result);
    }

}
