/**
 * Clase que actúa como el organizador o intermediario del programa.
 * Recibe las órdenes que vienen desde la Vista, le pide los datos al Modelo
 * y le pasa las respuestas de vuelta a la Vista para que las enseñe.
 * Trabaja en silencio y no imprime textos directamente.
 * * @author Andre
 * @version 26.05.2026
 */
public class Controller {
    /** El almacén de datos (Modelo) con el que se comunica. */
    private static Model miModel;

    /** La interfaz de pantalla (Vista) con la que se comunica. */
    private static View miView;

    /**
     * Punto de partida del programa. Crea el Modelo, crea la Vista, los conecta
     * y arranca el menú principal.
     * * @param args Argumentos de la consola (no se utilizan).
     */
    public static void main(String[] args) {
        miModel = new Model();

        Controller programa = new Controller();
        miView = new View(programa);

        miView.ejecutarMenu();
    }

    /**
     * Gestiona la creación de un coche: le pide al modelo que lo guarde
     * y le pasa el coche nuevo a la vista para que confirme la acción.
     * * @param modelo El nombre del modelo del coche.
     * @param matricula La matrícula del coche.
     */
    public void procesarCrearCoche(String modelo, String matricula) {
        Coche nuevo = miModel.crearCoche(modelo, matricula);
        miView.confirmarCreacion(nuevo);
    }

    /**
     * Gestiona la búsqueda de un coche: se lo pide al modelo y se lo envía
     * a la vista para que lo muestre por pantalla.
     * * @param matricula La matrícula del coche que queremos ver.
     */
    public void procesarVerCoche(String matricula) {
        Coche encontrado = miModel.getCoche(matricula);
        miView.muestraCoche(encontrado);
    }

    /**
     * Gestiona el cambio de velocidad: le ordena al modelo actualizar el dato
     * y le dice a la vista que avise del cambio en la pantalla.
     * * @param matricula La matrícula del coche.
     * @param nuevaVelocidad La velocidad en números que queremos asignar.
     */
    public void procesarModificarVelocidad(String matricula, int nuevaVelocidad) {
        int velAct = miModel.cambiarVelocidad(matricula, nuevaVelocidad);
        miView.confirmarModificacionVelocidad(matricula, velAct);
    }

    /**
     * Gestiona la consulta de velocidad: la saca del modelo, llama al método
     * de la vista para imprimirla y confirma el resultado basándose en si funcionó.
     * * @param matricula La matrícula del coche a consultar.
     */
    public void procesarVerVelocidad(String matricula) {
        int velocidad = miModel.getVelocidad(matricula);

        boolean hecho = miView.muestraVelocidad(matricula, velocidad);
        miView.confirmarVerVelocidad(hecho);
    }

    /**
     * Gestiona la acción de avanzar: le ordena en silencio al modelo que
     * calcule los nuevos kilómetros y le pasa el resultado a la vista para que lo pinte.
     * Le pasa los metros recorridos a la gasolinaGastada
     * * @param matricula La matrícula del coche que avanza.
     * @param metros Los metros que se va a desplazar.
     */
    public void procesarAvanzar(String matricula, int metros) {
        boolean hecho = miModel.GasolinaGastada(matricula, metros);
        miView.confirmarAvanzar(hecho);
    }

    /**
     * Procesa cuanta asolina se añade y se la manda al model luego lo devuelve en formato boolean
     * @param matricula
     * @param litros
     */

    public void ProcesarGasolinaAñadida(String matricula,int litros){
        boolean Verdadero = miModel.GasolinaSumar(matricula, litros);

        miView.confirmarGasolina(Verdadero);


    }






}