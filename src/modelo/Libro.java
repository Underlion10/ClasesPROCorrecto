package modelo;

public class Libro {
	
	//Creo las propiedades de la clase
	
	private int id;
	private String titulo;
	private float precio;
	
	//Creo el constructor de objetos de la clase Libro
	
	public Libro() {
		super();
	}
	
	//Desarrollo getters y setter para obtener y determinar los valores de las propiedades privadas de la clase 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	

}
