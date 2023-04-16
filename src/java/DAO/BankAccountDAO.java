/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.BankAccount;
import model.Customer;

/**
 *
 * @author Legion
 */
public class BankAccountDAO extends DatabaseConnection {
    CustomerDAO customerDAO=new CustomerDAO();
    public void addBankAccount(BankAccount account) {
        String sql = "insert into Bank_Account(number, balance, customer_id) values (?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, account.getNumber());
            st.setLong(2, account.getBalance());
            st.setInt(3, account.getCustomer().getId());
            st.executeUpdate();
        } catch (Exception e) {
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
                BankAccount a = new BankAccount(rs.getInt("id"), rs.getString("number"), rs.getLong("balance"), customerDAO.getCustomerByID(rs.getInt("customer_id")));
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
                BankAccount a = new BankAccount(rs.getInt("id"), rs.getString("number"), rs.getLong("balance"), customerDAO.getCustomerByID(rs.getInt("customer_id")));
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
}
