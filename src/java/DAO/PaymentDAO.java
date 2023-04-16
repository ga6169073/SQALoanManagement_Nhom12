/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.LoanDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Payment;

/**
 *
 * @author Legion
 */
public class PaymentDAO extends DatabaseConnection{
    LoanDAO loanDAO =new LoanDAO();
    public void addPayments(List<Payment> list) {
        String sql = "insert into Payment (loan_id, amount_per_month, interest_per_month, fine, status, payment_date, payment_amount, pay_date) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            for (Payment i : list) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, i.getLoan().getId());
                ps.setDouble(2, i.getAmount_per_month());
                ps.setDouble(3, i.getInterest_per_month());
                ps.setDouble(4, i.getFine());
                ps.setBoolean(5, i.isStatus());
                ps.setString(6, i.getPayment_date());
                ps.setLong(7, i.getPayment_amount());
                ps.setString(8, i.getPay_date());
                ps.executeUpdate();
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
                Payment p = new Payment(rs.getInt("id"), loanDAO.getLoanByID(loan_id), rs.getLong("amount_per_month"), 
                        rs.getLong("interest_per_month"), rs.getLong("fine"), rs.getBoolean("status"), 
                        rs.getString("payment_date"), (rs.getLong("payment_amount") != 0 ? rs.getLong("payment_amount") : 0), 
                        (rs.getString("pay_date") != null ? rs.getString("pay_date") : ""));
                list.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public void updatePaymentByTimeandId(List<Payment> list) {
        String sql = "update Payment set fine = ? where id = ?";
        try {
            for (Payment i : list) {
                PreparedStatement ps = con.prepareCall(sql);
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
                Payment p = new Payment(rs.getInt("id"), loanDAO.getLoanByID(rs.getInt("loan_id")), rs.getLong("amount_per_month"), 
                        rs.getLong("interest_per_month"), rs.getLong("fine"), rs.getBoolean("status"), 
                        rs.getString("payment_date"), (rs.getLong("payment_amount") != 0 ? rs.getLong("payment_amount") : 0), 
                        (rs.getString("pay_date") != null ? rs.getString("pay_date") : ""));
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
