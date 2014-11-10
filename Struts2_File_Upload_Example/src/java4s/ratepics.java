package java4s;

import com.opensymphony.xwork2.ActionSupport;

public class ratepics extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		obj.like(picture);
		//System.out.println(picture);	
		return SUCCESS;
	}
	
	
	
}
