package job_portal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class do_register {
    static String n,e,c,p;
    static int m;
    public do_register(String name,String password,String email,String contact_no,int mode) 
    {
        n=name;e=email;c=contact_no;p=password;m=mode;
    }
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
    static final String DB_URL = "jdbc:mysql://localhost:3306/job_portal";
    static final String USER = "root";
    static final String PASS = "root";
    public static int main(String[] args)
    {
        int hey = 0;
        Connection conn = null;
        PreparedStatement stmt = null;
        try
        {             
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL,USER, PASS);
            if(m==1){
                stmt = conn.prepareStatement("INSERT INTO comapny VALUES(?,?,?,?)");
            }else if(m==2){
                stmt = conn.prepareStatement("INSERT INTO jobseeker VALUES(?,?,?,?)");
            }else if(m==3){
                stmt = conn.prepareStatement("INSERT INTO admin VALUES(?,?,?,?)");
            }
            stmt.setString(1,e);
            stmt.setString(2,p);
            stmt.setString(3,n);
            stmt.setString(4,c);
            stmt.executeUpdate();
        }
        
        catch (SQLIntegrityConstraintViolationException se)
        {
        	hey=1;
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
                {
                	conn.close();
                }
            }
            catch(SQLException se)
            {
            	se.printStackTrace();
            }
            finally {
            	try
                {
                    if(conn!=null)
                    {
                    	conn.close();
                    }
                    
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
