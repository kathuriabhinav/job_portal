package job_portal;

import java.sql.*;
public class login{
    static String emailid;
    static String pass;
    static int mode;
    login(String e, String p,int m){
            emailid=e;
            pass=p;
            mode=m;
    }
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
    static final String USER = "root";
    static final String PASS = "root";  
    public static int main(String[] s) {
		
		int hey=0;
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{    
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER, PASS);
			if(mode==1){
                            stmt = conn.prepareStatement("SELECT email_id,person_id FROM company WHERE email_id=? and person_id=?");
                        }else if(mode==2){
                            stmt = conn.prepareStatement("SELECT email_id,person_id FROM jobseeker WHERE email_id=? and person_id=?");
                        }else if(mode==3){
                            stmt = conn.prepareStatement("SELECT email_id,person_id FROM admin WHERE email_id=? and person_id=?");
                        }
			stmt.setString(1,emailid);
			stmt.setString(2,pass);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
			    hey=1; 
			}
		}
		catch(SQLException se)
		{
		    se.printStackTrace();
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
		finally
		{
		    try
		    {
		        if(stmt!=null)
		        conn.close();
		    }
		    catch(SQLException se)
		    {
		    	se.printStackTrace();
		    }
		    finally 
		    {
		    	try
			    {
			        if(conn!=null)
			        conn.close();
			    }
			    catch(SQLException se)
			    {
			        se.printStackTrace();
			    }
		    }
		}
		return hey;
	}
	
}