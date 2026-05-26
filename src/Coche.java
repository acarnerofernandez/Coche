/**
 * Clase que sirve para guardar los datos básicos de un coche.
 * Contiene la información de su modelo, su matrícula y su velocidad.
 * * @author Andre
 * @version 26.05.2026
 */
public class Coche {
    /** La matrícula que identifica al coche. */
    String matricula;

    /** El nombre del modelo o la marca del coche. */
    String modelo;

    /** La velocidad actual del coche en kilómetros por hora. */
    Integer velocidad;

    /** El contador que guarda los kilómetros totales que ha recorrido el coche. */
    double kilometrosRecorridos;


    double TanqueGasolina;

    /**
     * Constructor para crear un coche desde cero.
     * Al principio, todos los coches se crean parados con velocidad cero
     * y con cero kilómetros recorridos.
     * * @param modelo El nombre del modelo o marca.
     * @param matricula La matrícula del vehículo.
     */
    public Coche(String modelo, String matricula) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.velocidad = 0;
        this.kilometrosRecorridos = 0.0;
        this.TanqueGasolina = 0.0;
    }
}