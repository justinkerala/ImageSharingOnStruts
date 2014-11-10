package java4s;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Admabusive extends ActionSupport {
	
	ResultSet rs;
	private ArrayList<String> abuimages= new ArrayList<String>();
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		
		DB obj=new DB();
		rs=obj.selectAbus();
		rs.first();
		abuimages.add(rs.getString(1));
		while(rs.next())
		{
			
			abuimages.add(rs.getString(1));
		}
		for(String s:abuimages)
		{
			
			System.out.println(s);
		}
		
		return SUCCESS;
	}
	public ArrayList<String> getAbuimages() {
		return abuimages;
	}
	public void setAbuimages(ArrayList<String> abuimages) {
		this.abuimages = abuimages;
	}

}
