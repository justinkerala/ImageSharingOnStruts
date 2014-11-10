package java4s;

import com.opensymphony.xwork2.ActionSupport;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
public class mailsender extends ActionSupport {

	private String to;
	private String subject;
	private String body;
    String from = "snapshareadm.com";//change accordingly
    final String username = "SnapShareAdmin";//change accordingly
    final String password = "namaskaram";//change accordingly

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
	
		//java4s.mailer obj= new mailer();
	//obj.send();
		
		
mailtest obj=new mailtest();
obj.send();
		return SUCCESS;
	}
	
	
	
	
}
