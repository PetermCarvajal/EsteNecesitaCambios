package Biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    public static class Libro {
        private String autor;
        private String titulo;
        private String isbn;
        private int anoPublicacion;

        public Libro(String autor, String titulo, String isbn, int anoPublicacion) {
            this.autor = autor;
            this.titulo = titulo;
            this.isbn = isbn;
            this.anoPublicacion = anoPublicacion;
        }

        public String getAutor() {
            return autor;
        }

        public void setAutor(String autor) {
            this.autor = autor;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public int getAnoPublicacion() {
            return anoPublicacion;
        }

        public void setAnoPublicacion(int anoPublicacion) {
            this.anoPublicacion = anoPublicacion;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Autor: " + autor + ", ISBN: " + isbn + ", Año de Publicación: " + anoPublicacion;
        }
    }

    private ArrayList<Libro> libros;

    public Biblioteca() {
        libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String isbn) {
        libros.removeIf(libro -> libro.getIsbn().equals(isbn));
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                return libro;
            }
        }
        return null;
    }

    public ArrayList<Libro> buscarLibroPorAutor(String autor) {
        ArrayList<Libro> resultado = new ArrayList<>();
        for (Libro libro : libros) {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultado.add(libro);
            }
        }
        return resultado;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }
}
