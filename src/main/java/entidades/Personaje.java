package entidades;

import lombok.Getter;

import javax.imageio.event.IIOReadProgressListener;
import java.util.*;


@Getter
public class Personaje {


    private String nombre;
    private Map<String,Item> inventario;
    private Map<TipoEquipamiento,Item> equipo;

    public Personaje(String nombre) {
        this.nombre = nombre;
        this.inventario = new HashMap<>();
        this.equipo = new TreeMap<>();
    }

    /**
     * Agrega un item al inventario del personaje
     * usamos como clave el nombre del item
     * @param item
     */
    public void agregarItemAlInventario(Item item){
        this.inventario.put(item.getNombre(), item);
    }

    /**
     * elimina un item del inventario del personaje
     * @param nombreitem
     */
    public void eliminarItemDelInventario(Item nombreitem){
        this.inventario.remove(nombreitem);
    }

    /**
     * devuelve una lista con todos los items del inventario del personaje
     * @return
     */
    public List<Item> getInventario(){
        return new ArrayList<>(inventario.values());
    }

    /**
     * Busca un item en el inventario del personaje por su nombre
     * @param nombreItem
     * @return
     */
    public Item buscarItem(String nombreItem){
        return inventario.get(nombreItem);
    }




}
