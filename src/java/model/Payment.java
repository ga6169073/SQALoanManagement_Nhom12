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
public class Payment implements Serializable {

    private int id;
    private Loan loan;
    private double amount_per_month;
    private double interest_per_month;
    private double fine;
    private boolean status;
    private String payment_date;
    private long payment_amount;
    private String pay_date;

    public Payment() {
    }

    public Payment(Loan loan, double amount_per_month, double interest_per_month, double fine, boolean status, String payment_date, long payment_amount, String pay_date) {
        this.loan = loan;
        this.amount_per_month = amount_per_month;
        this.interest_per_month = interest_per_month;
        this.fine = fine;
        this.status = status;
        this.payment_date = payment_date;
        this.payment_amount = payment_amount;
        this.pay_date = pay_date;
    }

    public Payment(int id, Loan loan, double amount_per_month, double interest_per_month, double fine, boolean status, String payment_date, long payment_amount, String pay_date) {
        this.id = id;
        this.loan = loan;
        this.amount_per_month = amount_per_month;
        this.interest_per_month = interest_per_month;
        this.fine = fine;
        this.status = status;
        this.payment_date = payment_date;
        this.payment_amount = payment_amount;
        this.pay_date = pay_date;
    }

    public Payment(double amount_per_month, double interest_per_month, String payment_date) {
        this.amount_per_month = amount_per_month;
        this.interest_per_month = interest_per_month;
        this.payment_date = payment_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public double getAmount_per_month() {
        return amount_per_month;
    }

    public void setAmount_per_month(double amount_per_month) {
        this.amount_per_month = amount_per_month;
    }

    public double getInterest_per_month() {
        return interest_per_month;
    }

    public void setInterest_per_month(double interest_per_month) {
        this.interest_per_month = interest_per_month;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public long getPayment_amount() {
        return payment_amount;
    }

    public void setPayment_amount(long payment_amount) {
        this.payment_amount = payment_amount;
    }

    public String getPay_date() {
        return pay_date;
    }

    public void setPay_date(String pay_date) {
        this.pay_date = pay_date;
    }

    
}
