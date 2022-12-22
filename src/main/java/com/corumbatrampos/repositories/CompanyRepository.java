/**
 * Esta classe representa um repositório do medelo Comprany.
 * Ela permite operações básicas de persistência para entidades company usando o framework Java Persistence API (JPA).
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corumbatrampos.model.Company;

public interface CompanyRepository extends JpaRepository<Company, Long> {}
