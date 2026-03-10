package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.UserModel;


public class UserDAO {
    public boolean validarLogin(UserModel userModel) {
    // 1. (nome = ? OR email = ?) garante que um dos dois deve bater
    // E a senha deve bater com o registro encontrado.
    String sql = "SELECT * FROM login WHERE (nome = ? OR email = ?) AND senha = ?";
    
    try (var con = ConnectionFactory.getConnection()) {
        PreparedStatement stmt = con.prepareStatement(sql);
        
        // Se o usuário preencheu o campo de login, usamos o mesmo valor para nome e email
        String loginValue = (userModel.getNome() != null && !userModel.getNome().isEmpty()) 
                            ? userModel.getNome() 
                            : userModel.getEmail();

        
        stmt.setString(1, loginValue); // Para o nome = ?
        stmt.setString(2, loginValue); // Para o email = ?
        stmt.setString(3, userModel.getSenha()); // Para a senha = ?

        ResultSet rs = stmt.executeQuery();
        
        return rs.next(); // Se houver resultado, login ok
        
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
