package java4s;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class selectf extends ActionSupport {
	private ArrayList<String> friends= new ArrayList<String>();
ResultSet rs;
	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");
		DB obj=new DB();
		rs=obj.selectfriends(uname);
		rs.first();
		friends.add(rs.getString(1));
		while(rs.next())
		{
			friends.add(rs.getString(1));
			
		}
		return SUCCESS;
	}
	
	
}
