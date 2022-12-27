/**
 * Esta classe representa uma setor cadastrado no sistema como Value Object.
 * Ela possui nome, descrição, salario e referência da empresa.
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.vo.v1;

import java.io.Serializable;

public class SectorVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
    // Atributos da classe
    private Long id;
    private String name;
    private String description;

    /**
     * Construtor padrão vazio.
     */
    public SectorVO() {}
    
    /**
     * Construtor que aceita três parâmetros para inicializar os atributos da classe.
     * 
     * @param id O ID do setor.
     * @param name O nome do setor.
     * @param description A descrição do setor.
     */
    public SectorVO(Long id, String name, String description) {
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
     * Define o ID do setor.
     * 
     * @param id O ID do setor.
     */
    public void setId(Long id) {
        this.id = id;
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
     * Obtém a descrição do setor.
     * 
     * @return A descrição do setor.
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * Define a descrição do setor.
     * 
     * @param description A descrição do setor.
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
