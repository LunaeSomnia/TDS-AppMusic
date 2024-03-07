package tds.repositorio;

import tds.appmusic.Usuario;

public class RepositorioUsuarios extends Repositorio<Usuario> {

    // Singleton handling
    private static RepositorioUsuarios unicaInstancia = null;

    public static RepositorioUsuarios getInstancia() {
        if (unicaInstancia == null) {
            unicaInstancia = new RepositorioUsuarios();
        }
        return unicaInstancia;
    }
}