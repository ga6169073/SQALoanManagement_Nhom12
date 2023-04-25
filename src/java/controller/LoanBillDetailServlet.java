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
import model.Loan;
import model.Payment;

/**
 *
 * @author Legion
 */
@WebServlet(name = "LoanBillDetailServlet", urlPatterns = {"/loanBillDetail"})
public class LoanBillDetailServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoanBillDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanBillDetailServlet at " + request.getContextPath() + "</h1>");
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
        DAO dao = new DAO();
        Date current_date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Loan loan = dao.getLoanByID(id);
            List<Payment> listpayment = dao.getPaymentByLoanID(id);
            for (Payment i : listpayment) {
                Date payment_date = sdf.parse(i.getPayment_date());
                long days_late = (current_date.getTime() - payment_date.getTime()) / (24 * 60 * 60 * 1000);
                double total = i.getAmount_per_month() + i.getInterest_per_month();
                float rate = loan.getInterestDetail().getRate();
                if (days_late > 0 && i.getPayment_amount() < total) {
                    i.setFine(rate * 1.5 / (rate * 365));
                }
            }

            dao.updatePaymentFineById(listpayment);
            double sum = 0;
            for (Payment i : listpayment) {
                sum += i.getAmount_per_month() + i.getInterest_per_month() + i.getFine();
            }
            long sum_render = (long) Math.round(sum);
            request.setAttribute("loan", loan);
            request.setAttribute("end_date", listpayment.get(listpayment.size() - 1).getPayment_date());
            request.setAttribute("sum", sum_render);
            request.setAttribute("listpayment", listpayment);
            request.getRequestDispatcher("loanBillDetail.jsp").forward(request, response);
        } catch (Exception e) {

        }
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
        request.getRequestDispatcher("loanBillDetail.jsp").forward(request, response);
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
