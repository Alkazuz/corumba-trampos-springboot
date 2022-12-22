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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name, description;

	/**
	 * Retorna a identidade unica do setor
	 * @return A identidade unica do setor.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Retorna o nome do setor
	 * @return O nome do setor.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Altera o nome do setor
	 * @param name Novo nome do setor.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retorna a descrição do setor
	 * @return A descrição do setor.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Altera a descrição do setor
	 * @param description Nova descrição do setor.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, name);
	}

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
