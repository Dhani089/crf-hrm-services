package com.hrm.hrmsecurity.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLOYEES database table.
 * 
 */
@Entity
@Table(name="EMPLOYEES")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long empno;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	

	@Column(name = "dateofbirth")
	private Date dateofbirth;

	@Column(name = "designation")
	private String designation;

	@Column(name = "hiredate")
	private Date hiredate;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	

	@Column(name = "deptno")
	private String deptno;


	public long getEmpno() {
		return empno;
	}


	public void setEmpno(long empno) {
		this.empno = empno;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public Date getDateofbirth() {
		return dateofbirth;
	}


	public void setDateofbirth(Date dateofbirth) {
		this.dateofbirth = dateofbirth;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getDeptno() {
		return deptno;
	}


	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}

	
}