package Cine;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cine cine = new Cine();

        // Crear sala con 5 filas y 10 columnas
        Cine.Sala sala1 = cine.new Sala(1, 5, 10);

        // Crear una función
        Cine.Funcion funcion1 = cine.new Funcion("Avatar", 20.30f, sala1, 150);

        // Crear un cliente
        Cine.Cliente cliente1 = cine.new Cliente("Juan Pérez", "Calle 123", 1);

        // Menú principal
        while (true) {
            String menu = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" +
                            "1. Reservar asiento\n" +
                            "2. Comprar entrada\n" +
                            "3. Ver historial de reservas\n" +
                            "4. Salir");

            int opcion = Integer.parseInt(menu);

            if (opcion == 4) {
                break;
            }

            switch (opcion) {
                case 1:
                    reservarAsiento(cine, cliente1, funcion1);
                    break;
                case 2:
                    comprarEntrada(cine, cliente1, funcion1);
                    break;
                case 3:
                    verHistorialReservas(cliente1);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        }
    }

    private static void reservarAsiento(Cine cine, Cine.Cliente cliente, Cine.Funcion funcion) {
        Cine.Sala sala = funcion.obtenerSala();
        int fila = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la fila del asiento:"));
        int columna = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la columna del asiento:"));

        Cine.Asiento asiento = sala.obtenerAsiento(fila, columna);
        if (asiento != null && asiento.obtenerEstado().equals("disponible")) {
            asiento.reservar();
            JOptionPane.showMessageDialog(null, "Asiento reservado con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "Asiento no disponible.");
        }
    }

    private static void comprarEntrada(Cine cine, Cine.Cliente cliente, Cine.Funcion funcion) {
        List<Cine.Asiento> asientosReservados = new ArrayList<>();
        Cine.Sala sala = funcion.obtenerSala();

        String filaColumna = JOptionPane.showInputDialog(null, "Ingrese la fila y columna del asiento (separados por una coma):");
        String[] partes = filaColumna.split(",");
        if (partes.length == 2) {
            int fila = Integer.parseInt(partes[0].trim());
            int columna = Integer.parseInt(partes[1].trim());

            Cine.Asiento asiento = sala.obtenerAsiento(fila, columna);
            if (asiento != null && asiento.obtenerEstado().equals("reservado")) {
                asiento.ocupar();
                asientosReservados.add(asiento);

                Cine.Reserva reserva = cine.new Reserva(cliente, funcion, asientosReservados);
                cliente.agregarReserva(reserva);

                JOptionPane.showMessageDialog(null, "Entrada comprada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Asiento no reservado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Entrada inválida.");
        }
    }

    private static void verHistorialReservas(Cine.Cliente cliente) {
        List<Cine.Reserva> historial = cliente.obtenerHistorialReservas();
        StringBuilder sb = new StringBuilder();
        sb.append("Historial de Reservas:\n");
    }
}
