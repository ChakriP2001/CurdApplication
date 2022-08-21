package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Plan_table")
@Data
public class Plan {
	@Id
	@GeneratedValue
	private Integer PlanId;
	private String PlanName;
	private LocalDate Startingdate;
	private LocalDate Endingdate;
	private Integer PlanCatid;
	private String Actionsw;
	private LocalDate Createddate;
	private LocalDate Updateddate;
	private String Cretedby;
	private String Updatedby;	

}
