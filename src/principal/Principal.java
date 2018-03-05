package principal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import auxiliar.Practicas;
import examen1EV.Metodos;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Libro;
import modelo.Persona;
import modelo.Vehiculo;

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
		
		//ArrayList<ArrayList<Integer>> arrayTrans = practicas.transArrayIntoArrayList(visitantesYear);
		
		//HashMap<String, Estudiante> estudiantesMapa = practicas.introMapas();
		HashMap<String,Estudiante> estudiantesLista = practicas.leerFichero();
//		System.out.println(estudiantesLista.get("MARÍA NAVARRO GÓMEZ").toString());
		practicas.calcularEdad("10052000");
		// Prueba ordenar ArrayList
		ArrayList<Integer> edades = new ArrayList<Integer>();
		edades.add(34);
		edades.add(20);
		edades.add(19);
		edades.add(53);
		edades.add(12);
		practicas.ordenarArrayList(edades);
		//FIN prueba ordenar ArrayList
		
		//Prueba ordenar HashMap
		HashMap<Integer, Integer> edadPeso = new HashMap<Integer, Integer>();
		edadPeso.put(23, 65);
		edadPeso.put(15, 50);
		edadPeso.put(45, 75);
		edadPeso.put(10, 30);
		edadPeso.put(19, 69);
		practicas.ordenarHashMapKey(edadPeso);
		ArrayList<Float> movs = new ArrayList<Float>();
		movs.add(20f);
		movs.add(30f);
		float saldo = practicas.calculaSaldo(45, movs);
		//FIN prueba ordenar HashMap
		
		//OrdenarHashMapPorValue
		HashMap<Integer, Integer> mapa = practicas.ordenarHashMapValue();
		
		//FIN OrdenarHashMapPorValue
		
		//Prueba Matrices con ArrayList
		ArrayList<ArrayList<Integer>> edadesMatriz = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> edades1 = new ArrayList<Integer>();
		edades1.add(34);
		edades1.add(20);
		edades1.add(19);
		edades1.add(53);
		edades1.add(12);
		ArrayList<Integer> edades2 = new ArrayList<Integer>();
		edades2.add(34);
		edades2.add(20);
		edades2.add(19);
		edades2.add(53);
		edades2.add(12);
		ArrayList<Integer> edades3 = new ArrayList<Integer>();
		edades3.add(35);
		edades3.add(26);
		edades3.add(17);
		edades3.add(59);
		edades3.add(15);
		edadesMatriz.add(edades1);
		edadesMatriz.add(edades2);
		edadesMatriz.add(edades3);
		
		practicas.recorrerMatrizIrregularPorColumnas2(edadesMatriz);
		
		//Fin Prueba Matrices con ArrayList
		//Prueba ordenar ArrayList
		ArrayList<String> cadenasDes = new ArrayList<String>();
		cadenasDes.add("gorra");
		cadenasDes.add("tuberculo");
		cadenasDes.add("arbelo");
		cadenasDes.add("junco");
		practicas.ordenaCadenas(cadenasDes);
		//Fin prueba ordenar ArrayList
		
		//Prueba ordenar ArrayList de personas por nombre
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Persona pers1 = new Persona("23n", "Juan",'N', LocalDate.now(), 0, null, null);
		Persona pers2 = new Persona("23n", "Marc",'N', LocalDate.now(), 0, null, null);
		Persona pers3 = new Persona("23n", "Alm",'N', LocalDate.now(), 0, null, null);
		Persona pers4 = new Persona("23n", "Crist",'N', LocalDate.now(), 0, null, null);
		personas.add(pers1);
		personas.add(pers2);
		personas.add(pers3);
		personas.add(pers4);
		practicas.ordenarPersonas(personas);
		//Fin Prueba ordenar ArrayList de personas por nombre
		
		//boolean correcto = practicas.generarArchivoLanzamiento(20, "C:\\Users\\lione\\Desktop\\EjerciciosClase2DA-Evaluacion\\src\\LanzamientoRes.txt");
//		ArrayList<Estudiante> ests = new ArrayList<Estudiante>();
//		ests.add(new Estudiante(21343, "ghgh", "abadia", 'F', LocalDate.now(), 56, null, null));
//		ests.add(new Estudiante(21343, "ghgh", "abaco", 'F', LocalDate.now(), 56, null, null));
//		ests.add(new Estudiante(21343, "ghgh", "abano", 'F', LocalDate.now(), 56, null, null));
//		ests.add(new Estudiante(21343, "ghgh", "asaid", 'F', LocalDate.now(), 56, null, null));
//		ArrayList<Estudiante> estus= practicas.escribirObjetoFichero(ests, "C:\\Users\\lione\\Desktop\\EjerciciosClase2DA-Evaluacion\\src\\ficheros\\objetos.obj");
		ArrayList<Vehiculo> vehiculos = practicas.leerFicheroVehiculo("src/ficheros/vehiculos.txt");
		practicas.crearArchivoObjetos(vehiculos, "src/ficheros/Objetosvehiculos.obj");
		ArrayList<Vehiculo> listaLectura = practicas.leerArchivoObjetos("src/ficheros/Objetosvehiculos.obj");
		practicas.crearFicheroListaVehiculos("src/ficheros/ALVehiculos.obj", vehiculos);
		ArrayList<Vehiculo> vehiculosAL = practicas.leerALVehiculosDesdeFichero("src/ficheros/ALVehiculos.obj");
		float saldoFinal = practicas.calculaSaldoList(125.3f, "src/ficheros/movimientos.txt");
		System.out.println(saldoFinal);
		// Prueba escribirIslaYear
		HashMap<String, ArrayList<Float>> visitantesIsla = practicas.guardarFicheroHashMap("src/ficheros/visitantes.txt");
		//Fin prueba
		HashMap<String, Float> visitantesMedia = practicas.mediaVisitantesMes(visitantesIsla);
		TreeMap<String, ArrayList<Float>> visitantesMes = practicas.visitantesMesIsla("src/ficheros/visitantes.txt");
		practicas.imprimirVisitantesIslaMesOrdenado(visitantesIsla);
		
		// Escritura fichero objetos
		practicas.copiarFicheroObjetoDesdeFicheroTexto("src/ficheros/FicheroVehiculos.txt",
				"src/ficheros/vehiculos.txt");
		practicas.obtenerFicheroVehiculo("src/ficheros/VehiculosDesdeFichero.txt",
				"src/ficheros/FicheroVehiculos.txt");
		System.out.println("fin");
	}

}

