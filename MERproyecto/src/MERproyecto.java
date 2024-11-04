/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MERproyecto;
/**
 *
 * @author mauro
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MERproyecto {
    
    public static void main(String[]args){
        
        String usuario="root";
        String password="Abundancia.87";
        String url="jdbc:mysql://localhost:3306/MERproyecto";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MERproyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {  
            conexion=DriverManager.getConnection(url,usuario,password);
            statement=conexion.createStatement();
            rs=statement.executeQuery("SELECT * FROM PARQUEADERO");
            rs.next();
            do{
                System.out.println(rs.getInt("id_parqueadero")+":"+ rs.getString("nombre"));
            }while (rs.next()); 
            
            //insert 
           statement.executeUpdate("INSERT INTO PARQUEADERO VALUES(1517,'Occidente','Floresta','Salitre','Bogota')"); 
           rs=statement.executeQuery("SELECT * FROM PARQUEADERO");
           rs.next();
            do{
                System.out.println("");
            }while (rs.next()); 
            
            //Update
            statement.executeUpdate("UPDATE parqueadero SET nombre='Polo' WHERE id_parqueadero=4"); 
           rs=statement.executeQuery("SELECT * FROM PARQUEADERO");
           rs.next();
            do{
                System.out.println("");
            }while (rs.next());
            
            //Delete
            statement.executeUpdate("DELETE FROM PARQUEADERO WHERE id_parqueadero=9873"); 
           rs=statement.executeQuery("SELECT * FROM PARQUEADERO");
           rs.next();
            do{
                System.out.println("");
            }while (rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(MERproyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
