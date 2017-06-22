package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//班级
@Entity
@Table(name="t_banji")
public class Banji {
	
	@Id
	@GeneratedValue
	private int id;
	private String bianhao;
	
	@ManyToOne
	@JoinColumn(name="xueyuan")
	private All xueyuan;
	
	@ManyToOne
	@JoinColumn(name="zhuanye")
	private All zhuanye;
	
	private int renshu;
	private int yiyou;
	private int shengyu;
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBianhao() {
		return bianhao;
	}
	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}
	
	public All getXueyuan() {
		return xueyuan;
	}
	public void setXueyuan(All xueyuan) {
		this.xueyuan = xueyuan;
	}
	public All getZhuanye() {
		return zhuanye;
	}
	public void setZhuanye(All zhuanye) {
		this.zhuanye = zhuanye;
	}
	public int getRenshu() {
		return renshu;
	}
	public void setRenshu(int renshu) {
		this.renshu = renshu;
	}
	public int getYiyou() {
		return yiyou;
	}
	public void setYiyou(int yiyou) {
		this.yiyou = yiyou;
	}
	public int getShengyu() {
		return shengyu;
	}
	public void setShengyu(int shengyu) {
		this.shengyu = shengyu;
	}
	public int getDeletestatus() {
		return deletestatus;
	}
	public void setDeletestatus(int deletestatus) {
		this.deletestatus = deletestatus;
	}
	
}
