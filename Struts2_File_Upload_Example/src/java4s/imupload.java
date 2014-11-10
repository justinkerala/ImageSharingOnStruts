package java4s;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class imupload extends ActionSupport {

	private File uploadFile;
	 private String Pro_path;
	public File getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	private String uploadFileContentType;
	private String uploadFileFileName;	
	public String execute()
	{		
		DB obj=new DB();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String uname=(String) session.getAttribute("username");
	//	System.out.println(l);
		try{
			String filePath = "d:/Myuploads";  
			 File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
		        Pro_path=filePath+"/"+uploadFileFileName;
		        FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content tos this file			
			    System.out.println(uname);
			    System.out.println(Pro_path);
		        int i=obj.uploadIm(uname,Pro_path);
		        
		        //insert into pit table which has two field pro_name and pic path.
		}catch(Exception e)
		{
			e.printStackTrace();
            addActionError(e.getMessage());
            
            return INPUT;
 
       
		}
		
	return SUCCESS;
			}
}
