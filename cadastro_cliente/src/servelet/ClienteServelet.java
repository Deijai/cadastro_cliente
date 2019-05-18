package servelet;

import java.io.IOException;

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
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		System.out.println(cliente.toString());
		
		clientedao.create(cliente);
		RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
		request.setAttribute("clientes", clientedao.listAll());
		dispatcher.forward(request, response);
		
		
		
	}

}
