import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GestorDeProductos {

	final static int NUMERO_PRODUCTOS=4;
	
	
	public static void main(String[] args) throws IOException {
		menu();
	}
	

	public static void menu() throws IOException {
		int opcion = 8;
		
		producto [] listaProductos = new producto[NUMERO_PRODUCTOS];
		
		Scanner sc = new Scanner(System.in);
		
        while (opcion!=0) {
    		
    		System.out.println("1. Crea el archivo de productos:");
            System.out.println("2. Lee un archivo");
            System.out.println("3. Copia el archivo");
            System.out.println("4. Modifica el archivo");
            System.out.println("5. Mostrar el archivo");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            
		switch(opcion) {
			case 1 -> creaArchivo(nombreArchivo());
			case 2 -> listaProductos = lectorArchivo();
			case 4 -> modificadorArchivos(listaProductos);
			case 5 -> mostrarArchivo(listaProductos);
			case 0 -> System.exit(0);		
		}
        
	}

}
	public static String nombreArchivo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduzca el nombre del archivo a crear:");
			String nombre=sc.nextLine();
			return nombre;
	}
	public static void creaArchivo (String archivo) {
		Scanner sc = new Scanner(System.in);	
		PrintWriter escribidor = null;
				
			try {
				escribidor = new PrintWriter(archivo);
				for (int i=0;i<NUMERO_PRODUCTOS;i++) {
					System.out.println("Estás creando el producto "+(i+1));
						System.out.println("Introduce el nombre del producto");
						String nombre=sc.nextLine();
					System.out.println("Introduce la marca del producto");
						String marca=sc.nextLine();
					System.out.println("Introduce el precio del producto");
						String precio=sc.nextLine();
					System.out.println("Introduce las existencias disponibles del producto");
						String cantidad=sc.nextLine();
						
						String escribir=nombre+","+marca+","+precio+","+cantidad;
						escribidor.println(escribir);
				}
			} catch (FileNotFoundException e) {
				System.out.println("No esta el archivo zuprim");
				e.printStackTrace();
			} finally {
				if (escribidor!=null) {
					escribidor.close();
				}
		}
			System.out.println("Za creao el archivo: "+archivo);
	}
	
	public static producto [] lectorArchivo () throws IOException {
		

		producto [] listaProductos = new producto[NUMERO_PRODUCTOS];
		
		FileReader manejador = null;
		BufferedReader lector = null;
		
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Introduzca el nombre del archivo que desea leer:");
		String filename = sc.nextLine();
		
		try {
			manejador = new FileReader(filename);
			lector = new BufferedReader(manejador);
			int j = 0;

			
			
			String linea;
			
			while ((linea = lector.readLine()) != null) {
				
				String nombre = "";
				String marca = "";
				String precio = "";
				String cantidad = "";
				
				
				// subcadena nombre del producto
				int i = 0;
				
				
				while (linea.charAt(i) != ',') {
					nombre += linea.charAt(i);
					i++;
				}
				i++;

				// subcadena marca del producto
				while (linea.charAt(i) != ',') {
					marca += linea.charAt(i);
					i++;
				}
				i++;

				// subcadena precio del producto
				while (linea.charAt(i) != ',') {
					precio += linea.charAt(i);
					i++;
				}
				i++;

				// subcadena cantidad del producto
				while (i < linea.length()) {
					cantidad += linea.charAt(i);
					i++;
				}
				i++;
				
				listaProductos[j]= new producto(nombre,marca, Double.parseDouble(precio), Integer.parseInt(cantidad));
				j++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No esta el archivo zuprim");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Ha petao la lectura de texto");
			e.printStackTrace();
		} finally {
			lector.close();
		}
		return listaProductos;
	}


	public static producto [] modificadorArchivos(producto [] listaProductos) {
		int i = 0;
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("Introduzca el nombre del producto que desea modificar:");
		String productoNuevo = sc.next();
		while (i<listaProductos.length) {
			if (listaProductos[i].getNombre().contains(productoNuevo)) {
				System.out.println("Introduce el nombre del producto a cambiar:");
					listaProductos[i].setNombre(sc.next());
				System.out.println("Introduce la marca del producto a cambiar:");
					listaProductos[i].setMarca(sc.next());
				System.out.println("Introduce el precio del producto a cambiar(usando ,):");
					listaProductos[i].setPrecio(sc.nextDouble());
				System.out.println("Introduce la cantidad del producto a cambiar:");
					listaProductos[i].setCantidad(sc.nextInt());
		}
			i++;
	}

		return listaProductos;
	}
	
	public static void mostrarArchivo (producto [] listaProducto) {
		int i = 0;
		while (i<listaProducto.length) {
		System.out.println(listaProducto[i].toString());
		i++;
		}
	}
	
}

	
/*

	}

}
try {
	manejador = new FileReader(filename);
	lector = new BufferedReader(manejador);
	escribidor = new PrintWriter(filename);

	String linea;
	while ((linea = lector.readLine()) != null) {


		
		String copia = listaProductos[j].getNombre() +", "+ listaProductos[j].getMarca() +", "+ listaProductos[j].getPrecio() +", "+ listaProductos[j].getCantidad();
		escribidor.println(copia);
		System.out.println(listaProductos[j].toString());
		j++;
		
		
		

	}
} catch (FileNotFoundException e) {
	System.out.println("No esta el archivo zuprim");
	e.printStackTrace();
} catch (IOException e) {
	System.out.println("Ha petao la lectura de texto");
	e.printStackTrace();
} finally {
	if (escribidor!=null) {
		escribidor.close();
	}
}

return;
				*/