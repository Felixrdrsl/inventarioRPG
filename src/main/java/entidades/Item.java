package entidades;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "nombre")


public class Item {

    private String nombre;
    private String descripcion;
    private Integer nivelRequerido;
    private TipoItem tipoItem;




}
