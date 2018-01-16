package examen1EV;

import java.util.ArrayList;
import java.util.Random;

import modelo.Libro;

public class Metodos {

	// ejercicio 1
	
	public char metodo1(int numero) {
		
		//Creo una variable letraDNI ddonde almacenaré la letra obtenida y será la que devuelva este metodo
		char letraDNI;
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };
		
		String numeroDNI = numero + "";
		
		//Compruebo que el numero introducido no sea ni superior ni inferior a ocho dígitos
		
		if(numeroDNI.length() != 8) {
			return '1';
		}
		
		//Almaceno el numero obtenido del modulo de el nuestro validado y 23.
		
		int resto = numero%23;
		
		// Finalmente almaceno la letra en la posicion del array de letrasValidas correspondiente
		// al valor obtenido de la operación anterior y devuelvo la letra.
		
		letraDNI = letrasValidas[resto];
		
		return letraDNI;
	}

	// ejercicio 2
	
	public Libro[] metodo2(String[] libros) {
		// Genero un array de libros donde almacenaré los libros y que será el que devuelva este metodo
		Libro[] Libros = new Libro[libros.length];
		for (int i = 0; i < libros.length; i++) {
			// Genero un libro donde almacenaré los valores obtenidos de dividir la cadena 
			// pasada por parametro libros, obteniendo id, titulo, precio
			Libro libro1 = new Libro();
			String[] libroPartes = libros[i].split("#");
			libro1.setTitulo(libroPartes[1]);
			// Compruebo que los valores introducidos de id y precio sean correctos (try/catch) 
			// y devuelvo null en caso contrario
			try {
				int id = Integer.parseInt(libroPartes[0]);
				float precio = Float.parseFloat(libroPartes[2]);
				libro1.setId(id);
				libro1.setPrecio(precio);
			} catch(NumberFormatException e) {
				continue;
			}
			
			// Finalmente almaceno el libro generado y con valores correctos en el array de libros
			
			Libros[i] = libro1;
		}
		
		// Devuelvo el array de Libros. 
		return Libros;
	}
	
	// ejercicio 2 Con ArrayList
	
	public ArrayList<Libro> metodo2(ArrayList<String> libros) {
		// Genero un array de libros donde almacenaré los libros y que será el que devuelva este metodo
		ArrayList<Libro> Libros = new ArrayList<Libro>(libros.size());
		for (int i = 0; i < libros.size(); i++) {
			// Genero un libro donde almacenaré los valores obtenidos de dividir la cadena 
			// pasada por parametro libros, obteniendo id, titulo, precio
			Libro libro1 = new Libro();
			String[] libroPartes = libros.get(i).split("#");
			libro1.setTitulo(libroPartes[1]);
			// Compruebo que los valores introducidos de id y precio sean correctos (try/catch) 
			// y devuelvo null en caso contrario
			try {
				int id = Integer.parseInt(libroPartes[0]);
				float precio = Float.parseFloat(libroPartes[2]);
				libro1.setId(id);
				libro1.setPrecio(precio);
			} catch(NumberFormatException e) {
				continue;
			}
			
			// Finalmente almaceno el libro generado y con valores correctos en el array de libros
			
			Libros.set(i, libro1);
		}
		
		// Devuelvo el array de Libros. 
		return Libros;
	}
	
	
	
	// ejercicio 3
	
	public int[][] metodo3(int jugadores, int partidas){
		
		// Genero una matríz con nº de filas = jugadores y nº de columnas = partidas.
		int[][] partidasJugadas = new int[jugadores][partidas];
		// Genero un objeto de la clase Random con el que obtendremos los valores aleatorios del 1 al 6
		Random rnd = new Random();
		
		for(int j = 0; j < partidasJugadas[0].length; j++) {
			for(int i = 0; i < partidasJugadas.length; i++) {
				// Genero los numeros aleatorios desde el 1 hasta el 6 y los almaceno en la matriz. 
				partidasJugadas[i][j] = rnd.nextInt(6) + 1;
			}
		}
		
		// Devuelvo la matriz de partidas.
		return partidasJugadas;
	}
	
	// ejercicio 3 ArrayList
	
	public ArrayList<ArrayList<Integer>> metodo3List(int jugadores, int partidas){
		
		// Genero una matríz con nº de filas = jugadores y nº de columnas = partidas.
		ArrayList<ArrayList<Integer>> partidasJugadas = new ArrayList<ArrayList<Integer>>(jugadores*partidas);
		// Genero un objeto de la clase Random con el que obtendremos los valores aleatorios del 1 al 6
		Random rnd = new Random();
		
		for(int j = 0; j < partidasJugadas.size(); j++) {
			for(int i = 0; i < partidasJugadas.size(); i++) {
				// Genero los numeros aleatorios desde el 1 hasta el 6 y los almaceno en la matriz. 
				partidasJugadas.set(rnd.nextInt(6)+1, partidasJugadas.get(j));
			}
		}
		
		// Devuelvo la matriz de partidas.
		return partidasJugadas;
	}
	
	
	

	
		

	
}
