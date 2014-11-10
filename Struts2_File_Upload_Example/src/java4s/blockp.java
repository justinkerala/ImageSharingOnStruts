package java4s;

import com.opensymphony.xwork2.ActionSupport;

public class blockp extends ActionSupport {

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
	
		
	    

		System.out.println("Reached here");
		DB obj=new DB();
		obj.bpic(picture);
		return SUCCESS;
	}
	
	
}
//ode to block the image.