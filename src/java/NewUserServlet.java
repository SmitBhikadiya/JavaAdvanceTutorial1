/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.DBHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.UserDetailes;

/**
 *
 * @author Smit Bhikadiya
 */
@WebServlet(urlPatterns = {"/NewUserServlet"})
public class NewUserServlet extends HttpServlet {

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
            
            String username = request.getParameter("username");
            String address = request.getParameter("address");
            int age = Integer.parseInt(request.getParameter("age"));
            String gender= request.getParameter("gender");
            String submitType = request.getParameter("submit");
            
            UserDetailes obj = new UserDetailes(username,address,age,gender);
          
            String msg = null;
            if(submitType.equals("Register")){
                msg = DBHandler.insert(obj);
            }
            else{
                msg = DBHandler.update(obj);
            }
            
            out.println("<h1>"+msg+"</h1>");
         
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp); //To change body of generated methods, choose Tools | Templates.
        processRequest(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp); //To change body of generated methods, choose Tools | Templates.
        processRequest(req,resp);
    }
    
    
}
