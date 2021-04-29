package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.res.Empleado;
import main.java.res.EmpleadoDAO;
import main.java.res.HibernateUtil;

/**
 * Servlet implementation class MostrarEmpleado
 */
@WebServlet("/MostrarEmpleado")
public class MostrarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	SessionFactory sessionFactory;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MostrarEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		printResponse(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		printResponse(request, response);
	}

	protected void printResponse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		Session session = HibernateUtil.getSessionFactory().openSession();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title> Mostrar Empleados </title>");
		out.print("<h1> Mostrar Empleados </h1>");
		out.println("</head>");
		out.println("<body>");
		// out.println("<br> <h1 align='center'> Departamentos </h1> <br><br> ");

		// Formulario que se llama a si mismo para realizar las busquedas
		out.println("<form action='http://localhost:8080/MostrarDepartamento' method='GET'> ");
		// Los campos de busqueda se muestran en una tabla independiente
		out.println("<table align='center' width='40%' border='0' >  ");
		// Los campos de busqueda se muestran en una tabla independiente
		out.println("<table align='center' width='40%' border='0' >  ");

		out.println("<tr>");
		out.println("<td>");
		out.println("</td>");
		out.println("</tr>");
		out.println(" </table> "); // Fin de campos de busqueda
		out.println("</form> ");
		out.println("<center>");
		out.println(" <b> <FONT color=:#0033FF> ");
		// Desplegar los datos del registro actual en el navegador
		out.println(" </FONT> </b> <br> </center> ");
		out.println("<br> ");
		out.println("<table align='center' width='90%' border='1' cellpadding='0' cellspacing='0'>  ");
		out.println("<tr> ");
		out.println("<td> ");
		out.println("<table width='100%' align='center' border='0' cellpadding='0' cellspacing='0'> ");
		out.println(" <tr bgcolor='#CCFF66' >");

		// Columnas de la tabla de la BD
		out.println("<td align='center width='3%' > <b> Código </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Nombre </b> </td> ");
		out.println("<td align='center' width='10%' > <b> Apellido 1 </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Apellido 2 </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Lugar de nacimiento </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Fecha de nacimiento </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Dirección </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Teléfono </b> </td>  ");
		out.println("<td align='center' width='10%' > <b> Puesto </b> </td>  ");

		List<Empleado> result = EmpleadoDAO.getAllEmpleados(session);

		for (int i = 0; i < result.size(); i++) {
			out.println("<tr>");
			out.print("<td align='center width='3%' >" + result.get(i).getCodigo() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getNombre() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getApellido1() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getApellido2() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getLugarNacimiento() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getFechaNacimiento() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getDireccion() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getTelefono() + "</td>");
			out.print("<td align='center width='10%' >" + result.get(i).getPuesto() + "</td>");
			out.println("</tr>");
		}

		out.println(" </tr>");

		out.println("</body>");
		out.println("</html>");

		session.close();

	}

}
