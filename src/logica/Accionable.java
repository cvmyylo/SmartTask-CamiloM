package logica;

import java.util.List;
import dominio.Tarea;

public interface Accionable {
    Tarea agregarTarea(String nombre, String prioridad, String tipo);
    List<Tarea> listarActivas();
    List<Tarea> listarCompletadas();
    boolean marcarComoCompletada(int id);
    boolean eliminarPorId(int id);
}