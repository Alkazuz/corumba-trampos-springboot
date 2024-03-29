/**
 * Esta classe representa um repositório do medelo Sector.
 * Ela permite operações básicas de persistência para entidades sector usando o framework Java Persistence API (JPA).
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corumbatrampos.model.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector, Long> {}
