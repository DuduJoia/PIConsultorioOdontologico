package consultorioodontologico.Dao;

import java.sql.*;
import javax.swing.JOptionPane;

public class ModuloConexao {
    private static final String URL = "jdbc:mysql://localhost:3306/consultorioodontologico";
    private static final String USER = "root";
    
    // para quem instalou o XAMPP
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SENHA = "";
    
    // para quem instalou como servidor o padrão MySQL
    // private static final Strin DRIVER = "com.mysql.cj.jdbc.Driver";
    // private static final senha = "root";
    
    public static void executar(String query){
        try{
            Class.forName(DRIVER);
            
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            Statement st = conn.createStatement();
            st.execute(query);
            conn.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
        
    public static ResultSet consultar(String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //   conn.close();
            return rs;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
        
        
        }
    
    public static Connection conector(){
            java.sql.Connection conexao = null;
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/consultorioodontologico";
            String user = "root";
            String password = "";
            
            try{ Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
            }   catch(Exception e){
                return null;
            }

    }
}