package tds.appmusic.utils;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import tds.appmusic.domain.Cancion;
import tds.appmusic.domain.RepositorioCanciones;
import tds.appmusic.domain.CatalogoInterpretes;
import tds.appmusic.domain.Categoria;
import tds.appmusic.domain.Interprete;

import static java.util.stream.Collectors.*;

public enum CargadorCanciones {
	INSTANCE;
	
	private String carpetaCanciones = "/canciones"; //carpeta con canciones en resources
	
	public boolean cargarCanciones() throws Exception {
		URL resourceURL = getClass().getResource(carpetaCanciones);
		Path path = Paths.get(resourceURL.toURI());

        if (hayCanciones(path)){ 
			  printCanciones(path);
			  crearObjetosCancion(path);
	          return true;
        }
	    else return false;
	}
	    
	private boolean hayCanciones(Path path) {
	    try {
	          return Files.walk(path)
	                      .anyMatch(f -> !Files.isDirectory(f));
	    } catch (IOException e) {
	            System.err.println("Caught IOException: " + e.getMessage());
	            return false; // Manejo de errores
	    }
	}

	private void printCanciones(Path path){
		try {   
			List<Path> dirs = Files.list(path).collect(toList());
		    for(Path dir:dirs) {
		    	System.out.println("Categoria: "+dir.toFile().getName());
		    	for (Path file:Files.list(dir).collect(toList())){
		    		System.out.println("Disco: "+ file.toFile().getName());
		    	}
		    }
		 } catch(IOException e){System.err.println("Caught IOException: " + e.getMessage());}
	}
	private void crearObjetosCancion(Path path){
		// se crea objeto Categoria, esto no sería necesario en el caso práctico propuesto.
		try {   
			List<Path> dirs = Files.list(path).collect(toList());
		    for(Path dir:dirs) {
		    	String nombreCategoria = dir.toFile().getName();
		    	Categoria categoria = new Categoria(nombreCategoria);
		    	for (Path file:Files.list(dir).collect(toList())){
		    		String nombreFichero = file.toFile().getName();
		    		String rutaFichero = nombreCategoria + "/"+ nombreFichero;
		    		String[] partesNombre = nombreFichero.split("-");
		    		String interprete = partesNombre[0];
		    		String titulo = partesNombre[1];
		    		//CatalogoInterpretes.getUnicaInstancia().addAutor(interprete);
		    		Cancion cancion = new Cancion(titulo, interprete, rutaFichero, categoria);
		    		RepositorioCanciones.getUnicaInstancia().addCancion(cancion);
		    		categoria.addCancion(cancion);
		    	}
		    }
		 } catch(IOException e){System.err.println("Caught IOException: " + e.getMessage());}
	}
}
