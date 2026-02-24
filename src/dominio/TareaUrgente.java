package dominio;

public class TareaUrgente extends Tarea {

    public TareaUrgente(int id, String nombre, String prioridad) {
        super(id, nombre, prioridad);
    }

    @Override
    public String getTipo() {
        return "URGENTE";
    }
}