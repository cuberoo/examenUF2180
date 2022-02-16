package vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import dao.CentroDAO;
import modelo.Centro;
import modelo.Departamento;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoAñadirDepartamento extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtCodDepartamento;
	private JTextField txtNombre;
	private JRadioButton radioProdiedad;
	private JRadioButton radioFunciones;
	private JSpinner SPresupuesto;
	private JComboBox comboBox;
	private ArrayList<Centro> listaCentros;
	private Controlador controlador;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAñadirDepartamento dialog = new DialogoAñadirDepartamento();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAñadirDepartamento() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[][][grow][][][][][]", "[][][][][][][][][][]"));
		{
			JLabel lblCodigo = new JLabel("C\u00F3digo:");
			contentPanel.add(lblCodigo, "cell 1 0,alignx trailing");
		}
		{
			txtCodDepartamento = new JTextField();
			contentPanel.add(txtCodDepartamento, "cell 2 0 6 1,growx");
			txtCodDepartamento.setColumns(10);
		}
		{
			JLabel lblCentro = new JLabel("Centro:");
			contentPanel.add(lblCentro, "cell 1 2,alignx trailing");
		}
		{
			comboBox = new JComboBox();
			contentPanel.add(comboBox, "cell 2 2 6 1,growx");
			
		}
		{
			JLabel lblDireccion = new JLabel("tipo Direccion: ");
			contentPanel.add(lblDireccion, "cell 1 4");
		}
		{
			radioProdiedad = new JRadioButton("Propiedad");
			buttonGroup.add(radioProdiedad);
			contentPanel.add(radioProdiedad, "cell 2 4");
		}
		{
			radioFunciones = new JRadioButton("En funciones");
			buttonGroup.add(radioFunciones);
			contentPanel.add(radioFunciones, "cell 4 4");
		}
		{
			JLabel lblNewLabel = new JLabel("Presupuesto:");
			contentPanel.add(lblNewLabel, "cell 1 6");
		}
		{
			SPresupuesto = new JSpinner();
			SPresupuesto.setModel(new SpinnerNumberModel(5, 1, 100, 1));
			contentPanel.add(SPresupuesto, "cell 2 6");
		}
		{
			JLabel lblEuro = new JLabel("(en miles de \u20AC)");
			contentPanel.add(lblEuro, "cell 4 6");
		}
		{
			JLabel lblNombre = new JLabel("Nombre:");
			contentPanel.add(lblNombre, "cell 1 9");
		}
		{
			txtNombre = new JTextField();
			contentPanel.add(txtNombre, "cell 2 9 6 1,growx");
			txtNombre.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						recogerDatos();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	protected void recogerDatos() {
		int cod_departamento = Integer.parseInt(txtCodDepartamento.getText());
		Centro cen = (Centro) comboBox.getSelectedItem();
		String nombre = txtNombre.getText();
		String tipo_dir ;
		int presupuesto = (int) SPresupuesto.getValue();
		if(radioProdiedad.isSelected() ) {
			tipo_dir = "P";
		}else {
			tipo_dir = "F";
		}
		Departamento dpto = new Departamento(cod_departamento, cen.getCod_centro(), tipo_dir, presupuesto, nombre);
		controlador.insertarDepartamento(dpto);
		
	}

	
	public void setListaCentros(ArrayList<Centro> listaCentros) {
		this.listaCentros = listaCentros;
		for (Centro centro : listaCentros) {
			comboBox.addItem(centro);
		}
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador=controlador;
	}

}
