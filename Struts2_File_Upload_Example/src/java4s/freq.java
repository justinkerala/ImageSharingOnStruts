package java4s;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class freq extends ActionSupport {

	private ArrayList<String> freq= new ArrayList<String>();
	
	/**
	 * 
	 */
	
	
	private static String user;
	private String Sbutton;
	public String getSbutton() {
		return Sbutton;
	}
	public void setSbutton(String sbutton) {
		Sbutton = sbutton;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	private String rowsIndexToAdd;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	public String getRowsIndexToAdd() {
		return rowsIndexToAdd;
	}
	public void setRowsIndexToAdd(String rowsIndexToAdd) {
		this.rowsIndexToAdd = rowsIndexToAdd;
	}
	private static final long serialVersionUID = 1L;
	public ArrayList<String> getFreq() {
		return freq;
	}
	public void setFreq(ArrayList<String> freq) {
		this.freq = freq;
	}
	private Map<String, Object> userSession ;
public Map<String, Object> getUserSession() {
		return userSession;
	}
	public void setUserSession(Map<String, Object> userSession) {
		this.userSession = userSession;
	}
@Override
public String execute() throws Exception {
	
	
	DB obj=new DB();
	ResultSet rs=null;
	HttpServletRequest request=ServletActionContext.getRequest();
	
	HttpSession session=request.getSession();
	String uname=(String) session.getAttribute("username");
	String[] untest=request.getParameterValues("rowsIndexToAdd");
	System.out.println(uname);
	rs=obj.requests(uname);
	
	System.out.println("hihih"+user);
	while(rs.next())
	{
		
		freq.add(rs.getString(1));
	}
	//user=request.getAttribute("user").toString();
	//System.out.println("user"+user);
	if(untest==null)
	{
		addActionError("No requests");
		
	}
	else if(untest!=null)
	{
		for(String s:untest)
	{
		//System.out.println(rowsIndexToAdd);
		//System.out.println(s);
		obj.accept(s);
		//return "remaining";
		
	}
	}
	
	
	return SUCCESS;
	
	
}
	
public void test()
{

	
}
}
