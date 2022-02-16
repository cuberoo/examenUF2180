package modelo;

import java.util.Objects;

public class Departamento {
	
	int cod_departamento;
	int cod_centro;
	String tipo_dir;
	int presupuesto;
	String nombre;
	
	public Departamento() {
		String tipo_dir = "";
		String nombre = "";
		
	}
	
	public Departamento(int cod_departamento, int cod_centro, String tipo_dir, int presupuesto, String nombre) {
		this.cod_departamento = cod_departamento;
		this.cod_centro = cod_centro;
		this.tipo_dir = tipo_dir;
		this.presupuesto = presupuesto;
		this.nombre = nombre;
	}

	/**
	 * @return el cod_departamentos
	 */
	public int getCod_departamentos() {
		return cod_departamento;
	}

	/**
	 * @param cod_departamentos el cod_departamentos a establecer
	 */
	public void setCod_departamentos(int cod_departamentos) {
		this.cod_departamento = cod_departamentos;
	}

	/**
	 * @return el cod_centro
	 */
	public int getCod_centro() {
		return cod_centro;
	}

	/**
	 * @param cod_centro el cod_centro a establecer
	 */
	public void setCod_centro(int cod_centro) {
		this.cod_centro = cod_centro;
	}

	/**
	 * @return el tipo_dir
	 */
	public String getTipo_dir() {
		return tipo_dir;
	}

	/**
	 * @param tipo_dir el tipo_dir a establecer
	 */
	public void setTipo_dir(String tipo_dir) {
		this.tipo_dir = tipo_dir;
	}

	/**
	 * @return el presupuesto
	 */
	public int getPresupuesto() {
		return presupuesto;
	}

	/**
	 * @param presupuesto el presupuesto a establecer
	 */
	public void setPresupuesto(int presupuesto) {
		this.presupuesto = presupuesto;
	}

	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [cod_departamentos=" + cod_departamento + ", cod_centro=" + cod_centro + ", tipo_dir="
				+ tipo_dir + ", presupuesto=" + presupuesto + ", cod_dpto_jefe=" + ", nombre=" + nombre
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod_centro, cod_departamento, nombre, presupuesto, tipo_dir);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		return cod_centro == other.cod_centro && cod_departamento == other.cod_departamento
				&&  Objects.equals(nombre, other.nombre)
				&& presupuesto == other.presupuesto && Objects.equals(tipo_dir, other.tipo_dir);
	}
	
	

}
