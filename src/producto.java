public class producto {

	private String nombre;
	private String marca;
	private double precio;
	private int cantidad;
	public producto(String nombre, String marca, double precio, int cantidad) {
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	
	public String toString() {
		return this.nombre+" "+this.marca+" "+this.precio+" "+this.cantidad;
	
	}
	public String getNombre() {
		return this.nombre;
	}
	
	public String getMarca() {
		return this.marca;
	}
	
	public double getPrecio() {
		return this.precio;
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	public void setNombre(String nombre) {
		 this.nombre = nombre;
	}
	
	public void setMarca(String marca) {
		 this.marca=marca;
	}
	
	public void setPrecio(double precio) {
		 this.precio=precio;
	}
	
	public void setCantidad(int cantidad) {
		 this.cantidad=cantidad;
	}
	
}
