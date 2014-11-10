package java4s;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class admcomplread extends ActionSupport {
	private String sender; 
	private String uname;
	private String subject;
	private String details;
	private String compnos;
	private String mailst;
    private static ResultSet rs;
	

	public String getMailst() {
		return mailst;
	}
	public void setMailst(String mailst) {
		this.mailst = mailst;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCompnos() {
		return compnos;
	}
	public void setCompnos(String compnos) {
		this.compnos = compnos;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	    DB obj=new DB();
	    
	    rs=obj.readCom();
	    if(rs.first())
	    {
	    rs.first();
	      
  
	 //   String s=uname.in;
	    sender=rs.getString(1);
	    uname=rs.getString(2);
	    subject=rs.getString(3);
	    details=rs.getString(4);
	    compnos=rs.getString(5);
	    mailst=rs.getString(6);
	    }
	    return SUCCESS;
	}
	public String next() throws SQLException
	{
		System.out.println("in next");
		     
		if(rs.next()){
			System.out.println("in if part");
			
	
		   sender=rs.getString(1);
		   uname=rs.getString(2);
		   subject=rs.getString(3);
		   details=rs.getString(4);
		   compnos=rs.getString(5);
		   mailst=rs.getString(6);
		}
		else
		{
			System.out.println("uin else part");
			this.prev();
		}
		   return SUCCESS;
		
	}
	public void prev() throws SQLException
	{
		System.out.println("in prev");
		
		if(rs.previous())
		{
		System.out.println("in if part of the prev");
		rs.first();
		sender=rs.getString(1);
	    uname=rs.getString(2);
	    subject=rs.getString(3);
	    details=rs.getString(4);
	    compnos=rs.getString(5);
	    mailst=rs.getString(6);
		}
		else
		{
			this.next();
			
		}
	}
}
