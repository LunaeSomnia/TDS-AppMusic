package tds.appmusic;

import java.util.*;

public class PlayList {
    private final String nombre;

    private final List<Cancion> canciones = new ArrayList<>();

    // Constructor
    public PlayList(String nombre) {
        this.nombre = nombre;
    }

    // Getters
    public List<Cancion> getCanciones() {
        // return canciones;
        throw new UnsupportedOperationException("TO-DO");
    }

    // Metodos
    public void anadirCancion() {
        throw new UnsupportedOperationException("TO-DO");
    }

}
