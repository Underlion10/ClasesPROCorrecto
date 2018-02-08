package auxiliar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import modelo.Datos;
import modelo.Equipo;
import modelo.Estudiante;
import modelo.Persona;
import modelo.Vehiculo;

public class Practicas {
	// private static String[] diasSemana = { "lunes", "martes", "miercoles",
	// "jueves", "viernes", "sábado", "domingo" };

	// 2DA EVALUACION//

	// MAPA
	
	//620430873
	
	//Variante ejercicio anterior
	
	public void crearFicheroListaVehiculos(String ruta, ArrayList<Vehiculo> vehiculos) {
		ObjectOutputStream or;
		try {
			FileOutputStream fr = new FileOutputStream(ruta);
			or = new ObjectOutputStream(fr);
			or.writeObject(vehiculos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Vehiculo> leerALVehiculosDesdeFichero(String ruta) {
		ArrayList<Vehiculo> vehiculos = new ArrayList<Vehiculo>();
		ObjectInputStream or;
		try {
			FileInputStream fr = new FileInputStream(ruta);
			or = new ObjectInputStream(fr);
			while(fr.available() > 0) {
				vehiculos.addAll((ArrayList<Vehiculo>) or.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return vehiculos;
				
	}
	
	//Ejercicio repaso ficherosObjetos
	
	public ArrayList<Vehiculo> leerArchivoObjetos(String ruta){
		ArrayList<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
		ObjectInputStream or;
		try {
			FileInputStream fr = new FileInputStream(ruta);
			or = new ObjectInputStream(fr);
			while(fr.available() > 0) {
				listaVehiculos.add((Vehiculo) or.readObject());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaVehiculos;
		
	}
	
	public void crearArchivoObjetos(ArrayList<Vehiculo> vehiculos, String ruta) {
		ObjectOutputStream or;
		try {
			FileOutputStream fr = new FileOutputStream(ruta);
			or = new ObjectOutputStream(fr);
			for(Vehiculo vehiculo: vehiculos) {
				or.writeObject(vehiculo);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Vehiculo> leerFicheroVehiculo(String ruta){
		ArrayList<Vehiculo> listaVehiculo = new ArrayList<Vehiculo>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(ruta));
			String linea;
			while((linea = br.readLine()) != null) {
				String[] partes = linea.split("%");
				int id = Integer.parseInt(partes[0]);
				String matricula = partes[1];
				int marcaModelo = Integer.parseInt(partes[2]);
				LocalDate fecha = LocalDate.of(Integer.parseInt(partes[3].substring(0, 4)), Integer.parseInt(partes[3].substring(4, 6)),
						Integer.parseInt(partes[3].substring(6, 8)));
				float precio = Float.parseFloat(partes[4]);
				listaVehiculo.add(new Vehiculo(id, matricula, marcaModelo, fecha, precio));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return listaVehiculo;
	}
	
	//Fin ejercicioFicheroObjetos
	
	
	//Ejercicio generarFichero de Estudiantes
	
	
	public ArrayList<Estudiante> escribirObjetoFichero(ArrayList<Estudiante> es, String ruta) {
		
		boolean correcto = true;
		
		//abrimos y creamos el fichero de objetos
		try {
			FileOutputStream br = new FileOutputStream(ruta);
			ObjectOutputStream os = new ObjectOutputStream(br);
			for(Estudiante est: es) {
				os.writeObject(est);
			}
			
			/*tambien se podría haber leído la lista mediante un os.writeObject(es),
			metiendo toda la lista de una sola vez*/
			os.close();
			br.close();
		} catch (FileNotFoundException e) {
			correcto = false;
		} catch (IOException e) {
			correcto = false;
		}
		
		ArrayList<Estudiante> estDev = new ArrayList<Estudiante>();
		
		// leemos el fichero de objetos que hemos creado anteriormente.
		try {
			FileInputStream fr = new FileInputStream(ruta);
			ObjectInputStream os = new ObjectInputStream(fr);
			while(fr.available() > 0) {
				Estudiante est = (Estudiante) os.readObject();
				estDev.add(est);
				System.out.println(est.getNombre());
			}
			fr.close();
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return estDev;
	}
	
	//Fin ejercicio ficheros de Estudiantes
	
	public boolean generarArchivoLanzamiento(int cuantos, String ruta) {
		long time = System.nanoTime();
		boolean correcto = true;
		Random rnd = new Random();
		try {
			BufferedWriter br = new BufferedWriter(new FileWriter(ruta));
			HashMap<Integer,Integer> lanzamientoResultado = new HashMap<Integer, Integer>();
			int contador1 = 0;
			int contador2 = 0;
			int contador3 = 0;
			int contador4 = 0;
			int contador5 = 0;
			int contador6 = 0;
			for(int i = 0; i < cuantos; i++) {
				int lanzamiento = i+1;
				int resultado = rnd.nextInt(6) + 1;
				lanzamientoResultado.put(lanzamiento, resultado);
				switch(resultado) {
				case 1:
					contador1++;
					break;
				case 2:
					contador2++;
					break;
				case 3:
					contador3++;
					break;
				case 4:
					contador4++;
					break;
				case 5:
					contador5++;
					break;
				case 6:
					contador6++;
					break;
				}
				
				try {
					Thread.sleep(rnd.nextInt(500) + 500);
					time += System.nanoTime();
					float acttime = (time/100000000);
					br.write(acttime/10000000 + " segundos de ejecución. ");
				} catch (InterruptedException e) {
					return false;
				}
				br.write(lanzamiento + "#" + resultado + "\n");
			}
			br.write("----Resultados----\n");
			br.write("El dado ha sido lanzado " + cuantos + " veces.\n");
			br.write("El numero 1 ha aparecido " + contador1 + " veces.\n");
			br.write("El numero 2 ha aparecido " + contador2 + " veces.\n");
			br.write("El numero 3 ha aparecido " + contador3 + " veces.\n");
			br.write("El numero 4 ha aparecido " + contador4 + " veces.\n");
			br.write("El numero 5 ha aparecido " + contador5 + " veces.\n");
			br.write("El numero 6 ha aparecido " + contador6 + " veces.\n");
			br.write(System.currentTimeMillis() + "");
			br.close();
		} catch (IOException e) {
			correcto = false;
		}
		return correcto;
	}
	
	//Fin ejercicioGenerarFichero
	
	//Calcular Ed
	//Ordenacion HashMap y ArrayList
	
	public void ordenarPersonas(ArrayList<Persona> personas) {
		for(int i = 0; i<personas.size()-1;i++) {
			for(int j = i+1; j<personas.size(); j++) {
				if(personas.get(i).compareTo(personas.get(j)) > 0) {
					Persona aux = personas.get(j);
					personas.set(j, personas.get(i));
					personas.set(i, aux);
				}
			}
		}
	}
	
	public HashMap<Integer, Integer> ordenarHashMapValue() {
		HashMap<Integer, Integer> mapa = new HashMap<Integer, Integer>();
		mapa.put(30, 10);
		mapa.put(2, 8);
		mapa.put(1, 16);
		ArrayList<Integer> misMapValues = new ArrayList<Integer>(mapa.values());
		Collections.sort(misMapValues);
		Set<Integer> claves = mapa.keySet();
		return mapa;
	}
	
	public void ordenarHashMapKey(HashMap<Integer, Integer> mapa) {
		TreeMap<Integer, Integer> mapaOrdenado = new TreeMap<Integer, Integer>(mapa);
		SortedMap<Integer, Integer> mapaSorted = new TreeMap<Integer, Integer>(mapa);
		System.out.println(mapaSorted);
	}
	
	public void ordenarArrayList(ArrayList<Integer> lista) {
		Collections.sort(lista);
	}
	
	public int calcularEdad(String fechaNacimiento) {
		DateTimeFormatter fat = DateTimeFormatter.ofPattern("ddMMyyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fat);
		LocalDate now = LocalDate.now();
		Period period = Period.between(fechaNac, now);
		
		System.out.println(period.getYears() + " años, " + period.getMonths() + " meses, " + period.getDays() + " días.");
		return period.getYears();
	}
	
	public HashMap<String, Estudiante> leerFichero() {
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		HashMap<String, Estudiante> mapaEstudiantes = new HashMap<String, Estudiante>();
		int year = 0;
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/ficheros/persona.txt"));
			while(in.ready()) {
				String linea = in.readLine();
				String[] partes = linea.split("-");
				int codGrupo = Integer.parseInt(partes[0]);
				String nif = partes[1];
				String nombre = partes[2];
				String fechaNacimiento = partes[3];
				year += calcularEdad(fechaNacimiento);
				String sexo = partes[4];
				Estudiante est1 = new Estudiante(codGrupo, nif, nombre, sexo.charAt(0), LocalDate.of(Integer.parseInt(fechaNacimiento.substring(4,8)), 
						Integer.parseInt(fechaNacimiento.substring(2,4)), Integer.parseInt(fechaNacimiento.substring(0,2))), 180, null, null);
				estudiantes.add(est1);
				mapaEstudiantes.put(est1.getNombre(), est1);
			}
			in.close();		
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		year = (int) year/estudiantes.size();
		System.out.println(year);
		return mapaEstudiantes;
	}
	
	public ArrayList<ArrayList<String>> probarMatrizAL(String[][] nombres){
		ArrayList<ArrayList<String>> nombresAL = new ArrayList<ArrayList<String>>();
		
		for(String[] nombreC: nombres) {
			ArrayList<String> names = new ArrayList<String>();
			for(String nombre: nombreC) {
				names.add(nombre);
			}
			
			nombresAL.add(names);
		}
		
		return nombresAL;
	}
	
	public HashMap<String,Persona> realizarList(ArrayList<String> nombres){
		HashMap<String,Persona> personasX = new HashMap<String,Persona>();
		ArrayList<Persona> personas = new ArrayList<Persona>();
		
		for(String nombre: nombres) {
			Persona persona = new Estudiante(23,"345690N",nombre,'M',null,178,null,null);
			personas.add(persona);
		}
		
		for(Iterator<Persona> iterador = personas.iterator(); iterador.hasNext();) {
			Persona personaAct = iterador.next();
			personasX.put(personaAct.getNombre(), personaAct);
		}
		
		return personasX;
	}
	
	public ArrayList<String> realizarIterator(ArrayList<Persona> personas) {
		ArrayList<String> nombres = new ArrayList<String>();
		for (Iterator<Persona> iterator = personas.iterator(); iterator.hasNext();) {
			nombres.add(iterator.next().getNombre());
		}
		return nombres;
	}
	
	public HashMap<Integer, Persona> crearMapaValores(ArrayList<Persona> personas){
		HashMap<Integer,Persona> mapaPersonas = new HashMap<Integer, Persona>();
		for(Persona persona: personas) {
			mapaPersonas.put(persona.getAltura(), persona);
		}
		
		return mapaPersonas;
		//
	}

	public HashMap<String, Estudiante> introMapas() {
		// La clave representa el nif del Estudiante.
		HashMap<String, Estudiante> resultado = new HashMap<String, Estudiante>();
		Estudiante est1 = new Estudiante(2, "123456769N", "Paco", 'M', null, 180, null, null);
		Estudiante est2 = new Estudiante(2, "123456780H", "Paco", 'M', null, 180, null, null);
		resultado.put(est1.getNif(), est1);
		resultado.put(est2.getNif(), est2);
		resultado.put("123456789N", new Estudiante(2, "123456789N", "Pipi", 'M', null, 180, null, null));
		
		Set<String> claves = resultado.keySet();
		
		for(String clave: claves) {
			System.out.println(resultado.get(clave).getNombre());
		}
		return resultado;
	}
	// ArrayList

	public ArrayList<Integer> numerosFibonacciList(int cuantos) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		int x = 0;
		int y = 1;
		numeros.add(x);
		numeros.add(y);
		for (int i = 2; i < cuantos; i++) {
			int z = x + y;
			numeros.set(i, z);
			x = y;
			y = z;
		}
		return numeros;
	}

	public float calculaSaldoList(float saldoInicial, ArrayList<Float> movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.size(); i++)
			saldoFinal += movimientos.get(i);
		return saldoFinal;
	}

	public ArrayList<ArrayList<Integer>> transArrayIntoArrayList(int[][] visitantesMesYear) {
		ArrayList<ArrayList<Integer>> arrayTrans = new ArrayList<ArrayList<Integer>>();

		// MUY IMPORTANTE
		for (int[] fila : visitantesMesYear) {
			// Se debe crear para almacenar el valor en cada una de las filas.
			ArrayList<Integer> filaLista = new ArrayList<Integer>();
			for (int num : fila) {
				filaLista.add(num);
			}
			arrayTrans.add(filaLista); // la creamos al terminar cada una de las iteraciones de filaLista para que se
										// almacene correctamente
		}
		return arrayTrans;
	}

	public void ordenaCadenas(ArrayList<String> cadenas) {
		for (int i = 0; i < cadenas.size() - 1; i++)
			for (int j = i + 1; j < cadenas.size(); j++)
				if (cadenas.get(i).compareTo(cadenas.get(j)) > 0) {
					String aux = cadenas.get(i);
					cadenas.set(i, cadenas.get(j));
					cadenas.set(j, aux);
				}
	}

	public void recorrerMatrizIrregularPorColumnas2(ArrayList<ArrayList<Integer>> matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.size(); i++) {
			if (matriz.get(i).size() > JMAX)
				JMAX = matriz.get(i).size();
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.size(); i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j).byteValue());
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}

			}
		}
	}

	public void recorrerMatrizIrregularPorColumnas(ArrayList<ArrayList<Integer>> matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.size(); i++) {
			if (matriz.get(i).size() > JMAX)
				JMAX = matriz.get(i).size();
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.size(); i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz.get(i).get(j));
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}
	}

	public float calculaSaldo(float saldoInicial, ArrayList<Float> movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.size(); i++)
			saldoFinal += movimientos.get(i);
		return saldoFinal;
	}

	public ArrayList<Integer> mezclaArrays(ArrayList<Integer> l1, ArrayList<Integer> l2) {
		int i = 0, j = 0, k = 0;
		ArrayList<Integer> resultado = new ArrayList<Integer>();

		while (l1.get(i) != Integer.MAX_VALUE || l2.get(j) != Integer.MAX_VALUE) {
			if (l1.get(i) < l2.get(j))
				resultado.set(k, l1.get(i++));
			else
				resultado.set(k, l2.get(j++));
			k++;

			if (i == l1.size())
				l1.set(--i, Integer.MAX_VALUE);

			if (j == l2.size())
				l2.set(--j, Integer.MAX_VALUE);
		}
		return resultado;
	}

	public int visitantesIslaYear(int isla, ArrayList<ArrayList<Integer>> v) {
		int acu = 0;
		for (int j = 0; j < v.size(); j++)
			acu += v.get(isla).get(j);
		return acu;
	}

	public ArrayList<Equipo> obtenerClasificacion3(ArrayList<ArrayList<Integer>> puntosJornadas) {
		ArrayList<Equipo> clasificacion = new ArrayList<Equipo>();
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas.size(); j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.size(); i++)
				e.setPuntos(e.getPuntos() + puntosJornadas.get(i).get(j));
			clasificacion.set(j, e);
		}

		return clasificacion;
	}

	public ArrayList<Integer> obtenerClasificacion2(ArrayList<ArrayList<String>> goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		ArrayList<Integer> puntos = new ArrayList<Integer>();
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int j = 0; j < goles.size(); j++)
			for (int i = 0; i < goles.size(); i++)
				if (goles.get(i).get(j).indexOf('-') != -1) {
					resultado = goles.get(i).get(j).split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos.set(i, puntos.get(i) + 3);
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos.set(j, puntos.get(j) + 3);
					else { // empate
						puntos.set(i, puntos.get(i) + 1);
						puntos.set(j, puntos.get(j) + 1);
					}
				}
		return puntos;
	}

	public ArrayList<Integer> obtenerClasificacion(ArrayList<ArrayList<String>> goles) {
		ArrayList<Integer> puntos = new ArrayList<Integer>();
		int golesLocal;
		int golesVisitante;
		String[] resultado;
		// recorrer la matriz de goles
		for (int i = 0; i < goles.size(); i++)
			for (int j = 0; j < goles.size(); j++)
				if (goles.get(i).get(j).indexOf('-') != -1) {
					resultado = goles.get(i).get(j).split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos.set(i, puntos.get(i) + 3);
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos.set(j, puntos.get(j) + 3);
					else { // empate
						puntos.set(i, puntos.get(i) + 1);
						puntos.set(j, puntos.get(j) + 1);
					}
				}
		return puntos;

	}

	public void ordenaEnteros(ArrayList<Integer> numeros) {
		for (int i = 0; i < numeros.size() - 1; i++)
			for (int j = i + 1; j < numeros.size(); j++)
				if (numeros.get(i) > numeros.get(j)) {
					int aux = numeros.get(i);
					numeros.set(i, numeros.get(j));
					numeros.set(j, aux);
				}
	}

	public void ordenaClasificacion(ArrayList<Integer> numeros, ArrayList<String> equipos) {
		for (int i = 0; i < numeros.size() - 1; i++)
			for (int j = i + 1; j < numeros.size(); j++)
				if (numeros.get(i) > numeros.get(j)) {
					int aux = numeros.get(i);
					numeros.set(i, numeros.get(j));
					numeros.set(j, aux);
					String aux2 = equipos.get(i);
					equipos.set(i, equipos.get(j));
					equipos.set(j, aux2);
				}
	}

	public ArrayList<Integer> convierteCadenasANumeros(ArrayList<String> cadenas) {
		ArrayList<Integer> resultado = new ArrayList<Integer>();
		for (String cadena : cadenas) {

			try {

				resultado.add(Integer.parseInt(cadena));
			} catch (NumberFormatException e) {

				resultado.add(-1);
			}
		}
		return resultado;
	}

	public void ordenaEstudiantes(ArrayList<Estudiante> estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.size() - 1; i++)
			for (int j = i + 1; j < estudiantes.size(); j++)
				if (estudiantes.get(i).compareTo(estudiantes.get(j)) > 0) {
					Estudiante aux = estudiantes.get(i);
					estudiantes.set(i, estudiantes.get(j));
					estudiantes.set(j, aux);
				}
	}

	public ArrayList<Estudiante> introlistas() {
		ArrayList<Estudiante> listaE = new ArrayList<Estudiante>();
		Estudiante est1 = new Estudiante(3);

		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);
		listaE.add(est1);

		Estudiante est2 = new Estudiante(324234);

		listaE.add(0, est2);
		int size = listaE.size();
		listaE.remove(size - 1);
		listaE.set(0, est1);

		for (Estudiante estudiante : listaE) { // Prueba con el for-each
			System.out.println(estudiante.getCodGrupo());
		}

		for (int i = 0; i < listaE.size(); i++) {
			System.out.println(listaE.get(i).getCodGrupo());
		}

		System.out.println("FIN");

		return listaE;

	}

	// FIN 2DA EVALUACIÓN//

	// 1ERA EVALUACION//

	public boolean esPrimo(int numero) {

		for (int i = 2; i < numero; i++) {
			if (numero % i == 0)
				return false;
		}

		return true;
	}

	public int[] numerosPrimos(int cuantos) {
		int[] primos = new int[cuantos];
		int i = 0;
		int j = 1;
		while (i < cuantos) {
			if (esPrimo(j))
				primos[i++] = j;
			j++;
		}
		return primos;
	}

	public int[] numerosFibonacci(int cuantos) {
		int[] numeros = new int[cuantos];
		int x = 0;
		int y = 1;
		numeros[0] = x;
		numeros[1] = y;
		for (int i = 2; i < cuantos; i++) {
			int z = x + y;
			numeros[i] = z;
			x = y;
			y = z;
		}
		return numeros;
	}

	// LIGA: Obtener clasificación a partir de resultados
	public int[] obtenerClasificacion(String[][] goles) {
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int i = 0; i < goles.length; i++)
			for (int j = 0; j < goles[i].length; j++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public int[] obtenerClasificacion2(String[][] goles) {
		// la diferencia con el anterior es que recorre la
		// matriz por columnas
		int[] puntos = new int[5];
		int golesLocal;
		int golesVisitante;
		String[] resultado = null;
		// recorrer la matriz de goles
		for (int j = 0; j < goles[0].length; j++)
			for (int i = 0; i < goles.length; i++)
				if (goles[i][j].indexOf('-') != -1) {
					resultado = goles[i][j].split("-");
					golesLocal = Integer.parseInt(resultado[0]);
					golesVisitante = Integer.parseInt(resultado[1]);
					if (golesLocal > golesVisitante)
						// suma 3 al local
						puntos[i] += 3;
					else if (golesLocal < golesVisitante)
						// suma 3 al visitante
						puntos[j] += 3;
					else { // empate
						puntos[i] += 1;
						puntos[j] += 1;
					}
				}
		return puntos;
	}

	public Equipo[] obtenerClasificacion3(int[][] puntosJornadas) {
		Equipo[] clasificacion = new Equipo[5];
		String[] equipos = new Datos().getEquipos();
		for (int j = 0; j < puntosJornadas[0].length; j++) {
			Equipo e = new Equipo();
			e.setNombre(equipos[j]);
			e.setPuntos(0);
			for (int i = 0; i < clasificacion.length; i++)
				e.setPuntos(e.getPuntos() + puntosJornadas[i][j]);
			clasificacion[j] = e;
		}

		return clasificacion;
	}

	public boolean validarNif(String nif) {
		char[] letrasValidas = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q',
				'V', 'H', 'L', 'C', 'K', 'E' };

		if (nif.length() != 9)
			return false;
		String numeros = nif.substring(0, 8);
		// System.out.println(numeros);
		int numerosOK;
		try {
			numerosOK = Integer.parseInt(numeros);
		} catch (NumberFormatException e) {
			return false;
		}
		int resto = numerosOK % 23;
		if (letrasValidas[resto] != nif.charAt(8))
			return false;
		return true;
	}

	// ORDENACION
	public void ordenaEnteros(int[] numeros) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] > numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
				}
	}

	public void ordenaClasificacion(int[] numeros, String[] equipos) {
		for (int i = 0; i < numeros.length - 1; i++)
			for (int j = i + 1; j < numeros.length; j++)
				if (numeros[i] < numeros[j]) {
					int aux = numeros[i];
					numeros[i] = numeros[j];
					numeros[j] = aux;
					String aux2 = equipos[i];
					equipos[i] = equipos[j];
					equipos[j] = aux2;
				}
	}
	// mezcla dos arrays ordenados

	public int[] mezclaArrays(int[] l1, int[] l2) {
		int i = 0, j = 0, k = 0;
		int[] resultado = new int[l1.length + l2.length];

		while (l1[i] != Integer.MAX_VALUE || l2[j] != Integer.MAX_VALUE) {
			if (l1[i] < l2[j])
				resultado[k] = l1[i++];
			else
				resultado[k] = l2[j++];
			k++;

			if (i == l1.length)
				l1[--i] = Integer.MAX_VALUE;

			if (j == l2.length)
				l2[--j] = Integer.MAX_VALUE;
		}
		return resultado;
	}

	public void ordenaCadenas(String[] cadenas) {
		for (int i = 0; i < cadenas.length - 1; i++)
			for (int j = i + 1; j < cadenas.length; j++)
				if (cadenas[i].compareTo(cadenas[j]) > 0) {
					String aux = cadenas[i];
					cadenas[i] = cadenas[j];
					cadenas[j] = aux;
				}

	}

	public void ordenaEstudiantes(Estudiante[] estudiantes) {
		// ejemplo de uso de la interfaz Comparable
		// debe implementarse el método compareTo

		for (int i = 0; i < estudiantes.length - 1; i++)
			for (int j = i + 1; j < estudiantes.length; j++)
				if (estudiantes[i].compareTo(estudiantes[j]) > 0) {
					Estudiante aux = estudiantes[i];
					estudiantes[i] = estudiantes[j];
					estudiantes[j] = aux;
				}
	}

	public float calculaSaldo(float saldoInicial, float[] movimientos) {
		float saldoFinal = saldoInicial;
		for (int i = 0; i < movimientos.length; i++)
			saldoFinal += movimientos[i];
		return saldoFinal;
	}

	public int[] convierteCadenasANumeros(String[] cadenas) {
		int[] resultado = new int[cadenas.length];
		for (int i = 0; i < resultado.length; i++) {

			try {

				resultado[i] = Integer.parseInt(cadenas[i]);
			} catch (NumberFormatException e) {

				resultado[i] = -1;
			}
		}
		return resultado;
	}

	public void muestraNumeros() {

		int x = 0;
		while (x <= 1000) {
			System.out.println("x: " + x);
			x++;
		}
	}

	public void muestraNumeros(int min, int max) {

		if (min <= max) {
			int x = min;
			while (x <= max) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros2(int min, int max) {

		if (min <= max) {
			int x = min;
			do {
				System.out.println("x: " + x);
				x++;
			} while (x <= max);
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void muestraNumeros3(int min, int max) {
		int x = min;
		if (min <= max) {
			// for (int x = min; x < max; x++) {
			// for (;;) {
			while (true) {
				System.out.println("x: " + x);
				x++;
			}
		} else
			System.out.println("Error, min debe ser menor que maximo");
	}

	public void generaAleatorios(int cuantos, int inferior, int superior) // max 30, min 10
	{

		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + (int) (Math.random() * (superior - inferior + 1)));

	}

	public void generaAleatorios2(int cuantos, int inferior, int superior) // max 30, min 10
	{

		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
	}

	public int[] generaAleatorios3(int cuantos, int inferior, int superior) // max 30, min 10
	{
		int[] resultado = new int[cuantos];
		Random rnd = new Random();
		for (int i = 0; i < cuantos; i++)
			// System.out.println(inferior + rnd.nextInt(superior - inferior + 1));
			resultado[i] = inferior + rnd.nextInt(superior - inferior + 1);
		return resultado;
	}

	public int[] frecuenciaAparicion(int cuantos, int inferior, int superior) {
		int[] resultado = new int[superior - inferior + 1];
		int[] lanzamientos = this.generaAleatorios3(cuantos, inferior, superior);
		for (int i = 0; i < lanzamientos.length; i++) {
			resultado[lanzamientos[i] - 1]++;
		}
		return resultado;

	}

	public void estadisticaCadena(String cadena) {
		int contadorVocales = 0;
		int contadorMayusculas = 0;
		int contadorEspeciales = 0;
		for (int i = 0; i < cadena.length(); i++) {
			if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' || cadena.charAt(i) == 'o'
					|| cadena.charAt(i) == 'u' || cadena.charAt(i) == 'A' || cadena.charAt(i) == 'E'
					|| cadena.charAt(i) == 'I' || cadena.charAt(i) == 'O' || cadena.charAt(i) == 'U')
				contadorVocales++;
			if (cadena.charAt(i) >= 'A' && cadena.charAt(i) <= 'Z')
				contadorMayusculas++;
			int caracterAscii = cadena.charAt(i);
			if ((caracterAscii >= 0 && caracterAscii <= 47) || (caracterAscii >= 58 && caracterAscii <= 64) ||
					(caracterAscii >= 91) && (caracterAscii <= 96))

				contadorEspeciales++;
		}
		// System.out.println("Hay " + contadorVocales + " vocales en " + cadena);
		System.out.println("Hay " + contadorEspeciales + " caracteres especiales en " + cadena);

	}

	public void listaDiasSemana() {
		Datos datos = new Datos();
		// String[] diasSemana = { "lunes", "martes", "miercoles", "jueves", "viernes",
		// "sábado", "domingo" };
		// for (int i = 0; i < datos.getDiasSemana().length; i++)
		for (String dia : datos.getDiasSemana())
			// System.out.println(datos.getDiasSemana()[i]);
			System.out.println(dia);
	}

	public void listaEstudiantes(Estudiante[] lista) {
		for (Estudiante estudiante : lista) {
			// if (estudiante != null)
			try {
				System.out.println(estudiante.getNombre());
			} catch (NullPointerException e) {

			}
		}
	}

	public int visitantesIslaYear(int isla, int[][] v) {
		int acu = 0;
		for (int j = 0; j < v[0].length; j++)
			acu += v[isla][j];
		return acu;
	}

	public int visitantesMesYear(int mes, int[][] v) {
		int acu = 0;
		for (int i = 0; i < v.length; i++)
			acu += v[i][mes];
		return acu;
	}

	public void recorrerMatrizIrregularPorColumnas(int[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j]);
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				}

			}
		}
	}

	public void recorrerMatrizIrregularPorColumnas2(Integer[][] matriz) {
		int JMAX = 0;
		// obtenemos el numero maximo de columnas
		for (int i = 0; i < matriz.length; i++) {
			if (matriz[i].length > JMAX)
				JMAX = matriz[i].length;
		}

		for (int j = 0; j < JMAX; j++) {
			for (int i = 0; i < matriz.length; i++) {
				try {
					System.out.println("[" + i + "][" + j + "]: " + matriz[i][j].byteValue());
				} catch (ArrayIndexOutOfBoundsException e) {
					continue;
				} catch (NullPointerException e) {
					continue;
				}

			}
		}
	}
}
