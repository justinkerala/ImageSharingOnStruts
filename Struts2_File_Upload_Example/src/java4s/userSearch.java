package java4s;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import java4s.LoginModel;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class userSearch extends ActionSupport implements SessionAware {
	DB obj=new DB();	
	ResultSet rs;
	private Map<String, Object> userSession ;
	private String SearchText;
	LoginModel logmodel;
	public String uname;
	public String userLink;
	

	public String getUserLink() {
		return userLink;
	}

	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}

	LoginModel lmo=new LoginModel();
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSearchText() {
		return SearchText;
	}

	public void setSearchText(String searchText) {
		SearchText = searchText;
	}

	int i=1;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private ArrayList<String> comboMeals= new ArrayList<String>();
	 
		public ArrayList<String> getComboMeals() {
			return comboMeals;
		}
	 
		public void setComboMeals(ArrayList<String> comboMeals) {
			this.comboMeals = comboMeals;
		}
	 
		public String execute() throws SQLException {
			
		    //System.out.println(uname);
	        rs=  obj.searchUser(SearchText);
			while(rs.next()){ 
			comboMeals.add(rs.getString(i));
			}
			//uname=lg.uname;
			//uname=lmo.getUname();
			//HttpSession ss= new HttpSession(uname);
			uname=lmo.getUname();
		//	System.out.println(typeA);
			
						
			return SUCCESS;
		}

		@Override
		public void setSession(Map<String, Object> arg0) {
			// TODO Auto-generated method stub
			
		}

		

		 
		 
			
		}
	 
	

