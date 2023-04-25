/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.InterestDetail;

/**
 *
 * @author Legion
 */
@WebServlet(name = "LoanServlet", urlPatterns = {"/loan"})
public class LoanServlet extends HttpServlet {

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
            out.println("<title>Servlet LoanServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoanServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("loan.jsp").forward(request, response);
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
        response.setContentType("text/html; charset=UTF-8");
        try {
            int loanType = Integer.parseInt(request.getParameter("loanType"));
            Long amount = Long.parseLong(request.getParameter("loanAmount"));
            int tenor = Integer.parseInt(request.getParameter("loanTenor"));

            DAO dao = new DAO();
            InterestDetail interestDetail = new InterestDetail();
            if (loanType == 0) {
                interestDetail = dao.getInterestDetailAvailableByLoanTypeAndTenor(false, tenor);
            } else {
                interestDetail = dao.getInterestDetailAvailableByLoanTypeAndTenor(true, tenor);
            }
            request.setAttribute("amount", amount);
            request.setAttribute("interestDetail", interestDetail);
            request.setAttribute("tenor", interestDetail.getTenor());
            request.setAttribute("rate", interestDetail.getRate());
            request.getRequestDispatcher("contract.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
        }

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
