package tds;

import javax.swing.JFrame;

import tds.appmusic.Cancion;
import tds.reproductor.PlayerBoton;
import tds.reproductor.Reproductor;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        JFrame miFrame = new JFrame("Hola Mundo con Swing");
        miFrame.setSize(300, 300);
        miFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        miFrame.setVisible(true);

        Reproductor reproductor = new Reproductor();

        Cancion cancion = new Cancion("uktheme-warthunder", "warthunder-uk.mp3", 0, null);

        reproductor.play(PlayerBoton.Play, cancion);
    }
}
