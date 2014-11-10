package java4s;

import com.opensymphony.xwork2.ActionSupport;

public class admbl extends ActionSupport {

	private String picture;
	
	
	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		DB obj=new DB();
		
		obj.blockImage(picture);
		return SUCCESS;
	}
}
