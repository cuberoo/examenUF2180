package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conexion.ConexionBD;
import modelo.Centro;
import modelo.Departamento;

public class DepartamentoDAO {
	
private ConexionBD conexion;
	
    public DepartamentoDAO() {
        this.conexion = new ConexionBD();
    }

	public ArrayList<Departamento> obtenerDepartamentos(){
		
		// Obtenemos una conexion a la base de datos.
				Connection con = conexion.getConexion();
				Statement consulta = null;
				ResultSet resultado = null;
				ArrayList<Departamento> dptos = new ArrayList<Departamento>();
				
				try {
					consulta = con.createStatement();
					resultado = consulta.executeQuery("select * from departamentos");
					
					// Bucle para recorrer todas las filas que devuelve la consulta
					while(resultado.next()) {
						
						int cod_departamento = resultado.getInt("cod_departamento");
						int cod_centro = resultado.getInt("cod_centro");
						String tipo_dir = resultado.getString("tipo_dir");
						int presupuesto = resultado.getInt("presupuesto");
						String nombre = resultado.getString("nombre");
						
						Departamento dpto = new Departamento(cod_departamento, cod_centro, tipo_dir, presupuesto, nombre);
						dptos.add(dpto);
					}
					
				} catch (SQLException e) {
					System.out.println("Error al realizar la consulta sobre centros: "+e.getMessage());
				} finally {
					try {
						resultado.close();
						consulta.close();
						conexion.desconectar();
					} catch (SQLException e) {
						System.out.println("Error al liberar recursos: "+e.getMessage());
					} catch (Exception e) {
						
					}
				}
				return dptos;
		    }
	
	public int insertarDepartamento(Departamento dpto) {
    	// Obtenemos una conexion a la base de datos.
		Connection con = conexion.getConexion();
		PreparedStatement consulta = null;
		int resultado=0;
		
		try {
			consulta = con.prepareStatement("INSERT INTO Departamentos (cod_departamento, cod_centro, tipo_dir, presupuesto, nombre)"
					+ " VALUES (?,?,?,?,?) ");
			
			consulta.setInt(1, dpto.getCod_departamentos());
			consulta.setInt(2, dpto.getCod_centro());
			consulta.setString(3, dpto.getTipo_dir());
			consulta.setInt(4, dpto.getPresupuesto());
			consulta.setString(5, dpto.getNombre());
			resultado=consulta.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la inserción del Departamento: "
		        +e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
    }

}
	

