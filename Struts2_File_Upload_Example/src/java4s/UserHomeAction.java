package java4s;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class UserHomeAction extends ActionSupport implements SessionAware {
String uname;
private Map<String, Object> sessionMap;

	public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		if (sessionMap.containsKey("userName")) {
            uname = (String) sessionMap.get("userName");
            System.out.println("haaai");
            System.out.println(uname);
	}
	}
	public String execute()
	{
		System.out.println(uname);
		
		
		return SUCCESS;	
		
		
		
		
	}
}


