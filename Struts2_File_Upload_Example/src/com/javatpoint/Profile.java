package com.javatpoint;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

public class Profile implements SessionAware {

public String execute(){
HttpServletRequest request=ServletActionContext.getRequest();
HttpSession session=request.getSession();

String s=(String)session.getAttribute("login");
String l=(String)session.getAttribute("uname");
System.out.println(l);
if(s!=null && !s.equals("")){
	System.out.println(s);
	return "success";
}
else{
	return "error";
}

}

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	
}
}
