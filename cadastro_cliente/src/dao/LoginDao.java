package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.SingleConnection;

public class LoginDao {
	
	private Connection conexao;
	private String sql;
	
	
	public LoginDao() {
		conexao = SingleConnection.getConexao();
	}
	
	
	public boolean validarLogin(String email, String senha) throws SQLException {
		this.sql = "SELECT email, senha FROM cliente WHERE email = ? AND senha = ?";
		PreparedStatement select = conexao.prepareStatement(this.sql);
		select.setString(1, email);
		select.setString(2, senha);
		
		ResultSet res = select.executeQuery();
		
		if (res.next()) {
			return true;
		} else {
			return false;
		}
	}

}
