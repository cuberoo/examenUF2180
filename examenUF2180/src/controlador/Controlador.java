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
import vista.DialogoA�adirCentro;
import vista.DialogoA�adirDepartamento;
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
	private DialogoA�adirCentro dialogoA�adirCentro;
	private VistaMostrarDepartamentos mostrarDepartamentos;
	private DialogoA�adirDepartamento a�adirDepartamento;
	
	// Objetos DAO o CRUD de la base de datos
	private CentroDAO centroDAO;
	private DepartamentoDAO departamentoDAO;

	
	
	public Controlador() {
		// Creamos las ventanas de la aplicaci�n
		ventanaPpal = new VentanaPpal();
		ventanaMostrarCentros = new VentanaMostrarCentros();
		dialogoA�adirCentro = new DialogoA�adirCentro();
		mostrarDepartamentos = new VistaMostrarDepartamentos();
		a�adirDepartamento = new DialogoA�adirDepartamento();
		
		// Dando acceso al controlador desde las vistas
		ventanaPpal.setControlador(this);
		ventanaMostrarCentros.setControlador(this);
		dialogoA�adirCentro.setControlador(this);
		mostrarDepartamentos.setControlador(this);
		a�adirDepartamento.setControlador(this);

		
		// Creamos los objetos DAO
		centroDAO = new CentroDAO();
		departamentoDAO = new DepartamentoDAO();
	}
	
	
	/**
	 * M�todo que arranca el programa principal
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
		dialogoA�adirCentro.setVisible(true);
	}

	public void mostrarListarDepartamentos() {
		ArrayList<Departamento> dptos = departamentoDAO.obtenerDepartamentos();
		mostrarDepartamentos.setListaDepartamenos(dptos);
		mostrarDepartamentos.setVisible(true);
	}
	
	public void mostrarInsertarDepartamentos() {
		ArrayList<Centro> listaCentros = centroDAO.obtenerCentros();
		a�adirDepartamento.setListaCentros(listaCentros);
		a�adirDepartamento.setVisible(true);
	}

	/** 
	 * M�todo del controlador que a�ade un nuevo centro a la tabla de centros
	 * @param centro
	 */
	public void insertaCentro(Centro centro) {
		// Invocando a centroDAO
		int resultado = centroDAO.insertarCentro(centro);
		if (resultado ==0) {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(dialogoA�adirCentro, "Insercion del centro correcta");
			dialogoA�adirCentro.setVisible(false);
		}
	}
	
	public void insertarDepartamento(Departamento dpto) {
		int resultado = departamentoDAO.insertarDepartamento(dpto);
		if (resultado == 0) {
			JOptionPane.showMessageDialog(a�adirDepartamento, "Error. no se ha podido insertar.");
		} else {
			JOptionPane.showMessageDialog(a�adirDepartamento, "Insercion del departamento correcta");
			dialogoA�adirCentro.setVisible(false);
		}
	}
	
}
