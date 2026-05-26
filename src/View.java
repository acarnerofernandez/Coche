import java.util.Scanner;

/**
 * Clase encargada de la pantalla y de hablar con el usuario.
 * Muestra el menú de opciones, lee lo que el usuario escribe en el teclado
 * y pone en la pantalla los mensajes de éxito o de error.
 * @author Andre
 * @version 26.05.2026
 */
public class View {
    /** Herramienta para leer las respuestas del usuario por consola. */
    private Scanner teclado = new Scanner(System.in);

    /** El controlador al que la vista le avisa para que procese las opciones. */
    private Controller controlador;

    /**
     * Constructor para conectar la vista con su controlador.
     * * @param controlador El encargado de procesar los datos que recoja esta vista.
     */
    public View(Controller controlador) {
        this.controlador = controlador;
    }

    /**
     * Muestra el menú en la pantalla y repite las preguntas hasta que
     * el usuario decide pulsar la opción de salir, que ahora es la número (6).
     */
    public void ejecutarMenu() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- MENU PARKING (VISTA) ---");
            System.out.println("1. Crear coche");
            System.out.println("2. Ver coche");
            System.out.println("3. Modificar velocidad");
            System.out.println("4. Ver velocidad");
            System.out.println("5. Avanzar coche ");
            System.out.println("6. Añadir gasolina ");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");

            int opcion = teclado.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el modelo: ");
                    String mod = teclado.next();
                    System.out.print("Introduce la matrícula: ");
                    String mat = teclado.next();
                    controlador.procesarCrearCoche(mod, mat);
                    break;

                case 2:
                    System.out.print("Introduce la matrícula a buscar: ");
                    String matBuscar = teclado.next();
                    controlador.procesarVerCoche(matBuscar);
                    break;

                case 3:
                    System.out.print("Introduce la matrícula: ");
                    String matVel = teclado.next();
                    System.out.print("Introduce la nueva velocidad: ");
                    int nuevaVel = teclado.nextInt();
                    controlador.procesarModificarVelocidad(matVel, nuevaVel);
                    break;

                case 4:
                    System.out.print("Introduce la matrícula: ");
                    String matCons = teclado.next();
                    controlador.procesarVerVelocidad(matCons);
                    break;

                case 5:
                    System.out.print("Introduce la matrícula: ");
                    String matAvanzar = teclado.next();
                    System.out.print("¿Cuántos metros avanza?: ");
                    int metros = teclado.nextInt();
                    controlador.procesarAvanzar(matAvanzar, metros);
                    break;

                case 6:

                    System.out.print("Introduce la matrícula: ");
                    String matricula = teclado.next();
                    System.out.print("¿Cuántos litros añades: ");
                    int litros = teclado.nextInt();
                    controlador.ProcesarGasolinaAñadida(matricula, litros);

                    break;

                case 0:
                    continuar = false;
                    System.out.println("Saliendo de la aplicación...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    /**
     * Muestra un mensaje confirmando si el coche se creó correctamente o si falló.
     * * @param c El coche que se ha creado (si no existe, vale null).
     */
    public void confirmarCreacion(Coche c) {
        if (c != null) {
            System.out.println("[VISTA] ¡Confirmado! Coche guardado con éxito: " + c.modelo);
        } else {
            System.out.println("[VISTA] Error al crear el coche.");
        }
    }

    /**
     * Imprime en pantalla todos los datos juntos de un coche.
     * * @param c El coche que queremos mostrar en la pantalla.
     */
    public void muestraCoche(Coche c) {
        if (c != null) {
            System.out.println("[VISTA] Datos del coche -> Modelo: " + c.modelo + " | Matrícula: " + c.matricula + " | Velocidad: " + c.velocidad + "km/hr" + " | Distancia recorrida " + c.kilometrosRecorridos + "km" + " | Gasolina " + c.TanqueGasolina + "L ");
        } else {
            System.out.println("[VISTA] El coche solicitado no existe en el sistema.");
        }
    }

    /**
     * Imprime un aviso indicando que la velocidad ha cambiado con éxito.
     * * @param matricula La matrícula del coche modificado.
     * @param nuevaVelocidad La velocidad con la que se queda el coche.
     */
    public void confirmarModificacionVelocidad(String matricula, int nuevaVelocidad) {
        System.out.println("[VISTA] ¡Modificación completada! El coche " + matricula + " ahora va a " + nuevaVelocidad + " km/hr.");
    }

    /**
     * Método obligatorio original que imprime la velocidad de un coche en la pantalla.
     * * @param matricula La matrícula del coche.
     * @param v Los kilómetros por hora.
     * @return Devuelve true para avisar de que ya se ha impreso el texto.
     */
    public boolean muestraVelocidad(String matricula, Integer v){
        System.out.println(matricula + ": " + v + "km/hr");
        return true;
    }

    /**
     * Muestra un mensaje final indicando si la consulta de velocidad salió bien o mal.
     * * @param hecho Indica si el proceso se completó con éxito.
     */
    public void confirmarVerVelocidad(boolean hecho) {
        if (hecho) {
            System.out.println("[VISTA] Consulta de velocidad realizada correctamente.");
        } else {
            System.out.println("[VISTA] Error al consultar la velocidad.");
        }
    }

    /**
     * Imprime en pantalla la confirmación de que el coche avanzó y
     * muestra la cantidad total de kilómetros acumulados.

     * @param completado Si se logro el viaje o no
     */
    public void confirmarAvanzar(boolean completado) {

        if (completado) {
            System.out.println("[VISTA]Gasolina suficiente.");
        } else {
            System.out.println("[VISTA] Error sin gasolina .");
        }
    }

    /**
     * Imprime Cuanta gasolina tiene
     * Si no se pudo añadir da error
     * @param Verdadero
     */

    public void confirmarGasolina(boolean Verdadero) {
        if (Verdadero) {
            System.out.println("[VISTA]Gasolina añdadida.");
        } else {
            System.out.println("[VISTA] Error al agregar gasolina.");
        }
    }


}