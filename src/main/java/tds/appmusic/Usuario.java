package tds.appmusic;

import java.util.ArrayList;
import java.util.List;

import tds.repositorio.Identificable;

public class Usuario implements Identificable {
    private String nombre;
    private final boolean premium;

    //

    private final List<PlayList> playlists = new ArrayList<>();
    private final List<Cancion> recientes = new ArrayList<>();

    public Usuario(String nombre, boolean premium) {
        this.nombre = nombre;
        this.premium = premium;
    }

    public void realizarPago() {
        throw new UnsupportedOperationException("TO-DO");
    }

    public void addPlaylist() {
        throw new UnsupportedOperationException("TO-DO");
    }

    // Identificable

    @Override
    public String getId() {
        return nombre;
    }

    @Override
    public void setId(String key) {
        nombre = key;
    }

}
