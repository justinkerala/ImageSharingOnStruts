package java4s;

import com.opensymphony.xwork2.ActionSupport;

public class loadmail extends ActionSupport {
	
	private String uname;
	 
	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	@Override
	public String execute() throws Exception {
	
		System.out.println(uname);
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	

}
