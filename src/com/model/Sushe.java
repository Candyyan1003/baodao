package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//宿舍
@Entity
@Table(name="t_sushe")
public class Sushe {

	@Id
	@GeneratedValue
	private int id;
	
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	
	private String louhao;//楼号
	
	private String ceng;//层
	
	private String bianhao;//宿舍编号
	
	private String leixing;//男生宿舍 女生宿舍
	
	@ManyToOne
	@JoinColumn(name="banjiid")
	private Banji banji;
	
	private int renshu;//最大可住人数
	
	private int yizhu;//已住人数
	
	private int shengyu;//剩余可住
	
	
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

	public String getLouhao() {
		return louhao;
	}

	public void setLouhao(String louhao) {
		this.louhao = louhao;
	}

	public String getCeng() {
		return ceng;
	}

	public void setCeng(String ceng) {
		this.ceng = ceng;
	}

	public String getBianhao() {
		return bianhao;
	}

	public void setBianhao(String bianhao) {
		this.bianhao = bianhao;
	}

	public String getLeixing() {
		return leixing;
	}

	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}

	public int getRenshu() {
		return renshu;
	}

	public void setRenshu(int renshu) {
		this.renshu = renshu;
	}

	public int getYizhu() {
		return yizhu;
	}

	public void setYizhu(int yizhu) {
		this.yizhu = yizhu;
	}

	public int getShengyu() {
		return shengyu;
	}

	public void setShengyu(int shengyu) {
		this.shengyu = shengyu;
	}

	public Banji getBanji() {
		return banji;
	}

	public void setBanji(Banji banji) {
		this.banji = banji;
	}

	
	
}
