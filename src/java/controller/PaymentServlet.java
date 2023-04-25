/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.BankAccount;
import model.Loan;
import model.Payment;

/**
 *
 * @author Legion
 */
@WebServlet(name = "PaymentServlet", urlPatterns = {"/payment"})
public class PaymentServlet extends HttpServlet {

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
            out.println("<title>Servlet PaymentServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PaymentServlet at " + request.getContextPath() + "</h1>");
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
        String loan_id_raw = request.getParameter("lid");
        HttpSession session = request.getSession();
        DAO dao = new DAO();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            int account_id = Integer.parseInt(request.getParameter("aid"));
            int loan_id = Integer.parseInt(request.getParameter("lid"));
            Loan loan = dao.getLoanByID(loan_id);
            BankAccount account = dao.getBankAccountByID(account_id);
            Payment payment = dao.getPaymentById(id);
            long total_amount = Math.round(payment.getAmount_per_month() + payment.getInterest_per_month() + payment.getFine());
            if (account.getBalance()-total_amount < 0) {
                session.setAttribute("message", "Tài khoản không đủ tiền để thực hiện thanh toán");
            } else {
                payment.setPay_date(sdf.format(date));
                payment.setPayment_amount(total_amount);
                payment.setStatus(true);
                session.setAttribute("balance_before", account.getBalance());
                account.setBalance(account.getBalance()-total_amount);
                dao.updateBankAccount(account);
                dao.updatePayment(payment);
                session.setAttribute("balance_after", account.getBalance());
            }
            List<Payment> list = dao.getPaymentByLoanID(loan_id);
            int sum = 0;
            for (Payment i : list) {
                if (i.isStatus() == true) {
                    sum += 1;
                }
            }
            if (sum == list.size()) {
                loan.setStatus(true);
                dao.updateLoan(loan);
            }
        } catch (Exception e) {

        }
        response.sendRedirect("loanBillDetail?id=" + loan_id_raw);
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
        processRequest(request, response);
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
