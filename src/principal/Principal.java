package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import auxiliar.Practicas;
import examen1EV.Metodos;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Libro;
import modelo.Persona;
import modelo.Profesor;

public class Principal {
	// metodo por el que debe empezar la ejecución ..
	public static void main(String[] args) {
		/*
		 * Persona persona; persona = new Persona();
		 * 
		 * persona.setNombre("Manolo"); System.out.println("nif : " + persona.getNif());
		 * System.out.println("nombre : " + persona.getNombre());
		 * System.out.println("altura : " + persona.getAltura());
		 * System.out.println("persona1 creada");
		 */
		/*
		 * Persona padre = new Persona(); padre.setNombre("JorgePadre");
		 * padre.setSexo('M'); Persona madre = new Persona();
		 * madre.setNombre("MariaMadre"); madre.setNif("44567981H"); madre.setSexo('F');
		 */

		/*
		 * Persona persona2 = new Persona("43897124R", "PEPE", 'F', LocalDate.of(1999,
		 * 9, 21), 170, padre, madre); System.out.println("persona2 creada");
		 * System.out.println("Nombre madre : " + persona2.getMadre().getNombre());
		 */
		// crear un Estudiante

		Estudiante estAnonimo = new Estudiante(123);

		

		//Estudiante[] listaEstudiantes = { estAnonimo, estudiante, estudiante2, estudiante3 };

		Practicas practicas = new Practicas();
		//practicas.ordenaEstudiantes(listaEstudiantes);

		// new Practicas().muestraNumerosDe1A1000();
		// practicas.muestraNumerosDe1A1000();
		// practicas.muestraNumeros3(20, 25);
		// practicas.generaAleatorios2(3,10,11);
		// practicas.estadisticaCadena("Las&%=\" PalmAs\\ de Gran CanarIa");
		// int [] numeros=practicas.generaAleatorios3(100, 1, 6);
		// int[] frecuencia = practicas.frecuenciaAparicion(100, 1, 8);
		// practicas.listaDiasSemana();
		// Estudiante[] lista = new Datos().getEstudiantes();
		// practicas.listaEstudiantes(new Datos().getEstudiantes());
		int[][] visitantesYear = { { 2, 4, 5, 1, 3, 2, 1, 1, 1, 3, 5, 1 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 12 },
				{ 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 13 }, { 23, 4, 56, 12, 32, 23, 17, 12, 11, 34, 45, 10 },
				{ 23, 3, 56, 12, 32, 23, 17, 12, 11, 34, 45, 45 }, { 23, 1, 56, 12, 32, 23, 17, 12, 11, 34, 45, 37 }

		};
		String[] islas = { "GC", "LTE", "FTV", "TFE", "LPA", "GOM", "HIE" };
		String[] meses = { "ENE", "FEB", "MAR", "ABR", "MAY", "JUN", "JUL", "AGO", "SEP", "OCT", "NOV", "DIC" };

		/*
		 * int isla=2; int mes =7; System.out.println("Visitantes en "+ islas[isla]
		 * +" : " + practicas.visitantesIslaYear(isla, visitantesYear));
		 * System.out.println("Visitantes  en Canarias en el mes " + meses[mes]+ " : " +
		 * practicas.visitantesMesYear(mes, visitantesYear));
		 */

		/*
		 * String[] misDatos = { "123","abc", "345", "1x2", "990" }; //int[] res =
		 * practicas.convierteCadenasANumeros(misDatos); float saldo= 1000.0f; float[]
		 * movimientos= {10.0f, -5.0f,20.5f};
		 * 
		 * float saldoFinal = practicas.calculaSaldo(saldo, movimientos);
		 */
		int[] datos = practicas.generaAleatorios3(500, 1, 500);
		// practicas.ordenaEnteros(datos);
		// Arrays.sort(datos);
		String[] cadenas = { "perro", "gato", "alce" };
		practicas.ordenaCadenas(cadenas);
		int[] array2 = { 3, 6, 9, 9, 9, 15, 29 };
		int[] array1 = { 1, 2, 9, 9, 25, 39, 56, 67, 99 };
		int[] arrayMezclado = practicas.mezclaArrays(array1, array2);
		// liga
		String[][] goles = new Datos().getResultados();

		int[] clasificacion = practicas.obtenerClasificacion2(goles);
		String[] equipos = new Datos().getEquipos();
		practicas.ordenaClasificacion(clasificacion, equipos);
		for (int i = 0; i < equipos.length; i++) {
			//System.out.println(equipos[i] + " \t" + clasificacion[i]);

		}
		int[][] puntosJornadas = new Datos().getPuntosJornada();
		Equipo[] clasi = practicas.obtenerClasificacion3(puntosJornadas);
		String nif = "345239";
	//	System.out.println(practicas.validarNif(nif)?"OK":"KO");
		int x=67;
		//System.out.println("El numero "+ x + (practicas.esPrimo(x)?" ES ":" NO ES ")+ " PRIMO" );
		int[][] matriz = {
				{3,4,8},
				{6},
				{5,9}
		};
		Integer[][] matriz2 = {
				{3,4,null,8,null,12,37,null},
				{6,7,12,null,34,21,null,11},
				{5,null,9}
		};
	//	practicas.recorrerMatrizIrregularPorColumnas(matriz);
		//practicas.recorrerMatrizIrregularPorColumnas2(matriz2);
		//int[] primos = practicas.numerosPrimos(100);
		//int [] fibonacci = practicas.numerosFibonacci(20);
		
		//Pruebas Examen 
		
		Metodos metodo = new Metodos();
		
		char letraDNI = metodo.metodo1(45396285);
		
		String[] libros = 
			{"2#EL QUIJOTE DE LA MANCHA#16.25",
			"X#LOS PILARES DE LA TIERRA#18.50",
			"2#ODISEA EN EL ESPACIO#16.X",
			"5#LOS PILARES DE LA TIERRA#18.50"
			};
		
		Libro[] libreria = metodo.metodo2(libros);
		int[][] partidasJugadas = metodo.metodo3(5, 3);
		
		//FIN Pruebas examen
		
		practicas.ordenaEstudiantes(practicas.introlistas());
		
		ArrayList<String> cadenas1 = new ArrayList<String>();
		cadenas1.add("sdf");
		cadenas1.add("adc");
		cadenas1.add("gjh");
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(46);
		numbers.add(13);
		numbers.add(34);
		practicas.ordenaEnteros(numbers);
		
		practicas.ordenaClasificacion(numbers, cadenas1);
		
		//ArrayList<Integer> numeros = practicas.convierteCadenasANumeros(cadenas1);
		
		ArrayList<ArrayList<Integer>> arrayTrans = practicas.transArrayIntoArrayList(visitantesYear);
		
		HashMap<String, Estudiante> estudiantesMapa = practicas.introMapas();
		HashMap<String,Estudiante> estudiantesLista = practicas.leerFichero();
		
		System.out.println("fin");

	}

}

