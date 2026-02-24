package dominio;

/**
 * Clase base abstracta para tareas
 */
public abstract class Tarea {

    private final int id;
    private String nombre;
    private String prioridad; // "BAJA", "MEDIA", "ALTA"
    private boolean completada;

    protected Tarea(int id, String nombre, String prioridad) {
        this.id = id;
        setNombre(nombre);
        setPrioridad(prioridad);
        this.completada = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public final void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre.trim();
    }

    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Prioridad válida
     */
    public final void setPrioridad(String prioridad) {
        if (prioridad == null) {
            throw new IllegalArgumentException("La prioridad no puede ser null.");
        }
        String p = prioridad.trim().toUpperCase();
        if (!"BAJA".equals(p) && !"MEDIA".equals(p) && !"ALTA".equals(p)) {
            throw new IllegalArgumentException("Prioridad inválida. Usa BAJA, MEDIA o ALTA.");
        }
        this.prioridad = p;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void marcarComoCompletada() {
        this.completada = true;
    }

    public abstract String getTipo();

    @Override
    public String toString() {
        String estado = completada ? "COMPLETADA" : "ACTIVA";
        return "#" + id + " [" + getTipo() + "] " + nombre + " | " + prioridad + " | " + estado;
    }
}