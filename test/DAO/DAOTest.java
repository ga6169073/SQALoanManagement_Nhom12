/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.BankAccount;
import model.Customer;
import model.InterestDetail;
import model.Loan;
import model.Payment;
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
public class DAOTest {

    public DAOTest() {
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
     * Test of getAdminByID method, of class DAO.
     */
    @Test
    public void testGetAdminByID() throws SQLException {
        System.out.println("1: getAdminByID");
        int id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Admin result = instance.getAdminByID(id);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
        assertNotNull(result);
    }

    /**
     * Test of addBankAccount method, of class DAO.
     */
    @Test
    public void testAddBankAccount() throws SQLException {
        System.out.println("2: addBankAccount");

        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer c = instance.getCustomerByID(1);
        BankAccount account = new BankAccount("111111111", 0, c);
        instance.addBankAccount(account);
        BankAccount sAccount = instance.getBankAccountByID(account.getId());
        assertEquals(sAccount.getNumber(), account.getNumber());
        assertEquals(sAccount.getBalance(), account.getBalance());
        assertEquals(sAccount.getCustomer().getId(), account.getCustomer().getId());
        assertEquals(sAccount.getCustomer().getAddress(), account.getCustomer().getAddress());
        assertEquals(sAccount.getCustomer().getCard_id(), account.getCustomer().getCard_id());
        assertEquals(sAccount.getCustomer().getDob(), account.getCustomer().getDob());
        assertEquals(sAccount.getCustomer().getEmail(), account.getCustomer().getEmail());
        assertEquals(sAccount.getCustomer().getName(), account.getCustomer().getName());
        assertEquals(sAccount.getCustomer().getPassword(), account.getCustomer().getPassword());
        assertEquals(sAccount.getCustomer().getPhonenumber(), account.getCustomer().getPhonenumber());
        assertEquals(sAccount.getCustomer().getUsername(), account.getCustomer().getUsername());

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);

    }

    /**
     * Test of getBankAccountByCustomer method, of class DAO.
     */
    @Test
    public void testGetBankAccountByCustomer() throws SQLException {
        System.out.println("3 getBankAccountByCustomer");
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer customer = instance.getCustomerByID(1);
        BankAccount account = instance.getBankAccountByCustomer(customer);
        assertNotNull(account);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getBankAccountByNumber method, of class DAO.
     */
    @Test
    public void testGetBankAccountByNumber() throws SQLException {
        System.out.println("4 getBankAccountByNumber");

        String number = "95914845481171";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        BankAccount result = instance.getBankAccountByNumber(number);
        assertNotNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getBankAccountByID method, of class DAO.
     */
    @Test
    public void testGetBankAccountByID() throws SQLException {
        System.out.println("5 getBankAccountByID");
        int id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        BankAccount result = instance.getBankAccountByID(id);
        assertNotNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of updateBankAccount method, of class DAO.
     */
    @Test
    public void testUpdateBankAccount() throws SQLException {
        System.out.println("6 updateBankAccount");
        DAO instance = new DAO();
        BankAccount account = instance.getBankAccountByID(1);
        account.setBalance(0);
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        instance.updateBankAccount(account);
        BankAccount sAccount = instance.getBankAccountByID(1);
        assertEquals(sAccount.getNumber(), account.getNumber());
        assertEquals(sAccount.getBalance(), account.getBalance());
        assertEquals(sAccount.getCustomer().getId(), account.getCustomer().getId());
        assertEquals(sAccount.getCustomer().getAddress(), account.getCustomer().getAddress());
        assertEquals(sAccount.getCustomer().getCard_id(), account.getCustomer().getCard_id());
        assertEquals(sAccount.getCustomer().getDob(), account.getCustomer().getDob());
        assertEquals(sAccount.getCustomer().getEmail(), account.getCustomer().getEmail());
        assertEquals(sAccount.getCustomer().getName(), account.getCustomer().getName());
        assertEquals(sAccount.getCustomer().getPassword(), account.getCustomer().getPassword());
        assertEquals(sAccount.getCustomer().getPhonenumber(), account.getCustomer().getPhonenumber());
        assertEquals(sAccount.getCustomer().getUsername(), account.getCustomer().getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of checkID_Card method, of class DAO.
     */
    @Test
    public void testCheckID_Card() throws SQLException {
        System.out.println("7 checkID_Card");
        String card_id = "005845126787";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer expResult = new Customer(1, "Nam", "abc", "005845126787", "0967195856", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        Customer result = instance.checkID_Card(card_id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of addCustomer method, of class DAO.
     */
    @Test
    public void testAddCustomer() throws SQLException {
        System.out.println("8 addCustomer");
        Customer expResult = new Customer("Test", "abcd", "00584512676", "0967195856", "aaaa@gmail.com", "test", "test", "28/09/2001", true);
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        instance.addCustomer(expResult);

        Customer result = instance.getCustomerByID(expResult.getId());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomer method, of class DAO.
     */
    @Test
    public void testGetCustomer() throws SQLException {
        System.out.println("9 login");
        String username = "customer";
        String password = "customer";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer expResult = new Customer(1, "Nam", "abc", "005845126787", "0967195856", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        Customer result = instance.getCustomer(username, password);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomerByID method, of class DAO.
     */
    @Test
    public void testGetCustomerByID() throws SQLException {
        System.out.println("10 getCustomerByID");
        int id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer expResult = new Customer(1, "Nam", "abc", "005845126787", "0967195856", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        Customer result = instance.getCustomerByID(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomerByUsername method, of class DAO.
     */
    @Test
    public void testGetCustomerByUsername() throws SQLException {
        System.out.println("11 getCustomerByUsername");
        String username = "customer";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer expResult = new Customer(1, "Nam", "abc", "005845126787", "0967195856", "abc@gmail.com", "customer", "customer", "28/09/2001", true);
        Customer result = instance.getCustomerByUsername(username);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of addInterest method, of class DAO.
     */
    @Test
    public void testAddInterest() throws SQLException {
        System.out.println("12 addInterest");
        DAO instance = new DAO();
        InterestDetail interestDetail = new InterestDetail(false, 3, 7, 1, instance.getAdminByID(1));
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        instance.addInterest(interestDetail);

        InterestDetail expResult = instance.getInterestDetailByID(interestDetail.getId());
        assertEquals(interestDetail.getId(), expResult.getId());
        assertEquals(interestDetail.getRate(), expResult.getRate(), 0.0f);
        assertEquals(interestDetail.getStatus(), expResult.getStatus());
        assertEquals(interestDetail.getTenor(), expResult.getTenor());
        assertEquals(interestDetail.isLoanType(), expResult.isLoanType());
        assertEquals(interestDetail.getAdmin().getId(), expResult.getAdmin().getId());
        assertEquals(interestDetail.getAdmin().getPassword(), expResult.getAdmin().getPassword());
        assertEquals(interestDetail.getAdmin().getUsername(), expResult.getAdmin().getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getInterestDetailByID method, of class DAO.
     */
    @Test
    public void testGetInterestDetailByID() throws SQLException {
        System.out.println("13 getInterestDetailByID");
        int id = 1;
        DAO instance = new DAO();
        InterestDetail expResult = new InterestDetail(1, false, 3, 7, 1, instance.getAdminByID(1));
        InterestDetail result = instance.getInterestDetailByID(id);
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();

        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getRate(), expResult.getRate(), 0.0f);
        assertEquals(result.getStatus(), expResult.getStatus());
        assertEquals(result.getTenor(), expResult.getTenor());
        assertEquals(result.isLoanType(), expResult.isLoanType());
        assertEquals(result.getAdmin().getId(), expResult.getAdmin().getId());
        assertEquals(result.getAdmin().getPassword(), expResult.getAdmin().getPassword());
        assertEquals(result.getAdmin().getUsername(), expResult.getAdmin().getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getInterestDetailAvailableByLoanTypeAndTenor method, of class
     * DAO.
     */
    @Test
    public void testGetInterestDetailAvailableByLoanTypeAndTenor() throws SQLException {
        System.out.println("14 getInterestDetailAvailableByLoanTypeAndTenor");
        boolean type = false;
        int tenor = 3;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        InterestDetail expResult = new InterestDetail(1, false, 3, 7, 1, instance.getAdminByID(1));
        InterestDetail result = instance.getInterestDetailAvailableByLoanTypeAndTenor(type, tenor);
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getRate(), expResult.getRate(), 0.0f);
        assertEquals(result.getStatus(), expResult.getStatus());
        assertEquals(result.getTenor(), expResult.getTenor());
        assertEquals(result.isLoanType(), expResult.isLoanType());
        assertEquals(result.getAdmin().getId(), expResult.getAdmin().getId());
        assertEquals(result.getAdmin().getPassword(), expResult.getAdmin().getPassword());
        assertEquals(result.getAdmin().getUsername(), expResult.getAdmin().getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of addLoan method, of class DAO.
     */
    @Test
    public void testAddLoan() throws SQLException {
        System.out.println("15 addLoan");

        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Loan result = new Loan(instance.getBankAccountByID(1), 100000000, instance.getInterestDetailByID(9), "19/04/2023", false);
        instance.addLoan(result);
        Loan expResult = instance.getLoanByID(result.getId());
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getAmount(), expResult.getAmount());
        assertEquals(result.getBegin_date(), expResult.getBegin_date());

        assertEquals(result.getBankAccount().getId(), expResult.getBankAccount().getId());
        assertEquals(result.getInterestDetail().getId(), expResult.getInterestDetail().getId());

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getLoanByBankAccountID method, of class DAO.
     */
    @Test
    public void testGetLoanByBankAccountID() throws SQLException {
        System.out.println("16 getLoanByBankAccountID");
        int bank_account_id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        List<Loan> expResult = new ArrayList<>();
        expResult.add(new Loan(1, instance.getBankAccountByID(1), 100000000, instance.getInterestDetailByID(9), "19/04/2023", false));
        List<Loan> result = instance.getLoanByBankAccountID(bank_account_id);
        assertEquals(result.get(0).getId(), expResult.get(0).getId());
        assertEquals(result.get(0).getAmount(), expResult.get(0).getAmount());
        assertEquals(result.get(0).getBegin_date(), expResult.get(0).getBegin_date());

        assertEquals(result.get(0).getBankAccount().getId(), expResult.get(0).getBankAccount().getId());
        assertEquals(result.get(0).getInterestDetail().getId(), expResult.get(0).getInterestDetail().getId());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getLoanByID method, of class DAO.
     */
    @Test
    public void testGetLoanByID() throws SQLException {
        System.out.println("17 getLoanByID");
        int id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Loan expResult = new Loan(1, instance.getBankAccountByID(1), 100000000, instance.getInterestDetailByID(9), "19/04/2023", false);
        Loan result = instance.getLoanByID(id);
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getAmount(), expResult.getAmount());
        assertEquals(result.getBegin_date(), expResult.getBegin_date());

        assertEquals(result.getBankAccount().getId(), expResult.getBankAccount().getId());
        assertEquals(result.getInterestDetail().getId(), expResult.getInterestDetail().getId());

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of updateLoan method, of class DAO.
     */
    @Test
    public void testUpdateLoan() throws SQLException {
        System.out.println("18 updateLoan");

        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Loan loan = new Loan(1, instance.getBankAccountByID(1), 100000000, instance.getInterestDetailByID(9), "19/04/2023", true);
        instance.updateLoan(loan);

        Loan expResult = new Loan(1, instance.getBankAccountByID(1), 100000000, instance.getInterestDetailByID(9), "19/04/2023", true);
        Loan result = instance.getLoanByID(1);
        assertEquals(result.getId(), expResult.getId());
        assertEquals(result.getAmount(), expResult.getAmount());
        assertEquals(result.getBegin_date(), expResult.getBegin_date());

        assertEquals(result.getBankAccount().getId(), expResult.getBankAccount().getId());
        assertEquals(result.getInterestDetail().getId(), expResult.getInterestDetail().getId());

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of addPayments method, of class DAO.
     */
    @Test
    public void testAddPayments() throws SQLException {
        System.out.println("19 addPayments");
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        List<Payment> expResult = new ArrayList<>();
        expResult.add(new Payment(instance.getLoanByID(1), (double) 8333333.333333333, (double) 1041666.6666666666, 0, false, "19/05/2023", 0, ""));
        instance.addPayments(expResult);
        Payment result = instance.getPaymentById(expResult.get(0).getId());

        assertEquals(result.getAmount_per_month(), expResult.get(0).getAmount_per_month(), 0.000000000f);
        assertEquals(result.getFine(), expResult.get(0).getFine(), 0.000000000f);
        assertEquals(result.getInterest_per_month(), expResult.get(0).getInterest_per_month(), 0.000000000f);
        assertEquals(result.getLoan().getId(), expResult.get(0).getLoan().getId());
        assertEquals(result.getPay_date(), expResult.get(0).getPay_date());
        assertEquals(result.getPayment_amount(), expResult.get(0).getPayment_amount());
        assertEquals(result.getPayment_date(), expResult.get(0).getPayment_date());
        assertEquals(result.isStatus(), expResult.get(0).isStatus());

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getPaymentByLoanID method, of class DAO.
     */
    @Test
    public void testGetPaymentByLoanID() throws SQLException {
        System.out.println("20 getPaymentByLoanID");
        int loan_id = 2;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        List<Payment> expResult = new ArrayList<>();
        expResult.add(new Payment(13, instance.getLoanByID(2), 33333333.333333332, 2500000, 0, false, "22/05/2023", 0, ""));
        expResult.add(new Payment(14, instance.getLoanByID(2), 33333333.333333332, 1666666.65, 0, false, "22/06/2023", 0, ""));
        expResult.add(new Payment(15, instance.getLoanByID(2), 33333333.333333332, 833333.3, 0, false, "22/07/2023", 0, ""));
        List<Payment> result = instance.getPaymentByLoanID(loan_id);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(0).getAmount_per_month(), expResult.get(0).getAmount_per_month(), 0.000000000f);
            assertEquals(result.get(0).getFine(), expResult.get(0).getFine(), 0.000000000f);
            assertEquals(result.get(0).getInterest_per_month(), expResult.get(0).getInterest_per_month(), 0.000000000f);
            assertEquals(result.get(0).getLoan().getId(), expResult.get(0).getLoan().getId());
            assertEquals(result.get(0).getPay_date(), expResult.get(0).getPay_date());
            assertEquals(result.get(0).getPayment_amount(), expResult.get(0).getPayment_amount());
            assertEquals(result.get(0).getPayment_date(), expResult.get(0).getPayment_date());
            assertEquals(result.get(0).isStatus(), expResult.get(0).isStatus());
        }
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of updatePaymentByTimeandId method, of class DAO.
     */
    @Test
    public void testUpdatePaymentFineById() throws SQLException {
        System.out.println("21 updatePaymentFineById");
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        List<Payment> expResult = new ArrayList<>();
        expResult.add(new Payment(13, instance.getLoanByID(2), 33333333.333333332, 2500000, 10000, false, "22/05/2023", 0, ""));
        expResult.add(new Payment(14, instance.getLoanByID(2), 33333333.333333332, 1666666.65, 20000, false, "22/06/2023", 0, ""));
        expResult.add(new Payment(15, instance.getLoanByID(2), 33333333.333333332, 833333.3, 30000, false, "22/07/2023", 0, ""));
        instance.updatePaymentFineById(expResult);
        List<Payment> result = instance.getPaymentByLoanID(2);
        for (int i = 0; i < result.size(); i++) {
            assertEquals(result.get(0).getAmount_per_month(), expResult.get(0).getAmount_per_month(), 0.000000000f);
            assertEquals(result.get(0).getFine(), expResult.get(0).getFine(), 0.000000000f);
            assertEquals(result.get(0).getInterest_per_month(), expResult.get(0).getInterest_per_month(), 0.000000000f);
            assertEquals(result.get(0).getLoan().getId(), expResult.get(0).getLoan().getId());
            assertEquals(result.get(0).getPay_date(), expResult.get(0).getPay_date());
            assertEquals(result.get(0).getPayment_amount(), expResult.get(0).getPayment_amount());
            assertEquals(result.get(0).getPayment_date(), expResult.get(0).getPayment_date());
            assertEquals(result.get(0).isStatus(), expResult.get(0).isStatus());
        }
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getPaymentById method, of class DAO.
     */
    @Test
    public void testGetPaymentById() throws SQLException {
        System.out.println("22 getPaymentById");
        int id = 1;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Payment expResult = new Payment(1, instance.getLoanByID(1), 8333333.333333333, 1041666.6666666666, 0, false, "19/05/2023", 0, "");
        Payment result = instance.getPaymentById(id);
        assertEquals(result.getAmount_per_month(), expResult.getAmount_per_month(), 0.000000000f);
        assertEquals(result.getFine(), expResult.getFine(), 0.000000000f);
        assertEquals(result.getInterest_per_month(), expResult.getInterest_per_month(), 0.000000000f);
        assertEquals(result.getLoan().getId(), expResult.getLoan().getId());
        assertEquals(result.getPay_date(), expResult.getPay_date());
        assertEquals(result.getPayment_amount(), expResult.getPayment_amount());
        assertEquals(result.getPayment_date(), expResult.getPayment_date());
        assertEquals(result.isStatus(), expResult.isStatus());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of updatePayment method, of class DAO.
     */
    @Test
    public void testUpdatePayment() throws SQLException {
        System.out.println("23 updatePayment");
        DAO instance = new DAO();

        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Payment expResult = new Payment(1, instance.getLoanByID(1), 8333333.333333333, 1041666.6666666666, 0, true, "19/05/2023", 1, "19/05/2023");
        instance.updatePayment(expResult);
        Payment result = instance.getPaymentById(1);
        assertEquals(result.getAmount_per_month(), expResult.getAmount_per_month(), 0.000000000f);
        assertEquals(result.getFine(), expResult.getFine(), 0.000000000f);
        assertEquals(result.getInterest_per_month(), expResult.getInterest_per_month(), 0.000000000f);
        assertEquals(result.getLoan().getId(), expResult.getLoan().getId());
        assertEquals(result.getPay_date(), expResult.getPay_date());
        assertEquals(result.getPayment_amount(), expResult.getPayment_amount());
        assertEquals(result.getPayment_date(), expResult.getPayment_date());
        assertEquals(result.isStatus(), expResult.isStatus());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    @Test
    public void testGetAdminByID2() throws SQLException {
        System.out.println("24: getAdminByID: Nhap id khong hop le");
        int id = 90;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Admin result = instance.getAdminByID(id);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
        assertNull(result);
    }

    /**
     * Test of addBankAccount method, of class DAO.
     */
    @Test
    public void testAddBankAccount2() throws SQLException {
        System.out.println("25: addBankAccount: Khong hop le");

        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer c = instance.getCustomerByID(1);
        c.setId(999);
        BankAccount account = new BankAccount("aaa", 0, c);
        instance.addBankAccount(account);
        BankAccount sAccount = instance.getBankAccountByID(account.getId());
        assertNull(sAccount);

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);

    }

    /**
     * Test of getBankAccountByCustomer method, of class DAO.
     */
    @Test
    public void testGetBankAccountByCustomer2() throws SQLException {
        System.out.println("26 getBankAccountByCustomer: customer khong co");
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer customer = new Customer(999, "aaa", "", "", "", "", "aaa", "aaa", "", true);
        BankAccount account = instance.getBankAccountByCustomer(customer);
        assertNull(account);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getBankAccountByNumber method, of class DAO.
     */
    @Test
    public void testGetBankAccountByNumber2() throws SQLException {
        System.out.println("27 getBankAccountByNumber: stk khong ton tai");

        String number = "99999999999";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        BankAccount result = instance.getBankAccountByNumber(number);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getBankAccountByID method, of class DAO.
     */
    @Test
    public void testGetBankAccountByID2() throws SQLException {
        System.out.println("28 getBankAccountByID: id khong ton tai");
        int id = 999;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        BankAccount result = instance.getBankAccountByID(id);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of updateBankAccount method, of class DAO.
     */
    @Test
    public void testUpdateBankAccount2() throws SQLException {
        System.out.println("29 updateBankAccount: khong ton tai bank account");
        DAO instance = new DAO();
        BankAccount account = instance.getBankAccountByID(1);
        account.setBalance(0);
        account.setId(9999);
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        instance.updateBankAccount(account);
        BankAccount sAccount = instance.getBankAccountByID(9999);
        assertNull(sAccount);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of checkID_Card method, of class DAO.
     */
    @Test
    public void testCheckID_Card2() throws SQLException {
        System.out.println("30 checkID_Card: khong ton tai");
        String card_id = "000000000000";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer result = instance.checkID_Card(card_id);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of addCustomer method, of class DAO.
     */
    @Test
    public void testAddCustomer2() throws SQLException {
        System.out.println("31 addCustomer: khong hop le");
        Customer expResult = new Customer();
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        instance.addCustomer(expResult);

        Customer result = instance.getCustomerByID(expResult.getId());
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getAddress(), result.getAddress());
        assertEquals(expResult.getCard_id(), result.getCard_id());
        assertEquals(expResult.getDob(), result.getDob());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getName(), result.getName());
        assertEquals(expResult.getPassword(), result.getPassword());
        assertEquals(expResult.getPhonenumber(), result.getPhonenumber());
        assertEquals(expResult.getUsername(), result.getUsername());
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomer method, of class DAO.
     */
    @Test
    public void testGetCustomer2() throws SQLException {
        System.out.println("32 login: khong ton tai");
        String username = "customerafaga";
        String password = "customersgagaga";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer result = instance.getCustomer(username, password);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomerByID method, of class DAO.
     */
    @Test
    public void testGetCustomerByID2() throws SQLException {
        System.out.println("33 getCustomerByID: Khong hop le");
        int id = 999;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer result = instance.getCustomerByID(id);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    /**
     * Test of getCustomerByUsername method, of class DAO.
     */
    @Test
    public void testGetCustomerByUsername2() throws SQLException {
        System.out.println("34 getCustomerByUsername");
        String username = "customerabc";
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Customer result = instance.getCustomerByUsername(username);
        assertNull(result);

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }


    @Test
    public void testGetInterestDetailByID2() throws SQLException {
        System.out.println("35 getInterestDetailByID: Khong hop le");
        int id = 999;
        DAO instance = new DAO();

        InterestDetail result = instance.getInterestDetailByID(id);
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();

        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

//    /**
//     * Test of getInterestDetailAvailableByLoanTypeAndTenor method, of class
//     * DAO.
//     */
    @Test
    public void testGetInterestDetailAvailableByLoanTypeAndTenor2() throws SQLException {
        System.out.println("36 getInterestDetailAvailableByLoanTypeAndTenor: khong hop le");
        boolean type = false;
        int tenor = 60;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        InterestDetail result = instance.getInterestDetailAvailableByLoanTypeAndTenor(type, tenor);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    @Test
    public void testGetLoanByID2() throws SQLException {
        System.out.println("37 getLoanByID: khong hop le");
        int id = 999;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Loan result = instance.getLoanByID(id);
        assertNull(result);

        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

    @Test
    public void testGetPaymentById2() throws SQLException {
        System.out.println("38 getPaymentById: khong hop le");
        int id = 999;
        DAO instance = new DAO();
        instance.con.setAutoCommit(false);
        Savepoint before = instance.con.setSavepoint();
        Payment result = instance.getPaymentById(id);
        assertNull(result);
        instance.con.rollback(before);
        instance.con.setAutoCommit(true);
    }

}