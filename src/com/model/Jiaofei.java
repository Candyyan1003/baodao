package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//缴费
@Entity
@Table(name="t_Jiaofei")
public class Jiaofei {

	@Id
	@GeneratedValue
	private int id;
	
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	
	@ManyToOne
	@JoinColumn(name="studentid")
	private Student student;//关联的学生，外键
	
	private int xuefen;//学费
	
	private int zafei;//杂费
	
	private int zhusu;//住宿费
	
	private int total;//总计
	
	private String path;//缴费凭证
	
	private String ctime;//缴费时间

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

	public int getXuefen() {
		return xuefen;
	}

	public void setXuefen(int xuefen) {
		this.xuefen = xuefen;
	}

	public int getZafei() {
		return zafei;
	}

	public void setZafei(int zafei) {
		this.zafei = zafei;
	}

	public int getZhusu() {
		return zhusu;
	}

	public void setZhusu(int zhusu) {
		this.zhusu = zhusu;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}
	
	
	
	
	
	
	
}
