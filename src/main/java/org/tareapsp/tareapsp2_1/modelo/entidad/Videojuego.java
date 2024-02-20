package org.tareapsp.tareapsp2_1.modelo.entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "videojuegos")
public class Videojuego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String nombre;
    private String compania;
    private String nota;

    public Videojuego() {
    }

    public Videojuego(int id, String nombre, String compañia, String nota) {
        this.id = id;
        this.nombre = nombre;
        this.compania = compañia;
        this.nota = nota;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compañia) {
        this.compania = compañia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Videojuego{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", compañia='" + compania + '\'' +
                ", nota='" + nota + '\'' +
                '}';
    }
}
