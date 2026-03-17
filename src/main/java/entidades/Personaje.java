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

    /**
     * agrega un item al equipo del personaje
     * @param tipoEquipamiento
     * @param item
     */
    public void agregarEquipo(TipoEquipamiento tipoEquipamiento, Item item){
        //verificar que el item no este ya en el equipo
        if (equipo.containsKey(tipoEquipamiento)) {
            //Mover el item al inventario
            Item antiguo = equipo.get(tipoEquipamiento);
            inventario.put(antiguo.getNombre(), antiguo);
        }
        //Poner de nuevo
        equipo.put(tipoEquipamiento, item);
        //Eliminar el nuevo item del inventario
        inventario.remove(item.getNombre());
    }

    /**
     * elimina un item del equipo del personaje, lo devolvemos al inventario
     * @param tipoEquipamiento
     */
    public void quitarEquipo(TipoEquipamiento tipoEquipamiento){
        Item item = equipo.get(tipoEquipamiento);
        equipo.remove(item.getNombre(), item);
    }


    /**
     * Devuelve una lista con todos los items del equipo del personaje
     * @return Map.Entry<TipoEquipamiento, Item>
     */
    public List<Map.Entry<TipoEquipamiento, Item>> getEquipo(){
        return new ArrayList<>(equipo.entrySet());
    }



    }




}
