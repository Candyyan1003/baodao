package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//分配宿舍
@Entity
@Table(name="t_zhusu")
public class Zhusu {

	@Id
	@GeneratedValue
	private int id;
	
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;//关联的学生，外键
	
	@ManyToOne
	@JoinColumn(name="susheid")
	private Sushe sushe;//关联的宿舍，外键
	
	private String ctime ;//分配时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDeletestatus() {
		return deletestatus;
	}

	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Sushe getSushe() {
		return sushe;
	}

	public void setSushe(Sushe sushe) {
		this.sushe = sushe;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
}
