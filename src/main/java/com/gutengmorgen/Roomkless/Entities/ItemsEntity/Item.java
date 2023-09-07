package com.gutengmorgen.Roomkless.Entities.ItemsEntity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gutengmorgen.Roomkless.Entities.CategoriaEntity.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "items")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private Long visitas = 0L;
    private Date ultima_visita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private Categoria categoria;

    public Item(DtoCrearItem parms){
     this.fecha_de_creacion = parms.fecha_de_creacion();
     this.nombre = parms.nombre();
     this.link = parms.link();
     this.link_status = parms.link_status();
     this.descripcion = parms.descripcion();
     this.visibilidad = parms.visibilidad();
     this.etiqueta = parms.etiqueta();
     this.ultima_visita = parms.ultima_visita();
    }

    public void actualizar(DtoModificarItem parms){
        if(parms.nombre() != null)
            this.nombre = parms.nombre();
        if(parms.link() != null)
            this.link = parms.link();
        if(parms.link_status() != null)
            this.link_status = parms.link_status();
        if(parms.descripcion() != null)
            this.descripcion = parms.descripcion();
        if(parms.visibilidad() != null)
            this.visibilidad = parms.visibilidad();
        if(parms.etiqueta() != null)
            this.etiqueta = parms.etiqueta();
        if(parms.visitas() != null)
            this.visitas = parms.visitas();
        if(parms.ultima_visita() != null)
            this.ultima_visita = parms.ultima_visita();
    }
}
