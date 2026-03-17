package app;

import entidades.Item;
import entidades.Personaje;
import entidades.TipoEquipamiento;
import entidades.TipoItem;

import java.util.Map;

public class app {


    static void main() {
        Personaje personaje = new Personaje("Manolo");
        personaje.agregarItemAlInventario(new Item("Vara troncho",
                "Una vara magica",10, TipoItem.ARMA));
        personaje.agregarItemAlInventario(new Item("Capa blanca",
                "capa de mago blanca ",7, TipoItem.ARMADURA));
        personaje.agregarItemAlInventario(new Item("Vino de la comarca",
                "ejem",1, TipoItem.CONSUMIBLE));
        personaje.agregarItemAlInventario(new Item("Botas de tom bombadil",
                "rayo mcqueen",3, TipoItem.ARMADURA));



        personaje.agregarEquipo(TipoEquipamiento.MANO_PRINCIPAL,personaje.buscarItem("Vara troncho"));
        personaje.agregarEquipo(TipoEquipamiento.PECHO,personaje.buscarItem("Capa blanca"));
        IO.println("----- Equipo -----");
        for (Map.Entry<TipoEquipamiento, Item> entry : personaje.getEquipo()){
            IO.println(entry.getKey() + ": " + entry.getValue());
        }

        IO.println("----- Inventario -----");
        for (Item item: personaje.getInventario()){
            IO.println(item);
        }

    }
}
