package servelet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;

@WebServlet("/ListarCliente")
public class ListarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClienteDao clientedao = new ClienteDao();
	
    public ListarCliente() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("listar")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("cadastroCliente.jsp");
			request.setAttribute("clientes", clientedao.listAll());
			dispatcher.forward(request, response);
		}
		
	}

}
