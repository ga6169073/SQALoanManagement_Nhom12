/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import model.Payment;

/**
 *
 * @author Legion
 */
@WebServlet(name = "CalculatorServlet", urlPatterns = {"/calculator"})
public class CalculatorServlet extends HttpServlet {

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
            out.println("<title>Servlet CalculatorServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CalculatorServlet at " + request.getContextPath() + "</h1>");
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
        request.getRequestDispatcher("calculator.jsp").forward(request, response);
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
            int loanType = Integer.parseInt(request.getParameter("loanType"));
            Long amount = Long.parseLong(request.getParameter("loanAmount"));
            int tenor = Integer.parseInt(request.getParameter("loanTenor"));
            float rate = Float.parseFloat(request.getParameter("loanRate"));
            boolean type;
            if (loanType == 0) {
                type = false;
            } else {
                type = true;
            }
            List<Payment> listpayment = new ArrayList<>();
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            List<String> payment_date = generateDates(sdf.format(date), tenor);
            long amount_per_month_round = (long) Math.round((double) amount / tenor);
            double amount_per_month = (double) amount / tenor;
            double sum=0;
            if (type == false) {
                // tra no deu theo thang        
                long interest_per_month_round = (long) Math.round(((double) amount * rate) / (100 * tenor));
                double interest_per_month = (double) amount * rate / (100 * tenor);
                for (int i = 0; i < tenor; i++) {
                    listpayment.add(new Payment(amount_per_month, interest_per_month, payment_date.get(i)));
                    sum+=amount_per_month+interest_per_month;
                }
            } else {
                // tra no giam dan theo thang       
                long amount_remain = amount;
                for (int i = 0; i < tenor; i++) {
                    long interest_per_month_round = (long) Math.round(((double) amount_remain * rate) / (100 * tenor));
                    double interest_per_month = (double) amount_remain * rate / (100 * tenor);
                    listpayment.add(new Payment(amount_per_month, interest_per_month, payment_date.get(i)));
                    sum+=amount_per_month+interest_per_month;
                    amount_remain -= amount_per_month;
                }
            }
            long sum_render = (long)Math.round(sum);
            request.setAttribute("listPayment", listpayment);
            request.setAttribute("amount", amount);
            request.setAttribute("tenor", tenor);
            request.setAttribute("rate", rate);
            request.setAttribute("begin_date", sdf.format(date));
            request.setAttribute("end_date", listpayment.get(listpayment.size() - 1).getPayment_date());
            request.setAttribute("sum", sum_render);
            request.getRequestDispatcher("calculator.jsp").forward(request, response);
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
