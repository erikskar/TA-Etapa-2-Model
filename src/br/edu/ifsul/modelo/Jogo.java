/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author eriks
 */
@Entity
@Table(name = "jogo")
public class Jogo implements Serializable{
    
    @Id
    @SequenceGenerator(name = "seq_jogo", sequenceName = "seq_jogo_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_jogo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O jogo não pode ser nulo")
    @NotBlank(message = "O jogo não pode ser em branco")
    @Length(max = 50, message = "O jogo não pode ter mais que {max} caracteres")
    @Column(name = "jogo", length = 50, nullable = false)    
    private String jogo;
    
    @NotNull(message = "A categoria não pode ser nula")
    @NotBlank(message = "a categoria não pode estar em branco")
    @Length(max = 255, message = "A categoria não pode ter mais que {max} caracteres")
    @Column(name = "categoria", length = 50, nullable = false)    
    private String categoria;
    
    @NotNull(message = "O dono não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "dono", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_jogo_gamer"))
    private Gamer dono;
    
    public Jogo(){
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJogo() {
        return jogo;
    }

    public void setJogo(String jogo) {
        this.jogo = jogo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Gamer getDono() {
        return dono;
    }

    public void setDono(Gamer dono) {
        this.dono = dono;
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Jogo other = (Jogo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
}
