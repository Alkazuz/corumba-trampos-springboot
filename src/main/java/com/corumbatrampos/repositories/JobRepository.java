/**
 * Esta classe representa um repositório do medelo Job.
 * Ela permite operações básicas de persistência para entidades job usando o framework Java Persistence API (JPA).
 * 
 * @author Marcos
 * @version 1.0
 */

package com.corumbatrampos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corumbatrampos.model.Job;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {}
