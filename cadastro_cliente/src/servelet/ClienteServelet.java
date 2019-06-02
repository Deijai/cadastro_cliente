package servelet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ClienteBean;
import dao.ClienteDao;

@WebServlet("/ClienteServelet")
public class ClienteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clientedao = new ClienteDao();

    public ClienteServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		String acao = request.getParameter("acao");
		System.out.println(acao);
		
		if (acao.equalsIgnoreCase("excluir")) {
			clientedao.delete(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
			request.setAttribute("clientes", clientedao.listAll());
			dispatcher.forward(request, response);
		}
		
		if (acao.equalsIgnoreCase("editar")) {
			ClienteBean cliente = clientedao.listOne(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
			request.setAttribute("cliente", cliente);
			dispatcher.forward(request, response);
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteBean cliente = new ClienteBean();
		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String fone = request.getParameter("fone");
		
		try {
			if(clientedao.verificaEmail(email) == false) {
				cliente.setNome(nome);
				cliente.setEmail(email);
				cliente.setSenha(senha);
				cliente.setFone(fone);
				
				System.out.println(cliente.toString());
				
				if (id.isEmpty() == false) {
					System.out.println("id no if === "+id);
					clientedao.update(cliente, Long.parseLong(id));
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
					request.setAttribute("clientes", clientedao.listAll());
					dispatcher.forward(request, response);
				} else {
					System.out.println("id no else === "+id);
					clientedao.create(cliente);
					request.setAttribute("class", "alert alert-success");
					request.setAttribute("msg", "Cliente cadastrado com sucesso!");
					RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
					request.setAttribute("clientes", clientedao.listAll());
					dispatcher.forward(request, response);
				}
			} else {
				request.setAttribute("class", "alert alert-danger");
				request.setAttribute("msg", "email ja cadastrado!");
				RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
				request.setAttribute("clientes", clientedao.listAll());
				dispatcher.forward(request, response);
				
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
