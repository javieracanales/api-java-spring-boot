package com.arriendos_ya_back.models;

import jakarta.persistence.*;
import java.time.ZonedDateTime;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "eventos")
public class evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descripcion;

    @Column(name = "fecha", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime fecha;
    private String url;

    @ManyToOne
    @JoinColumn(name = "propiedad_id", nullable = false)
    @JsonBackReference 
    private propiedad propiedad;

    public evento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public ZonedDateTime getFecha() { return fecha; }
    public void setFecha(ZonedDateTime fecha) { this.fecha = fecha; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public propiedad getPropiedad() { return propiedad; }
    public void setPropiedad(propiedad propiedad) { this.propiedad = propiedad; }
}