package tds.appmusic.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import tds.appmusic.domain.Cancion;

public class Player {
	// canciones almacenadas en src/main/resources
	private Cancion cancionActual = null;
	private MediaPlayer mediaPlayer;
	private String carpetaCanciones = "/canciones/";

	public Player() {
		// existen otras formas de lanzar JavaFX desde Swing
		try {
			com.sun.javafx.application.PlatformImpl.startup(() -> {
			});
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception: " + ex.getMessage());
		}
	}

	public void play(PlayerBoton boton, Cancion cancion) {
		switch (boton) {
			case PlayerBoton.Play:
				try {
					setCancionActual(cancion);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mediaPlayer.play();
				break;
			case PlayerBoton.Stop:
				mediaPlayer.stop();
				break;
			case PlayerBoton.Pause:
				mediaPlayer.pause();
				break;
		}
	}

	private void setCancionActual(Cancion cancion) throws FileNotFoundException {
		if (cancionActual != cancion) {
			cancionActual = cancion;
			String rutaCancion = cancion.getRutaFichero();
			System.out.println(rutaCancion);
			URL resourceURL = getClass().getResource(carpetaCanciones + rutaCancion);

			if (resourceURL == null) {
				throw new FileNotFoundException("Resource not found: " + rutaCancion);
			}

			Media hit = new Media(resourceURL.toExternalForm());
			mediaPlayer = new MediaPlayer(hit);

		}

	}

}