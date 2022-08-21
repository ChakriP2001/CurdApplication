package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.Plan;

public interface PlanRep extends JpaRepository<Plan, Integer> {

}
