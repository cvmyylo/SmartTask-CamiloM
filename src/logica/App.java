package logica;

import java.util.List;
import java.util.Scanner;

import dominio.Tarea;

/**
 * App de consola para el proyecto
 */
public class App {

    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        Scanner sc = new Scanner(System.in);

        boolean salir = false;
        while (!salir) {
            imprimirMenu();
            int opcion = leerEntero(sc, "Elige una opción: ");

            try {
                if (opcion == 1) {
                    agregar(gestor, sc);
                } else if (opcion == 2) {
                    listar("ACTIVAS", gestor.listarActivas());
                } else if (opcion == 3) {
                    listar("COMPLETADAS", gestor.listarCompletadas());
                } else if (opcion == 4) {
                    int id = leerEntero(sc, "ID a completar: ");
                    boolean ok = gestor.marcarComoCompletada(id);
                    System.out.println(ok ? "Tarea marcada como completada." : "No existe una tarea con ese ID.");
                } else if (opcion == 5) {
                    int id = leerEntero(sc, "ID a eliminar: ");
                    boolean ok = gestor.eliminarPorId(id);
                    System.out.println(ok ? "Tarea eliminada." : "No existe una tarea con ese ID.");
                } else if (opcion == 0) {
                    salir = true;
                    System.out.println("Saliendo...");
                } else {
                    System.out.println("Opción inválida.");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        sc.close();
    }

    private static void imprimirMenu() {
        System.out.println();
        System.out.println("==== SmartTask ====");
        System.out.println("1) Agregar tarea");
        System.out.println("2) Listar activas");
        System.out.println("3) Listar completadas");
        System.out.println("4) Marcar completada por ID");
        System.out.println("5) Eliminar por ID");
        System.out.println("0) Salir");
    }

    private static void agregar(GestorTareas gestor, Scanner sc) {
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Prioridad (BAJA/MEDIA/ALTA): ");
        String prioridad = sc.nextLine();

        System.out.print("Tipo (NORMAL/URGENTE): ");
        String tipo = sc.nextLine();

        Tarea t = gestor.agregarTarea(nombre, prioridad, tipo);
        System.out.println("Creada: " + t);
    }

    private static void listar(String titulo, List<Tarea> tareas) {
        System.out.println("---- " + titulo + " ----");
        if (tareas.isEmpty()) {
            System.out.println("(sin tareas)");
            return;
        }
        for (int i = 0; i < tareas.size(); i++) {
            System.out.println(tareas.get(i));
        }
    }

    private static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = sc.nextLine();
            try {
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException ex) {
                System.out.println("Error: Ingresa un número válido.");
            }
        }
    }
}