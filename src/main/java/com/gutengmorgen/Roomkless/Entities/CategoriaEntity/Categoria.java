package com.gutengmorgen.Roomkless.Entities.CategoriaEntity;

import com.gutengmorgen.Roomkless.Entities.ItemsEntity.Item;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "categorias")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha_de_creacion;
    private String nombre;
    private Boolean visibilidad;
    private Long numero_de_items = 0L;

    @OneToMany(mappedBy = "categoria_pw")
    private List<Item> items;

    public Categoria(DtoCrearCategoria parms) {
        this.fecha_de_creacion = parms.fecha_de_creacion();
        this.nombre = parms.nombre();
        this.visibilidad = parms.visibilidad();
    }

    public void actualizar(DtoModificarCategoria parms) {
        if(parms.nombre() != null)
            this.nombre = parms.nombre();
        if(parms.visibilidad() != null)
            this.visibilidad = parms.visibilidad();
        if(parms.numero_de_items() != null)
            this.numero_de_items = parms.numero_de_items();
    }
}
