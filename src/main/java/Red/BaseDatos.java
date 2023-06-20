/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Red;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
/**
 *
 * @author DANIELA
 */
public class BaseDatos {
    //54.147.25.136:3306
    public static final String JDBC_URL = "jdbc:mysql://localhost:3306/60-63-77-82?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    public static final String DB_USER = "root";
    public static final String DB_CLAVE = "";
    
    public static DataSource getDataSource(){
        
        BasicDataSource bs = new BasicDataSource();
        bs.setUrl(JDBC_URL);
        bs.setUsername(DB_USER);
        bs.setPassword(DB_CLAVE);  
        bs.setInitialSize(5);
        return bs;       
        
    }
    public static Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return getDataSource().getConnection();
    }
    
    public static void close(Connection con) throws SQLException{
        con.close();
    }
    
    public static void close(Statement stm) throws SQLException{
        stm.close();
    }
    
    public static void close(ResultSet res) throws SQLException{
        if (res != null) {
            res.close();
        }
    }
    
    public static void close(PreparedStatement ps) throws SQLException{
        if (ps != null) {
            ps.close();
        }
    }
}
