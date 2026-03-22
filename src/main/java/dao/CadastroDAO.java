/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import model.CadastroModel;

/**
 *
 * @author jrgab
 */
public class CadastroDAO {
    public boolean cadastrarCliente(CadastroModel cadastro) {
        String sql = "INSERT INTO cadastro (nomeCadastro, emailCadastro, senhaCadastro) VALUES(?,?,?)"; 
        
        try (var con = ConnectionFactory.getConnection();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            
            stmt.setString(1, cadastro.getNomeCadastro());
            stmt.setString(2, cadastro.getEmailCadastro());
            stmt.setString(3, cadastro.getSenhaCadastro());
            
            int linhasAfetadas = stmt.executeUpdate();
            
            return linhasAfetadas > 0;
        } catch(java.sql.SQLException e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
            return false; 

        }
    }
}
