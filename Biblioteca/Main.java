package Biblioteca;
import javax.swing.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            String seleccion = JOptionPane.showInputDialog(null, "Por favor seleccione una opción:\n"+"1. Agregar libro\n" + "2. Eliminar libro\n" + "3. Buscar libro por título\n" + "4. Buscar libro por autor\n" + "5. Listar libros\n" + "6. Buscar libro por título (búsqueda parcial)\n" + "7. Salir");
            opcion = Integer.parseInt(seleccion);

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca);
                    break;
                case 2:
                    eliminarLibro(biblioteca);
                    break;
                case 3:
                    buscarLibroPorTitulo(biblioteca);
                    break;
                case 4:
                    buscarLibroPorAutor(biblioteca);
                    break;
                case 5:
                    listarLibros(biblioteca);
                    break;
                case 6:
                    buscarLibroPorTituloParcial(biblioteca);
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void agregarLibro(Biblioteca biblioteca) {
        String autor = JOptionPane.showInputDialog(null, "Ingrese el autor:");
        String titulo = JOptionPane.showInputDialog(null, "Ingrese el título:");
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN:");
        int anoPublicacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de publicación:"));
        Biblioteca.Libro libro = new Biblioteca.Libro(autor, titulo, isbn, anoPublicacion);
        biblioteca.agregarLibro(libro);
    }

    private static void eliminarLibro(Biblioteca biblioteca) {
        String isbn = JOptionPane.showInputDialog(null, "Ingrese el ISBN del libro a eliminar:");
        biblioteca.eliminarLibro(isbn);
    }

    private static void buscarLibroPorTitulo(Biblioteca biblioteca) {
        String titulo = JOptionPane.showInputDialog(null, "Ingrese el título a buscar:");
        Biblioteca.Libro libro = biblioteca.buscarLibroPorTitulo(titulo);
        if (libro != null) {
            JOptionPane.showMessageDialog(null, "Libro encontrado: " + libro);
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el libro.");
        }
    }

    private static void buscarLibroPorAutor(Biblioteca biblioteca) {
        String autor = JOptionPane.showInputDialog(null, "Ingrese el autor a buscar:");
        ArrayList<Biblioteca.Libro> librosEncontrados = biblioteca.buscarLibroPorAutor(autor);
        if (!librosEncontrados.isEmpty()) {
            StringBuilder mensaje = new StringBuilder("Libros encontrados:\n");
            for (Biblioteca.Libro libro : librosEncontrados) {
                mensaje.append(libro).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron libros del autor.");
        }
    }

    private static void listarLibros(Biblioteca biblioteca) {
        ArrayList<Biblioteca.Libro> libros = biblioteca.getLibros();
        if (libros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay libros en la biblioteca.");
        } else {
            StringBuilder mensaje = new StringBuilder("Lista de libros:\n");
            for (Biblioteca.Libro libro : libros) {
                mensaje.append(libro).append("\n");
            }
            JOptionPane.showMessageDialog(null, mensaje.toString());
        }
    }

    private static void buscarLibroPorTituloParcial(Biblioteca biblioteca) {
        String parcial = JOptionPane.showInputDialog(null, "Ingrese parte del título a buscar:");
        StringBuilder resultados = new StringBuilder("Libros encontrados:\n");
        boolean encontrado = false;

        for (Biblioteca.Libro libro : biblioteca.getLibros()) {
            if (libro.getTitulo().toLowerCase().contains(parcial.toLowerCase())) {
                resultados.append(libro).append("\n");
                encontrado = true;
            }
        }

        if (encontrado) {
            JOptionPane.showMessageDialog(null, resultados.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No se encontraron libros con el título parcial dado.");
        }
    }
}