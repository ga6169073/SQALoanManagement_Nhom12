/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Admin;
import model.BankAccount;
import model.Customer;
import model.InterestDetail;
import model.Loan;
import model.Payment;

/**
 *
 * @author Legion
 */
public class DAO {

    public Connection con = DatabaseConnection.getDatabaseConnection();


    public Admin getAdminByID(int id) {
        String sql = "select * from Admin where id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                return admin;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addBankAccount(BankAccount account) {
        String sql = "insert into Bank_Account(number, balance, customer_id) values (?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, account.getNumber());
            st.setLong(2, account.getBalance());
            st.setInt(3, account.getCustomer().getId());
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                account.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public BankAccount getBankAccountByCustomer(Customer customer) {
        String sql = "select * from Bank_Account where customer_id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, customer.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BankAccount a = new BankAccount(rs.getInt("id"), rs.getString("number"), rs.getLong("balance"), customer);
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BankAccount getBankAccountByNumber(String number) {
        String sql = "select * from Bank_Account where number = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, number);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BankAccount a = new BankAccount(rs.getInt("id"), rs.getString("number"), rs.getLong("balance"), getCustomerByID(rs.getInt("customer_id")));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public BankAccount getBankAccountByID(int id) {
        String sql = "select * from Bank_Account where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                BankAccount a = new BankAccount(rs.getInt("id"), rs.getString("number"), rs.getLong("balance"), getCustomerByID(rs.getInt("customer_id")));
                return a;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateBankAccount(BankAccount account) {
        String sql = "update Bank_Account set balance = ? where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, account.getBalance());
            ps.setInt(2, account.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    public Customer checkID_Card(String card_id) {
        String sql = "select * from Customer where card_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, card_id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"),
                        rs.getString("card_id"), rs.getString("phonenumber"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("dob"), rs.getBoolean("gender"));
                return customer;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        String sql = "insert into Customer(name, address, card_id, phonenumber, email, username, password, dob, gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {

            PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, customer.getName());
            st.setString(2, customer.getAddress());
            st.setString(3, customer.getCard_id());
            st.setString(4, customer.getPhonenumber());
            st.setString(5, customer.getEmail());
            st.setString(6, customer.getUsername());
            st.setString(7, customer.getPassword());
            st.setString(8, customer.getDob());
            st.setBoolean(9, customer.isGender());
            st.executeUpdate();
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                customer.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Customer getCustomer(String username, String password) {
        String sql = "select * from Customer where username = ? and password = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("card_id"), rs.getString("phonenumber"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("dob"), rs.getBoolean("gender"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Customer getCustomerByID(int id) {
        String sql = "select * from Customer where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("card_id"), rs.getString("phonenumber"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("dob"), rs.getBoolean("gender"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public Customer getCustomerByUsername(String username) {
        String sql = "select * from Customer where username = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Customer c = new Customer(rs.getInt("id"), rs.getString("name"), rs.getString("address"), rs.getString("card_id"), rs.getString("phonenumber"), rs.getString("email"), rs.getString("username"), rs.getString("password"), rs.getString("dob"), rs.getBoolean("gender"));
                return c;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void addInterest(InterestDetail interestDetail) {
        String sql = "insert into Interest_Detail(loan_type, tenor, rate, status, admin_id) values (?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setBoolean(1, interestDetail.isLoanType());
            ps.setInt(2, interestDetail.getTenor());
            ps.setFloat(3, interestDetail.getRate());
            ps.setInt(4, interestDetail.getStatus());
            ps.setInt(5, interestDetail.getAdmin().getId());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                interestDetail.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public InterestDetail getInterestDetailByID(int id) {
        String sql = "select * from Interest_Detail where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InterestDetail interestDetail = new InterestDetail(rs.getInt("id"), rs.getBoolean("loan_type"), rs.getInt("tenor"), rs.getFloat("rate"), rs.getInt("status"), getAdminByID(rs.getInt("admin_id")));
                return interestDetail;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public InterestDetail getInterestDetailAvailableByLoanTypeAndTenor(boolean type, int tenor) {
        String sql = "select * from Interest_Detail where loan_type = ? and tenor = ? and status = '1'";
        List<InterestDetail> list = new ArrayList<>();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, type);
            ps.setInt(2, tenor);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                InterestDetail interestDetail = new InterestDetail(rs.getInt("id"), rs.getBoolean("loan_type"), rs.getInt("tenor"), rs.getFloat("rate"), rs.getInt("status"), getAdminByID(rs.getInt("admin_id")));
                return interestDetail;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

//    ----------------------------------------
    // Loan
    public void addLoan(Loan loan) {
        String sql = "insert into Loan(bank_account_id, amount, interest_detail_id, begin_date, status) values (?, ?, ?, ?, ?)";
        try {

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, loan.getBankAccount().getId());
            ps.setLong(2, loan.getAmount());
            ps.setInt(3, loan.getInterestDetail().getId());
            ps.setString(4, loan.getBegin_date());
            ps.setBoolean(5, loan.isStatus());
            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                loan.setId(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Loan> getLoanByBankAccountID(int bank_account_id) {
        List<Loan> list = new ArrayList<>();
        String sql = "select * from Loan where bank_account_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bank_account_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Loan l = new Loan(rs.getInt("id"), getBankAccountByID(rs.getInt("bank_account_id")), rs.getLong("amount"), getInterestDetailByID(rs.getInt("interest_detail_id")), rs.getString("begin_date"), rs.getBoolean("status"));
                list.add(l);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public Loan getLoanByID(int id) {
        String sql = "select * from Loan where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Loan l = new Loan(rs.getInt("id"), getBankAccountByID(rs.getInt("bank_account_id")), rs.getLong("amount"), getInterestDetailByID(rs.getInt("interest_detail_id")), rs.getString("begin_date"), rs.getBoolean("status"));
                return l;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateLoan(Loan loan) {
        String sql = "update Loan set status = ? where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, loan.isStatus());
            ps.setInt(2, loan.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    ------------------------------------------------------
    //Payment
    public void addPayments(List<Payment> list) {
        String sql = "insert into Payment (loan_id, amount_per_month, interest_per_month, fine, status, payment_date, payment_amount, pay_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            for (Payment i : list) {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, i.getLoan().getId());
                ps.setDouble(2, i.getAmount_per_month());
                ps.setDouble(3, i.getInterest_per_month());
                ps.setDouble(4, i.getFine());
                ps.setBoolean(5, i.isStatus());
                ps.setString(6, i.getPayment_date());
                ps.setLong(7, i.getPayment_amount());
                ps.setString(8, i.getPay_date());
                ps.executeUpdate();
                ResultSet generatedKeys = ps.getGeneratedKeys();
                if (generatedKeys.next()) {
                    i.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public List<Payment> getPaymentByLoanID(int loan_id) {
        List<Payment> list = new ArrayList<>();
        String sql = "select * from Payment where loan_id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, loan_id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Payment p = new Payment(rs.getInt("id"), getLoanByID(loan_id), rs.getDouble("amount_per_month"),
                        rs.getDouble("interest_per_month"), rs.getDouble("fine"), rs.getBoolean("status"),
                        rs.getString("payment_date"), rs.getLong("payment_amount") ,
                        (rs.getString("pay_date") ));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updatePaymentFineById(List<Payment> list) {
        String sql = "update Payment set fine = ? where id = ?";
        try {

            for (Payment i : list) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setDouble(1, i.getFine());
                ps.setInt(2, i.getId());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Payment getPaymentById(int id) {
        String sql = "select * from Payment where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Payment p = new Payment(rs.getInt("id"), getLoanByID(rs.getInt("loan_id")), rs.getDouble("amount_per_month"),
                        rs.getDouble("interest_per_month"), rs.getDouble("fine"), rs.getBoolean("status"),
                        rs.getString("payment_date"), rs.getLong("payment_amount") ,
                        (rs.getString("pay_date")));
                return p;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void updatePayment(Payment payment) {
        String sql = "update Payment set pay_date = ?, payment_amount = ?, status = ? where id = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, payment.getPay_date());
            ps.setLong(2, payment.getPayment_amount());
            ps.setBoolean(3, true);
            ps.setInt(4, payment.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
