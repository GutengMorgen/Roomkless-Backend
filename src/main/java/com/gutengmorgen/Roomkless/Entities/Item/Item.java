package com.gutengmorgen.Roomkless.Entities.Item;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "items")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha_de_creacion;
    private String nombre;
    private String link;
    private String link_status;
    private String descripcion;
    private Boolean visibilidad;
    private String etiqueta;
    private Long visitas;
    private Date ultima_visita;
    private Long categoria_id;

    public Item(DtoCrearItem parms){
     this.fecha_de_creacion = parms.fecha_de_creacion();
     this.nombre = parms.nombre();
     this.link = parms.link();
     this.link_status = parms.link_status();
     this.descripcion = parms.descripcion();
     this.visibilidad = parms.visibilidad();
     this.etiqueta = parms.etiqueta();
    }

    public Item(DtoModificarItem parms){
        this.nombre = parms.nombre();
        this.link = parms.link();
        this.link_status = parms.link_status();
        this.descripcion = parms.descripcion();
        this.visibilidad = parms.visibilidad();
        this.etiqueta = parms.etiqueta();
    }
}
