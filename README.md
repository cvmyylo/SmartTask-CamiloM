🧭 Paso a paso de ejecución del sistema en consola

En esta sección se describe paso a paso el uso de la aplicación SmartTask, mostrando el flujo completo desde la creación de tareas hasta su eliminación, ejecutándose desde consola.

Paso 1: Inicio del programa

Al ejecutar la aplicación, el sistema muestra el menú principal con las opciones disponibles.

```text
==== SmartTask ====
1) Agregar tarea
2) Listar activas
3) Listar completadas
4) Marcar completada por ID
5) Eliminar por ID
0) Salir
```

Paso 2: Creación de una tarea normal

Se selecciona la opción 1) Agregar tarea.
El sistema solicita los datos de la tarea: nombre, prioridad y tipo.

```text
Elige una opción: 1
Nombre: Correr
Prioridad (BAJA/MEDIA/ALTA): MEDIA
Tipo (NORMAL/URGENTE): NORMAL
Creada: #1 [NORMAL] Correr | MEDIA | ACTIVA
```

✔ La tarea se crea correctamente y queda en estado ACTIVA.

Paso 3: Creación de una tarea urgente

Se vuelve a seleccionar la opción 1) Agregar tarea para crear una segunda tarea, esta vez de tipo urgente.

```text
Elige una opción: 1
Nombre: TOMAR MEDICACION
Prioridad (BAJA/MEDIA/ALTA): ALTA
Tipo (NORMAL/URGENTE): URGENTE
Creada: #2 [URGENTE] TOMAR MEDICACION | ALTA | ACTIVA
```

✔ El sistema asigna automáticamente un nuevo ID.

Paso 4: Listado de tareas activas

Se selecciona la opción 2) Listar activas para visualizar todas las tareas que aún no han sido completadas.

```text
Elige una opción: 2
---- ACTIVAS ----
#1 [NORMAL] Correr | MEDIA | ACTIVA
#2 [URGENTE] TOMAR MEDICACION | ALTA | ACTIVA
```

✔ Se muestran correctamente ambas tareas activas.

Paso 5: Marcar una tarea como completada

Se selecciona la opción 4) Marcar completada por ID y se ingresa el ID de la tarea a completar.

```text
Elige una opción: 4
ID a completar: 2
Tarea marcada como completada.
```

✔ La tarea con ID 2 cambia su estado a COMPLETADA.

Paso 6: Verificación de tareas activas tras completar una

Se vuelve a listar las tareas activas.

```text
Elige una opción: 2
---- ACTIVAS ----
#1 [NORMAL] Correr | MEDIA | ACTIVA
```

✔ Solo se muestra la tarea que sigue activa.

Paso 7: Eliminación de una tarea

Se selecciona la opción 5) Eliminar por ID e ingresa el ID correspondiente.

```text
Elige una opción: 5
ID a eliminar: 1
Tarea eliminada.
```

✔ La tarea se elimina correctamente del sistema.

Paso 8: Verificación final de tareas activas

Se listan nuevamente las tareas activas para confirmar que no quedan tareas registradas.

```text
Elige una opción: 2
---- ACTIVAS ----
(sin tareas)
```

✔ El sistema indica correctamente que no existen tareas activas.

Paso 9: Cierre del programa

Finalmente, se selecciona la opción 0) Salir para cerrar la aplicación.

```text
Elige una opción: 0
Saliendo...
```

✔ El programa finaliza su ejecución de forma correcta.