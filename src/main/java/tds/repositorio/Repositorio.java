package tds.repositorio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Repositorio<T extends Identificable> {

    private HashMap<String, T> entidades = new HashMap<>();

    public String add(T entity) throws RepositorioException {

        if (entity.getId() == null)
            throw new RepositorioException("La entidad no tiene una id asignada");

        this.entidades.put(entity.getId(), entity);

        return entity.getId();
    }

    public void update(T entity) throws RepositorioException, EntidadNoEncontrada {

        if (!this.entidades.containsKey(entity.getId()))
            throw new EntidadNoEncontrada(entity.getId() + " no existe en el repositorio");

        this.entidades.put(entity.getId(), entity);
    }

    public void delete(T entity) throws RepositorioException, EntidadNoEncontrada {

        if (!this.entidades.containsKey(entity.getId()))
            throw new EntidadNoEncontrada(entity.getId() + " no existe en el repositorio");

        this.entidades.remove(entity.getId());
    }

    public T getById(String id) throws RepositorioException, EntidadNoEncontrada {

        if (!this.entidades.containsKey(id))
            throw new EntidadNoEncontrada(id + " no existe en el repositorio");

        return this.entidades.get(id);
    }

    public List<T> getAll() throws RepositorioException {

        return new ArrayList<>(this.entidades.values());
    }

    public List<String> getIds() throws RepositorioException {

        return new ArrayList<>(this.entidades.keySet());
    }
}
