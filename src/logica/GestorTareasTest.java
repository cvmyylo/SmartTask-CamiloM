package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dominio.Tarea;

public class GestorTareasTest {

    @Test
    void agregarTarea_deberiaCrearTarea() {
        GestorTareas gestor = new GestorTareas();

        Tarea tarea = gestor.agregarTarea("Estudiar Java", "MEDIA", "NORMAL");

        assertNotNull(tarea);
        assertEquals(1, tarea.getId());
        assertEquals("Estudiar Java", tarea.getNombre());
        assertFalse(tarea.isCompletada());
    }

    @Test
    void marcarComoCompletada_deberiaCambiarEstado() {
        GestorTareas gestor = new GestorTareas();
        Tarea tarea = gestor.agregarTarea("Prueba", "ALTA", "URGENTE");

        boolean resultado = gestor.marcarComoCompletada(tarea.getId());

        assertTrue(resultado);
        assertTrue(tarea.isCompletada());
    }

    @Test
    void eliminarPorId_deberiaEliminarTarea() {
        GestorTareas gestor = new GestorTareas();
        Tarea tarea = gestor.agregarTarea("Eliminar", "BAJA", "NORMAL");

        boolean eliminado = gestor.eliminarPorId(tarea.getId());

        assertTrue(eliminado);
        assertEquals(0, gestor.listarActivas().size());
    }

    @Test
    void agregarTarea_prioridadInvalida_deberiaLanzarExcepcion() {
        GestorTareas gestor = new GestorTareas();

        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> gestor.agregarTarea("Error", "SUPERALTA", "NORMAL")
        );

        assertTrue(ex.getMessage().toUpperCase().contains("PRIORIDAD"));
    }
}