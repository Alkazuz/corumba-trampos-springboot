/**
 * Esta classe representa setores de uma vaga. Por exemplo: setor financeiro, TI, etc.
 * Ela possui nome e descrição.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Sector implements Serializable{

	private static final long serialVersionUID = 1L;

    // Atributos da classe
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name, description;

    /**
     * Construtor padrão vazio.
     */
    public Sector() {}
    
    /**
     * Construtor que aceita três parâmetros para inicializar os atributos da classe.
     * 
     * @param id O ID do setor.
     * @param name O nome do setor.
     * @param description A descrição do setor.
     */
    public Sector(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    /**
     * Obtém o ID do setor.
     * 
     * @return O ID do setor.
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Obtém o nome do setor.
     * 
     * @return O nome do setor.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Define o nome do setor.
     * 
     * @param name O nome do setor.
     */
    public void setName(String name) {
        this.name = name;
    }

	/**
     * Define a descrição do setor.
     * 
     * @param description A descrição do setor.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gera um código de hash para o objeto.
     * 
     * @return O código de hash gerado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(description, name);
    }

    /**
     * Compara o objeto atual com outro objeto.
     * 
     * @param obj O objeto a ser comparado.
     * @return Verdadeiro se os objetos forem iguais, falso caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sector other = (Sector) obj;
        return Objects.equals(description, other.description) && Objects.equals(name, other.name);
    }

}
