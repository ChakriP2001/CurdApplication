package com.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.entity.Plan;
import com.spring.entity.PackageCat;
@Service
public interface PlanService {

	public  Map<Integer,String> Setplancat();
	public boolean SavePlan(Plan plan);
	public List<Plan> GetAllPlans();
	public Plan getPlanByID(Integer planId);
	public boolean Updateplan(Plan plan);
	public boolean Deleteplan(Integer planId);
	public boolean stausofplan(Integer id , String activesw);		
}
