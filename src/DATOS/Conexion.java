package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	 // Parámetros de conexión
	 private static final String URL = "jdbc:mysql://localhost:3306/dbLibreria";
	 private static final String USER = "root";
	 private static final String PASSWORD = "admin";

	 public static Connection conectar() throws SQLException {
	     try {
	         Class.forName("com.mysql.cj.jdbc.Driver");
	     } catch (ClassNotFoundException e) {
	         throw new SQLException("Driver MySQL no encontrado", e);
	     }

	     return DriverManager.getConnection(URL, USER, PASSWORD);
	 }

	 //Cierra la conexión
	 public static void desconectar(Connection connection) {
	     if (connection != null) {
	         try {
	             connection.close();
	         } catch (SQLException e) {
	             System.err.println("Error al cerrar conexión: " + e.getMessage());
	         }
	     }
	 }
	 
}
