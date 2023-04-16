/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.LoanDAO;
import DAO.PaymentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Loan;
import model.Payment;

/**
 *
 * @author Legion
 */
@WebServlet(name = "LoanSuccessServlet", urlPatterns = {"/loanSuccess"})
public class LoanSuccessServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoanSuccessServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanSuccessServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("loanSuccess.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int accountId = Integer.parseInt(request.getParameter("accountid"));
            LoanDAO loanDAO = new LoanDAO();
            PaymentDAO paymentDAO = new PaymentDAO();
            List<Loan> listloan = loanDAO.getLoanByBankAccountID(accountId);
            Loan loan = listloan.get(listloan.size() - 1);
            List<String> payment_date = generateDates(loan.getBegin_date(), loan.getInterestDetail().getTenor());
            List<Payment> listpayment = new ArrayList<>();
            boolean type = loan.getInterestDetail().isLoanType();
            long amount_per_month_round = (long) Math.round((double) loan.getAmount() / loan.getInterestDetail().getTenor());
            double amount_per_month =(double) loan.getAmount() / loan.getInterestDetail().getTenor();
            if (type == false) {
                // tra no deu theo thang        
                long interest_per_month_round = (long) Math.round(((double) loan.getAmount() * loan.getInterestDetail().getRate()) / (100 * loan.getInterestDetail().getTenor()));
                double interest_per_month = ((double) loan.getAmount() * loan.getInterestDetail().getRate()) / (100 * loan.getInterestDetail().getTenor());
                for (int i = 0; i < loan.getInterestDetail().getTenor(); i++) {
                    listpayment.add(new Payment(loan, amount_per_month, interest_per_month, 0, false, payment_date.get(i), 0, ""));
                }
            } else {
                // tra no giam dan theo thang       
                long amount_remain = loan.getAmount();
                for (int i = 0; i < loan.getInterestDetail().getTenor(); i++) {
                    long interest_per_month_round = (long) Math.round(((double) amount_remain * loan.getInterestDetail().getRate()) / (100 * loan.getInterestDetail().getTenor()));
                    double interest_per_month = ((double) amount_remain * loan.getInterestDetail().getRate()) / (100 * loan.getInterestDetail().getTenor());
                    listpayment.add(new Payment(loan, amount_per_month, interest_per_month, 0, false, payment_date.get(i), 0, ""));
                    amount_remain -= amount_per_month;
                }
            }

            paymentDAO.addPayments(listpayment);
            request.getRequestDispatcher("homePage.jsp").forward(request, response);

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private List<String> generateDates(String startDate, int tenor) throws Exception {
        List<String> list = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(startDate);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        for (int i = 0; i < tenor; i++) {
            calendar.add(Calendar.MONTH, 1);
            Date currentdate = calendar.getTime();
            String datestring = sdf.format(currentdate);
            list.add(datestring);
        }
        return list;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
