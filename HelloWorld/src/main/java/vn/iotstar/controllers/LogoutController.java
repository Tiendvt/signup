package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import vn.iotstar.utils.Constant;

@WebServlet(urlPatterns = "/logout")
public class LogoutController extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.removeAttribute("account");
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
		  for (Cookie cookie : cookies) {
		      if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
		          cookie.setMaxAge(0); // Set cookie expiration to 0 to delete it
		          resp.addCookie(cookie); // Add the updated cookie to the response
		          break;
		      }
		  }
		}
		resp.sendRedirect("home");
//		
		
	}
}
//HttpSession session = req.getSession(false); // Get the session if it exists
//if (session != null) {
//  session.invalidate(); // Invalidate the session
//}
//
//// Remove the "remember me" cookie if it exists

//
//// Redirect to the login page after logout
//resp.sendRedirect(req.getContextPath() + "/login");
//Cookie[] cookies = req.getCookies();
//if (cookies != null) {
//  for (Cookie cookie : cookies) {
//      if (Constant.COOKIE_REMEMBER.equals(cookie.getName())) {
//          cookie.setMaxAge(0); // Set cookie expiration to 0 to delete it
//          resp.addCookie(cookie); // Add the updated cookie to the response
//          break;
//      }
//  }
//}
