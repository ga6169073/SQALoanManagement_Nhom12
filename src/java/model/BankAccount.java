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
public class BankAccount implements Serializable{
    private int id;
    private String number;
    private long balance;
    private Customer customer;

    public BankAccount() {
    }

    public BankAccount(String number, long balance, Customer customer) {
        this.number = number;
        this.balance = balance;
        this.customer = customer;
    }

    public BankAccount(int id, String number, long balance, Customer customer) {
        this.id = id;
        this.number = number;
        this.balance = balance;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
}
