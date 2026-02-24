package logica;

import java.util.ArrayList;
import java.util.List;

import dominio.Tarea;
import dominio.TareaNormal;
import dominio.TareaUrgente;

/**
 * Gestiona tareas en memoria.
 */
public class GestorTareas implements Accionable {

    private final List<Tarea> tareas;
    private int siguienteId;

    public GestorTareas() {
        this.tareas = new ArrayList<Tarea>();
        this.siguienteId = 1;
    }

    @Override
    public Tarea agregarTarea(String nombre, String prioridad, String tipo) {
        String tipoNormalizado = normalizarTipo(tipo);
        int id = siguienteId;
        siguienteId++;

        Tarea nueva;
        if ("URGENTE".equals(tipoNormalizado)) {
            nueva = new TareaUrgente(id, nombre, prioridad);
        } else {
            nueva = new TareaNormal(id, nombre, prioridad);
        }

        tareas.add(nueva);
        return nueva;
    }

    @Override
    public List<Tarea> listarActivas() {
        List<Tarea> out = new ArrayList<Tarea>();
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            if (!t.isCompletada()) {
                out.add(t);
            }
        }
        return out;
    }

    @Override
    public List<Tarea> listarCompletadas() {
        List<Tarea> out = new ArrayList<Tarea>();
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            if (t.isCompletada()) {
                out.add(t);
            }
        }
        return out;
    }

    @Override
    public boolean marcarComoCompletada(int id) {
        Tarea t = buscarPorId(id);
        if (t == null) {
            return false;
        }
        t.marcarComoCompletada();
        return true;
    }

    @Override
    public boolean eliminarPorId(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            if (tareas.get(i).getId() == id) {
                tareas.remove(i);
                return true;
            }
        }
        return false;
    }

    public Tarea buscarPorId(int id) {
        for (int i = 0; i < tareas.size(); i++) {
            Tarea t = tareas.get(i);
            if (t.getId() == id) {
                return t;
            }
        }
        return null;
    }

    private String normalizarTipo(String tipo) {
        if (tipo == null) {
            return "NORMAL";
        }
        String t = tipo.trim().toUpperCase();
        if ("URGENTE".equals(t)) return "URGENTE";
        if ("NORMAL".equals(t)) return "NORMAL";
        // si viene cualquier cosa, por defecto NORMAL
        return "NORMAL";
    }
}