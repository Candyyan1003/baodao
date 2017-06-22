package com.action;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.JSON;
import com.dao.AllDao;
import com.dao.BanjiDao;
import com.dao.DanganDao;
import com.dao.FenbanDao;
import com.dao.JiaofeiDao;
import com.dao.StudentDao;
import com.dao.SusheDao;
import com.dao.TijianDao;
import com.dao.UserDao;
import com.dao.YktDao;
import com.dao.ZhusuDao;
import com.model.All;
import com.model.Banji;
import com.model.Dangan;
import com.model.Fenban;
import com.model.Jiaofei;
import com.model.Student;
import com.model.Sushe;
import com.model.Tijian;
import com.model.User;
import com.model.Ykt;
import com.model.Zhusu;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pager;
import com.util.Util;



public class ManageAction extends ActionSupport {

	private static final long serialVersionUID = -4304509122548259589L;

	
	 private boolean result;
	 
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	private String url = "./";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	//获取请求对象
	public HttpServletRequest getRequest(){
		HttpServletRequest request = ServletActionContext.getRequest();
		return request;
	}
	
	
	//获取响应对象
	public HttpServletResponse getResponse(){
		HttpServletResponse response = ServletActionContext.getResponse();
		return response;
	}
	
	//获取session对象
	public HttpSession getSession(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		return session;
	}
	
	
	//获取输出对象
	public PrintWriter getPrintWriter() {
		
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return writer;
	}
	
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	
	
//登录请求
	public String login() throws IOException {
		String responseContext="";
		HttpServletRequest request = this.getRequest();
		PrintWriter writer=this.getPrintWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String  role = request.getParameter("status");
		
			User user = userDao.selectBean(" where username = '" + username
					+ "' and password= '" + password +"' and role='"+role+"' and deletestatus=0 ");
			
			if (user != null) {
				
				HttpSession session = request.getSession();
				All all=user.getDepart();
				String depart=all.getDepart().trim();
				int number=all.getNumber();
				//截取字符串判断末尾是学院的部门
				String userDepart=depart.substring(depart.length()-2,depart.length());
				session.setAttribute("user", user);
				session.setAttribute("userDepart", userDepart);
				session.setAttribute("number", number);
			}else{
				responseContext="false";
			}
		 writer.print(responseContext);
		 writer.flush();
		 writer.close();
		return null;	
	}
	
	//学生登录
	
	public String stuLogin(){
		String responseContextstu="";
		HttpServletRequest request=this.getRequest();
		PrintWriter writer=this.getPrintWriter();
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
			Student stu=studentDao.selectBean("where name='"+name+"' and password='"+password+"'");
			if(stu!=null){
				HttpSession session=request.getSession();
				session.setAttribute("stu",stu);
				
			}else{
				responseContextstu="false";
			}
		
		writer.print(responseContextstu);
		writer.flush();
		writer.close();
		return null;
	}
//用户退出
	public String loginout() {
		HttpServletRequest request = this.getRequest();
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		this.setUrl("login.jsp");
		return SUCCESS;
	}
//跳转到修改密码页面
	public String changepwd() {
		this.setUrl("password.jsp");
		return SUCCESS;
	}

//修改密码操作
	public void changepwd2() throws IOException {
		
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		HttpSession session = request.getSession();
		String password=request.getParameter("password1");
		String password3 = request.getParameter("password3");
		
		User u = (User)session.getAttribute("user");
		User user=userDao.selectBean(" where username='"+u.getUsername()+"' and password='"+password+"' and deletestatus=0");
		
		if(user!=null){
			user.setPassword(password3);
			userDao.updateBean(user);
			writer.print("<script language=javascript>alert('修改成功');window.location.href='method!changepwd'</script>");
		}else{
			
			writer.print("<script language=javascript>alert('原密码错误！');window.location.href='method!changepwd'</script>");
			
		}
		
	}
	
	
	//工作人员列表
	public String userlist() {
		HttpServletRequest request = this.getRequest();
		
		String username = request.getParameter("username");		
		String depart=request.getParameter("depart");
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (username != null && !"".equals(username)) {

			sb.append("username like '%" + username + "%'");
			sb.append(" and ");
			request.setAttribute("username", username);
		}

		if (depart != null && !"".equals(depart)) {
			All all=allDao.selectBean(" where depart='"+depart+"'");
			sb.append("depart =" + all.getId() );
			sb.append(" and ");
			request.setAttribute("depart", depart);
		}
		
		sb.append("   deletestatus=0  and role is not 1 order by username  ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = userDao.selectBeanCount(where.replaceAll(" order by username  ", ""));
		request.setAttribute("list", userDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!userlist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!userlist");
		request.setAttribute("url2", "method!user");
		request.setAttribute("biaoti", "工作人员管理");
		this.setUrl("user/userlist.jsp");
		return SUCCESS;

	}
	private AllDao allDao;
	
	
	public AllDao getAllDao() {
		return allDao;
	}

	public void setAllDao(AllDao allDao) {
		this.allDao = allDao;
	}

	//跳转到添加工作人员页面
	public String useradd() {
		HttpServletRequest request = this.getRequest();
		//查询出所有的部门
		List<All> departs=allDao.selectBeanList(0, 100, "  where  parentid=0");
		request.setAttribute("list", departs);
		
		request.setAttribute("url", "method!useradd2");
		request.setAttribute("biaoti", "工作人员添加");
		this.setUrl("user/useradd.jsp");
		return SUCCESS;
	}
	

//添加工作人员操作
	public void useradd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		String depart=request.getParameter("depart");
		
		All all=allDao.selectBean(" where id='"+depart+"'");
		
		User bean = userDao.selectBean(" where deletestatus=0 and  username='"+username+"' ");
		if(bean!=null){
			writer.print("<script language=javascript>alert('操作失败，该账号已经存在');window.location.href='method!userlist';</script>");
			return;
		}
		
		bean = new User();
		
		bean.setCreatetime(Util.getRiqi());
		bean.setName(name);
		bean.setPassword("111111");
		
		bean.setRole(2);
		bean.setDepart(all);
		
		bean.setTel(tel);
		bean.setUsername(username);
		
		
		userDao.insertBean(bean);
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
			
	}
	
//跳转到更新工作人员页面
	public String userupdate() {
		HttpServletRequest request = this.getRequest();
		List<All> list=allDao.selectBeanList(0, 999, " where parentid=0 ");
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		request.setAttribute("list", list);
		request.setAttribute("url", "method!userupdate2?id="+bean.getId());
		request.setAttribute("biaoti", "更新工作人员");
		this.setUrl("user/userupdate.jsp");
		return SUCCESS;
	}
	
	
//更新工作人员操作
	public void userupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");

		String depart=request.getParameter("depart");
		All all=allDao.selectBean(" where id="+depart);
		
		
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setName(name);
		bean.setTel(tel);
		bean.setDepart(all);
		userDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
	}
	
//删除工作人员操作
	public void userdelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		userDao.updateBean(bean);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!userlist';</script>");
		
	}
	
	//跳转到查看工作人员页面
	public String userupdate3() {
		HttpServletRequest request = this.getRequest();
		User bean = userDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("biaoti", "工作人员查看");
		this.setUrl("user/userupdate3.jsp");
		return SUCCESS;
	}
	
	
	private SusheDao susheDao;

	public SusheDao getSusheDao() {
		return susheDao;
	}

	public void setSusheDao(SusheDao susheDao) {
		this.susheDao = susheDao;
	}
	
	
	//宿舍列表
	public String sushelist() {
		HttpServletRequest request = this.getRequest();
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");
		
		String bianhao = request.getParameter("bianhao");		
		String zhuanye=request.getParameter("zhuanye");
		if(zhuanye!=null&&!"".equals(zhuanye)){
			All zy=allDao.selectBean(" where depart like' %"+zhuanye+"%'");
			sb.append(" zhuanye="+zy);
			sb.append(" and");
			request.setAttribute("zhuanye", zhuanye);
		}
		
		
		

		if (bianhao != null && !"".equals(bianhao)) {

			sb.append("bianhao like '%" + bianhao + "%'");
			sb.append(" and ");
			request.setAttribute("bianhao", bianhao);
		}
		
		sb.append("   deletestatus=0  order by id desc ");
		String where = sb.toString();

		int currentpage = 1;
		int pagesize =5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = susheDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", susheDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!sushelist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!sushelist");
		request.setAttribute("url2", "method!sushe");
		request.setAttribute("biaoti", "宿舍管理");
		this.setUrl("sushe/sushelist.jsp");
		return SUCCESS;

	}
	
//跳转到添加宿舍页面
	public String susheadd() {
		HttpServletRequest request = this.getRequest();
		List<All> zhuanye=allDao.selectBeanList(0, 999, " where parentid is not 0");
		request.setAttribute("listZy", zhuanye);
		request.setAttribute("url", "method!susheadd2");
		request.setAttribute("biaoti", "宿舍添加");
		this.setUrl("sushe/susheadd.jsp");
		return SUCCESS;
	}
	

//添加宿舍操作
	public void susheadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String bianhao = request.getParameter("bianhao");
		String ceng = request.getParameter("ceng");
		String leixing = request.getParameter("leixing");
		String louhao = request.getParameter("louhao");
		String zhuanye=request.getParameter("zhuanye");
		String banjibianhao=request.getParameter("banjibianhao");
		String renshu = request.getParameter("renshu");
		
		Sushe bean = susheDao.selectBean(" where deletestatus=0 and louhao='"+louhao+"'  and  bianhao='"+bianhao+"' ");
		if(bean!=null){
			writer.print("<script language=javascript>alert('操作失败，该楼已存在该宿舍编号');window.location.href='method!sushelist';</script>");
			return;
		}
		
		Banji bj=banjiDao.selectBean(" where zhuanye='"+zhuanye+"' and bianhao='"+banjibianhao+"'");
		if(bj==null){
			writer.print("<script language=javascript>alert('班级不存在，请先添加此班级');window.location.href='method!banjiadd';</script>");
			return;
		}
		
		bean = new Sushe();
		
		bean.setBianhao(bianhao);
		bean.setCeng(ceng);
		bean.setLeixing(leixing);
		bean.setLouhao(louhao);
		bean.setRenshu(Integer.parseInt(renshu));
		bean.setShengyu(Integer.parseInt(renshu));
		bean.setBanji(bj);
		susheDao.insertBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!sushelist';</script>");
				
	}
	
	
//跳转到更新宿舍页面
	public String susheupdate() {
		HttpServletRequest request = this.getRequest();
		Sushe bean = susheDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!susheupdate2?id="+bean.getId());
		request.setAttribute("biaoti", "更新宿舍");
		this.setUrl("sushe/susheupdate.jsp");
		return SUCCESS;
	}
	
	
//更新宿舍操作
	public void susheupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String bianhao = request.getParameter("bianhao");
		String ceng = request.getParameter("ceng");
		String leixing = request.getParameter("leixing");
		String louhao = request.getParameter("louhao");
		String renshu = request.getParameter("renshu");


		Sushe bean = susheDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setBianhao(bianhao);
		bean.setCeng(ceng);
		bean.setLeixing(leixing);
		bean.setLouhao(louhao);
		bean.setRenshu(Integer.parseInt(renshu));
		
		susheDao.updateBean(bean);
		
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!sushelist';</script>");
	}
	
//删除宿舍操作
	public void sushedelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		Sushe bean = susheDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		susheDao.updateBean(bean);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!sushelist';</script>");
		
	}
	
	//跳转到查看宿舍页面
	public String susheupdate3() {
		HttpServletRequest request = this.getRequest();
		Sushe bean = susheDao.selectBean(" where id= "
				+ request.getParameter("id"));
		request.setAttribute("bean", bean);
		request.setAttribute("biaoti", "宿舍查看");
		this.setUrl("sushe/susheupdate3.jsp");
		return SUCCESS;
	}
	
	private BanjiDao banjiDao;
	
	public BanjiDao getBanjiDao() {
		return banjiDao;
	}

	public void setBanjiDao(BanjiDao banjiDao) {
		this.banjiDao = banjiDao;
	}
	
	//ajax请求获取专业
	public void seleZhuanye(){
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String xueyuan=request.getParameter("xueyuan");
		All xy=allDao.selectBean(" where id='"+xueyuan+"'");
		List<All>  zhuanyes=allDao.selectBeanList(0, 999, " where parentid="+xy.getId());
		String json=JSON.toJSONString(zhuanyes);
		writer.print(json);
	}
	
	
	
	//班级列表……
	public String banjilist(){
		
		HttpServletRequest request = this.getRequest();
		
		String bianhao = request.getParameter("bianhao");		
		String xueyuan=request.getParameter("xueyuan");
		String zhuanye=request.getParameter("zhuanye");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" where ");

		if (bianhao != null && !"".equals(bianhao)) {

			sb.append("bianhao like '%" + bianhao + "%'");
			sb.append(" and ");
			request.setAttribute("bianhao", bianhao);
		}
		if(xueyuan!=null&&!"".equals(xueyuan)){
			All xy=allDao.selectBean(" where depart like'%"+xueyuan+"%'");
			int id=xy.getId();
			sb.append(" xueyuan="+id);
			sb.append(" and");
			request.setAttribute("xueyuan", xy.getDepart());
		}
		if(zhuanye!=null&&!"".equals(zhuanye)){
			All zy=allDao.selectBean(" where depart like'%"+zhuanye+"%'");
			int id=zy.getId();
			sb.append(" zhuanye="+id);
			sb.append(" and");
			request.setAttribute("zhuanye", zy.getDepart());
		}
		
		sb.append("   deletestatus=0  order by bianhao  ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = banjiDao.selectBeanCount(where.replaceAll(" order by bianhao  ", ""));
		
		request.setAttribute("list", banjiDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		System.out.println(total);
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!banjilist", "共有" + total + "条记录"));
		request.setAttribute("url", "method!banjilist");
		request.setAttribute("url2", "method!banji");
		request.setAttribute("biaoti", "班级管理");
		this.setUrl("banji/banjilist.jsp");
		
		return SUCCESS;
	}
	
	//跳转到添加班级页面
	public String banjiadd() {
		HttpServletRequest request = this.getRequest();
		//获取所有学院
		List<All> list=allDao.selectBeanList(0, 999, " where parentid=0 and depart like'%学院'");
		request.setAttribute("list", list);
		request.setAttribute("url", "method!banjiadd2");
		request.setAttribute("biaoti", "班级添加");
		this.setUrl("banji/banjiadd.jsp");
		return SUCCESS;
	}
	
	
	//添加班级页面
	public void banjiadd2(){
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String bianhao = request.getParameter("bianhao");
		String xueyuan1 = request.getParameter("xueyuan");
		String zhuanye1 = request.getParameter("zhuanye");
		String renshu = request.getParameter("renshu");
		
		All zhuanye=allDao.selectBean(" where id="+zhuanye1);
		All xueyuan=allDao.selectBean(" where id="+xueyuan1);
		Banji bean = banjiDao.selectBean(" where deletestatus=0 and bianhao='"+bianhao+"' and zhuanye='"+zhuanye1+"'");
		if(bean!=null){
			writer.print("<script language=javascript>alert('操作失败，该专业已存在该班级编号');window.location.href='method!banjilist';</script>");
			return;
		}
		
		bean = new Banji();
		
		bean.setBianhao(bianhao);
		bean.setZhuanye(zhuanye);
		bean.setXueyuan(xueyuan);
		
		bean.setRenshu(Integer.parseInt(renshu));
		bean.setYiyou(0);
		bean.setShengyu(Integer.parseInt(renshu));
		
		banjiDao.insertBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!banjilist';</script>");
				
	}
	
	//跳转到更新班级页面
	public String banjiupdate(){
		HttpServletRequest request = this.getRequest();
		Banji bean = banjiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!banjiupdate2?id="+bean.getId());
		request.setAttribute("biaoti", "更新班级");
		this.setUrl("banji/banjiupdate.jsp");
		return SUCCESS;
	}
	
	
	//更新班级
	public void banjiupdate2(){
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String bianhao = request.getParameter("bianhao");
		String xueyuan1 = request.getParameter("xueyuan");
		String zhuanye1 = request.getParameter("zhuanye");
		String renshu = request.getParameter("renshu");

		All xueyuan=allDao.selectBean(" where id="+xueyuan1);
		All zhuanye=allDao.selectBean(" where id="+zhuanye1);
		Banji bean = banjiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		
		bean.setBianhao(bianhao);
		bean.setZhuanye(zhuanye);
		bean.setXueyuan(xueyuan);
		
		bean.setRenshu(Integer.parseInt(renshu));
		bean.setYiyou(0);
		bean.setShengyu(Integer.parseInt(renshu));
		
		banjiDao.updateBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!banjilist';</script>");
	}
	
	//删除班级
	public void banjidelete(){
		
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		Banji bean = banjiDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setDeletestatus(1);
		
		banjiDao.updateBean(bean);
		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!banjilist';</script>");
		
	}
	private StudentDao studentDao;

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	//新生登记
	public String studentlist() {
		HttpServletRequest request = this.getRequest();
		
		String xuehao = request.getParameter("xuehao");		
		
		String name = request.getParameter("name");	
		
		String sfz = request.getParameter("sfz");	
		
		String zhuanye=request.getParameter("zhuanye");
		
		String xueyuan=request.getParameter("xueyuan");
		
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		
		int id=xy.getId();
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" where ");

		if (xuehao != null && !"".equals(xuehao)) {

			sb.append("xuehao like '%" + xuehao + "%'");
			sb.append(" and ");
			request.setAttribute("xuehao", xuehao);
		}
		
		if (name != null && !"".equals(name)) {

			sb.append("name like '%" + name + "%'");
			sb.append(" and ");
			request.setAttribute("name", name);
		}
		
		if (sfz != null && !"".equals(sfz)) {

			sb.append("sfz like '%" + sfz + "%'");
			sb.append(" and ");
			request.setAttribute("sfz", sfz);
		}
		
	if(zhuanye!=null&&!"".equals(zhuanye)){
		All zy=allDao.selectBean("  where depart like '%"+zhuanye+"%'");
		sb.append(" zhuanye="+zy.getId());
		sb.append(" and ");
		request.setAttribute("zhuanye", zhuanye);
	}
	
		sb.append(" xueyuan ="+id+" and  deletestatus=0  order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = studentDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", studentDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!studentlist?xueyuan="+xueyuan, "共有" + total + "条记录"));
		request.setAttribute("url", "method!studentlist?xueyuan="+xueyuan);
		request.setAttribute("xueyuan", xy);
		request.setAttribute("url2", "method!student");
		//HttpSession session=request.getSession();
		request.setAttribute("total", total);
		request.setAttribute("biaoti", xy.getDepart()+"新生列表");
		this.setUrl("student/studentlist.jsp");
		return SUCCESS;

	}
	//ajax验证手机号不能重复
	public String checkTel(){
		System.out.println("--------------------------------------1111");
		HttpServletRequest request=this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String msg="";
		String tel=request.getParameter("tel");
		Student stu=studentDao.selectBean(" where tel='"+tel+"' and deletestatus=0");
		if(stu!=null&&!"".equals(stu)){
			msg="手机号已存在";
		}
		writer.print(msg);
		return SUCCESS;
	}
	
//跳转到新生登记页面
	public String studentadd() {
		HttpServletRequest request = this.getRequest();
		String xueyuan=request.getParameter("xueyuan");
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		List<All> zhuanyes=allDao.selectBeanList(0, 999, " where parentid="+xy.getId());
		request.setAttribute("zhuanyelist", zhuanyes);
		request.setAttribute("url", "method!studentadd2");
		request.setAttribute("biaoti", "新生登记");
		HttpSession session=request.getSession();
		session.setAttribute("xueyuan", xy);
		this.setUrl("student/studentadd.jsp");
		return SUCCESS;
	}
	
	
	private File uploadfile;

	public File getUploadfile() {
		return uploadfile;
	}

	public void setUploadfile(File uploadfile) {
		this.uploadfile = uploadfile;
	}

	//新生登记操作
	public void studentadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String address = request.getParameter("address");
		
		String minzu = request.getParameter("minzu");
		String name = request.getParameter("name");
		String sfz = request.getParameter("sfz");
		String tel = request.getParameter("tel");
		String xueyuan = request.getParameter("xueyuan");
		String zhuanye=request.getParameter("zhuanye");
		String zzmm = request.getParameter("zzmm");
		String sex = request.getParameter("sex");
		
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		System.out.println(xueyuan);
		All zy=allDao.selectBean(" where id='"+zhuanye+"'");
		String xuehao = Util.getbianhao(studentDao.selectBeanCount(""));
		//System.out.println(zy.getDepart());
		
		
		Student bean = new Student();
		
		
		bean.setAddress(address);
		
		bean.setMinzu(minzu);
		bean.setName(name);
		bean.setSfz(sfz);
		bean.setTel(tel);
		bean.setXuehao(xuehao);
		bean.setZhuanye(zy);
		bean.setXueyuan(xy);
		
		bean.setZzmm(zzmm);
		bean.setSex(sex);
		if(sfz!=null&&!"".equals(sfz)&&sfz.length()==18){
			bean.setPassword(sfz.substring(12, 18));
			
		}else {
			
		}
		//bean.setPassword(sfz.substring(12, 18));
		
		if(uploadfile!=null){
			String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

			String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

			String imgpath = time + ".jpg";
			File file1 = new File(savaPath + imgpath);
			Util.copyFile(uploadfile, file1);

			bean.setPhoto(imgpath);
		}
		studentDao.insertBean(bean);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist?xueyuan="+xueyuan+"';</script>");
		
				
	}
	
	
//跳转到修改学生信息页面
	public String studentupdate() {
		HttpServletRequest request = this.getRequest();
		Student bean = studentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		String xueyuan=request.getParameter("xueyuan");
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		List<All> listZy=allDao.selectBeanList(0, 999, " where  parentid="+xy.getId());
		request.setAttribute("listZy", listZy);
		request.setAttribute("xueyuan", xueyuan);
		request.setAttribute("bean", bean);
		request.setAttribute("url", "method!studentupdate2?id="+bean.getId());
		request.setAttribute("biaoti", "修改学生信息");
		this.setUrl("student/studentupdate.jsp");
		return SUCCESS;
	}
	
	
//更新学生操作
	public void studentupdate2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String address = request.getParameter("address");
		String minzu = request.getParameter("minzu");
		String name = request.getParameter("name");
		String sfz = request.getParameter("sfz");
		String xueyuan=request.getParameter("xueyuan");
		String tel = request.getParameter("tel");
		String zhuanye = request.getParameter("zhuanye");
		String zzmm = request.getParameter("zzmm");
		String sex = request.getParameter("sex");
		
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		
		All zy=allDao.selectBean(" where id='"+zhuanye+"'");

		Student bean = studentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		bean.setAddress(address);
		bean.setMinzu(minzu);
		bean.setName(name);
		bean.setSfz(sfz);
		bean.setTel(tel);
		bean.setXueyuan(xy);
		bean.setZhuanye(zy);
		bean.setZzmm(zzmm);
		bean.setSex(sex);
		
		
		if(uploadfile!=null){
			String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

			String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

			String imgpath = time + ".jpg";
			File file1 = new File(savaPath + imgpath);
			Util.copyFile(uploadfile, file1);

			bean.setPhoto(imgpath);
		}
		
		studentDao.updateBean(bean);
		
	
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist?xueyuan="+xueyuan+"';</script>");
	}
	
	//跳转到修改学生信息页面
		public String stuupdate() {
			HttpServletRequest request = this.getRequest();
			
			Student bean = studentDao.selectBean(" where id= "
					+ request.getParameter("studentid"));
			
			request.setAttribute("bean", bean);
			request.setAttribute("url", "method!stuupdate2?id="+bean.getId());
			request.setAttribute("biaoti", "修改个人信息");
			this.setUrl("student/stuupdate.jsp");
			return SUCCESS;
		}
		
		
	//更新学生操作
		public String stuupdate2() throws IOException {
			HttpServletRequest request = this.getRequest();
			
			String address = request.getParameter("address");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String zzmm = request.getParameter("zzmm");


			Student bean = studentDao.selectBean(" where id= "
					+ request.getParameter("id"));
			
			bean.setAddress(address);
			bean.setName(name);
			bean.setTel(tel);
			bean.setZzmm(zzmm);
			
			if(uploadfile!=null){
				String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

				String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

				String imgpath = time + ".jpg";
				File file1 = new File(savaPath + imgpath);
				Util.copyFile(uploadfile, file1);

				bean.setPhoto(imgpath);
			}
			
			studentDao.updateBean(bean);
			request.setAttribute("bean", bean);
			request.setAttribute("biaoti", "学生信息");
			request.setAttribute("url", "method!studentupdate3?id="+bean.getId());
			this.setUrl("student/studentupdate3.jsp");
			return SUCCESS;
		}
		
	
		//选择报到流程页面
		public void selebaodao(){
			PrintWriter writer=this.getPrintWriter();
			writer.print("<script language=javascript>window.location.href='student/showbaodao.jsp';</script>");
		}
		
//删除学生操作
	public void studentdelete() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		String id=request.getParameter("id");
		String xueyuan=request.getParameter("xueyuan");
		System.out.println(xueyuan);
		Student bean = studentDao.selectBean(" where id= "+id);
		//如果已分班，删除学生的时候删除关联班级,班级人数改变
		if(bean.getBanji()==1){
			Fenban fenban=fenbanDao.selectBean(" where stuid="+id);
			fenban.setDeleteStatus(1);
			fenbanDao.updateBean(fenban);
			
			Banji banji=fenban.getBanji();
			banji.setYiyou(banji.getYiyou()-1);
			banji.setShengyu(banji.getShengyu()+1);
			banjiDao.updateBean(banji);
		}
		
		//如果已分配宿舍，关联删除,宿舍人数改变
		if(bean.getSushe()==1){
			Zhusu zhusu=zhusuDao.selectBean(" where studentid= "+id);
			zhusu.setDeletestatus(1);
			zhusuDao.updateBean(zhusu);
			Sushe sushe=zhusu.getSushe();
			sushe.setYizhu(sushe.getYizhu()-1);
			sushe.setShengyu(sushe.getShengyu()+1);
			susheDao.updateBean(sushe);
		}
		
		//如果已开通一卡通，关联删除
		if(bean.getYkt()==1){
			Ykt ykt=yktDao.selectBean(" where studentid="+id);
			ykt.setDeletestatus(1);
			yktDao.updateBean(ykt);
		}
		
		//如果已体检，关联删除
		if(bean.getTijian()==1){
			Tijian tijian=tijianDao.selectBean(" where studentid="+id);
			tijian.setDeletestatus(1);
			tijianDao.updateBean(tijian);
			
		}
		
		//转档案关联删除
		if(bean.getDangan()==1){
			Dangan dangan=danganDao.selectBean(" where studentid="+id);
			dangan.setDeletestatus(1);
			danganDao.updateBean(dangan);
		}
		
		//缴费关联删除
		if(bean.getJiaofei()==1){
			Jiaofei jiaofei=jiaofeiDao.selectBean(" where studentid="+id);
			jiaofei.setDeletestatus(1);
			jiaofeiDao.updateBean(jiaofei);
		}
		bean.setDeletestatus(1);
		
		studentDao.updateBean(bean);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist?xueyuan="+xueyuan+"';</script>");
		
	}
	
	//跳转到查看学生页面
	public String studentupdate3() {
		
		HttpServletRequest request = this.getRequest();
		
		Student bean = studentDao.selectBean(" where id= "
				+ request.getParameter("id"));
		
		request.setAttribute("bean", bean);
		
		request.setAttribute("biaoti", "学生信息查看");
		
		this.setUrl("student/studentupdate3.jsp");
		
		return SUCCESS;
	}
	
	
	//新生报道管理
	public String studentlist2() {
		
		HttpServletRequest request = this.getRequest();
		
		String xuehao = request.getParameter("xuehao");		
		
		String name = request.getParameter("name");	
		
		String sfz = request.getParameter("sfz");	
		
		String xueyuan=request.getParameter("xueyuan");
		
		
		All xy=allDao.selectBean(" where depart='"+xueyuan+"'");
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(" where ");

		if (xuehao != null && !"".equals(xuehao)) {

			sb.append("xuehao like '%" + xuehao + "%'");
			sb.append(" and ");
			request.setAttribute("xuehao", xuehao);
		}
		
		if (name != null && !"".equals(name)) {

			sb.append("name like '%" + name + "%'");
			sb.append(" and ");
			request.setAttribute("name", name);
		}
		
		if (sfz != null && !"".equals(sfz)) {

			sb.append("sfz like '%" + sfz + "%'");
			sb.append(" and ");
			request.setAttribute("sfz", sfz);
		}
		
		if(xueyuan!=null &&xueyuan.endsWith("学院")){
			sb.append("  xueyuan = "+xy.getId());
			sb.append(" and ");
			request.setAttribute("xueyuan", xueyuan);
		}
		
		sb.append(" deletestatus=0  order by id desc ");
			 
		
		String where = sb.toString();

		int currentpage = 1;
		int pagesize = 5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int total = studentDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", studentDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		if(xueyuan!=null &&xueyuan.endsWith("学院")){
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
					currentpage, "method!studentlist2?xueyuan="+xueyuan, "共有" + total + "条记录"));
			request.setAttribute("url", "method!studentlist2?xueyuan="+xueyuan);
			request.setAttribute("url2", "method!student");
			request.setAttribute("biaoti",xueyuan+"新生报道管理");
			request.setAttribute("xueyuan", xueyuan);
			
			
		}else{
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
					currentpage, "method!studentlist2?", "共有" + total + "条记录"));
			request.setAttribute("url", "method!studentlist2");
			request.setAttribute("url2", "method!student");
			request.setAttribute("biaoti","新生报道管理");
			HttpSession session=getSession();
			User user=(User) session.getAttribute("user");
			request.setAttribute("user", user);
		}
		
		this.setUrl("student/studentlist2.jsp");
		return SUCCESS;
	}
	
	
	//学生个人查看自己详细信息包括已报到等
	public String studetail(){
		HttpServletRequest request = this.getRequest();
		String studentid = request.getParameter("studentid");
		Student stu=studentDao.selectBean(" where id="+studentid+" and deletestatus=0 ");
		request.setAttribute("bean", stu);
		if(stu.getBanji()==1){
			Fenban fenban=fenbanDao.selectBean(" where stuid="+studentid+" and deletestatus=0");
			Banji banji=fenban.getBanji();
			request.setAttribute("banji",banji);
		}
		if(stu.getSushe()==1){
			Zhusu zhusu=zhusuDao.selectBean(" where studentid="+studentid+" and deletestatus=0");
			Sushe sushe=zhusu.getSushe();
			request.setAttribute("sushe", sushe);
		}
		if(stu.getYkt()==1){
			Ykt ykt=yktDao.selectBean(" where studentid="+studentid+" and deletestatus=0");
			request.setAttribute("ykt", ykt);
		}
		if(stu.getJiaofei()==1){
			Jiaofei jiaofei=jiaofeiDao.selectBean(" where studentid="+studentid+" and deletestatus=0");
			request.setAttribute("jiaofei", jiaofei);
		}
		if(stu.getDangan()==1){
			Dangan dangan=danganDao.selectBean(" where studentid="+studentid+" and deletestatus=0");
			request.setAttribute("dangan", dangan);
		}
		if(stu.getTijian()==1){
			Tijian tj=tijianDao.selectBean(" where studentid="+studentid+" and deletestatus=0");
			request.setAttribute("tijian", tj);
		}
		request.setAttribute("biaoti", "个人详细信息查看");
		this.setUrl("student/studetail.jsp");
		
		return SUCCESS;
	}
	
	
	
	private JiaofeiDao jiaofeiDao;
	

	public JiaofeiDao getJiaofeiDao() {
		return jiaofeiDao;
	}

	public void setJiaofeiDao(JiaofeiDao jiaofeiDao) {
		this.jiaofeiDao = jiaofeiDao;
	}
	
	

	
	
//跳转到缴纳学费页面
	public String jiaofeiadd() {
		HttpServletRequest request = this.getRequest();
		String studentid = request.getParameter("studentid");
		
		Student bean = studentDao.selectBean(" where id= "+studentid);
		
		request.setAttribute("bean", bean);
		
		request.setAttribute("url", "method!jiaofeiadd2?studentid="+studentid);
		request.setAttribute("biaoti", "缴纳学费");
		this.setUrl("jiaofei/jiaofeiadd.jsp");
		return SUCCESS;
	}
	
	
	//缴纳学费操作
	public void jiaofeiadd2() throws IOException {
		HttpServletRequest request = this.getRequest();
		PrintWriter writer = this.getPrintWriter();
		
		String studentid = request.getParameter("studentid");
		String xuefen = request.getParameter("xuefen");
		String zafei = request.getParameter("zafei");
		String zhusu = request.getParameter("zhusu");
		String total = request.getParameter("total");
		
		Student stu = studentDao.selectBean(" where id= "+studentid);
	
		Jiaofei bean = new Jiaofei();
		
		
		
		bean.setCtime(Util.getTime());
		
		bean.setStudent(stu);
		bean.setTotal(Integer.parseInt(total));
		bean.setXuefen(Integer.parseInt(xuefen));
		bean.setZafei(Integer.parseInt(zafei));
		bean.setZhusu(Integer.parseInt(zhusu));
		
		
		
		if(uploadfile!=null){
			String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

			String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

			String imgpath = time + ".jpg";
			File file1 = new File(savaPath + imgpath);
			Util.copyFile(uploadfile, file1);

			bean.setPath(imgpath);
		}

		jiaofeiDao.insertBean(bean);
		
		stu.setJiaofei(1);
		
		studentDao.updateBean(stu);

		
		writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2';</script>");
		
				
	}
	
	//个人缴费查看
	public String jiaofeistu(){
		HttpServletRequest request=this.getRequest();
		String studentid=request.getParameter("studentid");
		Jiaofei jf=jiaofeiDao.selectBean("where studentid='"+studentid+"'");
		request.setAttribute("bean", jf);
		request.setAttribute("biaoti", "缴费记录查看");
		//request.setAttribute("url", "");
		this.setUrl("jiaofei/jiaofeistu.jsp");
		
		return SUCCESS;
	}
	
	
	//缴费记录查询
	public String jiaofeilist() {
		HttpServletRequest request = this.getRequest();
		
		String xuehao = request.getParameter("xuehao");		
		
		String name = request.getParameter("name");	
		
		String sfz = request.getParameter("sfz");	
		
		StringBuffer sb = new StringBuffer();
		sb.append(" where ");

		if (xuehao != null && !"".equals(xuehao)) {

			sb.append(" student.xuehao like '%" + xuehao + "%'");
			sb.append(" and ");
			request.setAttribute("xuehao", xuehao);
		}
		
		if (name != null && !"".equals(name)) {

			sb.append(" student.name like '%" + name + "%'");
			sb.append(" and ");
			request.setAttribute("name", name);
		}
		
		if (sfz != null && !"".equals(sfz)) {

			sb.append(" student.sfz like '%" + sfz + "%'");
			sb.append(" and ");
			request.setAttribute("sfz", sfz);
		}
		
	
		sb.append("   deletestatus=0  order by id desc ");
		String where = sb.toString();


		int currentpage = 1;
		int pagesize = 5;
		if (request.getParameter("pagenum") != null) {
			currentpage = Integer.parseInt(request.getParameter("pagenum"));
		}
		int jiaofeiTotal=studentDao.selectBeanCount(" where jiaofei=1 and deletestatus=0");
		int alltotal=studentDao.selectBeanCount(" where deletestatus=0");
		int total = jiaofeiDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
		request.setAttribute("list", jiaofeiDao.selectBeanList((currentpage - 1)
				* pagesize, pagesize, where));
		request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
				currentpage, "method!jiaofeilist", "共有" + total + "条记录"));
		request.setAttribute("jiaofei", jiaofeiTotal);
		request.setAttribute("total", alltotal);
		request.setAttribute("url", "method!jiaofeilist");
		request.setAttribute("url2", "method!jiaofei");
		request.setAttribute("biaoti", "缴费记录查询");
		this.setUrl("jiaofei/jiaofeilist.jsp");
		return SUCCESS;

	}
	
	
	private ZhusuDao zhusuDao;

	public ZhusuDao getZhusuDao() {
		return zhusuDao;
	}

	public void setZhusuDao(ZhusuDao zhusuDao) {
		this.zhusuDao = zhusuDao;
	}
	
	

	//跳转到分配宿舍页面
		public String zhusuadd() {
			HttpServletRequest request = this.getRequest();
			PrintWriter writer = this.getPrintWriter();
			
			String studentid = request.getParameter("studentid");
			
			Student bean = studentDao.selectBean(" where id= "+studentid);
			
			
			Fenban fenban=fenbanDao.selectBean(" where stuid="+studentid);
			
			if(bean.getBanji()==0){
				writer.print("<script language=javascript>alert('班级未分配，无法分配宿舍');window.location.href='method!studentlist2';</script>");
				return null;
			}
			
			Banji banji=fenban.getBanji();
			List<Sushe> list = susheDao.selectBeanList(0, 999, 
					" where deletestatus=0 and leixing like '%"
							+bean.getSex()+"%' and shengyu>0 and banjiid='"
							+banji.getId()+"'");
		
			if(list.size()<=0){
				writer.print("<script language=javascript>alert('操作失败，宿舍不足');window.location.href='method!studentlist2';</script>");
				return null;
			}
			
			request.setAttribute("sushe", list.get(0));
			
			request.setAttribute("bean", bean);
			
			request.setAttribute("url", "method!zhusuadd2?studentid="+studentid);
			request.setAttribute("biaoti", "分配宿舍");
			this.setUrl("zhusu/zhusuadd.jsp");
			return SUCCESS;
		}
		
		
		//分配宿舍操作
		public void zhusuadd2() throws IOException {
			
			HttpServletRequest request = this.getRequest();
			PrintWriter writer = this.getPrintWriter();
			
			String studentid = request.getParameter("studentid");
			String susheid = request.getParameter("susheid");
			
			Student stu = studentDao.selectBean(" where id= "+studentid);
			
			Sushe sushe = susheDao.selectBean(" where id= "+susheid);
			
		
			Zhusu bean = new Zhusu();

			
			bean.setCtime(Util.getTime());
			
			bean.setStudent(stu);
			bean.setSushe(sushe);
			

			zhusuDao.insertBean(bean);
			
			stu.setSushe(1);
			
			studentDao.updateBean(stu);
			
			sushe.setYizhu(sushe.getYizhu()+1);
			sushe.setShengyu(sushe.getRenshu()-sushe.getYizhu());
			
			susheDao.updateBean(sushe);

			
			writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2';</script>");
			
					
		}
		
		//宿舍分配查询
		public String zhusulist() {
			HttpServletRequest request = this.getRequest();
			
			String xuehao = request.getParameter("xuehao");		
			
			String name = request.getParameter("name");	
			
			String sfz = request.getParameter("sfz");	
			
			StringBuffer sb = new StringBuffer();
			sb.append(" where ");

			if (xuehao != null && !"".equals(xuehao)) {

				sb.append(" student.xuehao like '%" + xuehao + "%'");
				sb.append(" and ");
				request.setAttribute("xuehao", xuehao);
			}
			
			if (name != null && !"".equals(name)) {

				sb.append(" student.name like '%" + name + "%'");
				sb.append(" and ");
				request.setAttribute("name", name);
			}
			
			if (sfz != null && !"".equals(sfz)) {

				sb.append(" student.sfz like '%" + sfz + "%'");
				sb.append(" and ");
				request.setAttribute("sfz", sfz);
			}
			
		
			sb.append("   deletestatus=0  order by id desc ");
			String where = sb.toString();


			int currentpage = 1;
			int pagesize = 5;
			if (request.getParameter("pagenum") != null) {
				currentpage = Integer.parseInt(request.getParameter("pagenum"));
			}
			int total = zhusuDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
			int total2=studentDao.selectBeanCount(" where deletestatus=0");
			request.setAttribute("list", zhusuDao.selectBeanList((currentpage - 1)
					* pagesize, pagesize, where));
			request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
					currentpage, "method!zhusulist", "共有" + total + "条记录"));
			request.setAttribute("total", total);
			request.setAttribute("total2", total2);
			
			request.setAttribute("url", "method!zhusulist");
			request.setAttribute("url2", "method!zhusu");
			request.setAttribute("biaoti", "宿舍分配查询");
			this.setUrl("zhusu/zhusulist.jsp");
			return SUCCESS;

		}
		
		//个人分配宿舍查看
		public String zhusustu(){
			HttpServletRequest request=this.getRequest();
			String studentid=request.getParameter("studentid");
			Zhusu bean=zhusuDao.selectBean(" where studentid='"+studentid+"'");
			request.setAttribute("bean", bean);
			request.setAttribute("biaoti","查看宿舍分配");
			this.setUrl("zhusu/zhusustu.jsp");
			return SUCCESS;
		}
	
		private FenbanDao fenbanDao;
		
		
		public FenbanDao getFenbanDao() {
			return fenbanDao;
		}

		public void setFenbanDao(FenbanDao fenbanDao) {
			this.fenbanDao = fenbanDao;
		}
		
		//分班
		public String fenbanadd() {
			HttpServletRequest request = this.getRequest();
			PrintWriter writer = this.getPrintWriter();
			
			String studentid = request.getParameter("studentid");
			
			Student bean = studentDao.selectBean(" where id= "+studentid);
			
			
			List<Banji> list = banjiDao.selectBeanList(0, 9999, " where deletestatus=0 and zhuanye ="+bean.getZhuanye().getId()+" and shengyu>0 ");
			
			if(list.size()<=0){
				writer.print("<script language=javascript>alert('操作失败，班级不足');window.location.href='method!studentlist2?xueyuan="+bean.getXueyuan().getDepart()+"';</script>");
				return null;
			}
			Banji banji=list.get(0);
			
			request.setAttribute("banji", banji);
			
			request.setAttribute("bean", bean);
			
			request.setAttribute("url", "method!fenbanadd2?studentid="+studentid);
			request.setAttribute("biaoti", "分配班级");
			this.setUrl("fenban/fenbanadd.jsp");
			return SUCCESS;
		}
		
		
		//分配班级操作
		public void fenbanadd2() throws IOException {
			HttpServletRequest request = this.getRequest();
			PrintWriter writer = this.getPrintWriter();
			
			String studentid = request.getParameter("studentid");
			String banjiid = request.getParameter("banjiid");
			//System.out.println(banjiid);
			Student stu = studentDao.selectBean(" where id= "+studentid);
			
			Banji banji = banjiDao.selectBean(" where id= "+banjiid);
			
		
			Fenban bean = new Fenban();

			
			bean.setCtime(Util.getTime());
			
			bean.setStudent(stu);
			bean.setBanji(banji);
			
			fenbanDao.insertBean(bean);
			
			stu.setBanji(1);
			
			studentDao.updateBean(stu);
			
			banji.setYiyou(banji.getYiyou()+1);
			banji.setShengyu(banji.getRenshu()-banji.getYiyou());
			
			banjiDao.updateBean(banji);

			writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2?xueyuan="+stu.getXueyuan().getDepart()+"';</script>");
			
					
		}
		
		//班级分配查询
		public String fenbanlist() {
			HttpServletRequest request = this.getRequest();
			
			String xuehao = request.getParameter("xuehao");		
			
			String name = request.getParameter("name");	
			
			String sfz = request.getParameter("sfz");
			
			String xueyuan=request.getParameter("xueyuan");
			
			//System.out.println(xueyuan);
			
			All xy=null;
			int totalBd=0;
			int totalFb=0;
			StringBuffer sb = new StringBuffer();
			sb.append(" where ");
			
			if (xuehao != null && !"".equals(xuehao)) {

				sb.append(" student.xuehao like '%" + xuehao + "%'");
				sb.append(" and ");
				request.setAttribute("xuehao", xuehao);
			}
			
			if (name != null && !"".equals(name)) {

				sb.append(" student.name like '%" + name + "%'");
				sb.append(" and ");
				request.setAttribute("name", name);
			}
			
			if (sfz != null && !"".equals(sfz)) {

				sb.append(" student.sfz like '%" + sfz + "%'");
				sb.append(" and ");
				request.setAttribute("sfz", sfz);
			}
			
			if(xueyuan!=null&&!"".equals(xueyuan)){
				 xy=allDao.selectBean(" where depart='"+xueyuan+"'");
				 List<Banji> banjilist=banjiDao.selectBeanList(0, 999, "where xueyuan like'%"+xy.getId()+"%'");
					
					String str="";
					for(int i=0;i<banjilist.size();i++){
						int id=banjilist.get(i).getId();
						
						if(i==banjilist.size()-1){
							str+=id;
						}else{
							str+=id+",";
						}
					}
					
						if(str.length()>0){
							sb.append("  banjiid in("+str+") ");
							sb.append("and");
						}else{
							sb.append(" banjiid=0 ");
							sb.append("and");
						}
						
						request.setAttribute("xueyuan", xueyuan);
						
			}
				if(xueyuan!=null&&!"".equals(xueyuan)){
					totalFb=studentDao.selectBeanCount(" where deletestatus=0 and banji=1 and xueyuan="+xy.getId());
					totalBd=studentDao.selectBeanCount(" where deletestatus=0 and xueyuan="+xy.getId());
					
				}else{
					totalFb=studentDao.selectBeanCount(" where deletestatus=0 and banji=1 ");
					totalBd=studentDao.selectBeanCount(" where deletestatus=0 ");
				}
				sb.append("   student.deletestatus=0  order by id desc ");
			
			
			String where = sb.toString();
			
			int currentpage = 1;
			int pagesize = 5;
			if (request.getParameter("pagenum") != null) {
				currentpage = Integer.parseInt(request.getParameter("pagenum"));
			}
			int total = fenbanDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
			//System.out.println(total);
			List<Fenban> list=fenbanDao.selectBeanList((currentpage - 1)
					* pagesize, pagesize, where);
			
			request.setAttribute("list", list);
			
			//如果是院系人员登录，只显示本院系的学生分班信息
			if(xueyuan!=null&&xueyuan.endsWith("学院")){
				request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
						currentpage, "method!fenbanlist?xueyuan="+xueyuan, "共有" + total + "条记录"));
				request.setAttribute("url", "method!fenbanlist?xueyuan="+xueyuan);
				request.setAttribute("url2", "method!fenban");
				
				
			}else{
				//管理员登录显示所有学生的信息
				request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
						currentpage, "method!fenbanlist", "共有" + total + "条记录"));
				request.setAttribute("url", "method!fenbanlist");
				request.setAttribute("url2", "method!fenban");
			}
			
			request.setAttribute("total", totalFb);
			request.setAttribute("total2", totalBd);
			request.setAttribute("biaoti", "班级分配查询");
			this.setUrl("fenban/fenbanlist.jsp");
			return SUCCESS;

		}
		
		//个人分班查询
		public String fenbanstu(){
			HttpServletRequest request=this.getRequest();
			String studentid=request.getParameter("studentid");
			Fenban bean=fenbanDao.selectBean(" where stuid='"+studentid+"'");
			request.setAttribute("bean", bean);
			request.setAttribute("biaoti", "班级分配查询");
			this.setUrl("fenban/fenbanstu.jsp");
			return SUCCESS;
		}

		private YktDao yktDao;

		public YktDao getYktDao() {
			return yktDao;
		}

		public void setYktDao(YktDao yktDao) {
			this.yktDao = yktDao;
		}
		
		//跳转到开通一卡通页面
			public String yktadd() {
				HttpServletRequest request = this.getRequest();
				PrintWriter writer=this.getPrintWriter();
				String studentid = request.getParameter("studentid");
				
				Student bean = studentDao.selectBean(" where id= "+studentid);
				
				if(bean.getJiaofei()==0){
					writer.print("<script language=javascript>alert('未交学费，请先缴费');"
							+ "window.location.href='method!studentlist2';</script>");
					return null;
				}
				
				String kahao = Util.getbianhao(yktDao.selectBeanCount("  "));
				
				request.setAttribute("kahao", kahao);
				
				request.setAttribute("bean", bean);
				
				request.setAttribute("url", "method!yktadd2?studentid="+studentid);
				request.setAttribute("biaoti", "开通一卡通");
				this.setUrl("ykt/yktadd.jsp");
				return SUCCESS;
			}
			
			
			//开通一卡通操作
			public void yktadd2() throws IOException {
				HttpServletRequest request = this.getRequest();
				PrintWriter writer = this.getPrintWriter();
				
				String studentid = request.getParameter("studentid");
			
				String kahao = request.getParameter("kahao");
				
				Student stu = studentDao.selectBean(" where id= "+studentid);
			
				Ykt bean = new Ykt();
				
				
				
				bean.setCtime(Util.getTime());
				
				bean.setStudent(stu);
				bean.setKahao(kahao);
				
				
				
				if(uploadfile!=null){
					String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

					String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

					String imgpath = time + ".jpg";
					File file1 = new File(savaPath + imgpath);
					Util.copyFile(uploadfile, file1);

					bean.setPath(imgpath);
				}

				yktDao.insertBean(bean);
				
				stu.setYkt(1);
				
				studentDao.updateBean(stu);

				
				writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2';</script>");
				
						
			}
			
			//一卡通开通记录查询
			public String yktlist() {
				HttpServletRequest request = this.getRequest();
				
				String xuehao = request.getParameter("xuehao");		
				
				String name = request.getParameter("name");	
				
				String sfz = request.getParameter("sfz");	
				
				StringBuffer sb = new StringBuffer();
				sb.append(" where ");

				if (xuehao != null && !"".equals(xuehao)) {

					sb.append(" student.xuehao like '%" + xuehao + "%'");
					sb.append(" and ");
					request.setAttribute("xuehao", xuehao);
				}
				
				if (name != null && !"".equals(name)) {

					sb.append(" student.name like '%" + name + "%'");
					sb.append(" and ");
					request.setAttribute("name", name);
				}
				
				if (sfz != null && !"".equals(sfz)) {

					sb.append(" student.sfz like '%" + sfz + "%'");
					sb.append(" and ");
					request.setAttribute("sfz", sfz);
				}
				
			
				sb.append("   deletestatus=0  order by id desc ");
				String where = sb.toString();


				int currentpage = 1;
				int pagesize =5;
				if (request.getParameter("pagenum") != null) {
					currentpage = Integer.parseInt(request.getParameter("pagenum"));
				}
				int total = yktDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
				int total1=studentDao.selectBeanCount(" where deletestatus=0");
				request.setAttribute("total", total);
				request.setAttribute("total1", total1);
				
				
				request.setAttribute("list", yktDao.selectBeanList((currentpage - 1)
						* pagesize, pagesize, where));
				request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
						currentpage, "method!yktlist", "共有" + total + "条记录"));
				request.setAttribute("url", "method!yktlist");
				request.setAttribute("url2", "method!ykt");
				request.setAttribute("biaoti", "一卡通开通记录查询");
				this.setUrl("ykt/yktlist.jsp");
				return SUCCESS;

			}
			
			
			//个人查看一卡通开通情况
			public String yktstu() {
				HttpServletRequest request = this.getRequest();
				String studentid=request.getParameter("studentid");
				
				Ykt ykt=yktDao.selectBean("where studentid='"+studentid+"'");
				request.setAttribute("bean", ykt);
				request.setAttribute("biaoti", "一卡通开通查询");
				this.setUrl("ykt/yktstu.jsp");
				
				return SUCCESS;
			}
			
			
			private DanganDao danganDao;

			public DanganDao getDanganDao() {
				return danganDao;
			}

			public void setDanganDao(DanganDao danganDao) {
				this.danganDao = danganDao;
			}
			
			
			
			//跳转到转档案页面
			public String danganadd() {
				HttpServletRequest request = this.getRequest();
				String studentid = request.getParameter("studentid");
				
				Student bean = studentDao.selectBean(" where id= "+studentid);
				
				
				
				request.setAttribute("bean", bean);
				
				request.setAttribute("url", "method!danganadd2?studentid="+studentid);
				request.setAttribute("biaoti", "转档案");
				this.setUrl("dangan/danganadd.jsp");
				return SUCCESS;
			}
			
			
			//转档案操作
			public void danganadd2() throws IOException {
				HttpServletRequest request = this.getRequest();
				PrintWriter writer = this.getPrintWriter();
				
				String studentid = request.getParameter("studentid");
			
				
				Student stu = studentDao.selectBean(" where id= "+studentid);
			
				Dangan bean = new Dangan();
				
				
				
				bean.setCtime(Util.getTime());
				
				bean.setStudent(stu);
				
				
				if(uploadfile!=null){
					String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";

					String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();

					String imgpath = time + ".jpg";
					File file1 = new File(savaPath + imgpath);
					Util.copyFile(uploadfile, file1);

					bean.setPath(imgpath);
				}

				danganDao.insertBean(bean);
				
				stu.setDangan(1);
				
				studentDao.updateBean(stu);

				
				writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2';</script>");
				
						
			}
			
			//转档案记录查询
			public String danganlist() {
				HttpServletRequest request = this.getRequest();
				
				String xuehao = request.getParameter("xuehao");		
				
				String name = request.getParameter("name");	
				
				String sfz = request.getParameter("sfz");	
				
				StringBuffer sb = new StringBuffer();
				sb.append(" where ");

				if (xuehao != null && !"".equals(xuehao)) {

					sb.append(" student.xuehao like '%" + xuehao + "%'");
					sb.append(" and ");
					request.setAttribute("xuehao", xuehao);
				}
				
				if (name != null && !"".equals(name)) {

					sb.append(" student.name like '%" + name + "%'");
					sb.append(" and ");
					request.setAttribute("name", name);
				}
				
				if (sfz != null && !"".equals(sfz)) {

					sb.append(" student.sfz like '%" + sfz + "%'");
					sb.append(" and ");
					request.setAttribute("sfz", sfz);
				}
				
			
				sb.append("   deletestatus=0  order by id desc ");
				String where = sb.toString();


				int currentpage = 1;
				int pagesize = 5;
				if (request.getParameter("pagenum") != null) {
					currentpage = Integer.parseInt(request.getParameter("pagenum"));
				}
				
				int total = danganDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
				int total1=studentDao.selectBeanCount(" where deletestatus=0");
				request.setAttribute("total", total);
				request.setAttribute("total1", total1);
				
				request.setAttribute("list", danganDao.selectBeanList((currentpage - 1)
						* pagesize, pagesize, where));
				request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
						currentpage, "method!danganlist", "共有" + total + "条记录"));
				request.setAttribute("url", "method!danganlist");
				request.setAttribute("url2", "method!dangan");
				request.setAttribute("biaoti", "转档案记录查询");
				this.setUrl("dangan/danganlist.jsp");
				return SUCCESS;

			}
			
			//个人转档案记录查看
			public String danganstu() {
				HttpServletRequest request = this.getRequest();
				String studentid=request.getParameter("studentid");
				Dangan dangan=danganDao.selectBean(" where studentid='"+studentid+"'");
				
				request.setAttribute("biaoti", "个人转档案记录查询");
				request.setAttribute("bean", dangan);
				this.setUrl("dangan/danganstu.jsp");
				return SUCCESS;

			}
	
			private TijianDao tijianDao;

			public TijianDao getTijianDao() {
				return tijianDao;
			}

			public void setTijianDao(TijianDao tijianDao) {
				this.tijianDao = tijianDao;
			}
			
			
			//跳转到提交体检报告页面
			public String tijianadd() {
				HttpServletRequest request = this.getRequest();
				String studentid = request.getParameter("studentid");
				
				Student bean = studentDao.selectBean(" where id= "+studentid);
				
				
				
				request.setAttribute("bean", bean);
				
				request.setAttribute("url", "method!tijianadd2?studentid="+studentid);
				request.setAttribute("biaoti", "提交体检报告");
				this.setUrl("tijian/tijianadd.jsp");
				return SUCCESS;
			}
			
			
			//提交体检报告操作
			public void tijianadd2() throws Exception {
				HttpServletRequest request = this.getRequest();
				PrintWriter writer = this.getPrintWriter();
				
				String studentid = request.getParameter("studentid");
			
				
				Student stu = studentDao.selectBean(" where id= "+studentid);
			
				Tijian bean = new Tijian();
				
				
				
				bean.setCtime(Util.getTime());
				
				bean.setStudent(stu);
				
				
				if(uploadfile!=null){
					String filename = request.getParameter("filename");
					String savaPath = ServletActionContext.getServletContext().getRealPath("/")+ "/uploadfile/";
					String time = new java.text.SimpleDateFormat("yyyyMMddHHmmss").format(new Date()).toString();
					String filename2 = filename.substring(filename.lastIndexOf("\\")+1,filename.length());
					String path = time +"_"+filename2;
					File file = new File(savaPath + path);
					Util.copyFile(uploadfile, file);
					String uploadpath = time +".zip";
					Util.createZip(path, uploadpath, savaPath);
					
					bean.setPath(uploadpath);
					
				}

				tijianDao.insertBean(bean);
				
				stu.setTijian(1);
				
				studentDao.updateBean(stu);

				
				writer.print("<script language=javascript>alert('操作成功');window.location.href='method!studentlist2';</script>");
				
						
			}
			
			//体检报告查询
			public String tijianlist() {
				HttpServletRequest request = this.getRequest();
				
				String xuehao = request.getParameter("xuehao");		
				
				String name = request.getParameter("name");	
				
				String sfz = request.getParameter("sfz");	
				
				StringBuffer sb = new StringBuffer();
				sb.append(" where ");

				if (xuehao != null && !"".equals(xuehao)) {

					sb.append(" student.xuehao like '%" + xuehao + "%'");
					sb.append(" and ");
					request.setAttribute("xuehao", xuehao);
				}
				
				if (name != null && !"".equals(name)) {

					sb.append(" student.name like '%" + name + "%'");
					sb.append(" and ");
					request.setAttribute("name", name);
				}
				
				if (sfz != null && !"".equals(sfz)) {

					sb.append(" student.sfz like '%" + sfz + "%'");
					sb.append(" and ");
					request.setAttribute("sfz", sfz);
				}
				
			
				sb.append("   deletestatus=0  order by id desc ");
				String where = sb.toString();


				int currentpage = 1;
				int pagesize = 5;
				if (request.getParameter("pagenum") != null) {
					currentpage = Integer.parseInt(request.getParameter("pagenum"));
				}
				int total = tijianDao.selectBeanCount(where.replaceAll(" order by id desc ", ""));
				int total1=studentDao.selectBeanCount(" where deletestatus=0");
				request.setAttribute("total", total);
				request.setAttribute("total1", total1);
				
				request.setAttribute("list", tijianDao.selectBeanList((currentpage - 1)
						* pagesize, pagesize, where));
				request.setAttribute("pagerinfo", Pager.getPagerNormal(total, pagesize,
						currentpage, "method!tijianlist", "共有" + total + "条记录"));
				request.setAttribute("url", "method!tijianlist");
				request.setAttribute("url2", "method!tijian");
				request.setAttribute("biaoti", "体检报告查询");
				this.setUrl("tijian/tijianlist.jsp");
				return SUCCESS;

			}
			//个人体检报告查询
			public String tijianstu() {
				HttpServletRequest request = this.getRequest();
				
				String studentid=request.getParameter("studentid");
				Tijian tijian=tijianDao.selectBean(" where studentid='"+studentid+"'");
				request.setAttribute("biaoti", "个人体检报告查询");
				request.setAttribute("bean", tijian);
				this.setUrl("tijian/tijianstu.jsp");
				return SUCCESS;

			}
			public String tongjilist(){
				HttpServletRequest request = this.getRequest();
				//所有缴费数据
				int jiaofeitotal=jiaofeiDao.selectBeanCount("  where deletestatus=0");
				//已在学院报到人数
				int studenttotal=studentDao.selectBeanCount(" where deletestatus=0");
				//已经分班的人数
				int fenbantotal=studentDao.selectBeanCount(" where deletestatus=0 and banji=1");
				//开通一卡通的人数
				int ykttotal=studentDao.selectBeanCount(" where deletestatus=0  and ykt=1 ");
				//分宿舍的人数
				int zhusutotal=studentDao.selectBeanCount(" where deletestatus=0 and sushe=1");
				//已经体检的人数
				int tijiantotal=studentDao.selectBeanCount("  where deletestatus=0 and tijian=1");
				//已经转档案的人数
				int dangantotal=studentDao.selectBeanCount(" where deletestatus=0 and dangan=1");
				
				
				
				
				request.setAttribute("studenttotal", studenttotal);
				request.setAttribute("jiaofeitotal", jiaofeitotal);
				request.setAttribute("fenbantotal", fenbantotal);
				request.setAttribute("ykttotal", ykttotal);
				request.setAttribute("zhusutotal", zhusutotal);
				request.setAttribute("dangantotal", dangantotal);
				request.setAttribute("tijiantotal", tijiantotal);
				this.setUrl("tongji.jsp");
				return SUCCESS;
			}
}
