/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Legion
 */
public class InterestDetail implements Serializable {

    private int id;
    private boolean loanType; // 0 la tra no theo thang // 1 la tra no giam dan
    private int tenor;  // ky han
    private float rate;
    private int status; // trang thai: 0 khong kich hoat , 1 kich hoat, 2 da tung kich hoat
    private Admin admin;

    public InterestDetail() {
    }

    public InterestDetail(boolean loanType, int tenor, float rate, int status, Admin admin) {
        this.loanType = loanType;
        this.tenor = tenor;
        this.rate = rate;
        this.status = status;
        this.admin = admin;
    }

    public InterestDetail(int id, boolean loanType, int tenor, float rate, int status, Admin admin) {
        this.id = id;
        this.loanType = loanType;
        this.tenor = tenor;
        this.rate = rate;
        this.status = status;
        this.admin = admin;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLoanType() {
        return loanType;
    }

    public void setLoanType(boolean loanType) {
        this.loanType = loanType;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
