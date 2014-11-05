package java4s;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class searchprof extends ActionSupport implements SessionAware {
	private Map<String, Object> userSession;
	public String tus;
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public static String uname;
	private String pro_pic;
	private String Msg;
	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	public String getPro_pic() {
		return pro_pic;
	}

	public void setPro_pic(String pro_pic) {
		this.pro_pic = pro_pic;
	}

	public ArrayList<String> getUserPics() {
		return userPics;
	}

	public void setUserPics(ArrayList<String> userPics) {
		this.userPics = userPics;
	}

	private ArrayList<String> userPics= new ArrayList<String>();
	
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String execute() throws SQLException
	{
		//String funame=(String) userSession.get("uname");
		//System.out.println(funame);
		System.out.println("haaaai");
		DB obj=new DB();
		ResultSet rs=obj.selectImage(uname);
		int i=1;
		int f=0;
		//System.out.println(rs.getString(1).tos);
		while(rs.next()){
			if(f==0)
			{
				rs.first();
				f=1;
			}
			userPics.add(rs.getString(1));
			i++;
			}
		System.out.println("adsasd"+ uname);
	
			return SUCCESS;
	}
	public void sendReq() throws SQLException
	{
		System.out.println("insendRequest"+ uname);

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String funame=(String) session.getAttribute("username");
		
		System.out.println(uname);
		//String uname=
		DB obj=new DB();
		int i=obj.sendReq(uname,funame,Msg);
		if(i==1)
			System.out.println("OK");
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	//return success to show the page itself with the content yes i got the logic;
	
}
