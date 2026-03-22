/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author 232.003676
 */
import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import model.UserModel;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("nome");
        String senha = request.getParameter("senha");
        
        UserModel userModel = new UserModel();
        userModel.setNome(usuario);
        userModel.setSenha(senha);
        
        UserDAO dao = new UserDAO();
        
        if(dao.validarLogin(userModel)) {
            HttpSession session = 
            request.getSession();
            
            session.setAttribute("nome", usuario);
            
            response.sendRedirect("pages/inicio.html");
        }else {
            response.sendRedirect("index.html");
        }
    }
    
}