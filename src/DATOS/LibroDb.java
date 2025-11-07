package DATOS;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import LOGICA.Libro;

public class LibroDb {
	
	public static List<Libro> libros=new ArrayList<>();
    //public static Libro lb=new Libro();
	
	public static String obtenerLibros() {
        String consulta = "SELECT * from libro";
        String libro="";
        String salida="";
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery(consulta)) {

            while (resultado.next()) {                
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String isbn = resultado.getString("isbn");
                int idLibro=resultado.getInt("idLibro");

                libro="---***---\nTitulo: "+titulo+"\nAutor: "+autor+"\nISBN: "+isbn+"\nID: "+idLibro;
                salida=salida+libro+"\n";
            }
            Conexion.desconectar(conn);

        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }

        return salida;
    }
	
	public static List<Libro> obtener() {
        String consulta = "SELECT * from libro";
                
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery(consulta)) {

            while (resultado.next()) {  
            	Libro lb=new Libro();
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String isbn = resultado.getString("isbn");
                int idLibro=resultado.getInt("idLibro");

                lb.setTitulo(titulo);
                lb.setAutor(autor);
                lb.setIsbn(isbn);
                lb.setIdLibro(idLibro);
                
                libros.add(lb);                
                //lb=new Libro();
            }            
            
            Conexion.desconectar(conn);

        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }

        return libros;
    }
	
	public static List<Libro> buscar(String parametro) {
        String consulta = "SELECT * from libro where titulo='"+parametro+"'";
                
        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet resultado = stmt.executeQuery(consulta)) {

            while (resultado.next()) {  
            	Libro lb=new Libro();
                String titulo = resultado.getString("titulo");
                String autor = resultado.getString("autor");
                String isbn = resultado.getString("isbn");
                int idLibro=resultado.getInt("idLibro");

                lb.setTitulo(titulo);
                lb.setAutor(autor);
                lb.setIsbn(isbn);
                lb.setIdLibro(idLibro);
                
                libros.add(lb);                
                //lb=new Libro();
            }            
            
            Conexion.desconectar(conn);

        } catch (SQLException e) {
            System.err.println("Error al obtener productos: " + e.getMessage());
        }

        return libros;
    }
}
