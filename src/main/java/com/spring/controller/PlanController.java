package com.spring.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entity.Plan;

import com.spring.service.PlanService;


@RestController
public class PlanController {
	@Autowired
	PlanService planservice;
	@GetMapping("/Category")
	public ResponseEntity<Map<Integer, String>>planCategories(){
		Map<Integer, String> cate=planservice.Setplancat();
		return new ResponseEntity<>(cate,HttpStatus.OK);
		}
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan){
		String msg="";
		boolean issaved=planservice.SavePlan(plan);
		if(issaved)msg="Plan Saved ";else msg="not saved ";
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
					}
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> planes(){
		List<Plan> allplans=planservice.GetAllPlans();
		return new ResponseEntity<>(allplans,HttpStatus.OK);
	}
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editplan(@PathVariable Integer PlanId){
		Plan plan=planservice.getPlanByID(PlanId);
		return new ResponseEntity<>(plan,HttpStatus.OK);
	}
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deleteplan(@PathVariable Integer PlanId){
		boolean isdelete=planservice.Deleteplan(PlanId);
		String msg="";
		if(isdelete)msg="is deleted ";else msg="not deleted";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@PutMapping("/plan")
	public ResponseEntity<String>updateplan(@RequestBody Plan plan){
		boolean isupdated=planservice.Updateplan(plan);
		String msg="";
		if(isupdated)msg="plan updated"; else msg="plan is not updated";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statuschanged(@PathVariable Integer planId, @PathVariable String status){
		boolean isstatuschaged=planservice.stausofplan(planId, status);
		String msg="";
		if(isstatuschaged)msg="satus is changed ";else msg="status is not changed ";
		return new ResponseEntity<>(msg,HttpStatus.OK);
	}
}
	
