package com.chainsys.empdao;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/Servlet3")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
        request.getRequestDispatcher("link.html").include(request, response);
        
        Cookie ck[] =request.getCookies();
        
        if(ck!=null) {
            String name= ck[0].getValue();
            if(name.equals("")|| name!=null) {
                out.print("<b>Welcome To Profile</b>");
                out.print("<br>Welcome"+ name);
                
            }
        }else {
            out.print("please Login First");
            request.getRequestDispatcher("login.html").include(request, response);

        }


	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
