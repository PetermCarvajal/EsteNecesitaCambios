package Cine;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Cine {

    // Clase Persona
    public class Persona {
        private String nombre;
        private String direccion;
        private int id;

        public Persona(String nombre, String direccion, int id) {
            this.nombre = nombre;
            this.direccion = direccion;
            this.id = id;
        }

        public String obtenerNombre() {
            return nombre;
        }

        public String obtenerDireccion() {
            return direccion;
        }

        public int obtenerId() {
            return id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }

        public void setId(int id) {
            this.id = id;
        }
    }

    // Clase Cliente que hereda de Persona
    public class Cliente extends Persona {
        private List<Reserva> historialReservas;

        public Cliente(String nombre, String direccion, int id) {
            super(nombre, direccion, id);
            this.historialReservas = new ArrayList<>();
        }

        public List<Reserva> obtenerHistorialReservas() {
            return historialReservas;
        }

        public void agregarReserva(Reserva reserva) {
            historialReservas.add(reserva);
        }
    }

    // Clase Asiento
    public class Asiento {
        private int fila;
        private int columna;
        private String estado; // "disponible", "reservado", "ocupado"

        public Asiento(int fila, int columna) {
            this.fila = fila;
            this.columna = columna;
            this.estado = "disponible";
        }

        public int obtenerFila() {
            return fila;
        }

        public int obtenerColumna() {
            return columna;
        }

        public String obtenerEstado() {
            return estado;
        }

        public void reservar() {
            if (estado.equals("disponible")) {
                estado = "reservado";
            }
        }

        public void ocupar() {
            if (estado.equals("reservado")) {
                estado = "ocupado";
            }
        }
    }

    // Clase Sala
    public class Sala {
        private int numero;
        private int capacidad;
        private Asiento[][] listaAsientos;

        public Sala(int numero, int filas, int columnas) {
            this.numero = numero;
            this.capacidad = filas * columnas;
            listaAsientos = new Asiento[filas][columnas];
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    listaAsientos[i][j] = new Asiento(i, j);
                }
            }
        }

        public int obtenerNumero() {
            return numero;
        }

        public int obtenerCapacidad() {
            return capacidad;
        }

        public Asiento obtenerAsiento(int fila, int columna) {
            if (fila >= 0 && fila < listaAsientos.length && columna >= 0 && columna < listaAsientos[0].length) {
                return listaAsientos[fila][columna];
            }
            return null; // Asiento no válido
        }
    }

    // Clase Funcion
    public class Funcion {
        private String pelicula;
        private float horaInicio;
        private Sala sala;
        private int precioEntrada;

        public Funcion(String pelicula, float horaInicio, Sala sala, int precioEntrada) {
            this.pelicula = pelicula;
            this.horaInicio = horaInicio;
            this.sala = sala;
            this.precioEntrada = precioEntrada;
        }

        public String obtenerPelicula() {
            return pelicula;
        }

        public float obtenerHoraInicio() {
            return horaInicio;
        }

        public Sala obtenerSala() {
            return sala;
        }

        public int obtenerPrecioEntrada() {
            return precioEntrada;
        }
    }

    // Clase Reserva
    public class Reserva {
        private Cliente cliente;
        private Funcion funcion;
        private List<Asiento> listaAsientos;

        public Reserva(Cliente cliente, Funcion funcion, List<Asiento> listaAsientos) {
            this.cliente = cliente;
            this.funcion = funcion;
            this.listaAsientos = listaAsientos;
        }

        public Cliente obtenerCliente() {
            return cliente;
        }

        public Funcion obtenerFuncion() {
            return funcion;
        }

        public List<Asiento> obtenerListaAsientos() {
            return listaAsientos;
        }
    }
}
