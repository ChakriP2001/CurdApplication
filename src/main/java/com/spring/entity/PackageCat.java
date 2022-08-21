package com.spring.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="PACKAGE_CAT")
@Entity
public class PackageCat {
	@Id
	@GeneratedValue
	private Integer PackageId;
	private String PackageName;
	private String Actionsw;
	private LocalDate Createddate;
	private LocalDate Updateddate;
	private String Cretedby;
	private String Updatedby;
	}
