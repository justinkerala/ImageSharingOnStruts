package java4s;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;





//import org.apache.struts.helloworld.model.MessageStore;
import java4s.LoginModel;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.ParameterNameAware;

public class LoginAction extends ActionSupport implements SessionAware {
	ResultSet rs;
	public String uname;
	private ArrayList<String> images= new ArrayList<String>();
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	private Map<String, Object> userSession ;
	//private static final String userName = "uname";
	//private LoginModel messageStore;
	public Map<String, Object> getUserSession() {
		return userSession;
	}
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
	LoginModel lmo=new LoginModel();
	String pro_ppath;
	public String getPro_ppath() {
		return pro_ppath;
	}
	public void setPro_ppath(String pro_ppath) {
		this.pro_ppath = pro_ppath;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	String pwd;
	public String execute()
	{		

		
		try{
			DB ob=new DB();
			
			rs=ob.ValidPwd(uname, pwd);
			pro_ppath=rs.getString(4);
			if (uname.equals(rs.getString(2))&&pwd.equals(rs.getString(3))){
	            userSession.put("username", rs.getString(1));
	              System.out.println(userSession.get("username"));
              selectimage();
	      			
	            return SUCCESS;
	            	            
	        } else {
	        	System.out.println(pwd);
	            addActionError("Username and Password are incorrect..!");
	            return ERROR;
	        }

		 		
		}catch(Exception e)
		{
			addActionError("Username and Password are incorrect..!");
			 return ERROR;
 
       
		}
		
	
		
	}
	
	@Override

	public void setSession(Map<String, Object> session) {
		
		userSession = session ;

	}
	

	String fetchIm(String uname) throws SQLException
	{
		
		DB ob=new DB();
        ResultSet im=ob.selectImage((userSession.get("username")).toString());
        int i=1;
        while(rs.next()){ 
			images.add(im.getString(i));
			i++;
			}
        return SUCCESS;
        	      
	}	
	public String selectimage() throws SQLException
	{
		DB iob=new DB();
		HttpServletRequest request=ServletActionContext.getRequest();
  		HttpSession session=request.getSession();
  
		String sn=session.getAttribute("username").toString();
        ResultSet im=iob.selectImage(sn);
        int i=1;
        //System.out.println(im.getString(1).toString());
       // System.out.println()
        
        while(im.next()){ 
			images.add(im.getString(1));
			i++;
			}

        return SUCCESS;
	}

}
