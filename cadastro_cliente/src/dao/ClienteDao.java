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
	
	
	//listar um cliente
	public ClienteBean listOne(Long id) {
		this.sql = "SELECT * FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement select = conexao.prepareStatement(this.sql);
			select.setLong(1, id);
			
			ResultSet res = select.executeQuery();
			
			if (res.next()) {
				ClienteBean cliente = new ClienteBean();
				cliente.setId(res.getLong("id"));
				cliente.setNome(res.getString("nome"));
				cliente.setEmail(res.getString("email"));
				cliente.setSenha(res.getString("senha"));
				
				return cliente;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
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
	
	//editar cliente
	public void update(ClienteBean cliente, Long id) {
		this.sql = "UPDATE cliente SET nome = ?, email = ?, senha = ? WHERE id = ?";
		
		try {
			PreparedStatement update = conexao.prepareStatement(this.sql);
			update.setString(1, cliente.getNome());
			update.setString(2, cliente.getEmail());
			update.setString(3, cliente.getSenha());
			update.setLong(4, id);
			update.execute();
			conexao.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//deletar cliente
	public void delete(Long id) {
		this.sql = "DELETE FROM cliente WHERE id = ?";
		
		try {
			PreparedStatement delete = conexao.prepareStatement(this.sql);
			delete.setLong(1, id);
			delete.execute();
			conexao.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
