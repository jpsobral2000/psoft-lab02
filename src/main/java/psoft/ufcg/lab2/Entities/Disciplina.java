package psoft.ufcg.lab2.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class Disciplina {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long id;

    private String nome;
    private double nota;
    private String comentarios;
    private int likes;

    public Disciplina(@JsonProperty ("nome")String nome) {
        this.id = id;
        this.nome = nome;
        this.nota = nota;
        this.comentarios = comentarios;
        this.likes = likes;

    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Disciplina that = (Disciplina) object;
        return id == that.id &&
                Double.compare(that.nota, nota) == 0 &&
                likes == that.likes &&
                java.util.Objects.equals(nome, that.nome) &&
                java.util.Objects.equals(comentarios, that.comentarios);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, nome, nota, comentarios, likes);
    }
}