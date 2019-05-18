package servelet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ClienteBean;

@WebServlet("/ClienteServelet")
public class ClienteServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ClienteServelet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteBean cliente = new ClienteBean();
		
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		
		
	}

}
