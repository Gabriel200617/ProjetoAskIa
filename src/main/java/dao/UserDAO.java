package dao;

import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.UserModel;


public class UserDAO {
    public boolean validarLogin(UserModel userModel){
        String sql = "SELECT * FROM Login WHERE nome OR email = ? AND senha = ?";
        try(var con = ConnectionFactory.getConnection()){
            PreparedStatement stmt =
                    con.prepareStatement(sql);
                String valueToSet = (userModel.getNome() != null) ? userModel.getNome() : userModel.getEmail();
                stmt.setString(1, valueToSet);            
                stmt.setString(2, userModel.getSenha());
                
                ResultSet rs =stmt.executeQuery();
                
                return rs.next();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
