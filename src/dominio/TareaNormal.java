package dominio;

public class TareaNormal extends Tarea {

    public TareaNormal(int id, String nombre, String prioridad) {
        super(id, nombre, prioridad);
    }

    @Override
    public String getTipo() {
        return "NORMAL";
    }
}