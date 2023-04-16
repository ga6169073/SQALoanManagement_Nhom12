/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.InterestDetail;

/**
 *
 * @author Legion
 */
public class InterestDetailDAO extends DatabaseConnection {

    AdminDAO adminDAO = new AdminDAO();

    public void addInterest(InterestDetail interestDetail) {
        String sql = "insert into Interest_Detail(loan_type, tenor, rate, status, admin_id) values (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, interestDetail.isLoanType());
            ps.setInt(2, interestDetail.getTenor());
            ps.setFloat(3, interestDetail.getRate());
            ps.setInt(4, interestDetail.getStatus());
            ps.setInt(5, interestDetail.getAdmin().getId());
            ps.executeUpdate();
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
                InterestDetail interestDetail = new InterestDetail(rs.getInt("id"), rs.getBoolean("loan_type"), rs.getInt("tenor"), rs.getFloat("rate"), rs.getInt("status"), adminDAO.getAdminByID(rs.getInt("admin_id")));
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
                InterestDetail interestDetail = new InterestDetail(rs.getInt("id"), rs.getBoolean("loan_type"), rs.getInt("tenor"), rs.getFloat("rate"), rs.getInt("status"), adminDAO.getAdminByID(rs.getInt("admin_id")));
                return interestDetail;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
}
