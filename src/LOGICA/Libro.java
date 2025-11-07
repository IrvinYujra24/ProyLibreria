package LOGICA;

import java.util.List;

import DATOS.LibroDb;

public class Libro {
	private String titulo;
	private String autor;
	private String isbn;
	private int idLibro;
	
	
	/*
	 * Este constructor no se utiliza desde la capa presentación, solo será usado desde la base de datos.
	 * */
	public Libro(String titulo, String autor, String isbn, int idLibro) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
		this.idLibro = idLibro;
	}


	public Libro(String titulo, String autor, String isbn) {	
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}


	public Libro() {		
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getAutor() {
		return autor;
	}


	public void setAutor(String autor) {
		this.autor = autor;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getIdLibro() {
		return idLibro;
	}
	
	public void setIdLibro(int idLibro) {
		this.idLibro= idLibro;
	}
	
	public String listarLibros() {
		String salida=LibroDb.obtenerLibros();
		return salida;
	}
	
	public List<Libro> listar(){
		return LibroDb.obtener();
	}

	public List<Libro> buscar(String titulo){
		return LibroDb.buscar(titulo);
	}
}
