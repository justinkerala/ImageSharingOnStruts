package java4s;
import java.io.File;

import org.apache.commons.io.FileUtils;

import com.opensymphony.xwork2.ActionSupport;

public class LogingEx extends ActionSupport{	
	private static final long serialVersionUID = 1L;

	
	private File uploadFile;
	private String uploadFileContentType;
	private String uploadFileFileName;	
    private String Uname;
    private String Pro_name;
    private String Pro_path;
    private String Pro_about;
    private String Pro_cam;
    private String res;
    //rank
    //compl=0
    private String Pro_mail;
    public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getPro_name() {
		return Pro_name;
	}
	public void setPro_name(String pro_name) {
		Pro_name = pro_name;
	}
	public String getPro_about() {
		return Pro_about;
	}
	public void setPro_about(String pro_about) {
		Pro_about = pro_about;
	}
	public String getPro_cam() {
		return Pro_cam;
	}
	public void setPro_cam(String pro_cam) {
		Pro_cam = pro_cam;
	}
	public String getPro_mail() {
		return Pro_mail;
	}
	public void setPro_mail(String pro_mail) {
		Pro_mail = pro_mail;
	}
	public String getPro_pwd() {
		return Pro_pwd;
	}
	public void setPro_pwd(String pro_pwd) {
		Pro_pwd = pro_pwd;
	}
	public String getCon_pwd() {
		return Con_pwd;
	}
	public void setCon_pwd(String con_pwd) {
		Con_pwd = con_pwd;
	}


	private String Pro_pwd;
    private String Con_pwd;


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


	public String execute()
	{		
		try{
		String filePath = "d:/Myuploads";  // Give your own path
        System.out.println("Server path:" + filePath); // test your path
        File fileToCreate = new File(filePath, uploadFileFileName);// Create file name  same as original
        Pro_path=filePath+"/"+uploadFileFileName;
        FileUtils.copyFile(uploadFile, fileToCreate); // Just copy temp file content tos this file		
        DB obj=new DB();
        res=obj.InsertRecord(Uname,Pro_name,Pro_path,Pro_about,Pro_cam,0,0,Pro_mail,Pro_pwd);
        if(res.equalsIgnoreCase("false"))
        
        	addActionMessage("INSERT EVERY FIELDS PROPERLY");
        	
        else
        	addActionMessage("YOU ARE LOGED IN SUCCESSFULLY");
      
		}catch(Exception e)
		{
			e.printStackTrace();
            addActionError(e.getMessage());
            
            return INPUT;
 
       
		}
		return SUCCESS;
	}
	
	
}
// Context pirnt.....

//private HttpServletRequest servletRequest;
//String filePath = servletRequest.getSession().getServletContext().getRealPath("/");
//System.out.println("Server path:" + filePath);
//File fileN = new File(filePath, this.uploadFileFileName);
//FileUtils.copyFile(this.userImage, fileToCreate);


