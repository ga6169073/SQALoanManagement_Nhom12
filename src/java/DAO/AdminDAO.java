/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Admin;

/**
 *
 * @author Legion
 */
public class AdminDAO extends DatabaseConnection {

    public Admin loginAdmin(String username, String password) {
        String sql = "select * from Admin where username = ? and password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Admin admin = new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
                return admin;
            }
        } catch (SQLException e) {
            System.out.println(e);
        } catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

    public void addAdmin(Admin admin) {
        String sql = "insert into Admin(username, password) values (?, ?)";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, admin.getUsername());
            st.setString(2, admin.getPassword());

            st.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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

    public Admin getAdminByUsername(String username) {
        String sql = "select * from Admin where username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
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
}
