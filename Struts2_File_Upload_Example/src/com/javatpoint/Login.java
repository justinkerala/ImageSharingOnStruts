package com.javatpoint;

import java.time.chrono.JapaneseChronology;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;

public class Login implements SessionAware{
private String username,userpass;
SessionMap<String,String> sessionmap;
//SessionMap<String,java.lang.String> sessionname;
Map<String, Object> sessionname;
public Map<String, Object> getSessionname() {
	return sessionname;
}

public void setSessionname(Map<String, Object> sessionname) {
	this.sessionname = sessionname;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUserpass() {
	return userpass;
}

public void setUserpass(String userpass) {
	this.userpass = userpass;
}

public String execute(){
	if(LoginDao.validate(username, userpass)){
		sessionmap.put("uname", username);
		return "success";
	}
	else{
		return "error";
	}
}

public void setSession(Map map) {
	sessionmap=(SessionMap)map;
	sessionmap.put("login","true");
    //sessionname=ActionContext.getContext().getSession();
	//sessionname.put("uname", username);
	//System.out.println(username);
	//setSessionname(sessionname);
}


public String logout(){
	sessionmap.invalidate();
	return "success";
}

}
