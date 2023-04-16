/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Customer;

/**
 *
 * @author Legion
 */
public class CustomerDAO extends DatabaseConnection{

    public Customer login(String username, String password) {
        String sql = "select * from Customer where username = ? and password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
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

    public Customer checkExistedCustomer(String username) {
        String sql = "select * from Customer where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
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

        }
        return null;
    }

    public void addCustomer(Customer customer) {
        String sql = "insert into Customer(name, address, card_id, phonenumber, email, username, password, dob, gender) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
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
}
