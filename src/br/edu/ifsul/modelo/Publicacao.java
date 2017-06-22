package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
/**
 *
 * @author alexandre
 */
@Entity
@Table(name = "publicacao")
public class Publicacao implements Serializable{
    @Id
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O titulo não pode ser em branco")
    @Column(name = "titulo", length = 60, nullable = false)
    private String titulo;
    @NotNull(message = "A data de publicacao não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataPublicacao", nullable = false)
    private Calendar dataPublicacao;
    @NotNull(message = "O tipo não pode ser nulo")
    @NotBlank(message = "O tipo não pode ser em branco")
    @Length(max = 15, message = "O tipo não pode ter mais que {max} caracteres")
    @Column(name = "tipo", length = 15, nullable = false)
    private String tipo;
    //relação um para muitos das tabelas ALUNO e ORIENTADOR
    @ManyToOne
    @NotNull(message = "O Orientador não pode ser nulo")    
    @JoinColumn(name = "orientador", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_publicacao_orientador"))    
    private Orientador orientador;
    
    public Publicacao() {
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Calendar getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Calendar dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.titulo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Publicacao other = (Publicacao) obj;
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return true;
    }

    public Orientador getOrientador() {
        return orientador;
    }

    public void setOrientador(Orientador orientador) {
        this.orientador = orientador;
    }
    
}
