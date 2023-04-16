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
public class Loan implements Serializable{
    private int id;
    private BankAccount bankAccount;
    private long amount;
    private InterestDetail interestDetail;
    private String begin_date;
    private boolean status;

    public Loan() {
    }

    public Loan(BankAccount bankAccount, long amount, InterestDetail interestDetail, String begin_date, boolean status) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.interestDetail = interestDetail;
        this.begin_date = begin_date;
        this.status = status;
    }

    public Loan(int id, BankAccount bankAccount, long amount, InterestDetail interestDetail, String begin_date, boolean status) {
        this.id = id;
        this.bankAccount = bankAccount;
        this.amount = amount;
        this.interestDetail = interestDetail;
        this.begin_date = begin_date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public InterestDetail getInterestDetail() {
        return interestDetail;
    }

    public void setInterestDetail(InterestDetail interestDetail) {
        this.interestDetail = interestDetail;
    }

    public String getBegin_date() {
        return begin_date;
    }

    public void setBegin_date(String begin_date) {
        this.begin_date = begin_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    
}
