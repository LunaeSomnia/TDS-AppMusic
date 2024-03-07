package tds.repositorio;

import tds.appmusic.Cancion;

public class RepositorioCanciones extends Repositorio<Cancion> {

    // Singleton handling
    private static RepositorioCanciones unicaInstancia = null;

    public static RepositorioCanciones getInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new RepositorioCanciones();
        }
        return unicaInstancia;
    }
}
