/**
 * 
 */
package controlador;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.CentroDAO;
import dao.DepartamentoDAO;
import modelo.Centro;
import modelo.Departamento;
import vista.DialogoAñadirCentro;
import vista.DialogoAñadirDepartamento;
import vista.VentanaMostrarCentros;
import vista.VentanaPpal;
import vista.VistaMostrarDepartamentos;

/**
 * @author David
 *
 */
public class Controlador {

	// Ventanas del sistema
	private VentanaPpal ventanaPpal;
	private VentanaMostrarCentros ventanaMostrarCentros;
	private DialogoAñadirCentro dialogoAñadirCentro;
	private VistaMostrarDepartamentos mostrarDepartamentos;
	private DialogoAñadirDepartamento añadirDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDAO departamentoDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicación
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoAñadirCentro = new DialogoAñadirCentro();
		mostrarDepartamentos = new VistaMostrarDepartamentos();
		añadirDepartamento = new DialogoAñadirDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoAñadirCentro.setControlador(this);
		mostrarDepartamentos.setControlador(this);
		añadirDepartamento.setControlador(this);

		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDAO = new DepartamentoDAO();
	}
	
	
	/**
	 * Método que arranca el programa principal
	 */
	public void inciarPrograma() {
		ventanaPpal.setVisible(true);
	}
	
	public void mostrarListarCentros() {
		ArrayList<Centro> lista = centroDAO.obtenerCentros();
		ventanaMostrarCentros.setListaCentros(lista);
		ventanaMostrarCentros.setVisible(true);
	}
	
	public void mostrarInsertarCentros() {
		dialogoAñadirCentro.setVisible(true);
	}

	public void mostrarListarDepartamentos() {
		ArrayList<Departamento> dptos = departamentoDAO.obtenerDepartamentos();
		mostrarDepartamentos.setListaDepartamenos(dptos);
		mostrarDepartamentos.setVisible(true);
	}
	
	public void mostrarInsertarDepartamentos() {
		ArrayList<Centro> listaCentros = centroDAO.obtenerCentros();
		añadirDepartamento.setListaCentros(listaCentros);
		añadirDepartamento.setVisible(true);
	}

	/** 
	 * Método del controlador que añade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoAñadirCentro, "Insercion del centro correcta");
			dialogoAñadirCentro.setVisible(false);
		}
	}
	
	public void insertarDepartamento(Departamento dpto) {
		int resultado = departamentoDAO.insertarDepartamento(dpto);
		if (resultado == 0) {
			JOptionPane.showMessageDialog(añadirDepartamento, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(añadirDepartamento, "Insercion del departamento correcta");
			dialogoAñadirCentro.setVisible(false);
		}
	}
	
}
