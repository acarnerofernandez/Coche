import java.util.ArrayList;

/**
 * Clase que funciona como el almacén de datos del programa.
 * Se encarga de guardar la lista de coches y de hacer los cambios internos.
 * No muestra nada por pantalla ni habla con el usuario.
 * * @author Andre
 * @version 26.05.2026
 */
public class Model {
    /** La lista o parking donde se van guardando todos los coches creados. */
    static ArrayList<Coche> parking = new ArrayList<>();

    /**
     * Registra un coche nuevo, lo mete en la lista y lo devuelve terminado.
     * * @param modelo El nombre del modelo del coche.
     * @param matricula La matrícula del coche.
     * @return El objeto coche que se acaba de guardar.
     */
    public Coche crearCoche(String modelo, String matricula){
        Coche aux = new Coche(modelo, matricula);
        parking.add(aux);
        return aux;
    }

    /**
     * Busca un coche en la lista comparando las matrículas una por una.
     * * @param matricula La matrícula del coche que estamos buscando.
     * @return El coche si lo encuentra, o un valor vacío (null) si no existe.
     */
    public Coche getCoche(String matricula){
        Coche aux = null;
        for (Coche e: parking) {
            if (e.matricula.equals(matricula)) {
                aux = e;
            }
        }
        return aux;
    }

    /**
     * Modifica los kilómetros por hora del coche que coincida con la matrícula.
     * * @param matricula La matrícula del coche a cambiar.
     * @param v La nueva velocidad que va a tener.
     * @return La velocidad final que se ha guardado.
     */
    public int cambiarVelocidad(String matricula, Integer v) {
        getCoche(matricula).velocidad = v;
        return getCoche(matricula).velocidad;
    }

    /**
     * Consulta la velocidad que tiene registrada un coche.
     * * @param matricula La matrícula del coche a consultar.
     * @return Los kilómetros por hora actuales de ese coche.
     */
    public int getVelocidad(String matricula) {

        return getCoche(matricula).velocidad;
    }

    /**
     * NUEVO: Hace avanzar al coche transformando los metros recibidos a kilómetros
     * y acumulándolos en el contador del vehículo.
     * * @param matricula La matrícula del coche que va a avanzar.
     * @param metros La cantidad de metros que se mueve el coche.
     * @return Los kilómetros totales acumulados que lleva recorridos ese coche.
     */
    public double avanzarCoche(String matricula, int metros) {
        Coche coche = getCoche(matricula);

        double kmNuevos = metros / 1000.0;


        coche.kilometrosRecorridos += kmNuevos;

        return coche.kilometrosRecorridos;
    }


    public boolean GasolinaGastada(String matricula, double metros){

        Coche coche = getCoche(matricula);

        double velocidad = coche.velocidad;

        double kmNuevos = metros / 1000.0;

        double Consumo = 1 * kmNuevos;

        double ConsumoTotal = Consumo * (velocidad * 0.10);

        if (coche.TanqueGasolina - ConsumoTotal < 0) {

            return false;
        }else {
            coche.TanqueGasolina = coche.TanqueGasolina - ConsumoTotal;
            return true;
        }

    }

    public boolean GasolinaSumar (String matricula, int litros) {

        Coche coche = getCoche(matricula);

        double Gasolina = coche.TanqueGasolina;
        double actual = Gasolina + litros;

        if(actual > 120 && Gasolina < 0){
          double GasolinaFinal = Gasolina;

            coche.TanqueGasolina = GasolinaFinal;

            return false;
        }  else {

            double GasolinaFinal = actual;
            coche.TanqueGasolina = GasolinaFinal;
            return true;
        }



    }


}