package java4s;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class Admall extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<String> allimages= new ArrayList<String>();
	public ArrayList<String> getAllimages() {
		return allimages;
	}
	public void setAllimages(ArrayList<String> allimages) {
		this.allimages = allimages;
	}
	public ResultSet getRs() {
		return rs;
	}
	public void setRs(ResultSet rs) {
		this.rs = rs;
	}
	ResultSet rs;
	@Override
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		DB obj=new DB();
		rs=obj.selectAll();
		rs.first();
		allimages.add(rs.getString(1));
		while(rs.next())
		{
			
			allimages.add(rs.getString(1));
		}
		//calling all fun and addin to array list
		for(String s:allimages)
		{
			System.out.println("from"+s);
		}
		return SUCCESS;
	}
	
	
}
