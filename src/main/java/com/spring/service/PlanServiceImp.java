package com.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.PackageCat;
import com.spring.entity.Plan;
import com.spring.repo.PacagecatRep;
import com.spring.repo.PlanRep;
@Service
public class PlanServiceImp implements PlanService {
	@Autowired
	private PacagecatRep PackageRep;
	@Autowired
	private PlanRep PlanRep;
	@Override
	public Map<Integer, String> Setplancat() {
		List<PackageCat> categories = PackageRep.findAll();
		Map<Integer, String> categorymap=new HashMap<>();
		categories.forEach(cate ->{
			categorymap.put(cate.getPackageId(),cate.getPackageName());
		});
		return categorymap;
	}

	@Override
	public boolean SavePlan(Plan plan) {
		Plan saved = PlanRep.save(plan);
		return saved.getPlanId()!=null;
	}

	@Override
	public List<Plan> GetAllPlans() {
		List<Plan> findAll = PlanRep.findAll();
		return findAll;
	}

	@Override
	public Plan getPlanByID(Integer planId) {
		Optional<Plan> findById = PlanRep.findById(planId);
		if(findById.isPresent())findById.get();
		return null;
	}

	@Override
	public boolean Updateplan(Plan plan) {
		PlanRep.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean Deleteplan(Integer planId) {
		boolean status=false;
		try {
		PlanRep.deleteById(planId);
		status =true;
		}catch(Exception  e) {e.printStackTrace();}
		return status;
	}

	@Override
	public boolean stausofplan(Integer id, String activesw) {
		Optional<Plan> findById = PlanRep.findById(id);
		if(findById.isPresent()) {
			Plan plan=findById.get();
			plan.setActionsw(activesw);
			PlanRep.save(plan);
			return true;
			}
		return false;
	}

}
