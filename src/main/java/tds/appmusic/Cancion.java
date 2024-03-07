package tds.appmusic;

import tds.repositorio.Identificable;

public class Cancion implements Identificable {
    private String titulo;
    private final String rutaFichero;
    private final int numReproducciones;

    private final Interprete interprete;

    public Cancion(String titulo, String rutaFichero, int numReproducciones, Interprete interprete) {
        this.titulo = titulo;
        this.rutaFichero = rutaFichero;
        this.numReproducciones = numReproducciones;
        this.interprete = interprete;
    }

    // Getters

    public String getTitulo() {
        return titulo;
    }

    public String getRutaFichero() {
        return rutaFichero;
    }

    public int getNumReproducciones() {
        return numReproducciones;
    }

    public Interprete getInterprete() {
        return interprete;
    }

    // Identificable

    @Override
    public String getId() {
        return titulo;
    }

    @Override
    public void setId(String key) {
        titulo = key;
    }
}
