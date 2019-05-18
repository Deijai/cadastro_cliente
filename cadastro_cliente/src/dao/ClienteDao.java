package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ClienteBean;
import conexao.SingleConnection;

public class ClienteDao {
	
	private Connection conexao;
	private String sql;
	
	
	
	public ClienteDao() {
		conexao = SingleConnection.getConexao();
	}
	
	//listar todos os clientes
	public List<ClienteBean> listAll(){
		List<ClienteBean> list = new ArrayList<ClienteBean>();
		
		try {
			this.sql = "SELECT * FROM cliente";
			PreparedStatement listAll = conexao.prepareStatement(this.sql);
			
			ResultSet res = listAll.executeQuery();
			
			while (res.next()) {
				ClienteBean cliente = new ClienteBean();
				cliente.setId(res.getLong("id"));
				cliente.setNome(res.getString("nome"));
				cliente.setEmail(res.getString("email"));
				cliente.setSenha(res.getString("senha"));
				list.add(cliente);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//cadastrar cliente
	public void create(ClienteBean cliente) {
		this.sql = "INSERT INTO cliente (nome, email, senha) VALUES (?,?,?)";
		
		try {
			PreparedStatement create = conexao.prepareStatement(this.sql);
			create.setString(1, cliente.getNome());
			create.setString(2, cliente.getEmail());
			create.setString(3, cliente.getSenha());
			create.execute();
			conexao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
