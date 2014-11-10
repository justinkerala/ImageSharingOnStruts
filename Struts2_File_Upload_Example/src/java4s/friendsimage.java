package java4s;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class friendsimage extends ActionSupport {
	private Map<String, Object> userSession;
	
	public Map<String, Object> getUserSession() {
		return userSession;
	}

	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}

	public static String uname;
	

	public static String getUname() {
		return uname;
	}

	public static void setUname(String uname) {
		friendsimage.uname = uname;
	}

	public ArrayList<String> getUserPics() {
		return userPics;
	}

	public void setUserPics(ArrayList<String> userPics) {
		this.userPics = userPics;
	}

	private ArrayList<String> userPics= new ArrayList<String>();
	private ArrayList<String> picLikes=new ArrayList<String>();
	


	public ArrayList<String> getPicLikes() {
		return picLikes;
	}

	public void setPicLikes(ArrayList<String> picLikes) {
		this.picLikes = picLikes;
	}

	public String execute() throws SQLException
	{

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");

		
		System.out.println(uname);
		DB obj=new DB();
		ResultSet rs=obj.photoByfriends(uname);
		int i=1;
		int f=0;
		System.out.println(rs.first());
		
		while(rs.next()){
			
			if(f==0)
			{
				rs.first();
				f=1;
			}
			userPics.add(rs.getString(1));
			i++;
			}
		
System.out.println(rs.first());
		
		while(rs.next()){
			
			if(f==0)
			{
				rs.first();
				f=1;
			}
			picLikes.add(rs.getString(2));
			i++;
			}
		System.out.println("adsasd"+ uname);
	
			
		
		return SUCCESS;
			
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//fething images of frieds, and giving a text box . to send the comments regarding to the image to the uploader
	

}
