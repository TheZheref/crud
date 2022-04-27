import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class mysql {
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/parcial_bd_2";
	private static final String usuario = "root";
	private static final String contrase�a = "";


	 	static {
	 		try {
	 			Class.forName(controlador);
	 		} catch(ClassNotFoundException e) {
	 			System.out.println("Error al cargar el driver. ");
				e.printStackTrace();
	 		}
	 	}

		public Connection conectar() {
			Connection conexion = null;
			try {
				
				conexion = DriverManager.getConnection(url,usuario,contrase�a);
				System.out.println("conexion OK.");
		
			} catch (SQLException e) {
				System.out.println("Error con la base de datos.");
				e.printStackTrace();
			}
			
			return conexion;
		}
}
