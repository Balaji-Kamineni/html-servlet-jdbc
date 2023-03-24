import javax.servlet.*;
import javax.servler.http.*;
import java.sql.*;
import java.io.*;

public class insertservlet extends HttpServlet
{
	public void service(ServletRequest request , ServletResponse response) throws ServletException,IOException{
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("dname");
		String loc=request.getParameter("dloc");
		int dno = Integer.parseInt(request.getParameter("dno"));
		Connection conn=null;
		PreparedStatement pst=null;
		try{
			class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection("url","username","password");
			String query="INSERT INTO DEPT VALUES(?,?,?)";
			pst=conn.prepareStatement(query);
			pst.setInt(1,dno);
			pst.setString(2,name);
			pst.setString(3,loc);
			pst.executeUpdate();
			out.print("inserted");
		}
		catch(ClassNotFoundException cnfe){
			out.print(<h1> cnfe </h1>);
		} catch (SQLException se){
			out.print(<h1> se </h1>);
		}
	
		finally{
			try{
				if (conn!=null) conn.close();
				if (pst!=null) pst.close();
			}
			catch (Exception e){};
		}
	}
}