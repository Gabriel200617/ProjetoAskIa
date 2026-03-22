/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.CadastroDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import model.CadastroModel;

@WebServlet("/pages/cadastro")
public class CadastroServlet extends HttpServlet {
    
    private static final long serialVersionUID =1L;
    
    @Override
    protected void doPost(
            HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
            // 1- pegando os dados do forms
            String nomeCad = request.getParameter("nomeCad");
            String emailCad = request.getParameter("emailCad");
            String senhaCad = request.getParameter("senhaCad");
            String senhaConfi = request.getParameter("senhaConfi");

            if (nomeCad.equals("") || emailCad.equals("") || senhaCad.equals("") || senhaConfi.equals("")) {
                // 1. Guarda a mensagem na "mochila" (request)
                request.setAttribute("mensagem", "Erro: Todos os campos devem ser preenchidos!");

                response.sendRedirect("cadastro.html");

                return; 
            }

            // 3- Validação de Senha
            if (senhaCad.equals(senhaConfi)) {
                CadastroModel cadastro = new CadastroModel();
                cadastro.setNomeCadastro(nomeCad);
                cadastro.setEmailCadastro(emailCad);
                cadastro.setSenhaCadastro(senhaCad);

                CadastroDAO dao = new CadastroDAO();
                boolean success = dao.cadastrarCliente(cadastro);

                if (success) {
                    // Aqui o Redirect é bom porque os dados já foram salvos!
                    response.sendRedirect("../index.html");
                } else {
                    response.sendRedirect("cadastro.html");
                }
            } else {
                response.sendRedirect("cadastro.html");
            }
        }
}
