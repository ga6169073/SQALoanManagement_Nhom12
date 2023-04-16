/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Loan;
import DAO.BankAccountDAO;
import java.sql.PreparedStatement;
/**
 *
 * @author Legion
 */

public class LoanDAO extends DatabaseConnection{
    InterestDetailDAO interestDetailDAO = new InterestDetailDAO();
    BankAccountDAO bankAccountDAO = new BankAccountDAO();
    public void addLoan(Loan loan) {
        String sql = "insert into Loan(bank_account_id, amount, interest_detail_id, begin_date, status) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, loan.getBankAccount().getId());
            ps.setLong(2, loan.getAmount());
            ps.setInt(3, loan.getInterestDetail().getId());
            ps.setString(4, loan.getBegin_date());
            ps.setBoolean(5, loan.isStatus());
            ps.executeUpdate();
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
                Loan l = new Loan(rs.getInt("id"),bankAccountDAO.getBankAccountByID(rs.getInt("bank_account_id")), rs.getLong("amount"), interestDetailDAO.getInterestDetailByID(rs.getInt("interest_detail_id")), rs.getString("begin_date"), rs.getBoolean("status"));
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
                Loan l = new Loan(rs.getInt("id"),bankAccountDAO.getBankAccountByID(rs.getInt("bank_account_id")), rs.getLong("amount"), interestDetailDAO.getInterestDetailByID(rs.getInt("interest_detail_id")), rs.getString("begin_date"), rs.getBoolean("status"));
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
}
