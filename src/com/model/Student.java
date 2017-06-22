package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//学生
@Entity
@Table(name="t_student")
public class Student {

	@Id
	@GeneratedValue
	private int id;
	
	private int deletestatus;//表示是否删除的状态，0表示未删除，1表示删除
	
	private String xuehao;//学号
	
	private String name;//姓名
	
	private String sfz;//身份证
	
	private String photo;//照片
	
	private String sex;//性别
	
	private String minzu;//民族
	
	private String zzmm;//政治面貌
	
	@ManyToOne
	@JoinColumn(name="xueyuan")
	private All xueyuan;
	
	@ManyToOne
	@JoinColumn(name="zhuanye")
	private All zhuanye;
	
	

	private String tel;//手机号码
	
	private String address;//家庭地址
	
	private int jiaofei;//是否缴费
	
	private int sushe;//是否分配宿舍
	
	private int banji;//是否分配班级
	
	private int ykt;//是否分配一卡通
	
	private int dangan;//是否转档案
	
	private int tijian;//是否提交体检报告
	
	private String password;//登录密码

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

	public String getXuehao() {
		return xuehao;
	}

	public void setXuehao(String xuehao) {
		this.xuehao = xuehao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSfz() {
		return sfz;
	}

	public void setSfz(String sfz) {
		this.sfz = sfz;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getMinzu() {
		return minzu;
	}

	public void setMinzu(String minzu) {
		this.minzu = minzu;
	}

	public String getZzmm() {
		return zzmm;
	}

	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
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

	public int getBanji() {
		return banji;
	}

	public void setBanji(int banji) {
		this.banji = banji;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getJiaofei() {
		return jiaofei;
	}

	public void setJiaofei(int jiaofei) {
		this.jiaofei = jiaofei;
	}

	public int getSushe() {
		return sushe;
	}

	public void setSushe(int sushe) {
		this.sushe = sushe;
	}

	public int getYkt() {
		return ykt;
	}

	public void setYkt(int ykt) {
		this.ykt = ykt;
	}

	public int getDangan() {
		return dangan;
	}

	public void setDangan(int dangan) {
		this.dangan = dangan;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getTijian() {
		return tijian;
	}

	public void setTijian(int tijian) {
		this.tijian = tijian;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
