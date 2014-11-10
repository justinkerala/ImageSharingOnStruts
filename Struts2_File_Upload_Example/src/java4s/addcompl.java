package java4s;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class addcompl extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String Friend;
private String Subject;
private String Details;
	public String getFriend() {
	return Friend;
}
public void setFriend(String friend) {
	Friend = friend;
}
public String getSubject() {
	return Subject;
}
public void setSubject(String subject) {
	Subject = subject;
}
public String getDetails() {
	return Details;
}
public void setDetails(String details) {
	Details = details;
}
	@Override
	public String execute() throws Exception {
		

		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");

		DB obj=new DB();
		obj.addCompl(uname, Friend,Subject, Details);
		
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
